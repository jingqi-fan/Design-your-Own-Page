package personalPage.entity;

/**
 * Represents a user profile with comprehensive details like name, biography, contact information, and appearance settings.
 */
public class Profile {
    private int id; // Unique identifier for the profile
    private String name; // Full name of the profile owner
    private String bio; // Biography or personal statement of the profile owner
    private String email; // Email address
    private String phone; // Telephone number
    private String address; // Physical or mailing address
    private String linkedin; // LinkedIn profile URL
    private String github; // GitHub profile URL
    private int colorScheme; // ID referencing a specific color scheme
    private int font; // ID referencing a specific font style
    private int fontSize; // Font size in points
    private String fontSizeString; // Font size as a string value

    /**
     * Default constructor for creating an empty Profile instance.
     */
    public Profile() {
    }

    /**
     * Constructs a Profile with detailed attributes.
     * @param id Unique identifier
     * @param name Full name
     * @param bio Biography or personal statement
     * @param email Email address
     * @param phone Phone number
     * @param address Physical or mailing address
     * @param linkedin LinkedIn URL
     * @param github GitHub URL
     * @param colorScheme Reference to color scheme
     * @param font Reference to font style
     * @param fontSize Font size in points
     * @param fontSizeString Font size as a string
     */
    public Profile(int id, String name, String bio, String email, String phone, String address, String linkedin, String github, int colorScheme, int font, int fontSize, String fontSizeString) {
        this.id = id;
        this.name = name;
        this.bio = bio;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.linkedin = linkedin;
        this.github = github;
        this.colorScheme = colorScheme;
        this.font = font;
        this.fontSize = fontSize;
        this.fontSizeString = fontSizeString;
    }

    // Getters and setters for all fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public int getColorScheme() {
        return colorScheme;
    }

    public void setColorScheme(int colorScheme) {
        this.colorScheme = colorScheme;
    }

    public int getFont() {
        return font;
    }

    public void setFont(int font) {
        this.font = font;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public String getFontSizeString() {
        return fontSizeString;
    }

    public void setFontSizeString(String fontSizeString) {
        this.fontSizeString = fontSizeString;
    }
}
