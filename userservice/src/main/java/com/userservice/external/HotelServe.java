package com.userservice.external;

import com.userservice.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOTELMS")
public interface HotelServe {
    @GetMapping("gethotelbyid/{id}")
    public Hotel getHotel(@PathVariable int id);
}
