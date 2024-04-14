package org.bheku.advance.test.cardgame.logic;

import org.bheku.advance.test.cardgame.model.Card;

import java.util.ArrayList;
import java.util.Collections;

public class BasicShuffle implements ShuffleLogic{

    @Override
    public void shuffle(ArrayList<Card> cards) {
        Collections.shuffle(cards);
    }
}
