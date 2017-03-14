package com.app.property.service.dto;

import com.app.property.service.models.Address;

public class AddressDTO {
	public long id;
	public String street;
	public String area;
	public String city;
	public String state;
	public String country;
	public long zipcode;
	public double latitude;
	public double longitude;
	
	public Address toModel() {
		return this.updateModel(new Address());
	}
	
	public Address updateModel(Address address) {
		address.setStreet(this.street);
		address.setArea(this.area);
		address.setCity(this.city);
		address.setState(this.state);
		address.setCountry(this.country);
		address.setZipcode(this.zipcode);
		address.setLatitude(this.latitude);
		address.setLongitude(this.longitude);
		return address;
	}
}
