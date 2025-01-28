package com.hms.repository;

import com.hms.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    @Query("select p from Property p JOIN p.city c  JOIN p.country co where c.name=:city or co.name=:country")
    List<Property> searchHotels(
            @Param("city") String cityName,
            @Param("country") String countryName
    );
}