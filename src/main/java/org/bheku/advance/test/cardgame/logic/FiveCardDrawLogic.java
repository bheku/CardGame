package org.bheku.advance.test.cardgame.logic;

import org.bheku.advance.test.cardgame.model.Card;
import org.bheku.advance.test.cardgame.model.Category;
import org.bheku.advance.test.cardgame.model.DrawResult;
import org.bheku.advance.test.cardgame.model.Rank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.bheku.advance.test.cardgame.model.Category.*;
import static org.bheku.advance.test.cardgame.model.Rank.ACE;
import static org.bheku.advance.test.cardgame.model.Rank.FIVE;

public class FiveCardDrawLogic implements HandEvaluatorLogic{
    @Override
    public DrawResult evaluate(List<Card> cards) {

        Hand evaluationResult = Hand.evaluate(cards);

        return new DrawResult(cards, evaluationResult.category.name());
    }

    // Logic from an internet post, for evaluating the cards.
    record Hand(Category category, Rank... ranks) implements Comparable<Hand> {
        public static Hand evaluate(List<Card> cards) {
            if (cards.size() != 5) throw new IllegalArgumentException();
            var flush = cards.stream().map(Card::getSuit).distinct().count() == 1;
            var counts = cards.stream().collect(groupingBy(Card::getRank, counting()));
            var ranks = counts.entrySet().stream().sorted(
                    comparing(Map.Entry<Rank,Long>::getValue).thenComparing(Map.Entry::getKey).reversed()
            ).map(Map.Entry::getKey).toArray(Rank[]::new);
            if (ranks.length == 4)
                return new Hand(PAIR, ranks);
            else if (ranks.length == 3)
                return new Hand(counts.get(ranks[0]) == 2 ? TWO_PAIR : TRIPS, ranks);
            else if (ranks.length == 2)
                return new Hand(counts.get(ranks[0]) == 3 ? FULL_HOUSE : QUADS, ranks);
            else if (ranks[0].ordinal() - ranks[4].ordinal() == 4)
                return new Hand(flush ? STRAIGHT_FLUSH : STRAIGHT, ranks[0]);
            else if (ranks[0] == ACE && ranks[1] == FIVE) // wheel
                return new Hand(flush ? STRAIGHT_FLUSH : STRAIGHT, FIVE);
            else
                return new Hand(flush ? FLUSH : HIGH_CARD, ranks);
        }

        @Override
        public int compareTo(Hand that) { // compare categories, then ranks lexicographically
            return comparing(Hand::category).thenComparing(Hand::ranks, Arrays::compare)
                    .compare(this, that);
        }
    }
}
