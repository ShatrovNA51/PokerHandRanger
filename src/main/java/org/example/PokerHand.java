package org.example;

import java.util.Arrays;

/**
 * Created by nshatrov on 18.08.2023.
 */

public class PokerHand {

    private final Card[] cards = new Card[5];

    private PokerHand(String[] cardsArr) {
        for (int i = 0; i < cards.length; i++) {
            cards[i] = Card.fromString(cardsArr[i]);
        }

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

}
