package org.bheku.advance.test.cardgame.model;

import org.bheku.advance.test.cardgame.logic.BasicShuffle;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void deck_size_is_52(){

        Deck<BasicShuffle> deck = new Deck<>(new BasicShuffle());
        ArrayList<Card> cards = deck.getCards();
        assertEquals(52, cards.size());

    }

    @Test
    void deck_repopulates_when_emptied(){

        Deck<BasicShuffle> deck = new Deck<>(new BasicShuffle());
        deck.draw(52);
        ArrayList<Card> cards = deck.getCards();
        assertEquals(52, cards.size());

    }

}