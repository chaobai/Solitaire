package org.ruthie.solitaire;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * The main class for the Solitaire game
 * @author ruthie
 *
 */
public class Solitaire {
    private static final int NUM_PILES = 7;
    private CardStack stack;
    private Pile[] columns = new Pile[NUM_PILES];
    private CardStack[] foundations = new CardStack[4];
    private final PrintStream output;

    public Solitaire(PrintStream ps) {
        this.output = ps;
        this.initAndShuffle();
        this.deal();
    }

    /**
     * initialise the deck of cards and shuffle
     * all card in stack ready to be laid
     */
    private void initAndShuffle() {
        List<Card> deck = new ArrayList<Card>();
        //add all 52 cards to deck
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                deck.add(new Card(s, r));
            }
        }
        //shuffle the deck
        Collections.shuffle(deck);
        //add the whole deck to stack
        stack = new CardStack(deck);
    }
    
    /**
     * lay out card to certain numbers of piles
     * top cards in stack is up turned and ready to be laid
     */
    private void deal(){
        //initialise all column piles of cards
        for (int i=0; i < NUM_PILES; i++) {
            columns[i] = new Pile();
        }
        //initialise all foundation piles of card
        for (int i=0; i < Suit.values().length; i++) {
            foundations[i] = new CardStack();
        }
        
        //lay out cards to each pile
        for (int row = 0; row < NUM_PILES; row++) {
            for (int col = row; col < NUM_PILES; col++) {
                Card card = stack.pop();
                if (row == col) {
                    card.turnUp();
                }
                columns[col].add(card);
            }
        }
        //flip the top card in stack
        stack.flip();
    }

    public String toString() {
        //print header
        StringBuilder sbGame = new StringBuilder();
        sbGame.append(StringUtils.rightPad("ColumnNames", 15))
              .append(StringUtils.rightPad("S[T]ack", 15));
        //print columns header
        for (int i = 1; i <= NUM_PILES; i++) {
            sbGame.append("[").append(i).append("] ");
        }
        //print foundations header
        for (Suit s : Suit.values()) {
            sbGame.append("[").append(s.getCode().toUpperCase()).append("] ");
        }
        int lenHeader = sbGame.length();
        //print seperator
        sbGame.append(StringUtils.LF)
              .append(StringUtils.repeat("-",lenHeader))
              .append(StringUtils.LF);

        //print stack
        sbGame.append(StringUtils.repeat(StringUtils.SPACE, 15))
              .append(StringUtils.leftPad(stack.peek().toString(), 7))
              .append(StringUtils.repeat(StringUtils.SPACE, 7));

        //print columns
        for (int row = 0; row < NUM_PILES; row++) {
            if (row > 0) {
                sbGame.append(StringUtils.repeat(StringUtils.SPACE, 29));
            }
            for (int col = 0; col < NUM_PILES; col++) {              
                   Card card = columns[col].get(row);
                sbGame.append(StringUtils.leftPad(card==null ? StringUtils.EMPTY : card.toString(),4));
            }
            //print foundations
            if (row == 0) {
                for (CardStack f : foundations) {
                    Card card = f.peek();
                    sbGame.append(StringUtils.leftPad(card==null ? StringUtils.EMPTY : card.toString(),4));
                }
            }
            sbGame.append(StringUtils.LF);
        }

        return sbGame.toString();
    }
    
    /**
     * show up the layout of cards in console
     */
    public void show() {
        output.println(this);
    }
    
    public static void main(String args[]) {
        final PrintStream stream = System.out;
        stream.println("WELCOME TO SOLITAIRE\n");
        Solitaire game = new Solitaire(stream);
        
        game.show();
        stream.close();
    }
}
