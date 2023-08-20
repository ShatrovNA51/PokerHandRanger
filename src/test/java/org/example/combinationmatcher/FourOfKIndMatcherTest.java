package org.example.combinationmatcher;

import org.example.Card;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
class FourOfKIndMatcherTest {

    private final CombinationMatcher fourOfKindMatcher = new FourOfKIndMatcher();

    @Test
    @DisplayName("Should return false when there are not four cards of the same rank")
    void matchWhenNotFourCardsOfSameRank() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(Card.fromString("2S"));
        hand.add(Card.fromString("3H"));
        hand.add(Card.fromString("4D"));
        hand.add(Card.fromString("5C"));
        hand.add(Card.fromString("KD"));

        assertFalse(fourOfKindMatcher.match(hand));
    }

    @Test
    @DisplayName("Should return true when there are four cards of the same rank")
    void matchWhenFourCardsOfSameRank() {

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(Card.fromString("2S"));
        hand.add(Card.fromString("2H"));
        hand.add(Card.fromString("2D"));
        hand.add(Card.fromString("2C"));
        hand.add(Card.fromString("3C"));

        assertTrue(fourOfKindMatcher.match(hand));
    }

}