//============================================================
//Copyright 2017, Drona, Inc. All rights reserved.
//============================================================
package com.property.rest.property.requestResponse;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="property")
public class PropertyDTO {
private String name;
private String shortDesc;
private String status;
private Long rating;
}
