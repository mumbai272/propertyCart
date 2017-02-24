//============================================================
//Copyright 2017, Drona, Inc. All rights reserved.
//============================================================
package com.property.rest.project.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.common.util.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.property.entity.Project;
import com.property.repository.project.ProjectDao;
import com.property.rest.project.requestResponse.ProjectDTO;
import com.property.rest.project.requestResponse.ProjectListResponse;

@Component
@Transactional
public class ProjectServiceImpl {

    private static final Logger logger = Logger.getLogger(ProjectServiceImpl.class);

    @Autowired
    private ProjectDao projectDao;

    public ProjectListResponse getPropertList() {
        logger.info("getting all the projects");
        ProjectListResponse response = new ProjectListResponse();
        List<Project> projectLists = (List<Project>) projectDao.findAll();
        if (!CollectionUtils.isEmpty(projectLists)) {
            response.setProjects(buildPropertiesDto(projectLists));
        }
        return response;
    }

    private List<ProjectDTO> buildPropertiesDto(List<Project> projectLists) {
        List<ProjectDTO> projectDtoList = new ArrayList<>();
        for (Project project : projectLists) {
            ProjectDTO projectDto = new ProjectDTO();
            BeanUtils.copyProperties(project, projectDto);
            projectDtoList.add(projectDto);
        }
        return projectDtoList;
    }
}
