package com.ratingms.controller;

import com.ratingms.entity.Rating;
import com.ratingms.service.RatingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
<<<<<<< HEAD
=======
//@RequestMapping("/rating")
>>>>>>> 07e3a19 (gate ways added)
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("addrating")
    public Rating createRating(@RequestBody Rating rating){
        return ratingService.createRating(rating);
    }

    @GetMapping("getallratings")
    public List<Rating> getAllRatings(){
        return ratingService.getAllRatings();
    }

    @GetMapping("getratingbyid/{id}")
    public Rating getRatingById(@PathVariable int id){
        return ratingService.getRatingById(id);
    }

    @PutMapping("updateRating/{id}")
    public Rating updateRating(@RequestBody Rating rating,@PathVariable int id){
        return ratingService.updateRating(rating,id);
    }

    @DeleteMapping("deleteRating/{id}")
    public void deleteRating(@PathVariable int id){
        ratingService.deleteRating(id);
    }

    @GetMapping("getRatingByUserId/{userId}")
    public List<Rating> getRatingByUserId(@PathVariable int userId){
        return ratingService.getRatingByUserId(userId);
    }

    @GetMapping("getRatingByHotelId/{hotelId}")
    public List<Rating> getRatingByHotelId(@PathVariable int hotelId){
        return ratingService.getRatingByHotelId(hotelId);
    }
}
