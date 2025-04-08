package com.hotelms.external;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ratings {
    private int ratingId;
    private int userId;
    private int hotelId;
    private int rating;
    private String feedback;
}
