package org.example.combinationmatcher;

import org.example.Card;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PairMatcherTest {

    private final CombinationMatcher pairMatcher = new PairMatcher();

    @Test
    @DisplayName("Should return false when there are no pairs in the hand")
    void matchWhenNoPairsInHand() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(Card.fromString("2S"));
        hand.add(Card.fromString("3H"));
        hand.add(Card.fromString("KD"));
        hand.add(Card.fromString("AS"));
        hand.add(Card.fromString("4S"));

        assertFalse(pairMatcher.match(hand));
    }

    @Test
    @DisplayName("Should return true when there are pairs in the hand")
    void matchWhenPairsInHand() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(Card.fromString("2S"));
        hand.add(Card.fromString("3H"));
        hand.add(Card.fromString("AD"));
        hand.add(Card.fromString("AS"));
        hand.add(Card.fromString("4S"));

        assertTrue(pairMatcher.match(hand));
    }

}