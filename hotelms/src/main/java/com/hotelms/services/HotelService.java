package com.hotelms.services;

import com.hotelms.entity.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel hotel);
    List<Hotel> getAllHotels();
    Hotel getHotelById(int id);
    Hotel updateHotel(Hotel hotel,int id);

    void deleteHotel(int id);
}
