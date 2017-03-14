package com.property.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.property.entity.ProjectResources;

public interface ProjectResourcesDao extends PagingAndSortingRepository<ProjectResources, Long> {
	List<ProjectResources> findByProjectId(Long projectId);

}
