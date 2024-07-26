package personalPage.bean;

import personalPage.entity.ColorScheme;
import personalPage.entity.Font;
import personalPage.entity.Profile;
import personalPage.entity.Project;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "showInfoBean")
@ViewScoped
public class ShowInfoBean {
    private Profile profile;
    private ColorScheme colorScheme;
    private Project project = new Project();
    private List<Project> projects;
    private Font font;

    // Getters and Setters
    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    // Default constructor
    public ShowInfoBean() {
    }

    public ShowInfoBean(Profile profile, ColorScheme colorScheme, Project project, List<Project> projects) {
        this.profile = profile;
        this.colorScheme = colorScheme;
        this.project = project;
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public ColorScheme getColorScheme() {
        return colorScheme;
    }

    public void setColorScheme(ColorScheme colorScheme) {
        this.colorScheme = colorScheme;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    // Database connection details
    private static final String URL = "jdbc:mysql:///personalpage?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    /**
     * Initialization method that loads the latest profile and related entities after bean construction.
     */
    @PostConstruct
    public void init() {
        try {
            // Load the latest profile from the database
            loadLatestProfile();
            if (profile != null) {
                // Load related data based on the profile's IDs
                int profileId = profile.getId();
                int colorSchemeId = profile.getColorScheme();
                int fontId = profile.getFont();
                String size = Integer.toString(profile.getFontSize());
                profile.setFontSizeString(size);

                System.out.println(profileId);
                System.out.println(colorSchemeId);
                System.out.println(fontId);

                projects = loadProjects(profileId);
                colorScheme = loadColorScheme(colorSchemeId);
                font = loadFont(fontId);

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // Consider logging the error or handling it more gracefully
        }
    }

    /**
     * Loads the most recent profile from the database.
     */
    private void loadLatestProfile() throws SQLException, ClassNotFoundException {
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM profile ORDER BY id DESC LIMIT 1")) {
            if (rs.next()) {
                profile = new Profile();
                profile.setId(rs.getInt("id"));
                profile.setName(rs.getString("name"));
                profile.setEmail(rs.getString("email"));
                profile.setPhone(rs.getString("phone"));
                profile.setAddress(rs.getString("address"));
                profile.setLinkedin(rs.getString("linkedin"));
                profile.setGithub(rs.getString("github"));
                profile.setBio(rs.getString("biography"));
                profile.setFont(rs.getInt("font"));
                profile.setFontSize(rs.getInt("font_size"));
                profile.setColorScheme(rs.getInt("color_scheme_id"));
            }
        }
    }

    /**
     * Loads a specific color scheme based on an ID.
     */
    private ColorScheme loadColorScheme(int colorSchemeId) throws SQLException, ClassNotFoundException {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM ColorSchemes WHERE id = ?")) {
            ps.setInt(1, colorSchemeId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ColorScheme scheme = new ColorScheme();
                    scheme.setId(rs.getInt("id"));
                    scheme.setColor1(rs.getString("color1"));
                    scheme.setColor2(rs.getString("color2"));
                    scheme.setColor3(rs.getString("color3"));
                    scheme.setColor4(rs.getString("color4"));
                    return scheme;
                }
            }
        }
        return null;
    }

    /**
     * Loads font details based on an ID.
     */
    private Font loadFont(int fontId) throws SQLException, ClassNotFoundException {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM Font WHERE id = ?")) {
            ps.setInt(1, fontId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Font font1 = new Font();
                    font1.setType(rs.getString("type"));
                    return font1;
                }
            }
        }
        return null;
    }

    /**
     * Loads all projects associated with a specific profile ID.
     */
    private List<Project> loadProjects(int profileId) throws SQLException, ClassNotFoundException {
        List<Project> projects = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM Projects WHERE profile_id = ?")) {
            ps.setInt(1, profileId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Project project = new Project();
                    project.setId(rs.getInt("id"));
                    project.setTitle(rs.getString("title"));
                    project.setSummary(rs.getString("summary"));
                    project.setType(rs.getString("type"));
                    project.setLink(rs.getString("link"));
                    project.setProfileId(profileId);
                    project.setKeywords(loadKeywords(connection, project.getId()));
                    project.setCollaborators(loadCollaborators(connection, project.getId()));
                    projects.add(project);
                }
            }
        }
        return projects;
    }

    /**
     * Loads keywords for a specific project.
     */
    private List<String> loadKeywords(Connection connection, int projectId) throws SQLException {
        List<String> keywords = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement("SELECT keyword FROM ProjectKeywords WHERE projectId = ?");
        ps.setInt(1, projectId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            keywords.add(rs.getString("keyword"));
        }
        return keywords;
    }

    /**
     * Loads collaborators for a specific project.
     */
    private List<String> loadCollaborators(Connection connection, int projectId) throws SQLException {
        List<String> collaborators = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement("SELECT collaborator FROM ProjectCollaborators WHERE projectId = ?");
        ps.setInt(1, projectId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            collaborators.add(rs.getString("collaborator"));
        }
        return collaborators;
    }

    /**
     * Establishes and returns a connection to the database.
     */
    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
