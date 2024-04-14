package org.bheku.advance.test.cardgame.model;

import org.bheku.advance.test.cardgame.logic.ShuffleLogic;

import java.util.ArrayList;
import java.util.List;

public class Deck<T extends ShuffleLogic> {

    private final T t;
    private ArrayList<Card> cards;

    public Deck(T t) {
        this.t = t;
        addCards();
        shuffle();
    }

    public void shuffle(){
        t.shuffle(cards);
    }

    private void addCards(){

        if(cards == null) {
            cards = new ArrayList<>();
        }

        for (int i=0; i<13; i++)
        {
            Rank value = Rank.values()[i];

            for (int j=0; j<4; j++)
            {
                Card card = new Card(Suit.values()[j], value);
                this.cards.add(card);
            }
        }
    }

    public ArrayList<Card> getCards() {

        return cards;

    }

    public List<Card> draw(int numberOfRequestedCards){

        List<Card> drawnCards = new ArrayList<>();

        while(!this.cards.isEmpty() && numberOfRequestedCards > 0 ){
            if(!drawnCards.contains(cards.get(0))) {
                drawnCards.add(this.cards.remove(0));
                numberOfRequestedCards--;
            }
        }

        if(this.cards.isEmpty()){
            addCards();
            shuffle();
        }

        return drawnCards;
    }
}
