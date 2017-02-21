//============================================================
//Copyright 2017, Drona, Inc. All rights reserved.
//============================================================
package com.property.rest.project.requestResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class ProjectListResponse implements Serializable {

    private List<ProjectDTO> projects = new ArrayList<>();

    
    public List<ProjectDTO> getProjects() {
        return projects;
    }

    
    public void setProjects(List<ProjectDTO> projects) {
        this.projects = projects;
    }



}
