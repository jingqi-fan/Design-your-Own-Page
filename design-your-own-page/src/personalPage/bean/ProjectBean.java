package personalPage.bean;

import personalPage.entity.Project;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "projectBean")
@ViewScoped
public class ProjectBean {
    private List<Project> projects = new ArrayList<>();
    private Project project = new Project();
    private Project selectedProject;

    /**
     * Default constructor initializing a new project.
     */
    public ProjectBean() {
        project = new Project();
    }

    // Getters and setters for the selected project
    public Project getSelectedProject() {
        return selectedProject;
    }

    public void setSelectedProject(Project selectedProject) {
        this.selectedProject = selectedProject;
    }

    // Getters and setters for the project
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    // Getters and setters for the list of projects
    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    /**
     * Load projects from the database after bean construction.
     */
    @PostConstruct
    public void init() {
        try {
            loadProjects();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves the project details to the database and handles transaction rollback on failure.
     * @return A string indicating a successful operation or null on failure.
     */
    public String saveProject() {
        Connection connection = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);

            String sql = "INSERT INTO projects (title, summary, type, link) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, project.getTitle());
            ps.setString(2, project.getSummary());
            ps.setString(3, project.getType());
            ps.setString(4, project.getLink());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Creating project failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int projectId = generatedKeys.getInt(1);
                    project.setId(projectId);
                    saveKeywords(connection, projectId);
                    saveCollaborators(connection, projectId);
                } else {
                    throw new SQLException("Creating project failed, no ID obtained.");
                }
            }

            connection.commit();
            return "success"; // Returns a success status
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Saves keywords related to a project in the database.
     * @param connection The database connection
     * @param projectId The project ID for which keywords are saved
     */
    private void saveKeywords(Connection connection, int projectId) throws SQLException {
        String sql = "INSERT INTO ProjectKeywords (projectId, keyword) VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        for (String keyword : project.getKeywords()) {
            ps.setInt(1, projectId);
            ps.setString(2, keyword);
            ps.executeUpdate();
        }
    }

    /**
     * Saves collaborators associated with a project in the database.
     * @param connection The database connection
     * @param projectId The project ID for which collaborators are saved
     */
    private void saveCollaborators(Connection connection, int projectId) throws SQLException {
        String sql = "INSERT INTO ProjectCollaborators (projectId, collaborator) VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        for (String collaborator : project.getCollaborators()) {
            ps.setInt(1, projectId);
            ps.setString(2, collaborator);
            ps.executeUpdate();
        }
    }

    /**
     * Establishes and returns a database connection using JDBC.
     * @return A Connection object
     */
    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql:///personalpage?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        return DriverManager.getConnection(url, "root", "Ff2004123");
    }

    /**
     * Retrieves a project based on the current page view ID.
     * @return The corresponding Project object
     */
    public Project getProjectByPageName() {
        String viewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
        String projectName = viewId.substring(viewId.lastIndexOf('/') + 1, viewId.lastIndexOf('.'));

        int projectIndex = Integer.parseInt(projectName.replace("project", "")) - 1;
        return projects.get(projectIndex);
    }

    /**
     * Loads all projects from the database and populates the projects list.
     */
    private void loadProjects() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql:///personalpage?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            connection = DriverManager.getConnection(url, "root", "Ff2004123");
            statement = connection.createStatement();
            String sql = "SELECT * FROM projects";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int profileId = resultSet.getInt("profile_id");
                String title = resultSet.getString("title");
                String summary = resultSet.getString("summary");
                String type = resultSet.getString("type");
                String link = resultSet.getString("link");
                List<String> keywords = loadKeywords(connection, id);
                List<String> collaborators = loadCollaborators(connection, id);

                Project project = new Project(id, profileId, title, summary, keywords, type, collaborators, link);
                projects.add(project);
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
    }

    /**
     * Loads keywords associated with a project from the database.
     * @param connection The database connection
     * @param projectId The ID of the project
     * @return A list of keywords
     */
    private List<String> loadKeywords(Connection connection, int projectId) throws SQLException {
        List<String> keywords = new ArrayList<>();
        String sql = "SELECT keyword FROM ProjectKeywords WHERE projectId = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, projectId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    keywords.add(rs.getString("keyword"));
                }
            }
        }
        return keywords;
    }

    /**
     * Loads collaborators associated with a project from the database.
     * @param connection The database connection
     * @param projectId The ID of the project
     * @return A list of collaborators
     */
    private List<String> loadCollaborators(Connection connection, int projectId) throws SQLException {
        List<String> collaborators = new ArrayList<>();
        String sql = "SELECT collaborator FROM ProjectCollaborators WHERE projectId = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, projectId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    collaborators.add(rs.getString("collaborator"));
                }
            }
        }
        return collaborators;
    }
}
