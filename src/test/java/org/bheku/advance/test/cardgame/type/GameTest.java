package org.bheku.advance.test.cardgame.type;

import org.bheku.advance.test.cardgame.logic.BasicShuffle;
import org.bheku.advance.test.cardgame.logic.FiveCardDrawLogic;
import org.bheku.advance.test.cardgame.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    @Test
    void five_card_draw_wiring_test(){

        FiveCardDrawLogic gameLogic = new FiveCardDrawLogic();
        Deck<BasicShuffle> deck = new Deck<>(new BasicShuffle());

        Game<BasicShuffle, FiveCardDrawLogic> game = new Game<>(deck,gameLogic);

        DrawResult hand = game.getHand();
        assertEquals(5, hand.getCards().size());
    }

    @Test
    void logic_PAIR_test(){
        List<Card> cards = List.of(
          new Card(Suit.CLUBS, Rank.QUEEN),
          new Card(Suit.DIAMONDS, Rank.QUEEN),
          new Card(Suit.SPADES, Rank.TWO),
          new Card(Suit.HEARTS, Rank.THREE),
          new Card(Suit.SPADES, Rank.KING)
        );
        FiveCardDrawLogic gameLogic = new FiveCardDrawLogic();
        DrawResult evaluate = gameLogic.evaluate(cards);
        assertEquals(Category.PAIR.toString(), evaluate.getMessage());
    }

    @Test
    void logic_QUADS_test(){
        List<Card> cards = List.of(
                new Card(Suit.CLUBS, Rank.QUEEN),
                new Card(Suit.DIAMONDS, Rank.QUEEN),
                new Card(Suit.SPADES, Rank.QUEEN),
                new Card(Suit.HEARTS, Rank.QUEEN),
                new Card(Suit.SPADES, Rank.KING)
        );
        FiveCardDrawLogic gameLogic = new FiveCardDrawLogic();
        DrawResult evaluate = gameLogic.evaluate(cards);
        assertEquals(Category.QUADS.toString(), evaluate.getMessage());
    }

    @Test
    void logic_TWO_PAIR_test(){
        List<Card> cards = List.of(
                new Card(Suit.CLUBS, Rank.QUEEN),
                new Card(Suit.DIAMONDS, Rank.QUEEN),
                new Card(Suit.SPADES, Rank.THREE),
                new Card(Suit.HEARTS, Rank.THREE),
                new Card(Suit.SPADES, Rank.KING)
        );
        FiveCardDrawLogic gameLogic = new FiveCardDrawLogic();
        DrawResult evaluate = gameLogic.evaluate(cards);
        assertEquals(Category.TWO_PAIR.toString(), evaluate.getMessage());
    }

    @Test
    void logic_STRAIGHT_test(){
        List<Card> cards = List.of(
                new Card(Suit.DIAMONDS, Rank.TEN),
                new Card(Suit.SPADES, Rank.NINE),
                new Card(Suit.HEARTS, Rank.EIGHT),
                new Card(Suit.DIAMONDS, Rank.SEVEN),
                new Card(Suit.CLUBS, Rank.SIX)
        );
        FiveCardDrawLogic gameLogic = new FiveCardDrawLogic();
        DrawResult evaluate = gameLogic.evaluate(cards);
        assertEquals(Category.STRAIGHT.toString(), evaluate.getMessage());
    }

    @Test
    void logic_FLUSH_test(){
        List<Card> cards = List.of(
                new Card(Suit.DIAMONDS, Rank.JACK),
                new Card(Suit.DIAMONDS, Rank.NINE),
                new Card(Suit.DIAMONDS, Rank.EIGHT),
                new Card(Suit.DIAMONDS, Rank.FOUR),
                new Card(Suit.DIAMONDS, Rank.THREE)
        );
        FiveCardDrawLogic gameLogic = new FiveCardDrawLogic();
        DrawResult evaluate = gameLogic.evaluate(cards);
        assertEquals(Category.FLUSH.toString(), evaluate.getMessage());
    }

    @Test
    void logic_FULL_HOUSE_test(){
        List<Card> cards = List.of(
                new Card(Suit.SPADES, Rank.SIX),
                new Card(Suit.HEARTS, Rank.SIX),
                new Card(Suit.DIAMONDS, Rank.SIX),
                new Card(Suit.CLUBS, Rank.KING),
                new Card(Suit.HEARTS, Rank.KING)
        );
        FiveCardDrawLogic gameLogic = new FiveCardDrawLogic();
        DrawResult evaluate = gameLogic.evaluate(cards);
        assertEquals(Category.FULL_HOUSE.toString(), evaluate.getMessage());
    }

    @Test
    void logic_STRAIGHT_FLUSH_test(){
        List<Card> cards = List.of(
                new Card(Suit.CLUBS, Rank.JACK),
                new Card(Suit.CLUBS, Rank.TEN),
                new Card(Suit.CLUBS, Rank.NINE),
                new Card(Suit.CLUBS, Rank.EIGHT),
                new Card(Suit.CLUBS, Rank.SEVEN)
        );
        FiveCardDrawLogic gameLogic = new FiveCardDrawLogic();
        DrawResult evaluate = gameLogic.evaluate(cards);
        assertEquals(Category.STRAIGHT_FLUSH.toString(), evaluate.getMessage());
    }

    @Test
    void logic_HIGH_CARD_test(){
        List<Card> cards = List.of(
                new Card(Suit.DIAMONDS, Rank.KING),
                new Card(Suit.DIAMONDS, Rank.QUEEN),
                new Card(Suit.SPADES, Rank.SEVEN),
                new Card(Suit.SPADES, Rank.FOUR),
                new Card(Suit.HEARTS, Rank.THREE)
        );
        FiveCardDrawLogic gameLogic = new FiveCardDrawLogic();
        DrawResult evaluate = gameLogic.evaluate(cards);
        assertEquals(Category.HIGH_CARD.toString(), evaluate.getMessage());
    }

    @Test
    void logic_TRIPS_test(){
        List<Card> cards = List.of(
                new Card(Suit.CLUBS, Rank.QUEEN),
                new Card(Suit.SPADES, Rank.QUEEN),
                new Card(Suit.HEARTS, Rank.QUEEN),
                new Card(Suit.HEARTS, Rank.NINE),
                new Card(Suit.SPADES, Rank.TWO)
        );
        FiveCardDrawLogic gameLogic = new FiveCardDrawLogic();
        DrawResult evaluate = gameLogic.evaluate(cards);
        assertEquals(Category.TRIPS.toString(), evaluate.getMessage());
    }

}