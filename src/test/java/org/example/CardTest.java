package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    @DisplayName("Should throw an exception when the card rank is not a valid character (T, J, Q, K, A)")
    void fromStringWhenCardRankIsInvalidCharacterThenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Card.fromString("HS"));
    }

    @Test
    @DisplayName("Should throw an exception when the card suit is not a valid character (S, H, D, C)")
    void fromStringWhenCardSuitIsInvalidCharacterThenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Card.fromString("2X"));
    }

    @Test
    @DisplayName("Should throw an exception when the card rank is not a digit or not in the range 2-9")
    void fromStringWhenCardRankIsInvalidThenThrowException() {

        assertThrows(IllegalArgumentException.class, () -> Card.fromString("1S"));
    }

    @Test
    @DisplayName("Should throw an exception when the card string is null or less than 2 characters")
    void fromStringWhenCardStringIsNullOrShortThenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Card.fromString(null));

        assertThrows(IllegalArgumentException.class, () -> Card.fromString(""));

        assertThrows(IllegalArgumentException.class, () -> Card.fromString("A"));
    }

    @Test
    @DisplayName("Should return a valid Card object when the card string is valid")
    void fromStringWhenCardStringIsValidThenReturnCard() {
        String cardString = "2S";

        Card card = Card.fromString(cardString);

        assertNotNull(card);
        assertEquals(Rank.TWO, card.getRank());
        assertEquals(Suit.S, card.getSuit());
    }

}