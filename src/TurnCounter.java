/*
 * TurnCounter.java
 * Authors: Sophia Yu, Ives Koulidiati, Cal Kothrade, Brian McKeown
 * ASU: Ira A. Fulton Schools of Engineering
 * 
 * SER215, Fall B Session
 * Final Project
 * 
 * This class simply keeps a running count of player turns during each game session. The current turnCount will let the game know which player's
 * turn it is. This counter also resets after each round. 
 */
public class TurnCounter {

	private int turnCount; // can only = 1 or 2.

	public TurnCounter() {
		turnCount = 1; // initiates to player 1 turn.

	}

	public int getPlayerTurn() {
		return turnCount;
	}

	public void setPlayerTurn(int num) {
		turnCount = num;
	}
}
