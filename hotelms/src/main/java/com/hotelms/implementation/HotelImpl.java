package com.hotelms.implementation;

import com.hotelms.dto.HotelWithRatings;
import com.hotelms.entity.Hotel;
import com.hotelms.exception.ResourceNotFoundException;
import com.hotelms.external.Ratings;
import com.hotelms.repository.HotelRepo;
import com.hotelms.services.HotelService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class HotelImpl implements HotelService {

    private final HotelRepo hotelRepo;


    public HotelImpl(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = hotelRepo.findAll();
        return hotels;
    }

    @Override
    public Hotel getHotelById(int id) {

        RestTemplate restTemplate = new RestTemplate();
        Hotel hotel = hotelRepo.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("Hotel Not Found with id"+ id));

        HotelWithRatings hotelWithRatings = new HotelWithRatings();

        hotelWithRatings.setHotel(hotel);
//        List<Ratings> ratings = restTemplate
//                .exchange("http://localhost:8083/getratingbyid/",)
        return hotel;
    }

    @Override
    public Hotel updateHotel(Hotel hotel, int id) {
        Hotel hotel1 = hotelRepo
                        .findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("Hotel Not Found with id"+ id));
        hotel1.setName(hotel.getName());
        hotel1.setLocation(hotel.getLocation());
        hotel1.setAbout(hotel.getAbout());

        return hotelRepo.save(hotel1);
    }

    @Override
    public void deleteHotel(int id) {
        hotelRepo.deleteById(id);
    }
}
