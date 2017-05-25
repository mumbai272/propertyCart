package com.app.property.service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.property.service.AddressService;
import com.app.property.service.dto.AddressDTO;
import com.app.property.service.dto.BaseResponse;

@Controller
@RequestMapping("/address")
public class AddressRestService {

    @Autowired
    private AddressService addressBO;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<AddressDTO> addAddress(@RequestBody AddressDTO addressDTO) {
        BaseResponse<AddressDTO> output = new BaseResponse<AddressDTO>();

        try {
            output.setData(addressBO.addAddress(addressDTO));
            output.setMessage("Address succesfully added!");
        } catch (Exception ex) {
            output.setError("Error - adding the address");
        }

        return output;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateAddress(@RequestBody AddressDTO addressDTO) {
        BaseResponse<AddressDTO> output = new BaseResponse<AddressDTO>();

        try {
            output.setData(addressBO.updateAddress(addressDTO));
        } catch (Exception ex) {
            return ex.toString();
        }
        return "Address succesfully updated!";
    }

    @RequestMapping(value = "/get/{addressId}", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse<AddressDTO> getAddress(@PathVariable("addressId") long addressId) {
        BaseResponse<AddressDTO> output = new BaseResponse<AddressDTO>();

        try {
            output.setData(addressBO.getAddress(addressId));
            output.setMessage("Address succesfully retrieved!");
        } catch (Exception ex) {
            output.setError(ex.getMessage());
        }
        return output;
    }


}
