package com.app.property.service.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.app.property.service.models.Image;

@Repository
@Transactional
public class ImageDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Image> getImagesByType(List<Long> projectIds, String type) {
		return entityManager.createQuery("from Image i where i.project.id in (" + StringUtils.collectionToCommaDelimitedString(projectIds) + ") and i.type='" + type+"'").getResultList();
	}
	public List<Image> getImages(Long projectId){
		return entityManager.createQuery("from Image i where i.project.id="+projectId).getResultList();
	}
    public List<Image> getImagesByType(Long projectId, String type) {
        return entityManager.createQuery("from Image i where i.project.id=" + projectId + " and i.type='" + type+"'").getResultList();
    }
	public Image getImageByType(Long projectId, String type) {
		return (Image)entityManager.createQuery("from Image i where i.project.id=" + projectId + " and i.type='" + type+"'").getResultList().get(0);
	}
	public Image getImageById(long imageId) {
		return entityManager.find(Image.class, imageId);
    }

}
