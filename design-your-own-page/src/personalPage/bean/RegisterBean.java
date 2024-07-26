package personalPage.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.sql.*;

@ManagedBean(name = "registerBean")
@ViewScoped
public class RegisterBean {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;

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

    // Getters and setters for confirm password
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    // Getters and setters for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Handles user registration by validating passwords and adding user to the database.
     * @return Navigation string based on the registration outcome.
     */
    public String register() {
        // Check if the passwords entered match
        if (!password.equals(confirmPassword)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registration Error", "Passwords do not match."));
            return null; // Stay on the registration page
        }
        // Attempt to add user to the database
        if (addUserToDatabase()) {
            return "/login?faces-redirect=true"; // Redirect to login page on successful registration
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registration Error", "Registration failed. Please try again."));
            return null; // Stay on the registration page
        }
    }

    /**
     * Adds a new user to the database.
     * @return True if the user was successfully added, false otherwise.
     */
    private boolean addUserToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql:///personalpage?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            try (Connection connection = DriverManager.getConnection(url, "root", "password");
                 PreparedStatement ps = connection.prepareStatement("INSERT INTO users (username, password, email) VALUES (?, ?, ?)")) {
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, email);

                int result = ps.executeUpdate();
                return result > 0; // Return true if the user was successfully added
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging purposes
        }
        return false; // Return false if the user was not added due to an error
    }
}
