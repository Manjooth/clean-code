package com.bowlingKata;

import java.util.Arrays;

public class BowlingGame {

    int[] pinsKnocked = new int[20];
    int total = 0, index = 0;

    public void roll(int pins) {
        pinsKnocked[index] = pins;
        index++;
    }

    public int score() {
        for (int i = 0; i < 20; i = i + 0) {
            int turnSum = pinsKnocked[i] + pinsKnocked[i + 1];
            if(pinsKnocked[i] == 10){
                total += 10 + pinsKnocked[i+1] + pinsKnocked[i+2];
                i ++;
            } else if(turnSum == 10){
                total += turnSum + pinsKnocked[i+2];
                i = i + 2;
            }else{
                total += turnSum;
                i = i + 2;
            }
        }
        return total;
    }
}
