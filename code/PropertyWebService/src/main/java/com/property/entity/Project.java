//============================================================
//Copyright 2017, Drona, Inc. All rights reserved.
//============================================================
package com.property.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * Entity for the project
 * 
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Feb 14, 2017
 */
@Entity
@Table(name = "PROJECT")
public class Project extends AuditData {

    @Id
    @TableGenerator(name = "tableGenerator", table = "primaryKeyTable", pkColumnName = "Id", pkColumnValue = "ProjectId_Next_Value", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tableGenerator")
    private Long id;

    @Column(name = "Project_Name", nullable = false, length = 100)
    private String projectName;

    @Column(name = "SHORT_DESC", length = 150)
    private String shortDesc;

    @Column(name = "ADDRESS_ID", unique = true)
    private Long addressId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_ID", insertable = false, updatable = false)
    private Address address;

    @Column(name = "STATUS", nullable = false, length = 50)
    private String status;

    @Column(name = "STARTING_PRICE", nullable = false, length = 50)
    private String startingPrice;

    @Column(name = "RATING")
    private Long rating;

    @OneToMany(targetEntity = ProjectDetails.class, mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProjectDetails> projectDetails;


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


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
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
    
    public List<ProjectDetails> getProjectDetails() {
        return projectDetails;
    }
    
    public void setProjectDetails(List<ProjectDetails> projectDetails) {
        this.projectDetails = projectDetails;
    }



}
