package com.property.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.property.entity.ProjectResources;
@Repository
public interface ProjectResourcesDao extends PagingAndSortingRepository<ProjectResources, Long> {
	List<ProjectResources> findByProjectId(Long projectId);

}
