package com.app.property.service.rest;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.property.service.ProjectService;
import com.app.property.service.PropertyService;
import com.app.property.service.dto.BaseResponse;
import com.app.property.service.dto.ProjectDTO;
import com.app.property.service.dto.PropertyDTO;

@Controller
@RequestMapping("/project")
public class ProjectRestService {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private PropertyService PropertyService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<ProjectDTO> createProject(@RequestBody ProjectDTO projectDTO) {
        BaseResponse<ProjectDTO> output = new BaseResponse<ProjectDTO>();

        try {
            output.setData(projectService.addProject(projectDTO));
            output.setMessage("Property succesfully added!");
        } catch (Exception ex) {
            output.setError("Error - adding the Project");
        }

        return output;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public BaseResponse<ProjectDTO> updateProject(@RequestBody ProjectDTO projectDTO) {
        BaseResponse<ProjectDTO> output = new BaseResponse<ProjectDTO>();

        try {
            output.setData(projectService.updateProject(projectDTO));
            output.setMessage("Property succesfully updated!");
        } catch (Exception ex) {
            output.setError(ex.getMessage());
        }
        return output;
    }

    @RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse<ProjectDTO> getProject(@PathVariable("projectId") long projectId) {
        BaseResponse<ProjectDTO> output = new BaseResponse<ProjectDTO>();

        try {
            output.setData(projectService.getProject(projectId));
            output.setMessage("Property succesfully retrieved!");
        } catch (Exception ex) {
            output.setError(ex.getMessage());
        }
        return output;
    }

    /**
     * return the list of projects
     * 
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse<List<ProjectDTO>> getProjects(@QueryParam("active") Boolean active) {
        BaseResponse<List<ProjectDTO>> output = new BaseResponse<List<ProjectDTO>>();

        try {
            if (active == null) {
                active = false;
            }
            output.setData(projectService.getProjects(active));

            output.setMessage("Property succesfully retrieved!");
        } catch (Exception ex) {
            output.setError(ex.getMessage());
        }
        return output;
    }

    @RequestMapping(value = "/{projectId}/property", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse<List<PropertyDTO>> getProperties(@PathVariable("projectId") long projectId) {
        BaseResponse<List<PropertyDTO>> output = new BaseResponse<List<PropertyDTO>>();

        try {
            output.setData(PropertyService.getProperties(projectId));
            output.setMessage("Property succesfully retrieved!");
        } catch (Exception ex) {
            output.setError(ex.getMessage());
        }
        return output;
    }

}
