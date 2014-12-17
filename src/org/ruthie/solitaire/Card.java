package org.ruthie.solitaire;

/**
 * The class for card object
 * @author ruthie
 *
 */
public class Card {

    private Suit suit;
    private Rank rank;
    private boolean isUpTurned = false;
    private static final String HIDDEN_CARD_MASK = "**";
    
    /**
     * doesn't allow card to be instantiated without suit or rank
     */
    private Card() {
    }

    public Card(Suit suit, Rank rank) {
        if (suit == null || rank == null) {
            throw new RuntimeException("Either suit or rank of card is null.");
        }
        this.suit = suit;
        this.rank = rank;
    }
    
    /**
     * turn the card over
     */
    public void turnUp() {
        isUpTurned = true;
    }

    /**
     * true if the card is turned up and visible
     * @return
     */
    public boolean isUpTurned() {
        return isUpTurned;
    }
    
    /**
     * return card name if it is turned up
     * return a mask value if card is hidden 
     */
    public String toString() {
        if (isUpTurned) {
            return suit.getCode() + rank.toString(); 
        } else {
            return HIDDEN_CARD_MASK;
        }
    }
}