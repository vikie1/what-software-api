package io.github.vikie1.whatsoftware.entity;

import javax.persistence.*;
import java.util.Set;

@Entity @Table(name = "category")
public class CategoryEntity{
    @Id @Column(name = "id", nullable = false) @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String catName;
    @Column(unique = true)
    private String nestedCategory;
    @OneToMany(mappedBy = "categoryEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<TypeEntity> typeEntity;

    public CategoryEntity(){}
    public CategoryEntity(String catName, String nestedCategory) {
        this.catName = catName;
        this.nestedCategory = nestedCategory;
    }

    public Long getId() { return id; }
    public String getCatName() { return catName; }
    public String getNestedCategory() { return nestedCategory; }
    public Set<TypeEntity> getTypeEntity() { return typeEntity; }

    public void setId(Long id) { this.id = id; }
    public void setCatName(String catName) { this.catName = catName; }
    public void setNestedCategory(String nestedCategory) { this.nestedCategory = nestedCategory; }
}
