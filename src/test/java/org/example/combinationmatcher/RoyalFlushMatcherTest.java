package org.example.combinationmatcher;

import org.example.Card;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RoyalFlushMatcherTest {

    private final CombinationMatcher royalFlushMatcher = new RoyalFlushMatcher();


    @Test
    @DisplayName("Should return true when the hand is a royal flush")
    void matchWhenHandIsRoyalFlush() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(Card.fromString("TS"));
        hand.add(Card.fromString("JS"));
        hand.add(Card.fromString("QS"));
        hand.add(Card.fromString("KS"));
        hand.add(Card.fromString("AS"));

        assertTrue(royalFlushMatcher.match(hand));
    }

    @Test
    @DisplayName("Should return false when the hand is not a royal flush")
    void matchWhenHandIsNotRoyalFlush() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(Card.fromString("2S"));
        hand.add(Card.fromString("3S"));
        hand.add(Card.fromString("4S"));
        hand.add(Card.fromString("5S"));
        hand.add(Card.fromString("6S"));

        assertFalse(royalFlushMatcher.match(hand));
    }

}