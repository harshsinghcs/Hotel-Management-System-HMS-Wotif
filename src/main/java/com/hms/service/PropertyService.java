package com.hms.service;

import com.hms.entity.Property;
import com.hms.repository.PropertyRepository;
import org.springframework.transaction.annotation.Transactional;

public class PropertyService {
    private final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Transactional
    public Property createProperty(Property property) {
        // Perform multiple operations in a single transaction
        return propertyRepository.save(property);
    }

    @Transactional
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
