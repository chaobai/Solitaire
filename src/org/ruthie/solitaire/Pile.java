package org.ruthie.solitaire;

import java.util.ArrayList;
import java.util.List;

/**
 * The class for the pile(column) of cards
 * @author ruthie
 *
 */
public class Pile {
    private final List<Card> cards = new ArrayList<Card>();

    public void add(Card card) {
        cards.add(card);
    }

    public Card get(int idx) {
        return (idx < 0 || idx >= cards.size()) ? null : cards.get(idx);
    }
}
