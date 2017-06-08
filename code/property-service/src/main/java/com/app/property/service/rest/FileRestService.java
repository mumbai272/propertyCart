package com.app.property.service.rest;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.app.property.service.ProjectService;
import com.app.property.service.PropertyService;
import com.app.property.service.dto.BaseResponse;
import com.app.property.service.dto.ImageDTO;

/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Jun 4, 2017
 */
@Controller
@RequestMapping("/project")
public class FileRestService {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private PropertyService PropertyService;

    /**
     * @param projectId
     * @return
     */
    @RequestMapping(value = "/image/list/{projectId}", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse<ArrayList<ImageDTO>> getAllProjectImage(
            @PathVariable("projectId") long projectId) {
        BaseResponse<ArrayList<ImageDTO>> response = new BaseResponse<ArrayList<ImageDTO>>();
        ArrayList<ImageDTO> dto =
            (ArrayList<ImageDTO>) projectService.getAllProjectImages(projectId);
        response.setData(dto);
        return response;
    }

    /**
     * @param imageId
     * @param response
     * @throws IOException
     */
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

    /**
     * Upload single file using Spring Controller
     */
    @RequestMapping(value = "/{projectId}/uploadFile", method = RequestMethod.POST)
    public @ResponseBody BaseResponse uploadFileHandler(@PathVariable("projectId") long projectId,
            @RequestParam("type") String type, @RequestParam("file") MultipartFile file) {
        BaseResponse response = new BaseResponse();
        if (!file.isEmpty()) {
            try {
                projectService.saveImage(projectId, type, file);

                response.setStatus(1l);
                response.setMessage("You successfully uploaded file");

            } catch(FileSizeLimitExceededException e){
                response.setStatus(-1L);
                response.setMessage(e.getMessage());
            }catch (Exception e) { 
                response.setStatus(-1L);
                response.setMessage("You failed to upload file");
            }
        } else {
            response.setMessage("You failed to upload  because the file was empty.");
        }
        return response;
    }

    @RequestMapping(value = "/image/{imageId}", method = RequestMethod.DELETE)
    public @ResponseBody BaseResponse deleteImage(@PathVariable("imageId") long imageId) {
        BaseResponse response = new BaseResponse();
        try {
            projectService.deleteImage(imageId);
            response.setStatus(1L);
            response.setMessage("deleted successfully");
        } catch (Exception e) {
            response.setStatus(-1L);
            response.setMessage("Failed to delete image");
        }
        return response;
    }
}
