package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("Should sorted by combination")
    void mainTest() {
        ArrayList<PokerHand> hands = new ArrayList<>();
        PokerHand highCardHand = PokerHand.fromString("KS 2H 5C JD TD");
        PokerHand flushCardHand = PokerHand.fromString("2C 3C AC 4C 5C");
        hands.add(highCardHand);
        hands.add(flushCardHand);
        Collections.sort(hands);

        assertEquals(hands.get(0), flushCardHand);

    }

    @Test
    @DisplayName("Should sorted by high card rank if combination equals")
    void highCardTest() {
        ArrayList<PokerHand> hands = new ArrayList<>();

        PokerHand kingHighCardHand = PokerHand.fromString("KS 2H 5C JD TD");
        PokerHand aceHighCardHand = PokerHand.fromString("2C 3D AC 4C 5C");

        hands.add(kingHighCardHand);
        hands.add(aceHighCardHand);
        Collections.sort(hands);

        assertEquals(hands.get(0), aceHighCardHand);

    }

}
