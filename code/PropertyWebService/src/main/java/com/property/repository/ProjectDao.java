//============================================================
//Copyright 2017, Drona, Inc. All rights reserved.
//============================================================
package com.property.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.property.entity.Project;

@Repository
public interface ProjectDao extends PagingAndSortingRepository<Project, Long> {

}
