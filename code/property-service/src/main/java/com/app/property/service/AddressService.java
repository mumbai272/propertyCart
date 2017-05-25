package com.app.property.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.property.service.dao.AddressDAO;
import com.app.property.service.dto.AddressDTO;
import com.app.property.service.models.Address;

@Repository
public class AddressService {

	public AddressDTO getAddress(long addressId) throws Exception {
		Address address = addressDAO.getById(addressId);
		
		if(address != null) {
			return address.toDTO();
		}else {
			throw new RuntimeException("Invalid address id : " + addressId);
		}
	}
	
	public AddressDTO addAddress(AddressDTO dto) {	
		return addressDAO.addAddress(dto.toModel()).toDTO();
	}
	
	public AddressDTO updateAddress(AddressDTO dto) {
		Address address = addressDAO.getById(dto.id);
		if(address.getId() == dto.id) {
			address = dto.updateModel(address);
			addressDAO.update(address);
		}
		return address.toDTO();
	}

	@Autowired
	private AddressDAO addressDAO;

}
