package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokerHandTest {


    @Test
    @DisplayName("Should return HIGH_CARD when no other combinations match")
    void getCombinationWhenNoOtherCombinationsMatch() {
        PokerHand pokerHand = PokerHand.fromString("2H 3D 5S 9C KD");

        Combination expectedCombination = Combination.HIGH_CARD;
        Combination actualCombination = pokerHand.getCombination();

        assertEquals(expectedCombination, actualCombination);
    }

    @Test
    @DisplayName("Should return the correct combination")
    void getCombinationWhenCombinationIsNull() {
        PokerHand pokerHand = PokerHand.fromString("2H 3H 4H 5H 6H");

        Combination expectedCombination = Combination.STRAIGHT_FLUSH;
        Combination actualCombination = pokerHand.getCombination();

        assertEquals(expectedCombination, actualCombination);
    }

    @Test
    @DisplayName("Should return the correct combination")
    void getCombinationWhenCombinationIsNotNull() {
        PokerHand pokerHand = PokerHand.fromString("2D 3H 4H 5H 6H");

        Combination expectedCombination = Combination.STRAIGHT;
        Combination actualCombination = pokerHand.getCombination();

        assertEquals(expectedCombination, actualCombination);
    }

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