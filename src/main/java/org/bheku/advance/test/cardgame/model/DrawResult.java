package org.bheku.advance.test.cardgame.model;

import java.util.List;

public class DrawResult {

    private List<Card> cards;
    private String message;

    public DrawResult(List<Card> cards, String message) {
        this.cards = cards;
        this.message = message;
    }

    public List<Card> getCards() {
        return cards;
    }

    public String getMessage() {
        return message;
    }
}