package io.github.vikie1.whatsoftware.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity @Table(name = "software_of_the_day")
public class SoftwareOfTheDayEntity {
    @Id @Column(name = "id", nullable = false)
    private Long id;
    @Column(unique = true)
    private String software;
    @Lob @Type(type = "org.hibernate.type.TextType")
    private String description;
    private String downloadUrl;
    @Column(unique = true)
    private String date;

    public SoftwareOfTheDayEntity(){}
    public SoftwareOfTheDayEntity(String software_of_the_day, String description, String downloadUrl, String date) {
        this.software = software_of_the_day;
        this.description = description;
        this.downloadUrl = downloadUrl;
        this.date = date;
    }

    public Long getId() { return id; }
    public String getSoftware() { return software; }
    public String getDescription() { return description; }
    public String getDownloadUrl() { return downloadUrl; }
    public String getDate() { return date; }

    public void setId(Long id) { this.id = id; }
    public void setSoftware(String software) { this.software = software; }
    public void setDescription(String description) { this.description = description; }
    public void setDownloadUrl(String downloadUrl) { this.downloadUrl = downloadUrl; }
}
