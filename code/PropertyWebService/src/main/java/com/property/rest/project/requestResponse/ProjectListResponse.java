//============================================================
//Copyright 2017, Drona, Inc. All rights reserved.
//============================================================
package com.property.rest.project.requestResponse;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
@XmlAccessorType (XmlAccessType.FIELD)
public class ProjectListResponse implements Serializable {
	
	@XmlElement(name="project")
	@XmlElementWrapper(name="projectList")
	private List<ProjectDTO> projects;

	public List<ProjectDTO> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectDTO> projects) {
		this.projects = projects;
	}

}
