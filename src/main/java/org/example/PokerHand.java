package org.example;

import java.util.Arrays;

/**
 * Created by nshatrov on 18.08.2023.
 */

public class PokerHand implements Comparable<PokerHand> {

    private final Card[] cards = new Card[5];
    private final Card highCard;

    private Combination combination;

    private PokerHand(String[] cardsArr) {
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



}
