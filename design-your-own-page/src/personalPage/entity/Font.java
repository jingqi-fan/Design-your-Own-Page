package personalPage.entity;

/**
 * Represents a font style used in user interfaces or documents.
 * This class encapsulates font attributes such as ID and font type.
 */
public class Font {
    private int id; // Unique identifier for the font
    private String type; // The type of the font (e.g., Arial, Times New Roman, etc.)

    /**
     * Default constructor that creates an empty Font instance.
     */
    public Font() {
    }

    /**
     * Constructs a Font with specified identifier and type.
     * @param id the unique identifier for the font
     * @param type the style/type of the font
     */
    public Font(int id, String type) {
        this.id = id;
        this.type = type;
    }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
