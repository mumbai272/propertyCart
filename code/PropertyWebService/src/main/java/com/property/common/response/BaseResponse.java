//============================================================
//Copyright 2017, Drona, Inc. All rights reserved.
//============================================================
package com.property.common.response;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class BaseResponse implements Serializable {

    private String status;

    private Long statusCode;


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public Long getStatusCode() {
        return statusCode;
    }


    public void setStatusCode(Long statusCode) {
        this.statusCode = statusCode;
    }


}
