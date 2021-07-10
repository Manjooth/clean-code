package com.c.refactoring.movie;

import com.c.refactoring.StringUtils;

import java.util.Arrays;
import java.util.List;

public class MyMovieRefactor {

    String rating;

    public MyMovieRefactor(String rating) {
        super();
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }

    /*Axx or By
    Where x represents any digit between 0 and 9, and y represents 
    any digit between 1 and 4*/
    public boolean isValidRating() {
        String getRatingSubstring = getRating().substring(0, 1);

        if (getRating() != null) {

            if (checkIfBCase()) return true;

            if (checkIfACase(getRatingSubstring)) return true;


        }
        return false;
    }

    private boolean checkIfACase(String getRatingSubstring) {
        return getRatingSubstring.equalsIgnoreCase("A")
                && getRating().length() == 3
                && StringUtils.isNumeric(getRating().substring(1, 3));
    }

    private boolean checkIfBCase() {
        List<String> validBRatings = Arrays.asList("B1","B2","B3","B4");

        return validBRatings.contains(rating);
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
