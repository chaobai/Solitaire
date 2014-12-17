package org.ruthie.solitaire;

/**
 * Enum class for 4 suits of cards
 * @author ruthie
 *
 */
public enum Suit {

	/* Diamon */
	DIAMOND("D", 0),
	/* Heart */
	HEART("H", 1),
	/* Club */
	CLUB("c", 2),
	/* Spade */
	SPADE("s", 3);
	
	private String code;
	private int index;
	
	private Suit(String code, int index) {
		this.code = code;
		this.index = index;
	}

	public String getCode() {
		return code;
	}
	public int getIndex() {
		return index;
	}
}