
/*
 * Player.java
 * Authors: Sophia Yu, Ives Koulidiati, Cal Kothrade, Brian McKeown
 * ASU: Ira A. Fulton Schools of Engineering
 * 
 * SER215, Fall B Session
 * Final Project
 * 
 * This class creates the player class, which stores each players name, color choice, win/loss/draw counts. 
 */
import java.awt.Color;

public class Player {

	private String name;
	private int color;
	public Token token = new Token();
	private int winCount;
	private int lossCount;
	private int drawCount;

	/*
	 * Default Constructor
	 */
	Player() {
		name = "NULL";
		color = 1;
		winCount = 0;
		lossCount = 0;
		drawCount = 0;
	}

	/**
	 * Modifier: set the name of the player
	 * 
	 * @param pname:
	 *            the name of the player
	 */
	public void setName(String pname) {
		name = pname;
	}

	/**
	 * Modifier: sets the color the player picked
	 * 
	 * @param num:
	 *            the color represented as an integer
	 */
	public void setColor(int num) {
		color = num;
	}

	public String getName() {
		return name;
	}

	public int getColor() {
		return color;
	}

	public int getWinCount() {
		return winCount;
	}

	public void addWinCount() {
		winCount++;
	}

	public int getLossCount() {
		return lossCount;
	}

	public void addLossCount() {
		lossCount++;
	}

	public int getDrawCount() {
		return drawCount;
	}

	public void addDrawCount() {
		drawCount++;
	}

	public void makeMove(Grid gamegrid, int col) {
		gamegrid.placeToken(token, col);
	}

}
