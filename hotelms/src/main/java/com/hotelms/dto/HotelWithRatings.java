package com.hotelms.dto;

import com.hotelms.entity.Hotel;
import com.hotelms.external.Ratings;
import com.hotelms.external.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HotelWithRatings {
    Hotel hotel;
    List<Ratings> ratings;
    List<User> users;
}
