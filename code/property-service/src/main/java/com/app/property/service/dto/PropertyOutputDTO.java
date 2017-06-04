package com.app.property.service.dto;

public class PropertyOutputDTO {
	private PropertyDTO property;
	private AddressDTO address;
    
    public PropertyDTO getProperty() {
        return property;
    }
    
    public void setProperty(PropertyDTO property) {
        this.property = property;
    }
    
    public AddressDTO getAddress() {
        return address;
    }
    
    public void setAddress(AddressDTO address) {
        this.address = address;
    }
	
	
}
