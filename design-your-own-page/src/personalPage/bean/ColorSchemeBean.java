package personalPage.bean;

import personalPage.entity.ColorScheme;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "colorSchemeBean")
@ViewScoped
public class ColorSchemeBean {
    private List<ColorScheme> colorSchemes = new ArrayList<>();
    private int selectedColorSchemeId=-1;

    // JDBC database credentials
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/personalpage";
    private final String USER = "root";
    private final String PASSWORD = "Ff2004123";

    @PostConstruct
    public void init() {
        // Load color schemes from the database when bean is created
        loadColorSchemesFromDatabase();
    }

    private void loadColorSchemesFromDatabase() {
        // Establish connection and prepare a statement to fetch color schemes
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT id, color1, color2, color3, color4 FROM ColorSchemes")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String color1 = rs.getString("color1");
                String color2 = rs.getString("color2");
                String color3 = rs.getString("color3");
                String color4 = rs.getString("color4");
                // Add new ColorScheme object to the list
                colorSchemes.add(new ColorScheme(id, color1, color2, color3, color4));
            }
        } catch (SQLException e) {
            // Print stack trace for debugging; consider logging in a real application
            e.printStackTrace();
        }
    }

    public List<ColorScheme> getColorSchemes() {
        return colorSchemes;
    }

    public void setColorSchemes(List<ColorScheme> colorSchemes) {
        this.colorSchemes = colorSchemes;
    }

    public int getSelectedColorSchemeId() {
        return selectedColorSchemeId;
    }

    public void setSelectedColorSchemeId(int selectedColorSchemeId) {
        this.selectedColorSchemeId = selectedColorSchemeId;
    }


    public void selectColorScheme(int schemeId) {
        // Toggle selection state: deselect if the same ID is clicked again
        if (this.selectedColorSchemeId == schemeId) {
            this.selectedColorSchemeId = -1; // Set to no selection
        } else {
            this.selectedColorSchemeId = schemeId; // Update to new selected scheme ID
        }
    }

}
