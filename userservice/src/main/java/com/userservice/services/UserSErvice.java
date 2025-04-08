package com.userservice.services;

import com.userservice.dto.UserWithHotelAndRatingDTO;
import com.userservice.entity.User;

import java.util.List;

public interface UserSErvice {
    User saveUser(User user);
    List<UserWithHotelAndRatingDTO> getAllUsers();
    UserWithHotelAndRatingDTO getUserById(int userId);
    User updateUser(User user,int id);
    void deleteUser(int id);
}
