package com.property.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.property.entity.Property;

public interface PropertyDao extends PagingAndSortingRepository<Property, Long> {
	List<Property> findByProjectId(Long projectId);

}
