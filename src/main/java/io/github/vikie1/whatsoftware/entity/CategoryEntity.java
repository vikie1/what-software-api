package io.github.vikie1.whatsoftware.entity;

import javax.persistence.*;

@Entity @Table(name = "category")
public class CategoryEntity {
    @Id @Column(name = "id", nullable = false) @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String catName;
    private String software;
    private String nestedCategory;

    public CategoryEntity(){}
    public CategoryEntity(String catName, String software, String nestedCategory) {
        this.catName = catName;
        this.software = software;
        this.nestedCategory = nestedCategory;
    }

    public Long getId() { return id; }
    public String getCatName() { return catName; }
    public String getSoftware() { return software; }
    public String getNestedCategory() { return nestedCategory; }

    public void setId(Long id) { this.id = id; }
    public void setCatName(String catName) { this.catName = catName; }
    public void setSoftware(String software) { this.software = software; }
    public void setNestedCategory(String nestedCategory) { this.nestedCategory = nestedCategory; }
}
