package org.example.combinationmatcher;

import org.example.Card;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class StraightMatcherTest {

    private final CombinationMatcher straightMatcher = new StraightMatcher();

    @Test
    @DisplayName("Should return true when the hand is a straight")
    void matchWhenHandIsStraight() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(Card.fromString("2S"));
        hand.add(Card.fromString("3H"));
        hand.add(Card.fromString("4D"));
        hand.add(Card.fromString("5C"));
        hand.add(Card.fromString("6S"));

        assertTrue(straightMatcher.match(hand));
    }

    @Test
    @DisplayName("Should return false when the hand is not a straight")
    void matchWhenHandIsNotStraight() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(Card.fromString("2S"));
        hand.add(Card.fromString("3H"));
        hand.add(Card.fromString("4D"));
        hand.add(Card.fromString("5C"));
        hand.add(Card.fromString("7S"));

        assertFalse(straightMatcher.match(hand));
    }

}