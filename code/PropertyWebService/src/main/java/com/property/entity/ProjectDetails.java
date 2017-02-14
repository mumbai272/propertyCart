//============================================================
//Copyright 2017, Drona, Inc. All rights reserved.
//============================================================
package com.property.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PROJECT_DETAILS", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "PROJECT_ID", "VALUE" }, name = "unique_pId_value") })
public class ProjectDetails {

    @Id
    @GeneratedValue
    private Long Id;

    @Column(name = "PROJECT_ID")
    private Long projectId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_ID", insertable = false, updatable = false)
    private Project project;

    @Column(name = "VALUE", nullable = false, length = 50)
    private String value;

    @Column(name = "KEY", nullable = false)
    private String key;

    
    public Long getId() {
        return Id;
    }

    
    public void setId(Long id) {
        Id = id;
    }

    
    public Long getProjectId() {
        return projectId;
    }

    
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    
    public Project getProject() {
        return project;
    }

    
    public void setProject(Project project) {
        this.project = project;
    }

    
    public String getValue() {
        return value;
    }

    
    public void setValue(String value) {
        this.value = value;
    }

    
    public String getKey() {
        return key;
    }

    
    public void setKey(String key) {
        this.key = key;
    }
    
   
}
