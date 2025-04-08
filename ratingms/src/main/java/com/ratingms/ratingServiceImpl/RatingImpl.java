package com.ratingms.ratingServiceImpl;

import com.ratingms.entity.Rating;
import com.ratingms.exception.ResourceNotFOundException;
import com.ratingms.repository.RatingRepo;
import com.ratingms.service.RatingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingImpl implements RatingService {

    private final RatingRepo ratingRepo;

    public RatingImpl(RatingRepo ratingRepo) {
        this.ratingRepo = ratingRepo;
    }


    @Override
    public Rating createRating(Rating rating) {
        return ratingRepo.save(rating);

    }

    @Override
    public List<Rating> getAllRatings() {
        List<Rating> ratings = ratingRepo.findAll();
        return ratings;

    }

    @Override
    public Rating getRatingById(int id) {
        Rating rating = ratingRepo
                        .findById(id)
                        .orElseThrow(()->new ResourceNotFOundException("Rating Not Found with id : "+id));
        return rating;
    }

    @Override
    public Rating updateRating(Rating rating, int id) {
        Rating rating1 = ratingRepo
                .findById(id)
                .orElseThrow(()->new ResourceNotFOundException("Rating Not Found with id : "+id));

        rating1.setRating(rating.getRating());
        rating1.setFeedback(rating.getFeedback());
        rating1.setFeedback(rating.getFeedback());
        return ratingRepo.save(rating1);
    }

    @Override
    public void deleteRating(int id) {
        ratingRepo.deleteById(id);
    }

    @Override
    public List<Rating> getRatingByUserId(int userId) {
        List<Rating> ratings = ratingRepo.findByUserId(userId);
        return ratings;
    }

    @Override
    public List<Rating> getRatingByHotelId(int hotelId) {
        List<Rating> ratings = ratingRepo.findByHotelId(hotelId);
        return null;
    }
}
