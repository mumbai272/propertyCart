//============================================================
//Copyright 2017, Drona, Inc. All rights reserved.
//============================================================
package com.property.rest.property.requestResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class PropertyListResponse implements Serializable {

    private List<PropertyDTO> properties = new ArrayList<>();


    public List<PropertyDTO> getProperties() {
        return properties;
    }


    public void setProperties(List<PropertyDTO> properties) {
        this.properties = properties;
    }

}
