package com.app.property.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.property.service.dao.AddressDAO;
import com.app.property.service.dao.PropertyDAO;
import com.app.property.service.dto.PropertyDTO;
import com.app.property.service.dto.PropertyOutputDTO;
import com.app.property.service.models.Property;

@Repository
@Transactional
public class PropertyService {

    @Autowired
    private PropertyDAO propertyDAO;

    @Autowired
    private AddressDAO addressDAO;

    public PropertyOutputDTO getProperty(long propertyId) throws Exception {
        Property property = propertyDAO.getById(propertyId);

        if (property != null) {
            PropertyOutputDTO dto = toOutputDTO(property);
            return dto;
        } else {
            throw new RuntimeException("Invalid property id : " + propertyId);
        }
    }

    public List<PropertyDTO> getProperties(long projectId) throws Exception {
        List<Property> properties = propertyDAO.getPropertiesByProjectId(projectId);

        if (properties == null || properties.isEmpty()) {
            throw new RuntimeException("Invalid property id : " + projectId);
        }
        List<PropertyDTO> dtos = new ArrayList<PropertyDTO>();
        for (Property property : properties) {
            dtos.add(toDTO(property));
        }

        return dtos;
    }

    public PropertyDTO addProperty(PropertyDTO dto) {
        dto.setUserId(1);
        Property property = propertyDAO.addProperty(toModel(dto));
        return toDTO(property);
    }

    public PropertyDTO updateProperty(PropertyDTO dto) {
        Property property = propertyDAO.getById(dto.getId());
        if (property.getId() == dto.getId()) {
            property = updateModel(property, dto);
            propertyDAO.update(property);
        }
        return toDTO(property);
    }

    public Property toModel(PropertyDTO dto) {
        Property property = new Property();
        BeanUtils.copyProperties(dto, property);
        return property;
    }

    public Property updateModel(Property property, PropertyDTO dto) {
        BeanUtils.copyProperties(dto, property);
        return property;
    }

    public PropertyDTO toDTO(Property property) {
        PropertyDTO dto = new PropertyDTO();
        BeanUtils.copyProperties(property, dto);
        dto.setSize(property.getSize());
        return dto;
    }

    public PropertyOutputDTO toOutputDTO(Property property) {
        PropertyOutputDTO dto = new PropertyOutputDTO();
        dto.setProperty(toDTO(property));
        return dto;
    }


}
