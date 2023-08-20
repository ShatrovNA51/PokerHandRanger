package org.example.combinationmatcher;

import org.example.Card;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ThreeOfKindMatcherTest {

    private final CombinationMatcher threeOfKindMatcher = new ThreeOfKindMatcher();

    @Test
    @DisplayName("Should return true when there are three cards of the same rank")
    void matchWhenThreeCardsOfSameRank() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(Card.fromString("2S"));
        hand.add(Card.fromString("2H"));
        hand.add(Card.fromString("2D"));
        hand.add(Card.fromString("3C"));
        hand.add(Card.fromString("4S"));

        assertTrue(threeOfKindMatcher.match(hand));
    }

    @Test
    @DisplayName("Should return false when there no three cards of the same rank")
    void matchWhenNoThreeCardsOfSameRank() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(Card.fromString("2S"));
        hand.add(Card.fromString("2H"));
        hand.add(Card.fromString("3D"));
        hand.add(Card.fromString("3C"));
        hand.add(Card.fromString("4S"));

        assertFalse(threeOfKindMatcher.match(hand));
    }

}