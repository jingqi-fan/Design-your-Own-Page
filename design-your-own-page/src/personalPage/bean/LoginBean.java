package personalPage.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.sql.*;

@ManagedBean(name = "loginBean")
@ViewScoped
public class LoginBean {
    private String username;
    private String password;

    // Getters and setters for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getters and setters for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Method to validate login credentials.
     * If authentication is successful, it redirects to the design page.
     * Otherwise, it displays an error message and stays on the login page.
     * @return the navigation outcome
     */
    public String login() {
        if (authenticate(username, password)) {
            return "/design"; // Redirect to the home page on successful login
        } else {
            // Add an error message if authentication fails
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Authentication failed. Check username and password."));
            return null; // Stay on the login page
        }
    }

    /**
     * Authenticates a user against credentials stored in the database.
     * @param username the username
     * @param password the password
     * @return true if authentication is successful, otherwise false
     */
    private boolean authenticate(String username, String password) {
        try {
            // Load database driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql:///personalpage?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            try (Connection connection = DriverManager.getConnection(url, "root", "Ff2004123");
                 PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?")) {
                ps.setString(1, username);
                ps.setString(2, password);

                try (ResultSet rs = ps.executeQuery()) {
                    return rs.next(); // Return true if a record is found
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log exception for debugging
        }
        return false;  // Return false if authentication fails
    }

    /**
     * Retrieves the UserSessionBean to manage user-specific data during a session.
     * @return UserSessionBean if available in the context, otherwise null
     */
    private UserSessionBean getUserSessionBean() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (facesContext != null) {
            return facesContext.getApplication().evaluateExpressionGet(facesContext, "#{userSessionBean}", UserSessionBean.class);
        }
        return null;
    }
}
