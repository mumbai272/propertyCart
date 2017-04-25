package com.app.property.service.dto;

import java.util.ArrayList;
import java.util.List;

import com.app.property.service.models.Project;

/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com>
 * Created on Apr 2, 2017
 */
public class ProjectDTO {
	public long id;
	private String status;
	public String title;
	private String startingPrice;
	public long addressId;
	public long userId;
	private AddressDTO address;
	private String thumbnailImage;
	private List<ImageDTO> images;

	
    public long getId() {
        return id;
    }

    
    public void setId(long id) {
        this.id = id;
    }

    
    public String getTitle() {
        return title;
    }

    
    public void setTitle(String title) {
        this.title = title;
    }

    
    
    public String getStartingPrice() {
        return startingPrice;
    }


    
    public void setStartingPrice(String startingPrice) {
        this.startingPrice = startingPrice;
    }


    public long getAddressId() {
        return addressId;
    }

    
    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    
    public long getUserId() {
        return userId;
    }

    
    public void setUserId(long userId) {
        this.userId = userId;
    }

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
//		project.setIsNew(this.isNew);
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

    
    public String getStatus() {
        return status;
    }

    
    public void setStatus(String status) {
        this.status = status;
    }
	

}
