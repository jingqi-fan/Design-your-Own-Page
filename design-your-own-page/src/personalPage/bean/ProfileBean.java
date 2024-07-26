package personalPage.bean;

import personalPage.entity.Profile;
import personalPage.entity.Project;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.sql.*;

@ManagedBean(name = "userProfileBean")
@ViewScoped
public class ProfileBean {
    private Profile profile = new Profile();
    private Project project1 = new Project();
    private Project project2 = new Project();

    // Getters and setters for the profile
    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    // Getters and setters for the first project
    public Project getProject1() {
        return project1;
    }

    public void setProject1(Project project1) {
        this.project1 = project1;
    }

    // Getters and setters for the second project
    public Project getProject2() {
        return project2;
    }

    public void setProject2(Project project2) {
        this.project2 = project2;
    }

    /**
     * Saves all profile and project information to the database.
     * Manages transactional consistency, committing all or nothing.
     * @return the navigation outcome string for redirection
     */
    public String saveAll() {
        Connection connection = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false); // Begin transaction

            int profileId = saveProfile(connection); // Save profile and get generated ID
            project1.setProfileId(profileId);
            saveProject(connection, project1); // Save first project linked to profile

            project2.setProfileId(profileId);
            saveProject(connection, project2); // Save second project linked to profile

            connection.commit(); // Commit the transaction
            return "page_example1?faces-redirect=true"; // Redirect on success
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            try {
                if (connection != null) {
                    // Roll back the transaction on error
                    connection.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();  // Always close the connection
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Helper method to save profile information and return generated profile ID
    private int saveProfile(Connection connection) throws SQLException {
        String sql = "INSERT INTO profile (name, biography, email, phone, address, linkedin, github, color_scheme_id, font, font_size) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        // Set profile attributes
        ps.setString(1, profile.getName());
        ps.setString(2, profile.getBio());
        ps.setString(3, profile.getEmail());
        ps.setString(4, profile.getPhone());
        ps.setString(5, profile.getAddress());
        ps.setString(6, profile.getLinkedin());
        ps.setString(7, profile.getGithub());
        ps.setInt(8, profile.getColorScheme());
        ps.setInt(9, profile.getFont());
        ps.setInt(10, profile.getFontSize());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1); // Return generated profile ID
        } else {
            throw new SQLException("Creating profile failed, no ID obtained.");
        }
    }

    // Helper method to save project information linked to a profile
    private void saveProject(Connection connection, Project project) throws SQLException {
        String sql = "INSERT INTO projects (title, summary, type, link, profile_id) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        // Set project attributes linked to profile ID
        ps.setString(1, project.getTitle());
        ps.setString(2, project.getSummary());
        ps.setString(3, project.getType());
        ps.setString(4, project.getLink());
        ps.setInt(5, project.getProfileId());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            int projectId = rs.getInt(1);
            // Save associated keywords
            saveKeywords(connection,project, projectId);
            // Save collaborators
            saveCollaborators(connection, project, projectId);
        } else {
            throw new SQLException("Creating project failed, no ID obtained.");
        }
    }

    // Additional helper methods for saving project keywords
    private void saveKeywords(Connection connection, Project project, int projectId) throws SQLException {
        String sql = "INSERT INTO ProjectKeywords (projectId, keyword) VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        for (String keyword : project.getKeywords()) {
            ps.setInt(1, projectId);
            ps.setString(2, keyword);
            ps.executeUpdate();
        }
    }

    // Additional helper methods for saving project keywords
    private void saveCollaborators(Connection connection, Project project, int projectId) throws SQLException {
        String sql = "INSERT INTO ProjectCollaborators (projectId, collaborator) VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        for (String collaborator : project.getCollaborators()) {
            ps.setInt(1, projectId);
            ps.setString(2, collaborator);
            ps.executeUpdate();
        }
    }

    // Establishes connection to the database
    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql:///personalpage?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        return DriverManager.getConnection(url, "root", "password");
    }
}

