package com.digitalcorewebservices.firstJobApp.review;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/companies/{companyId}")
@RestController
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity <List<Review>> findreviewsByCompanyId(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.findReviewsByCompanyId(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> createReview(@PathVariable Long companyId, @RequestBody Review review) {
        boolean created = reviewService.createReview(companyId, review);
        if (created)
            return new ResponseEntity<>("Review Created Successfully!", HttpStatus.CREATED);
        return new ResponseEntity<>("Company Not Found!", HttpStatus.NOT_FOUND);
    }

    @GetMapping("reviews/{reviewId}")
    public ResponseEntity<Review> findReviewById(@PathVariable Long companyId , @PathVariable Long reviewId) {
        Review review = reviewService.findReviewByReviewId(companyId, reviewId);
        if (review != null) 
            return new ResponseEntity<>(review, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("reviews/{reviewId}")
    public ResponseEntity<String> updateReviewById(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review review) {
        boolean updated = reviewService.updateReviewById(companyId, reviewId, review);
        if (updated)
            return new ResponseEntity<>("Review Updated Successfully!!", HttpStatus.OK);
        return new ResponseEntity<>("Review Not Found", HttpStatus.NOT_FOUND);
    }
}
