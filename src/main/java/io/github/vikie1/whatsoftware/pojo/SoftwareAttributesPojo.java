package io.github.vikie1.whatsoftware.pojo;

public class SoftwareAttributesPojo {
    private final String softwareName;
    private final String description;
    private final String downloadUrl;
    //Check README.md at the root of the project
    private final String type;
    private final String category;
    private final String parentCategory;
    private final boolean isNested;

    //This is the only way to assign the instance variables, no Setters.
    public SoftwareAttributesPojo(String softwareName, String description, String downloadUrl, String type, String category, String parentCategory, boolean isNested) {
        this.softwareName = softwareName;
        this.description = description;
        this.downloadUrl = downloadUrl;
        this.type = type;
        this.category = category;
        this.parentCategory = parentCategory;
        this.isNested = isNested;
    }

    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public String getDownloadUrl() { return downloadUrl; }
    public String getSoftwareName() { return softwareName; }
    public String getType() { return type; }
    public String getParentCategory() { return parentCategory; }
    public boolean isNested() { return isNested; }
}
