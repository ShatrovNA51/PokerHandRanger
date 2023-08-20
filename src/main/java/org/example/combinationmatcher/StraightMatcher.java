package org.example.combinationmatcher;

import org.example.Card;

import java.util.ArrayList;


public class StraightMatcher implements CombinationMatcher {
    //Hand must be sorted by rank in ascending order
    @Override
    public boolean match(ArrayList<Card> hand) {
        for (int i = 0; i < hand.size() - 1; i++) {
            if (hand.get(i).getRank().ordinal() - hand.get(i + 1).getRank().ordinal() != -1) {
                return false;
            }
        }
        return true;
    }
}
