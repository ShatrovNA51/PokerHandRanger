package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokerHandTest {

    @Test
    @DisplayName("Should throw an exception when the input string does not contain exactly 5 cards")
    void fromStringWhenInputDoesNotContainFiveCardsThenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> PokerHand.fromString("2H 3D 4S 5C"));
    }

    @Test
    @DisplayName("Should throw an exception when the input string is null or empty")
    void fromStringWhenInputIsEmptyOrNullThenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> PokerHand.fromString(null));

        assertThrows(IllegalArgumentException.class, () -> PokerHand.fromString(""));
    }

    @Test
    @DisplayName("Should create a PokerHand object when the input string is valid")
    void fromStringWhenInputIsValid() {
        String validHandString = "2H 3D 5S 9C KD";
        PokerHand pokerHand = PokerHand.fromString(validHandString);

        assertNotNull(pokerHand);
        assertEquals(5, pokerHand.getCards().length);
    }

}