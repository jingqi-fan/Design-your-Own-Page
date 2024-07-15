package personalPage.entity;

/**
 * Represents a user in the system, holding login credentials and contact information.
 */
public class User {
    private String username; // Username for the user's login
    private String password; // Password for the user's login
    private String email; // Email address associated with the user

    /**
     * Default constructor that creates an empty User instance.
     */
    public User() {
    }

    /**
     * Constructs a User with specified username, password, and email.
     * @param username the user's username
     * @param password the user's password
     * @param email the user's email address
     */
    public User(String username, String password, String email, String fullName) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Getters and setters for each property

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Provides a string representation of the user, including username and email,
     * which is helpful for debugging and logging.
     * @return a string representation of the user
     */
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email +
                '}';
    }
}
