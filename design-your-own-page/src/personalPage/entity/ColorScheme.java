package personalPage.entity;

/**
 * Represents a color scheme with four distinct color components.
 */
public class ColorScheme {
    private int id; // Unique identifier
    private String color1; // First color in the color scheme
    private String color2; // Second color in the color scheme
    private String color3; // Third color in the color scheme
    private String color4; // Fourth color in the color scheme

    /**
     * Default constructor for creating an empty color scheme.
     */
    public ColorScheme() {
    }

    /**
     * Constructor for creating a color scheme without an ID.
     * This is typically used for creating new color scheme records that have not yet been persisted.
     *
     * @param color1 the first color
     * @param color2 the second color
     * @param color3 the third color
     * @param color4 the fourth color
     */
    public ColorScheme(String color1, String color2, String color3, String color4) {
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.color4 = color4;
    }

    /**
     * Constructor for creating a color scheme with an ID.
     * This is used when fetching existing records from a database.
     *
     * @param id the unique identifier for the color scheme
     * @param color1 the first color
     * @param color2 the second color
     * @param color3 the third color
     * @param color4 the fourth color
     */
    public ColorScheme(int id, String color1, String color2, String color3, String color4) {
        this.id = id;
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.color4 = color4;
    }

    // Getters and setters for each field

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor1() {
        return color1;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public String getColor2() {
        return color2;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public String getColor3() {
        return color3;
    }

    public void setColor3(String color3) {
        this.color3 = color3;
    }

    public String getColor4() {
        return color4;
    }

    public void setColor4(String color4) {
        this.color4 = color4;
    }
}
