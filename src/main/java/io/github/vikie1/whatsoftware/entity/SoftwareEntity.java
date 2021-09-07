package io.github.vikie1.whatsoftware.entity;

import javax.persistence.*;

@Entity @Table(name = "software")
public class SoftwareEntity {

    @Id @Column(name = "id", nullable = false) @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    private String description;
    @Column(nullable = false)
    private String downloadUrl;

    public SoftwareEntity(){}
    public SoftwareEntity(String name, String description, String downloadUrl){
        this.name = name;
        this.description = description;
        this.downloadUrl = downloadUrl;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getDownloadUrl() { return downloadUrl; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setDownloadUrl(String downloadUrl) { this.downloadUrl = downloadUrl; }
}
