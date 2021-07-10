package com.learnTDD;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class areMatchingTest {

    // first test case is "", false
    // second test case is "A", false
    // third test case is "AB", false
    // fourth test case is "ABC", false
    // fifth test case is "AAA", true
    // sixth test case is "ABCAB", true
    // seventh test case is "ZWASEOKROKFGPKMDGZW"

    private truncateA ta = new truncateA();

    @Test
    public void returns_false_when_string_is_empty() {
        boolean result = ta.areFirstTwoAndLastTwoCharMatching("");
        assertFalse(result);
    }

    @Test
    public void returns_false_when_string_is_A() {
        boolean result = ta.areFirstTwoAndLastTwoCharMatching("A");
        assertFalse(result);
    }

    @Test
    public void returns_false_when_string_is_AB() {
        boolean result = ta.areFirstTwoAndLastTwoCharMatching("AB");
        assertFalse(result);
    }

    @Test
    public void returns_false_when_string_is_ABC() {
        boolean result = ta.areFirstTwoAndLastTwoCharMatching("ABC");
        assertFalse(result);
    }

    @Test
    public void returns_true_when_string_is_AAA() {
        boolean result = ta.areFirstTwoAndLastTwoCharMatching("AAA");
        assertTrue(result);
    }

    @Test
    public void returns_true_when_string_is_ABCAB() {
        boolean result = ta.areFirstTwoAndLastTwoCharMatching("ABCAB");
        assertTrue(result);
    }

    @Test
    public void returns_true_when_string_is_ZWASEOKROKFGPKMDGZW() {
        boolean result = ta.areFirstTwoAndLastTwoCharMatching("ZWASEOKROKFGPKMDGZW");
        assertTrue(result);
    }
}
