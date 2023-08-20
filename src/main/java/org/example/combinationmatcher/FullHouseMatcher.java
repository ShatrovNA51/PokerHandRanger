package org.example.combinationmatcher;

import org.example.Card;
import org.example.Rank;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

public class FullHouseMatcher implements CombinationMatcher {
    @Override
    public boolean match(ArrayList<Card> hand) {
        Map<Rank, Integer> countRank = new EnumMap<>(Rank.class);
        for (Card card : hand) {
            countRank.merge(card.getRank(), 1, Integer::sum);
        }
        return countRank.containsValue(2) && countRank.containsValue(3);
    }
}
