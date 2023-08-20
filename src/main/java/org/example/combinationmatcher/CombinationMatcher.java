package org.example.combinationmatcher;

import org.example.Card;

import java.util.ArrayList;

public interface CombinationMatcher {
    boolean match(ArrayList<Card> hand);
}
