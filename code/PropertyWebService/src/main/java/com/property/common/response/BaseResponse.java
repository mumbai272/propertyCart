//============================================================
//Copyright 2017, Drona, Inc. All rights reserved.
//============================================================
package com.property.common.response;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class BaseResponse implements Serializable {

    public static final Long FAILED_CODE = -1L;

    private String message;

    private Long statusCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public Long getStatusCode() {
        return statusCode;
    }


    public void setStatusCode(Long statusCode) {
        this.statusCode = statusCode;
    }


}
