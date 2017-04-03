package com.app.property.service.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.app.property.service.models.Project;
import com.app.property.service.models.Property;

@Repository
@Transactional
public class PropertyDAO {

	public Property addProperty(Property property) {
		entityManager.persist(property);
		return property;
	}

	public Property update(Property property) {
		return entityManager.merge(property);
	}
	
	@SuppressWarnings("unchecked")
	public List<Property> getAll() {
		return entityManager.createQuery("from Property").getResultList();
	}

	public Property getNewProperties(String isNew) {
		return (Property) entityManager.createQuery("from Property where isNew = :isNew")
				.setParameter("isNew", isNew).getSingleResult();
	}

	public Property getById(long id) {
		return entityManager.find(Property.class, id);
	}
	public List<Property> getPropertiesByProjectId(long id) {
	    return  entityManager.createQuery("from Property where projectId = :projectId")
                .setParameter("projectId", id).getResultList();  }
	
	
	
	public Project update(Project project) {
		return entityManager.merge(project);
	}

	public Project addProject(Project project) {
		entityManager.persist(project);
		return project;
	}

	public Project getByProjectId(long id) {
		return entityManager.find(Project.class, id);
	}
	public List<Project> getAllProjects() {
        return entityManager.createQuery("from Project").getResultList();
    }
	
	@PersistenceContext
	private EntityManager entityManager;
}
