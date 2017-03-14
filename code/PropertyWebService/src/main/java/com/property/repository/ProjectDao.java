//============================================================
//Copyright 2017, Drona, Inc. All rights reserved.
//============================================================
package com.property.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import com.property.entity.Project;

@Component
public interface ProjectDao extends PagingAndSortingRepository<Project, Long> {

}
