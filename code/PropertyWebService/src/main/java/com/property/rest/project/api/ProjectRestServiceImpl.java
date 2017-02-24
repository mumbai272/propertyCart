//============================================================
//Copyright 2017, Drona, Inc. All rights reserved.
//============================================================
package com.property.rest.project.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.property.rest.project.requestResponse.ProjectListResponse;
import com.property.rest.project.service.ProjectServiceImpl;

@Component
public class ProjectRestServiceImpl {

    private static final Logger logger = Logger.getLogger(ProjectRestServiceImpl.class);

    @Autowired
    private ProjectServiceImpl projectService;


    @GET
    @Path(value = "/project")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getCollection() {
        ProjectListResponse response = projectService.getPropertList();
        return Response.ok(response).build();

    }

    // @GET
    // @Procedure({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    // @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    // public getEntity() {}

}
