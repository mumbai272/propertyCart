package com.app.property.service.rest;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.property.service.bo.ProjectService;
import com.app.property.service.dto.ProjectDTO;
import com.app.property.service.dto.WSOutputDTO;

@Controller
@RequestMapping("/project")
public class ProjectRestService {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public WSOutputDTO<ProjectDTO> createProperty(@RequestBody ProjectDTO projectDTO) {
        WSOutputDTO<ProjectDTO> output = new WSOutputDTO<ProjectDTO>();

        try {
            output.setObject(projectService.addProject(projectDTO));
            output.setMessage("Property succesfully added!");
        } catch (Exception ex) {
            output.setError("Error - adding the Project");
        }

        return output;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public String updateProject(@RequestBody ProjectDTO projectDTO) {
        WSOutputDTO<ProjectDTO> output = new WSOutputDTO<ProjectDTO>();

        try {
            output.setObject(projectService.updateProject(projectDTO));
        } catch (Exception ex) {
            return ex.toString();
        }
        return "Project succesfully updated!";
    }

    @RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
    @ResponseBody
    public WSOutputDTO<ProjectDTO> getProject(@PathVariable("projectId") long projectId) {
        WSOutputDTO<ProjectDTO> output = new WSOutputDTO<ProjectDTO>();

        try {
            output.setObject(projectService.getProject(projectId));
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
    public WSOutputDTO<List<ProjectDTO>> getProjects() {
        WSOutputDTO<List<ProjectDTO>> output = new WSOutputDTO<List<ProjectDTO>>();

        try {
            output.setObject(projectService.getProjects());
            output.setMessage("Property succesfully retrieved!");
        } catch (Exception ex) {
            output.setError(ex.getMessage());
        }
        return output;
    }

    @RequestMapping(value = "/image/{imageId}", method = RequestMethod.GET)
    public void getProjectImage(@PathVariable("imageId") long imageId, HttpServletResponse response)
            throws IOException {
        File f = projectService.getProjectImages(imageId);

        String mimeType = URLConnection.guessContentTypeFromName(f.getName());
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }

        response.setContentType(mimeType);

        response.setHeader("Content-Disposition",
            String.format("inline; filename=\"" + f.getName() + "\""));
        response.setContentLength((int) f.length());

        InputStream inputStream = new BufferedInputStream(new FileInputStream(f));

        // Copy bytes from source to destination(outputstream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());

    }

}
