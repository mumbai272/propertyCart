package com.app.property.service.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.app.property.service.dao.PropertyDAO;
import com.app.property.service.dto.ProjectDTO;
import com.app.property.service.models.Project;

@Repository
public class ProjectBO {
    @Autowired
    private PropertyDAO propertyDAO;

    public ProjectDTO addProperty(ProjectDTO dto) {
        if (dto.userId <= 0) {
            throw new RuntimeException("Missing user id");
        }

        if (dto.addressId <= 0) {
            throw new RuntimeException("Missing address id");
        }

        return propertyDAO.addProject(dto.toModel()).toDTO();
    }

    public ProjectDTO updateProject(ProjectDTO dto) {
        Project project = propertyDAO.getByProjectId(dto.id);
        if (project.getId() == dto.id) {
            project = dto.updateModel(project);
            propertyDAO.update(project);
        }
        return project.toDTO();
    }


    public ProjectDTO addProject(ProjectDTO dto) {
        if (dto.userId <= 0) {
            throw new RuntimeException("Missing user id");
        }

        if (dto.addressId <= 0) {
            throw new RuntimeException("Missing address id");
        }

        return propertyDAO.addProject(dto.toModel()).toDTO();
    }

    public ProjectDTO getProject(long projectId) throws Exception {
        Project project = propertyDAO.getByProjectId(projectId);

        if (project != null) {
            return project.toDTO();
        } else {
            throw new RuntimeException("Invalid project id : " + projectId);
        }
    }

   

    public List<ProjectDTO> getProjects() {
        List<Project> projects = propertyDAO.getAllProjects();

        if (CollectionUtils.isEmpty(projects)) {
                throw new RuntimeException("No project entries found");
        }
        List<ProjectDTO> projectDTOs=new ArrayList<ProjectDTO>();
        for (Project project : projects) {
            projectDTOs.add(project.toDTO());
        }
        return projectDTOs;
    }


}
