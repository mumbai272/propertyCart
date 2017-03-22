package com.app.property.service.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.app.property.service.dto.ImageDTO;

@Entity
@Table(name = "ps_image")
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String imageName;
	
	@NotNull
	private String type;
	
	@NotNull
	private String status; // Active or Inactive or Blocked

	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;
	
	@ManyToOne
	@JoinColumn(name="property_id")
	private Property property;
	
	@NotNull
	@Column(name="is_active")
	private boolean isActive;
	
	@NotNull
	@Column(name="is_blocked")	
	private boolean isBlocked;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public ImageDTO toDTO() {
		ImageDTO dto = new ImageDTO();
		dto.setId(this.id);
		dto.setType(this.type);
		dto.setImageName(this.imageName);
		dto.setUrl("api/project/image/"+this.id);
		return dto;
	}
	
}
