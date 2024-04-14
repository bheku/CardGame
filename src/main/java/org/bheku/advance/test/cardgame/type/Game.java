package org.bheku.advance.test.cardgame.type;

import org.bheku.advance.test.cardgame.logic.HandEvaluatorLogic;
import org.bheku.advance.test.cardgame.logic.ShuffleLogic;
import org.bheku.advance.test.cardgame.model.Card;
import org.bheku.advance.test.cardgame.model.Deck;
import org.bheku.advance.test.cardgame.model.DrawResult;

import java.util.List;

public class Game<D extends ShuffleLogic,E extends HandEvaluatorLogic> {

    private final Deck<D> deck;
    private final HandEvaluatorLogic evaluator;

    public Game(Deck<D> deck, HandEvaluatorLogic evaluator) {
        this.deck = deck;
        this.evaluator = evaluator;
    }

    public DrawResult getHand(){

        List<Card> drawn = deck.draw(5);

        return evaluator.evaluate(drawn);

    }
}
