//============================================================
//Copyright 2017, Drona, Inc. All rights reserved.
//============================================================
package com.property.rest.project.requestResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.property.common.response.BaseResponse;

@XmlRootElement(name="response")
@XmlAccessorType (XmlAccessType.FIELD)
public class ProjectDeatilsResponse extends BaseResponse {
private ProjectDTO project;

public ProjectDTO getProject() {
	return project;
}
public void setProject(ProjectDTO project) {
	this.project = project;
}


}
