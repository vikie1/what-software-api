package io.github.vikie1.whatsoftware.entity;

import javax.persistence.*;

@Entity @Table( name = "nested_category" )
public class NestedCategoryEntity {

    @Id @Column(name = "id", nullable = false) @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String parentCategory;
    @Column(nullable = false)
    private String catName;
    private String software;
    private String nestedCategory;

    public NestedCategoryEntity(){}
    public NestedCategoryEntity(String parentCategory, String catName, String software, String nestedCategory) {
        this.parentCategory = parentCategory;
        this.catName = catName;
        this.software = software;
        this.nestedCategory = nestedCategory;
    }

    public Long getId() { return id; }
    public String getSoftware() { return software; }
    public String getParentCategory() { return parentCategory; }
    public String getCatName() { return catName; }
    public String getNestedCategory() { return nestedCategory; }

    public void setParentCategory(String parentCategory) { this.parentCategory = parentCategory; }
    public void setSoftware(String software) { this.software = software; }
    public void setCatName(String catName) { this.catName = catName; }
    public void setNestedCategory(String nestedCategory) { this.nestedCategory = nestedCategory; }
}
