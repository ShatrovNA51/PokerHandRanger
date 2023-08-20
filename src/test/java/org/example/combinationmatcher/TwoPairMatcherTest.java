package org.example.combinationmatcher;

import org.example.Card;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TwoPairMatcherTest {

    private final CombinationMatcher twoPairMatcher = new TwoPairMatcher();

    @Test
    @DisplayName("Should return false when there are less than two pairs in the hand")
    void matchWhenLessThanTwoPairsInHand() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(Card.fromString("2S"));
        hand.add(Card.fromString("2H"));
        hand.add(Card.fromString("3D"));
        hand.add(Card.fromString("4C"));
        hand.add(Card.fromString("5S"));

        assertFalse(twoPairMatcher.match(hand));
    }

    @Test
    @DisplayName("Should return true when there are two pairs in the hand")
    void matchWhenMoreThanTwoPairsInHand() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(Card.fromString("2S"));
        hand.add(Card.fromString("2H"));
        hand.add(Card.fromString("3D"));
        hand.add(Card.fromString("3C"));
        hand.add(Card.fromString("4S"));

        assertTrue(twoPairMatcher.match(hand));
    }

}