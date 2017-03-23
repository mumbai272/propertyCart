package com.property.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.property.entity.Property;
@Repository
public interface PropertyDao extends PagingAndSortingRepository<Property, Long> {
	List<Property> findByProjectId(Long projectId);

}
