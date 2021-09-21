package io.github.vikie1.whatsoftware.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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


    public TypeEntity(){}
    public TypeEntity(String type, CategoryEntity category, boolean isNested) {
        this.type = type;
        if (!isNested) setCategoryEntity(category);
    }

    @JsonIgnore
    public CategoryEntity getCategoryEntity() { return categoryEntity; }
    public Long getId() { return id; }
    public String getType() { return type; }
    public Set<SoftwareEntity> getSoftware() { return software; }

    public void setId(Long id) { this.id = id; }
    public void setCategoryEntity(CategoryEntity cat) { this.categoryEntity = cat; }
    public void setType(String type) { this.type = type; }
    public void setSoftware(Set<SoftwareEntity> software) { this.software = software; }
}
