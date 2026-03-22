package com.digitalcorewebservices.firstJobApp.review.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.digitalcorewebservices.firstJobApp.company.Company;
import com.digitalcorewebservices.firstJobApp.company.CompanyRepository;
import com.digitalcorewebservices.firstJobApp.review.Review;
import com.digitalcorewebservices.firstJobApp.review.ReviewRepository;
import com.digitalcorewebservices.firstJobApp.review.ReviewService;

@Service
public class ReviewServiceImplementation implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final CompanyRepository companyRepository;

    public ReviewServiceImplementation(ReviewRepository reviewRepository, CompanyRepository companyRepository) {
        this.reviewRepository = reviewRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Review> findReviewsByCompanyId(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean createReview(Long companyId, Review review) {
        Optional<Company> company = companyRepository.findById(companyId);
        if (company.isPresent()) {
            review.setCompany(company.get());
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review findReviewByReviewId(Long companyId, Long reviewId) {
        return reviewRepository.findByIdAndCompanyId(reviewId, companyId);
    }

    @Override
    public boolean updateReviewById(Long companyId, Long reviewId, Review updatedReview) {
        Review review = reviewRepository.findByIdAndCompanyId(reviewId, companyId);
        if (review != null) {
            review.setComment(updatedReview.getComment());
            review.setRating(updatedReview.getRating());
            review.setReviewerName(updatedReview.getReviewerName());
            reviewRepository.save(review);
            return true;
        } else {
            return false;
        }
    }
}
