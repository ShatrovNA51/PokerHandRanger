package org.example.combinationmatcher;

import org.example.Card;
import org.example.Rank;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

public class TwoPairMatcher implements CombinationMatcher {
    @Override
    public boolean match(ArrayList<Card> hand) {
        Map<Rank, Integer> countRank = new EnumMap<>(Rank.class);
        for (Card card : hand) {
            countRank.merge(card.getRank(), 1, Integer::sum);
        }
        int countPairs = 0;
        for (Integer i : countRank.values()) {
            if (i == 2) {
                countPairs++;
            }
        }
        return countPairs == 2;
    }
}
