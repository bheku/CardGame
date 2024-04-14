package org.bheku.advance.test.cardgame.commands;

import org.bheku.advance.test.cardgame.logic.BasicShuffle;
import org.bheku.advance.test.cardgame.logic.FiveCardDrawLogic;
import org.bheku.advance.test.cardgame.model.Card;
import org.bheku.advance.test.cardgame.model.Deck;
import org.bheku.advance.test.cardgame.model.DrawResult;
import org.bheku.advance.test.cardgame.type.Game;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class FiveCardDrawCommand {

    private final FiveCardDrawLogic gameLogic = new FiveCardDrawLogic();
    private final Deck<BasicShuffle> deck = new Deck<>(new BasicShuffle());
    private final Game<BasicShuffle, FiveCardDrawLogic> game = new Game<>(deck,gameLogic);

    @ShellMethod(key = "draw", value = "Display the result of Five Card Draw.")
    public String draw(){

        DrawResult hand = game.getHand();
        String cards = prettify(hand.getCards());
        String result = hand.getMessage();

        return  cards +"\n"+ result;
    }

    private String prettify(List<Card> cards){
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for (Card card : cards) {
            sb.append(card.getRank()).append(" of ").append(card.getSuit());
            sb.append(",");
        }
        sb.append("]");
        sb.replace(sb.length() - 2 , sb.length() - 1, "");

        return sb.toString();
    }
}
