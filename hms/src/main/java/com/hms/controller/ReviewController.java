package com.hms.controller;

import com.hms.entity.AppUser;
import com.hms.entity.Property;
import com.hms.entity.Review;
import com.hms.repository.PropertyRepository;
import com.hms.repository.ReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/app/v1/review")
public class ReviewController {

    private final PropertyRepository propertyRepository;
    private final ReviewRepository reviewRepository;

    public ReviewController(PropertyRepository propertyRepository, ReviewRepository reviewRepository) {
        this.propertyRepository = propertyRepository;
        this.reviewRepository = reviewRepository;
    }

    // Endpoint: http://localhost:8080/app/v1/review?propertyId=1
    @PostMapping
    public ResponseEntity<?> writeReview(
            @RequestBody Review review,
            @RequestParam("propertyId") long propertyId,
            @AuthenticationPrincipal AppUser appUser
    ) {
        // Validate property existence
        Optional<Property> propertyOptional = propertyRepository.findById(propertyId);
        if (propertyOptional.isEmpty()) {
            return new ResponseEntity<>("Property not found", HttpStatus.NOT_FOUND);
        }

        // Associate the review with the authenticated user and the property
        Property property = propertyOptional.get();
        review.setAppUser(appUser); // Assuming `Review` has an `AppUser` field
        review.setBookingId(propertyId); // Assuming propertyId is linked to a booking

        // Save the review
        Review savedReview = reviewRepository.save(review);

        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }
}
