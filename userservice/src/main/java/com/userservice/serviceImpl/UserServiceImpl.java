package com.userservice.serviceImpl;

import com.userservice.dto.UserWithHotelAndRatingDTO;
import com.userservice.entity.Hotel;
import com.userservice.entity.Ratings;
import com.userservice.entity.User;
import com.userservice.exception.UserNotFoundException;
import com.userservice.external.HotelServe;
import com.userservice.external.RatingService;
import com.userservice.repository.UserRepo;
import com.userservice.services.UserSErvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserSErvice {

    private final UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelServe hotelServe;

    @Autowired
    private RatingService ratingService;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);

    }

    @Override
    public List<UserWithHotelAndRatingDTO> getAllUsers() {
        List<User> users = userRepo.findAll();

        List<UserWithHotelAndRatingDTO> usersWithHotelAndRating = new ArrayList<>();
        //http://localhost:8083/getRatingByUserId/2


        for(User user : users) {
            UserWithHotelAndRatingDTO userWithHotelAndRatingDTO =new UserWithHotelAndRatingDTO();

//            using restTemplate
//            ResponseEntity<List<Ratings>> ratingsResponse =
//                    restTemplate
//                            .exchange("http://RATINGMS/getRatingByUserId/" + user.getId(),
//                                    HttpMethod.GET,
//                                    null,
//                                    new ParameterizedTypeReference<List<Ratings>>() {
//                                    }
//                            );
//            List<Ratings> ratings = ratingsResponse.getBody();
//
//            using feign client
            //use same getMapping method as used in original rating service
            List<Ratings> ratings = ratingService.getRatingByUserId(user.getId());


            List<Ratings> collectHOtels = ratings.stream().map(rating -> {

//                using restTemplate
//                Hotel forObject = restTemplate
//                        .getForObject("http://HOTELMS/gethotelbyid/"+rating.getHotelId(), Hotel.class);


//                using feign client
                Hotel forObject = hotelServe.getHotel(rating.getHotelId());
                rating.setHotel(forObject);
                System.out.println(rating);
                return rating;
            }).collect(Collectors.toList());

//            Hotel hotel = restTemplate
//                    .getForObject("http://localhost:8082/getHotelById/" + ratings.get(0).getHotelId(), Hotel.class);

//
            userWithHotelAndRatingDTO.setRatings(ratings);
            userWithHotelAndRatingDTO.setUser(user);
//            userWithHotelAndRatingDTO.setHotel(hotel);
            usersWithHotelAndRating.add(userWithHotelAndRatingDTO);

        }

        return usersWithHotelAndRating;
    }

    @Override
    public UserWithHotelAndRatingDTO getUserById(int userId) {
        //http://localhost:8083/getRatingByUserId/2
        UserWithHotelAndRatingDTO userWithHotelAndRatingDTO =new UserWithHotelAndRatingDTO();
        User user=userRepo.findById(userId)
                .orElseThrow(()->new UserNotFoundException("User with given id is not found on server !! : " + userId));


//        using feign client
        List<Ratings> ratingsList1 = ratingService.getRatingByUserId(user.getId());
        userWithHotelAndRatingDTO.setRatings(ratingsList1);
        userWithHotelAndRatingDTO.setUser(user);
        return userWithHotelAndRatingDTO;

    }

    @Override
    public User updateUser(User user, int id) {
        User user1 = userRepo.findById(id)
                    .orElseThrow(()->new UserNotFoundException("User with given id is not found on server !! : " + id));
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setAbout(user.getAbout());
        return userRepo.save(user1);
    }

    @Override
    public void deleteUser(int id) {
        userRepo.deleteById(id);

    }
}
