package com.userservice.controller;

import com.userservice.dto.UserWithHotelAndRatingDTO;
import com.userservice.entity.User;
import com.userservice.services.UserSErvice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
<<<<<<< HEAD
=======
//@RequestMapping("/user")
>>>>>>> 07e3a19 (gate ways added)
public class userController {

    private final UserSErvice userSErvice;

    public userController(UserSErvice userSErvice) {
        this.userSErvice = userSErvice;
    }

    @PostMapping("createUser")
    public User createUser(@RequestBody User user){
        return userSErvice.saveUser(user);

    }

    @GetMapping("getallusers")
    public List<UserWithHotelAndRatingDTO> getAllUsers(){
        return userSErvice.getAllUsers();
    }

    @GetMapping("getuserbyid/{id}")
    public UserWithHotelAndRatingDTO getUserById(@PathVariable int id){
        return userSErvice.getUserById(id);
    }

    @PutMapping("updateuser/{id}")
    public User updateUser(@RequestBody User user, @PathVariable int id){
        return userSErvice.updateUser(user,id);
    }

    @DeleteMapping("deleteuser/{id}")
    public void deleteUser(@PathVariable int id){
        userSErvice.deleteUser(id);
    }

}
