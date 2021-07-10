package com.learnTDD;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class truncateATest {

    private truncateA ta = new truncateA();

    // first test case would be "" to ""
    // second test case would be "A" to ""
    // third test case would be "AA" to ""
    // fourth test case would be "AACD" to "CD"
    // fifth test case would be "ADAC" to "DAC"

    // TDD is red, green, refactor
    @Test
    public void returns_empty_string_when_empty() {
        String result = ta.removeA("");
        assertEquals("", result);
    }

    @Test
    public void returns_empty_string_when_string_is_A() {
        String result = ta.removeA("A");
        assertEquals("", result);
    }

    @Test
    public void returns_empty_string_when_string_is_AA() {
        String result = ta.removeA("AA");
        assertEquals("", result);
    }

    @Test
    public void returns_string_when_string_is_AACD() {
        String result = ta.removeA("AACD");
        assertEquals("CD", result);
    }

    @Test
    public void returns_string_when_string_is_ADAC() {
        String result = ta.removeA("ADAC");
        assertEquals("DAC", result);
    }

    @Test
    public void returns_string_when_string_is_ZAAC() {
        String result = ta.removeA("ZAAC");
        assertEquals("ZAC", result);
    }

    @Test
    public void returns_string_when_string_is_BDAAACB() {
        String result = ta.removeA("BDAAACB");
        assertEquals("BDAAACB", result);
    }

}
