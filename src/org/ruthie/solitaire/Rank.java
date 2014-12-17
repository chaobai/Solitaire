package org.ruthie.solitaire;

/**
 * Enum class for the rank of cards
 * @author ruthie
 *
 */
public enum Rank {

	R_A(1, "A"),
	R_2(2, "2"),
	R_3(3, "3"),
	R_4(4, "4"),
	R_5(5, "5"),
	R_6(6, "6"),
	R_7(7, "7"),
	R_8(8, "8"),
	R_9(9, "9"),
	R_T(10, "T"),
	R_J(11, "J"),
	R_Q(12, "Q"),
	R_K(13, "K");
	
	private int value;
	private String name;

	private Rank(int value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}