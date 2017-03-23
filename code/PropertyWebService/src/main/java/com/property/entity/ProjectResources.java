package com.property.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class ProjectResources {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(name = "PROJECT_ID", nullable = false)
    private Long projectId;

    @NotNull
    @Column(name = "PROPERTY_ID", nullable = false)
    private Long propertyId;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "PROJECT_ID", insertable = false, updatable = false)
    // private Project project;
    private String name;

    private String resourceType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    
    public Long getPropertyId() {
        return propertyId;
    }

    
    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }


}
