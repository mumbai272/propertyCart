//============================================================
//Copyright 2017, Drona, Inc. All rights reserved.
//============================================================
package com.property.rest.project.requestResponse;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "id", "projectName", "shortDesc", "startingPrice", "status", "rating",
        "address" })
public class ProjectDTO implements Serializable {

    private Long id;

    private String projectName;

    private String shortDesc;

    private String startingPrice;

    private String status;

    private Long rating;

    private AddressDTO address;

    private String thumbnailUrl;

    private List<PropertyDTO> properties;

    private List<PropertyResourceDTO> resources;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(String startingPrice) {
        this.startingPrice = startingPrice;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public List<PropertyDTO> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyDTO> properties) {
        this.properties = properties;
    }

    public List<PropertyResourceDTO> getResources() {
        return resources;
    }

    public void setResources(List<PropertyResourceDTO> resources) {
        this.resources = resources;
    }

    
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

}
