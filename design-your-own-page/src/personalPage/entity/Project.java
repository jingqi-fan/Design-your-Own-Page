package personalPage.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a project with comprehensive details like title, summary, keywords, and collaborators.
 */
public class Project {
    private int id; // Unique identifier for the project
    private int profileId; // Identifier linking this project to a specific profile
    private String title; // Title of the project
    private String summary; // Brief summary of the project
    private List<String> keywords; // List of keywords associated with the project
    private String type; // Type of project, e.g., software development, research
    private List<String> collaborators; // List of collaborators involved in the project
    private String link; // URL link to the project or related resources

    /**
     * Constructor to initialize a Project with all attributes.
     * @param id Unique identifier for the project
     * @param profileId Profile identifier this project is associated with
     * @param title Title of the project
     * @param summary Summary of the project
     * @param keywords List of keywords associated with the project
     * @param type Type of the project
     * @param collaborators List of collaborators on the project
     * @param link URL link to the project or additional resources
     */
    public Project(int id, int profileId, String title, String summary, List<String> keywords, String type, List<String> collaborators, String link) {
        this.id = id;
        this.profileId = profileId;
        this.title = title;
        this.summary = summary;
        this.keywords = (keywords != null) ? keywords : new ArrayList<>();
        this.type = type;
        this.collaborators = (collaborators != null) ? collaborators : new ArrayList<>();
        this.link = link;
    }

    /**
     * Default constructor that initializes lists to avoid null pointer exceptions.
     */
    public Project() {
        this.keywords = new ArrayList<>();
        this.collaborators = new ArrayList<>();
    }

    // Getters and setters for all fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(List<String> collaborators) {
        this.collaborators = collaborators;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    // Keywords as comma-separated string
    public String getKeywordsAsString() {
        return keywords == null ? "" : String.join(", ", keywords);
    }

    public void setKeywordsAsString(String keywordsStr) {
        this.keywords = Arrays.stream(keywordsStr.split("\\s*,\\s*"))
                .collect(Collectors.toList());
    }

    // Collaborators as comma-separated string
    public String getCollaboratorsAsString() {
        return collaborators == null ? "" : String.join(", ", collaborators);
    }

    public void setCollaboratorsAsString(String collaboratorsStr) {
        this.collaborators = Arrays.stream(collaboratorsStr.split("\\s*,\\s*"))
                .collect(Collectors.toList());
    }
}