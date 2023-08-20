package org.example;

import org.example.combinationmatcher.*;

import java.util.*;

/**
 * Created by nshatrov on 18.08.2023.
 */

public class PokerHand implements Comparable<PokerHand> {

    private final Card[] cards = new Card[5];
    private final Card highCard;

    private final Map<Combination, CombinationMatcher> combinationMatchers;

    private final Combination combination;

    private Map<Combination, CombinationMatcher> initCombinationMatcher() {
        Map<Combination, CombinationMatcher> initCombinationMatchers = new LinkedHashMap<>();
        initCombinationMatchers.put(Combination.ROYAL_FLUSH, new RoyalFlushMatcher());
        initCombinationMatchers.put(Combination.STRAIGHT_FLUSH, new StraightFlashMatcher());
        initCombinationMatchers.put(Combination.FOUR_OF_KIND, new FourOfKIndMatcher());
        initCombinationMatchers.put(Combination.FULL_HOUSE, new FullHouseMatcher());
        initCombinationMatchers.put(Combination.FLUSH, new FlushMatcher());
        initCombinationMatchers.put(Combination.STRAIGHT, new StraightMatcher());
        initCombinationMatchers.put(Combination.THREE_OF_KIND, new ThreeOfKindMatcher());
        initCombinationMatchers.put(Combination.TWO_PAIRS, new TwoPairMatcher());
        initCombinationMatchers.put(Combination.PAIR, new PairMatcher());
        return initCombinationMatchers;
    }

    private PokerHand(String[] cardsArr) {
        combinationMatchers = initCombinationMatcher();
        for (int i = 0; i < cards.length; i++) {
            cards[i] = Card.fromString(cardsArr[i]);
        }
        Arrays.sort(cards);
        highCard = cards[4];
        combination = getCombination();
    }

    public static PokerHand fromString(String handString) {
        if (handString == null || handString.isEmpty()) {
            throw new IllegalArgumentException("hand string is empty");
        }
        String[] cardsArr = handString.split(" ");
        if (cardsArr.length != 5) {
            throw new IllegalArgumentException("wrong length of string");
        }
        return new PokerHand(cardsArr);
    }

    public Card[] getCards() {
        return Arrays.copyOf(cards, cards.length);
    }

    public Combination getCombination() {
        if (combination == null) {
            for (Map.Entry<Combination, CombinationMatcher> entry : combinationMatchers.entrySet()) {
                if (entry.getValue().match(new ArrayList<>(Arrays.asList(cards)))) {
                    return entry.getKey();
                }
            }
            return Combination.HIGH_CARD;
        } else {
            return combination;
        }
    }

    public Card getHighCard() {
        return highCard;
    }

    @Override
    public int compareTo(PokerHand o) {
        if (this.getCombination() == o.getCombination()) {
            return Integer.compare(o.getHighCard().getRank().ordinal(), this.getHighCard().getRank().ordinal());
        } else {
            return Integer.compare(o.getCombination().ordinal(), this.getCombination().ordinal());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokerHand pokerHand = (PokerHand) o;
        return Arrays.equals(cards, pokerHand.cards) && Objects.equals(highCard, pokerHand.highCard) && combination == pokerHand.combination;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(highCard, combination);
        result = 31 * result + Arrays.hashCode(cards);
        return result;
    }

    @Override
    public String toString() {
        return "PokerHand{" +
                "cards=" + Arrays.toString(cards) +
                '}';
    }
}
