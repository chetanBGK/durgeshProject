package com.userservice.dto;


import com.userservice.entity.Hotel;
import com.userservice.entity.Ratings;
import com.userservice.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter


public class UserWithHotelAndRatingDTO {
    User user;
    List<Ratings> ratings;
//    Hotel hotel;

}
