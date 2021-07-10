package com.learnTDD;

public class truncateA {

    public String removeA(String str) {

        if(str.length() <= 1){
            return str.replaceAll("A", "");
        }

        return removeAFromFirstTwoChars(str) + str.substring(2);
    }

    private String removeAFromFirstTwoChars(String str) {

        return str.substring(0,2).replaceAll("A", "");
    }

    public boolean areFirstTwoAndLastTwoCharMatching(String str) {
        int length = str.length();
        if(length <= 2) return false;

        String firstTwoChars = str.substring(0,2);
        String lastTwoChars = str.substring(length - 2);

        return firstTwoChars.equals(lastTwoChars);
    }
}
