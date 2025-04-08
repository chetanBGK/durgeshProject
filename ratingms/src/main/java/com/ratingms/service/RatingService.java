package com.ratingms.service;

import com.ratingms.entity.Rating;

import java.util.List;

public interface RatingService {
    Rating createRating(Rating rating);
    List<Rating> getAllRatings();
    Rating getRatingById(int id);
    Rating updateRating(Rating rating,int id);
    void deleteRating(int id);

    List<Rating> getRatingByUserId(int userId);

    List<Rating> getRatingByHotelId(int hotelId);
}
