/*
 * Token.java
 * Authors: Sophia Yu, Ives Koulidiati, Cal Kothrade, Brian McKeown
 * ASU: Ira A. Fulton Schools of Engineering
 * 
 * SER215, Fall B Session
 * Final Project
 * 
 * This class creates tokens, which can be thought of as the actual game pieces. Each token has a color, position (row,column) and an owner.
 * These tokens are important for identifying whether spaces on the board have been filled or not, as well as checking for winners. 
 */
public class Token {
	public int color;
	public int row, col;
	public String owner;

	/*
	 * / Constructor
	 */
	public Token(String owner, int color, int row, int col) {
		this.owner = owner;
		this.color = color;
		this.row = row;
		this.col = col;
	}

	// Default Constructor:
	public Token() {
	}

	// getters and setters:
	public void SetPosition(int r, int c) {
		row = r;
		col = c;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

}
