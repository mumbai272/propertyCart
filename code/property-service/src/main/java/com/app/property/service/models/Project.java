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

@Entity
@Table(name = "ps_project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String title;

    @NotNull
    @Column(name = "address_id", unique = true, nullable = false)
    private long addressId;

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID", insertable = false, updatable = false)
    private Address address;

    @NotNull
    @Column(name = "user_id")
    private long userId;

    @Column(name = "STATUS", nullable = false)
    private Long status;

    @Column(name = "STARTING_PRICE", nullable = false, length = 50)
    private String startingPrice;

    @Column(name = "IS_ACTIVE", nullable = false, length = 1)
    private String isActive = "0";

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

    
    public String getIsActive() {
        return isActive;
    }

    
    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

}
