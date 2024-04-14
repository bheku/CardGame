package org.bheku.advance.test.cardgame.logic;

import org.bheku.advance.test.cardgame.model.Card;
import org.bheku.advance.test.cardgame.model.DrawResult;

import java.util.List;

public interface HandEvaluatorLogic {
    DrawResult evaluate(List<Card> cards);
}
