package org.example.combinationmatcher;

import org.example.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FullHouseMatcherTest {

    private FullHouseMatcher fullHouseMatcher;

    @BeforeEach
    void setUp() {
        fullHouseMatcher = new FullHouseMatcher();
    }

    @Test
    @DisplayName("Should return false when hand does not contain a full house")
    void matchWhenHandDoesNotContainFullHouse() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(Card.fromString("2S"));
        hand.add(Card.fromString("2S"));
        hand.add(Card.fromString("2D"));
        hand.add(Card.fromString("3C"));
        hand.add(Card.fromString("4S"));

        assertFalse(fullHouseMatcher.match(hand));
    }

    @Test
    @DisplayName("Should return true when hand contains a full house")
    void matchWhenHandContainsFullHouse() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(Card.fromString("2S"));
        hand.add(Card.fromString("2H"));
        hand.add(Card.fromString("2D"));
        hand.add(Card.fromString("3C"));
        hand.add(Card.fromString("3S"));

        boolean result = fullHouseMatcher.match(hand);

        assertTrue(result);
    }

}