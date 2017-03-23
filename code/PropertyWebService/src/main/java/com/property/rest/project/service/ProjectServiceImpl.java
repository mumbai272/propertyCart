//============================================================
//Copyright 2017, Drona, Inc. All rights reserved.
//============================================================
package com.property.rest.project.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.cxf.common.util.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.property.entity.Project;
import com.property.entity.Property;
import com.property.repository.ProjectDao;
import com.property.repository.PropertyDao;
import com.property.rest.project.requestResponse.AddressDTO;
import com.property.rest.project.requestResponse.ProjectDTO;
import com.property.rest.project.requestResponse.ProjectDeatilsResponse;
import com.property.rest.project.requestResponse.ProjectListResponse;

@Component
@Transactional
public class ProjectServiceImpl {

	private static final Logger logger = Logger.getLogger(ProjectServiceImpl.class);
	@Resource
	private Map<Long, String> propertyStatusMap;
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private PropertyDao propertyDao;

	/**
	 * returns the all the project list.
	 * 
	 * @return
	 */
	public ProjectListResponse getProjectList() {
		logger.info("getting all the projects");
		ProjectListResponse response = new ProjectListResponse();
		List<Project> projectLists = (List<Project>)projectDao.findAll();
		if(!CollectionUtils.isEmpty(projectLists)) {
			response.setProjects(buildProjectListDTO(projectLists));
		}
		return response;
	}

	/**
	 * returns the complete details about project
	 * 
	 * @param projectId
	 * @return
	 */
	public ProjectDeatilsResponse getProjectDetails(Long projectId) {
		Project project = projectDao.findOne(projectId);
		if(project == null) {
			throw new RuntimeException("invalid projectId is passed");
		}
		List<Property> propertyList = propertyDao.findByProjectId(project.getId());
		for(Property property : propertyList) {

		}
		return null;
	}

	private ProjectDTO buildProjectDTO(Project project) {
		ProjectDTO projectDto = new ProjectDTO();
		BeanUtils.copyProperties(project, projectDto);
		projectDto.setStatus(propertyStatusMap.get(project.getStatus()));
		AddressDTO address = new AddressDTO();
		BeanUtils.copyProperties(project.getAddress(), address);
		StringBuilder addressBuilder = new StringBuilder(project.getAddress().getStreet1()).append(", ")
		        .append(project.getAddress().getStreet2());
		address.setAddressString(addressBuilder.toString());
		projectDto.setAddress(address);
		return projectDto;
	}

	private List<ProjectDTO> buildProjectListDTO(List<Project> projectLists) {
		List<ProjectDTO> projectDtoList = new ArrayList<>();
		for(Project project : projectLists) {
			ProjectDTO projectDto = buildProjectDTO(project);
			projectDtoList.add(projectDto);
		}
		return projectDtoList;
	}

	public File getProjectResource(Long projectId, Long fileId) {

		return null;
	}

}
