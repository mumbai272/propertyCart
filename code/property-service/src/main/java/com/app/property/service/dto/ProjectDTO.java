package com.app.property.service.dto;

import java.util.ArrayList;
import java.util.List;

import com.app.property.service.models.Project;

public class ProjectDTO {
	public long id;
	public boolean isNew;
	public String title;
	public long addressId;
	public long userId;
	private AddressDTO address;
	private String thumbnailImage;
	private List<ImageDTO> images;

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public String getThumbnailImage() {
		return thumbnailImage;
	}

	public void setThumbnailImage(String thumbnailImage) {
		this.thumbnailImage = thumbnailImage;
	}

	public List<ImageDTO> getImages() {
		return images;
	}

	public void setImages(List<ImageDTO> images) {
		this.images = images;
	}

	public Project toModel() {
		return updateModel(new Project());
	}

	public Project updateModel(Project project) {
		project.setNew(this.isNew);
		project.setTitle(this.title);
		project.setAddressId(this.addressId);

		if(this.id > 0) {
			project.setId(this.id);
		}

		if(this.addressId > 0) {
			project.setAddressId(this.addressId);
		}

		if(this.userId > 0) {
			project.setAddressId(this.userId);
		}

		return project;
	}

	public void  addImages(ImageDTO image) {
		if(images == null) {
			images = new ArrayList<>();
		}
		images.add(image);
	}

}
