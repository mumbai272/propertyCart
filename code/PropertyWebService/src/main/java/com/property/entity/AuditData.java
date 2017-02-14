//============================================================
//Copyright 2017, Drona, Inc. All rights reserved.
//============================================================
package com.property.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Audit data
 * 
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Feb 14, 2017
 */
public class AuditData {

    @Column(name = "CREATED_BY")
    private Long createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE")
    private Calendar createdDate;

    @Column(name = "LAST_MODIFIED_BY")
    private Long lastModifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_MODIFIED_DATE")
    private Calendar lastModifiedDate;


    public Long getCreatedBy() {
        return createdBy;
    }


    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }


    public Calendar getCreatedDate() {
        return createdDate;
    }


    public void setCreatedDate(Calendar createdDate) {
        this.createdDate = createdDate;
    }


    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }


    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }


    public Calendar getLastModifiedDate() {
        return lastModifiedDate;
    }


    public void setLastModifiedDate(Calendar lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

}
