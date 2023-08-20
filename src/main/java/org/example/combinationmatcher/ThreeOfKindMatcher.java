package org.example.combinationmatcher;

import org.example.Card;
import org.example.Rank;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

public class ThreeOfKindMatcher implements CombinationMatcher {
    @Override
    public boolean match(ArrayList<Card> hand) {
        Map<Rank, Integer> countRank = new EnumMap<>(Rank.class);
        for (Card card : hand) {
            countRank.merge(card.getRank(), 1, Integer::sum);
        }
        for (Integer i : countRank.values()) {
            if (i == 3) {
                return true;
            }
        }
        return false;
    }
}
