package com.hotelms.controller;

import com.hotelms.entity.Hotel;
import com.hotelms.services.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("addhotel")
    public Hotel addHotel(@RequestBody Hotel hotel){
        return hotelService.createHotel(hotel);
    }

    @GetMapping("getallhotels")
    public List<Hotel> getAllHotels(){
        return hotelService.getAllHotels();
    }

    @GetMapping("gethotelbyid/{id}")
    public Hotel getHotelById(@PathVariable int id){
        return hotelService.getHotelById(id);
    }

    @PutMapping("updatehotel/{id}")
    public Hotel updateHotel(@RequestBody Hotel hotel,@PathVariable int id){
        return hotelService.updateHotel(hotel,id);
    }

    @DeleteMapping("deletehotel/{id}")
    public void deleteHotel(@PathVariable int id){
        hotelService.deleteHotel(id);
    }

}
