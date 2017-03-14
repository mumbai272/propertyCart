//============================================================
//Copyright 2017, Drona, Inc. All rights reserved.
//============================================================
package com.property.rest.project.api;

import java.io.File;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.property.rest.project.requestResponse.ProjectDeatilsResponse;
import com.property.rest.project.requestResponse.ProjectListResponse;
import com.property.rest.project.service.ProjectServiceImpl;

@Component
public class ProjectRestServiceImpl {

	private static final Logger logger = Logger.getLogger(ProjectRestServiceImpl.class);

	@Autowired
	private ProjectServiceImpl projectService;

	/**
	 * get the list of projects
	 * 
	 * @return
	 */
	@GET
	@Path(value = "/project")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getCollection() {
		ProjectListResponse response = projectService.getProjectList();
		return Response.ok(response).build();

	}
	@GET
	@Path(value = "/project/{projectId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getEntity(@Valid @NotNull @PathParam("projectId") Long projectId) {
		ProjectDeatilsResponse response = projectService.getProjectDetails(projectId);
		return Response.ok(response).build();

	}

	@GET
	@Path(value = "/project/resource/{projectId}/{fileId}")
	@Produces({ MediaType.APPLICATION_OCTET_STREAM })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getProjectResource(@PathParam("projectId") Long projectId, @PathParam("fileId") Long fileId) {
		File file = projectService.getProjectResource(projectId, fileId);
		ResponseBuilder response = Response.ok((Object)file);
		response.header("Content-Disposition", "attachment;filename=filename");

		return response.build();

	}

}
