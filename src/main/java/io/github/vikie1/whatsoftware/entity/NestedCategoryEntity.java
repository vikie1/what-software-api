package io.github.vikie1.whatsoftware.entity;

import io.github.vikie1.whatsoftware.pojo.CategoryEntitiesAbstraction;

import javax.persistence.*;
import java.util.Set;

/**
 * By default, parentCategories are categories in the CategoryEntity Class
 * To nest a category in a nestedCategory,
 * just assign the parentCategory the name of an Existing nestedCategory.
 */

@Entity @Table( name = "nested_category" )
public class NestedCategoryEntity extends CategoryEntitiesAbstraction {

    @Id @Column(name = "id", nullable = false) @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String parentCategory;
    @Column(nullable = false)
    private String catName;
    @Column(unique = true)
    private String software;
    @OneToMany(mappedBy = "nestedCategoryEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<TypeEntity> typeEntity;

    public NestedCategoryEntity(){}
    public NestedCategoryEntity(String parentCategory, String catName, String software) {
        this.parentCategory = parentCategory;
        this.catName = catName;
        this.software = software;
    }

    public Long getId() { return id; }
    public String getSoftware() { return software; }
    public String getParentCategory() { return parentCategory; }
    public String getCatName() { return catName; }

    public void setId(Long id) { this.id = id; }
    public void setParentCategory(String parentCategory) { this.parentCategory = parentCategory; }
    public void setSoftware(String software) { this.software = software; }
    public void setCatName(String catName) { this.catName = catName; }
}
