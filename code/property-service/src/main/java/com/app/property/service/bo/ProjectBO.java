package com.app.property.service.bo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.app.property.service.dao.ImageDAO;
import com.app.property.service.dao.PropertyDAO;
import com.app.property.service.dto.ProjectDTO;
import com.app.property.service.models.Image;
import com.app.property.service.models.Project;

@Repository
public class ProjectBO {

    private static final String IMAGE_API = "api/project/image/";

    @Autowired
    private PropertyDAO propertyDAO;

    @Autowired
    private ImageDAO imageDAO;

    @Autowired
    private Environment env;

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

        if (project == null) {
            throw new RuntimeException("Invalid project id : " + projectId);
        }
        ProjectDTO dto = project.toDTO();
        List<Image> images = imageDAO.getImages(dto.id);
        for (Image image : images) {
            dto.addImages(image.toDTO());
        }
        return dto;
    }

    public List<ProjectDTO> getProjects() {
        List<Project> projects = propertyDAO.getAllProjects();

        if (CollectionUtils.isEmpty(projects)) {
            throw new RuntimeException("No project entries found");
        }
        List<ProjectDTO> projectDTOs = new ArrayList<ProjectDTO>();
        List<Long> projectIds = new ArrayList<>();
        for (Project project : projects) {
            projectIds.add(project.getId());
            projectDTOs.add(project.toDTO());
        }
        List<Image> thumbenails = imageDAO.getImagesByType(projectIds, "thumbnail");
        if (!CollectionUtils.isEmpty(thumbenails)) {

            Map<Long, String> map = buildMapOfThumbnails(thumbenails);
            for (ProjectDTO dto : projectDTOs) {
                String url = "images/default.jpg";
                if (map.containsKey(dto.id)) {
                    url = map.get(dto.id);
                }
                dto.setThumbnailImage(url);
            }
        }
        return projectDTOs;
    }

    private Map<Long, String> buildMapOfThumbnails(List<Image> thumbenails) {
        Map<Long, String> map = new HashMap<>();
        for (Image image : thumbenails) {
            StringBuilder url = new StringBuilder(IMAGE_API).append(image.getId());
            map.put(image.getProject().getId(), url.toString());
        }
        return map;
    }

    public File getProjectImages(long imageId) {

        Image image = imageDAO.getImageById(imageId);
        if (image == null) {
            throw new RuntimeException("image does not exist");
        }
        String rootDirectory = env.getProperty("file.rootDirectory");
        StringBuilder url =
            new StringBuilder(rootDirectory).append(File.separator)
                    .append(image.getProject().getId()).append(File.separator)
                    .append(image.getProperty().getId()).append(File.separator)
                    .append(image.getImageName());
        File f = new File(url.toString());
        if (f == null) {
            throw new RuntimeException("image does not exist");
        }
        return f;
    }

}
