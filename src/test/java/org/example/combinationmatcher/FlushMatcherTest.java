package org.example.combinationmatcher;

import org.example.Card;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FlushMatcherTest {
    private final CombinationMatcher flushMatcher = new FlushMatcher();

    @Test
    @DisplayName("Should return false when at least one card in the hand has a different suit")
    void matchWhenAtLeastOneCardHasDifferentSuit() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(Card.fromString("2S"));
        hand.add(Card.fromString("3S"));
        hand.add(Card.fromString("4S"));
        hand.add(Card.fromString("5S"));
        hand.add(Card.fromString("6H")); 

        assertFalse(flushMatcher.match(hand));
    }

    @Test
    @DisplayName("Should return true when all cards in the hand have the same suit")
    void matchWhenAllCardsHaveSameSuit() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(Card.fromString("2S"));
        hand.add(Card.fromString("5S"));
        hand.add(Card.fromString("7S"));
        hand.add(Card.fromString("JS"));
        hand.add(Card.fromString("AS"));

        assertTrue(flushMatcher.match(hand));
    }

}