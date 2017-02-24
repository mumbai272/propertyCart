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
        "PROJECT_ID", "DETAIL_KEY" }, name="unique_project_id_detail_key") })
public class ProjectDetails {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "PROJECT_ID")
    private Long projectId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_ID", insertable = false, updatable = false)
    private Project project;

    @Column(name = "DETAIL_VALUE", nullable = false)
    private String detailValue;

    @Column(name = "DETAIL_KEY", nullable = false,length = 50)
    private String detailKey;

        
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

    
    public Project getProject() {
        return project;
    }

    
    public void setProject(Project project) {
        this.project = project;
    }


	public String getDetailValue() {
		return detailValue;
	}


	public void setDetailValue(String detailValue) {
		this.detailValue = detailValue;
	}


	public String getDetailKey() {
		return detailKey;
	}


	public void setDetailKey(String detailKey) {
		this.detailKey = detailKey;
	}

    
   
}
