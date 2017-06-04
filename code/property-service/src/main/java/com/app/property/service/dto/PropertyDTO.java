package com.app.property.service.dto;


public class PropertyDTO {
	private long id;
	private long bedrooms;
	private double price;
	private boolean isNew;
	private long addressId;
	private long projectId;
	private long userId;
	private long size;
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public long getBedrooms() {
        return bedrooms;
    }
    
    public void setBedrooms(long bedrooms) {
        this.bedrooms = bedrooms;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public boolean isNew() {
        return isNew;
    }
    
    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }
    
    public long getAddressId() {
        return addressId;
    }
    
    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }
    
    public long getProjectId() {
        return projectId;
    }
    
    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }
    
    public long getUserId() {
        return userId;
    }
    
    public void setUserId(long userId) {
        this.userId = userId;
    }
    
    public Long getSize() {
        return size;
    }
    
    public void setSize(String size) {
        this.size = Long.parseLong(size);
    }
    public void setSize(long size) {
        this.size = size;
    }
	
	
}
