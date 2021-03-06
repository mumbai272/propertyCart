package com.property.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Feb 14, 2017
 */
@Entity
@Table(name = "ADDRESS")
public class Address {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "STREET1", length = 150, nullable = false)
	private String street1;

	@Column(name = "STREET2", length = 150)
	private String street2;

	@Column(name = "LOCALITY", length = 100, nullable = false)
	private String locality;

	@Column(name = "COUNTRY", length = 50, nullable = false)
	private String country;

	@Column(name = "STATE", length = 50)
	private String state;

	@Column(name = "CITY", length = 50, nullable = false)
	private String city;

	@Column(name = "ZIP_CODE", length = 50)
	private String zipCode;

	@Column(name = "CO_ORDINATE", length = 50)
	private String coordinates;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

}
