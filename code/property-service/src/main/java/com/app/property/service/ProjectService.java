package com.app.property.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.app.property.service.dao.ImageDAO;
import com.app.property.service.dao.PropertyDAO;
import com.app.property.service.dto.AddressDTO;
import com.app.property.service.dto.ImageDTO;
import com.app.property.service.dto.ProjectDTO;
import com.app.property.service.models.Image;
import com.app.property.service.models.Project;

@Service
public class ProjectService {

    private static final String IMAGE_API = "project/image/";

    @Autowired
    private PropertyDAO propertyDAO;

    @Autowired
    private AddressService addressBO;

    @Autowired
    private ImageDAO imageDAO;

    @Autowired
    private Environment env;

    @Resource(name = "statusMap")
    private Map<Long, String> statusMap;

    @Resource(name = "statusToIdMap")
    private Map<String, Long> statusToIdMap;

    public ProjectDTO addProject(ProjectDTO dto) {
        AddressDTO address = addressBO.addAddress(dto.getAddress());
        dto.setUserId(1);
        dto.setAddressId(address.id);
        Project project = toModel(dto);
        project.setStatus(statusToIdMap.get(dto.getStatus()));
        return toDTO(propertyDAO.addProject(project));
    }


    public ProjectDTO addProperty(ProjectDTO dto) {
        if (dto.getUserId() <= 0) {
            throw new RuntimeException("Missing user id");
        }
        if (dto.getAddressId() <= 0) {
            throw new RuntimeException("Missing address id");
        }

        return toDTO(propertyDAO.addProject(toModel(dto)));
    }

    public ProjectDTO updateProject(ProjectDTO dto) {
        Project project = propertyDAO.getByProjectId(dto.getId());
        if (project.getId() == dto.getId()) {
            project = updateModel(dto);
            propertyDAO.update(project);
            addressBO.updateAddress(dto.getAddress());
        }
        return dto;
    }



    public ProjectDTO getProject(long projectId) throws Exception {
        Project project = propertyDAO.getByProjectId(projectId);

        if (project == null) {
            throw new RuntimeException("Invalid project id : " + projectId);
        }
        ProjectDTO dto = toDTO(project);
        List<Image> images = imageDAO.getImages(dto.getId());
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
            projectDTOs.add(toDTO(project));
        }
        List<Image> thumbenails = imageDAO.getImagesByType(projectIds, "thumbnail");
        if (!CollectionUtils.isEmpty(thumbenails)) {

            Map<Long, String> map = buildMapOfThumbnails(thumbenails);
            for (ProjectDTO dto : projectDTOs) {
                String url = "images/default.jpg";
                if (map.containsKey(dto.getId())) {
                    url = map.get(dto.getId());
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
    
    public List<ImageDTO> getAllProjectImages(long projectId) {
        List<ImageDTO> dtos=new ArrayList<ImageDTO>();
        List<Image> image = imageDAO.getImages(projectId);
        for (Image i : image) {
            dtos.add(i.toDTO());
        }
        return dtos;
    }

    public ProjectDTO toDTO(Project project) {
        ProjectDTO dto = new ProjectDTO();
        BeanUtils.copyProperties(project, dto);
        dto.setStatus(statusMap.get(project.getStatus()));
        dto.setAddress(project.getAddress().toDTO());
        return dto;
    }

    public Project toModel(ProjectDTO dto) {
        return updateModel(dto);
    }

    public Project updateModel(ProjectDTO dto) {
        Project project = new Project();
        BeanUtils.copyProperties(dto, project);
        project.setStatus(statusToIdMap.get(dto.getStatus()));
        // project.setAddress(dto.getAddress().toModel());
        return project;
    }
}
