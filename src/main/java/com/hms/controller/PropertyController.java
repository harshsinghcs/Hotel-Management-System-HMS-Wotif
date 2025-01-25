package com.hms.controller;

import com.hms.entity.Property;
import com.hms.repository.PropertyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    private final PropertyRepository propertyRepository;

    public PropertyController(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

//    @GetMapping("/search-hotels")
//    public ResponseEntity<?> searchHotels(@RequestParam(required = false) String city) {
//        if (city == null && city.isEmpty()) {
//            return new ResponseEntity<>("City name must be provided.", HttpStatus.BAD_REQUEST);
//        }
//
//        List<Property> properties = propertyRepository.searchHotels(city, null); // Assuming countryName can be null in your repository logic.
//
//        if (properties.isEmpty()) {
//            String message = "No properties found in the city '" + city + "'.";
//            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
//        }
//
//        return ResponseEntity.ok(properties); // Returning the found properties with HTTP 200.
//    }


    @GetMapping("/search-hotels")
    public List<Property> searchHotels(
            @RequestParam String cityName,
            @RequestParam String country
    ){
        List<Property> properties = propertyRepository.searchHotels(cityName, country);
        return properties;
    }

//    public List<Property>searchHotel(@RequestParam String name){
//        propertyRepository.searchByName(name);
//    }

    // Create a new Property
    @PostMapping
    public ResponseEntity<Property> createProperty(@RequestBody Property property) {
        Property savedProperty = propertyRepository.save(property);
        return ResponseEntity.ok(savedProperty);
    }

    // Retrieve all Properties
    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties() {
        List<Property> properties = propertyRepository.findAll();
        return ResponseEntity.ok(properties);
    }

    // Retrieve a single Property by ID
    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        Optional<Property> property = propertyRepository.findById(id);
        return property.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update a Property
    @PutMapping("/{id}/{Name}")
    public ResponseEntity<Property> updateProperty(
            @PathVariable Long id,
            @PathVariable String name,
            @RequestBody Property updatedProperty) {
        return propertyRepository.findById(id)
                .map(existingProperty -> {
                    existingProperty.setName(updatedProperty.getName());
                    existingProperty.setNo_of_guest(updatedProperty.getNo_of_guest());
                    existingProperty.setNo_of_bedrooms(updatedProperty.getNo_of_bedrooms());
                    existingProperty.setNo_of_bathrooms(updatedProperty.getNo_of_bathrooms());
                    existingProperty.setNo_of_beds(updatedProperty.getNo_of_beds());
                    existingProperty.setCountry(updatedProperty.getCountry());
                    existingProperty.setCity(updatedProperty.getCity());
                    propertyRepository.save(existingProperty);
                    return ResponseEntity.ok(existingProperty);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a Property
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id) {
        if (propertyRepository.existsById(id)) {
            propertyRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
