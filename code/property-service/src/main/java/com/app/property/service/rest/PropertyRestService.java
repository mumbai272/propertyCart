package com.app.property.service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.property.service.PropertyService;
import com.app.property.service.dto.BaseResponse;
import com.app.property.service.dto.PropertyDTO;
import com.app.property.service.dto.PropertyOutputDTO;

@Controller
@RequestMapping("/property")
public class PropertyRestService {

    @Autowired
    private PropertyService PropertyService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<PropertyDTO> addProperty(@RequestBody PropertyDTO propertyDTO) {
        BaseResponse<PropertyDTO> output = new BaseResponse<PropertyDTO>();

        try {
            output.setData(PropertyService.addProperty(propertyDTO));
            output.setMessage("Property succesfully added!");
        } catch (Exception ex) {
            output.setError("Error - adding the Property");
        }

        return output;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String updateProperty(@RequestBody PropertyDTO propertyDTO) {
        try {
            BaseResponse<PropertyDTO> output = new BaseResponse<PropertyDTO>();
            output.setData(PropertyService.updateProperty(propertyDTO));
        } catch (Exception ex) {
            return ex.toString();
        }
        return "Property succesfully updated!";
    }

    @RequestMapping(value = "/{propertyId}", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse<PropertyOutputDTO> getProperty(@PathVariable("propertyId") long propertyId) {
        BaseResponse<PropertyOutputDTO> output = new BaseResponse<PropertyOutputDTO>();

        try {
            output.setData(PropertyService.getProperty(propertyId));
            output.setMessage("Property succesfully retrieved!");
        } catch (Exception ex) {
            output.setError(ex.getMessage());
        }
        return output;
    }


}
