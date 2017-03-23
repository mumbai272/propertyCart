//============================================================
//Copyright 2017, Drona, Inc. All rights reserved.
//============================================================
package com.property.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity for the project
 * 
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Feb 14, 2017
 */
@Entity
@Table(name = "PROJECT")
public class Project extends AuditData {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "TITLE", nullable = false, length = 100)
	private String title;

	@Column(name = "SHORT_DESC", length = 150)
	private String shortDesc;

	@Column(name = "ADDRESS_ID", nullable = false)
	private Long addressId;

	@ManyToOne()
	@JoinColumn(name = "ADDRESS_ID", insertable = false, updatable = false)
	private Address address;

	@Column(name = "STATUS", nullable = false)
	private Long status;

	@Column(name = "STARTING_PRICE", nullable = false, length = 50)
	private String startingPrice;

	@Column(name = "RATING")
	private Long rating;

	@OneToMany(targetEntity = Property.class, mappedBy = "project", cascade = CascadeType.ALL)
	private List<Property> properies;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
    public String getTitle() {
        return title;
    }

    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getStartingPrice() {
		return startingPrice;
	}

	public void setStartingPrice(String startingPrice) {
		this.startingPrice = startingPrice;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public List<Property> getProperies() {
		return this.properies;
	}

	public void setProperies(List<Property> properies) {
		this.properies = properies;
	}

	
}
