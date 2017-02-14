//============================================================
//Copyright 2017, Drona, Inc. All rights reserved.
//============================================================
package com.property.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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


}
