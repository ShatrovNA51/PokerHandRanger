package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Created by nshatrov on 18.08.2023.
 */
@Getter
@Setter
public class Card implements Comparable<Card> {
    private Rank rank;
    private Suit suit;

    private Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public static Card fromString(String cardString) {

        if (cardString == null || cardString.length() < 2) {
            throw new IllegalArgumentException("wrong string");
        }

        char rankChar = cardString.charAt(0);
        char suitChar = cardString.charAt(1);
        Rank tmpRank;
        Suit tmpSuit;

        if (Character.isDigit(rankChar)) {
            int num = Character.getNumericValue(rankChar);
            if (num < 2 || num > 9) {
                throw new IllegalArgumentException("wrong card rank");
            } else {
                tmpRank = Rank.values()[num - 2];
            }
        } else {
            switch (rankChar) {
                case 'T' -> tmpRank = Rank.TEN;
                case 'J' -> tmpRank = Rank.JACK;
                case 'Q' -> tmpRank = Rank.QUEEN;
                case 'K' -> tmpRank = Rank.KING;
                case 'A' -> tmpRank = Rank.ACE;
                default -> throw new IllegalArgumentException("wrong card rank");
            }
        }

        switch (suitChar) {
            case 'S' -> tmpSuit = Suit.S;
            case 'H' -> tmpSuit = Suit.H;
            case 'D' -> tmpSuit = Suit.D;
            case 'C' -> tmpSuit = Suit.C;
            default -> throw new IllegalArgumentException("wrong card suit");
        }


        return new Card(tmpRank, tmpSuit);
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.getRank().ordinal(), o.getRank().ordinal());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}
