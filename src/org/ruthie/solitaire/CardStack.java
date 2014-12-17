package org.ruthie.solitaire;

import java.util.List;
import java.util.Stack;

/**
 * The class for the stack of cards
 * @author ruthie
 *
 */
public class CardStack {
	private final Stack<Card> stack;
	
	public CardStack() {
		stack = new Stack<Card>(); 
	}

	public CardStack(List<Card> deck) {
		this();
		stack.addAll(deck);
	}

	public Card pop() {
		return stack.pop();
	}

	public Card peek() {
		return stack.empty() ? null : stack.peek();
	}
	
	/**
	 * turn over the first card
	 */
	public void flip() {
		stack.peek().turnUp();
	}
}