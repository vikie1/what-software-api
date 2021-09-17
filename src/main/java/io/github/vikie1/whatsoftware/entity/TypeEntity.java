package io.github.vikie1.whatsoftware.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.vikie1.whatsoftware.pojo.CategoryEntitiesAbstraction;

import javax.persistence.*;
import java.util.Set;

@Entity @Table(name = "type")
public class TypeEntity {

    @Id @Column(name = "id", nullable = false) @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String type;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "typeEntity", cascade = CascadeType.ALL)
    private Set<SoftwareEntity> software;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) @JoinColumn(name = "cat_id")
    private CategoryEntity categoryEntity;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) @JoinColumn(name = "nested_cat_id")
    private NestedCategoryEntity nestedCategoryEntity;


    public TypeEntity(){}
    public TypeEntity(String type, CategoryEntitiesAbstraction categoryEntitiesAbstraction, boolean isNested) {
        this.type = type;
        if (!isNested) setCategoryEntity(categoryEntitiesAbstraction.getCategory());
        else setNestedCategoryEntity(categoryEntitiesAbstraction.getNestedCategory());
    }

    @JsonIgnore
    public CategoryEntity getCategoryEntity() { return categoryEntity; }
    public Long getId() { return id; }
    public String getType() { return type; }
    public Set<SoftwareEntity> getSoftware() { return software; }

    public void setId(Long id) { this.id = id; }
    public void setCategoryEntity(CategoryEntity cat) {
        this.categoryEntity = cat;
    }
    public void setNestedCategoryEntity(NestedCategoryEntity nestedCategoryEntity) { this.nestedCategoryEntity = nestedCategoryEntity; }
    public void setType(String type) { this.type = type; }
    public void setSoftware(Set<SoftwareEntity> software) { this.software = software; }
}
