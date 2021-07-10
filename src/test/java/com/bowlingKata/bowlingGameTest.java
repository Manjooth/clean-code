package com.bowlingKata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


// roll 0, 20 times, so 0
// roll 1, 20 times, so 20
// roll 2, 20 times, so 40
// roll 3, 20 times, so 60

// roll 1, 10 times and 2, 10 times, so 30
// spare: 5,5 1 18 times
// 10|10|10|10|1,1 = 30+30+21+12+2

public class bowlingGameTest {

    private BowlingGame game;

    @BeforeEach
    void setUp() {
        game = new BowlingGame();
    }

    private void rollMultipleTimes(int pinsKnockedDown, int noOfTimes) {
        for (int i = 0; i < noOfTimes; i++) {
            game.roll(pinsKnockedDown);
        }
    }

    @Test
    public void bowls_all_zero(){
        rollMultipleTimes(0, 20);
        assertEquals(0, game.score());
    }

    @Test
    public void bowls_all_ones(){
        rollMultipleTimes(1, 20);
        assertEquals(20, game.score());
    }

    @Test
    public void bowls_all_twos(){
        rollMultipleTimes(2, 20);
        assertEquals(40, game.score());
    }

    @Test
    public void bowls_all_threes(){
        rollMultipleTimes(3, 20);
        assertEquals(60, game.score());
    }

    @Test
    public void bowls_half_ones_half_twos(){
        rollMultipleTimes(1, 10);
        rollMultipleTimes(2, 10);
        assertEquals(30, game.score());
    }

    @Test
    public void bowls_one_spare(){
        rollMultipleTimes(5, 2);
        rollMultipleTimes(1, 18);
        assertEquals(29, game.score());
    }

    @Test
    public void bowls_two_spares(){
        rollMultipleTimes(5, 4);
        rollMultipleTimes(1, 16);
        assertEquals(42, game.score());
    }

    @Test
    public void bowls_one_strike(){
        rollMultipleTimes(10, 1);
        rollMultipleTimes(1, 18);
        assertEquals(29, game.score());
    }

}
