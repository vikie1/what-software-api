package io.github.vikie1.whatsoftware.entity;

import javax.persistence.*;

@Entity @Table(name = "type")
public class TypeEntity {

    @Id @Column(name = "id", nullable = false) @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String type;
    @Column(unique = true)
    private String software;

    public TypeEntity(){}
    public TypeEntity(String type, String software) {
        this.type = type;
        this.software = software;
    }

    public Long getId() { return id; }
    public String getType() { return type; }
    public String getSoftware() { return software; }

    public void setId(Long id) { this.id = id; }
    public void setType(String type) { this.type = type; }
    public void setSoftware(String software) { this.software = software; }
}
