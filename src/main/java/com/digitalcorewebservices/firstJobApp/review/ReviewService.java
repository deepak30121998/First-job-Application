package com.digitalcorewebservices.firstJobApp.review;

import java.util.List;

public interface ReviewService {
    public List<Review> findReviewsByCompanyId(Long companyId);
    public boolean createReview(Long companyId, Review review);
    public Review findReviewByReviewId(Long companyId, Long reviewId);
    public boolean updateReviewById(Long companyId, Long reviewId, Review review);
}
