package org.example.combinationmatcher;

import org.example.Card;

import java.util.ArrayList;

public class FlushMatcher implements CombinationMatcher {
    @Override
    public boolean match(ArrayList<Card> hand) {
        for (int i = 0; i < hand.size() - 1; i++) {
            if (hand.get(i).getSuit() != hand.get(i + 1).getSuit()) {
                return false;
            }
        }
        return true;
    }
}
