package com.userservice.external;

import com.userservice.entity.Ratings;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="RATINGMS")
public interface RatingService {

    //use same getMapping method as used in original rating service

    @GetMapping("getRatingByUserId/{userId}")
    public List<Ratings> getRatingByUserId(@PathVariable int userId);
}
