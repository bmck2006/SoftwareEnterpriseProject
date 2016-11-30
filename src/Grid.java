
/*
 * Grid.java
 * Authors: Sophia Yu, Ives Koulidiati, Cal Kothrade, Brian McKeown
 * ASU: Ira A. Fulton Schools of Engineering
 * 
 * SER215, Fall B Session
 * Final Project
 * 
 * This class creates the grid, which takes Tokens as entries. The purpose of the grid is to design the game interface, as well as check for
 * legal moves, and winners. 
 */
public class Grid {

	private Token board[][]; // 2dArray for the game board
	final private int maxW = 7; // length of the board
	final private int maxH = 6; // height of the board

	/**
	 * Returns the game board.
	 * 
	 * @return the game board
	 */
	public Token getBoard() {
		return board[maxH][maxW];
	}

	/**
	 * Constructor. Sets all spaces to empty.
	 */
	public Grid() {

		// Creates new board
		board = new Token[maxH][maxW];

		// Sets all board spaces to empty
		clearBoard();

	}

	/**
	 * Returns the value of the token at the requested position.
	 * 
	 * @param row
	 *            which row is requested
	 * @param width
	 *            which column is requested
	 * @return token at specific position
	 */
	public Token getToken(int row, int col) {
		return board[row][col];
	}

	/**
	 * Resets the game board.
	 */
	public void clearBoard() {

		// Sets all board positions to empty (0)
		for (int i = 0; i < maxH; i++)
			for (int j = 0; j < maxW; j++)
				board[i][j] = null;

	}

	/**
	 * Checks to see if the selected column has available positions for the
	 * player to place a token.
	 * 
	 * @param temp
	 *            the column which the player wishes to place a token
	 * @return true if there is a position, false otherwise
	 */
	private boolean legalMove(int temp) {

		boolean game = false;

		// ==========================================================
		// If the top row has an open position for the
		// selected column, then the move is approved.
		// ==========================================================
		if (board[0][temp] == null)
			game = true;

		return game;
	}

	/**
	 * Places a token in the appropriate position in the column selected by the
	 * player.
	 * 
	 * @param val
	 *            token to be placed
	 * @param col
	 *            column int which the player has elected to place token
	 */
	public void placeToken(Token val, int col) {

		// ==========================================================
		// If the column is empty then a token is placed in the
		// most bottom position, else the token is placed on top
		// of other pieces in play.
		// ==========================================================

		if (legalMove(col)) {

			if (board[maxH - 1][col] == null) {
				val.SetPosition(maxH - 1, col);
				board[maxH - 1][col] = val;
			} else {

				int i = 0;

				while (board[i][col] == null) {
					i++;
				}
				val.SetPosition(i - 1, col);
				board[i - 1][col] = val;

			}
		}
	}

	/**
	 * Displays the game board.
	 * 
	 * @return A virtual representation of the board.
	 */
	public String toString() {

		String result = "";

		for (int i = 0; i < maxH; i++) {
			result += "\n";
			for (int j = 0; j < maxW; j++)
				if (board[i][j] == null)
					result += " 0  ";
				else {
					if (board[i][j].getColor() == 1)
						result += " " + "B" + "  ";
					else if (board[i][j].getColor() == 1)
						result += " " + "B" + "  ";
					else if (board[i][j].getColor() == 2)
						result += " " + "R" + "  ";
					else if (board[i][j].getColor() == 3)
						result += " " + "G" + "  ";
					else if (board[i][j].getColor() == 4)
						result += " " + "O" + "  ";
					else if (board[i][j].getColor() == 5)
						result += " " + "b" + "  ";
					else if (board[i][j].getColor() == 6)
						result += " " + "P" + "  ";
					else
						result += " " + "L" + "  ";

				}
		}

		return result;
	}
	/*
	 * ************************************************************* Check for
	 * Winner methods: Horizontal, Vertical, and Diagonal.
	 * ************************************************************
	 */

	public String checkWinnerVertical() {
		// Check rows and see if there are 4 disks of the same color
		for (int column = 0; column < 7; ++column) {
			int count = 1;
			// We will compare current element with the next
			for (int row = 0; row < 5; ++row) {
				if (board[row][column] != null && board[row + 1][column] != null
						&& board[row][column].getColor() == (board[row + 1][column].getColor()))
					++count;
				else
					count = 1;

				// Check if there are 4 in a row.
				if (count >= 4) {
					// Return name of the winner
					return board[row][column].getOwner();
				}
			}
		}
		// Otherwise return character, which means nobody win in rows.
		return null;
	}

	public String checkWinnerHorizontal() {
		// Check rows and see if there are 4 disks of the same color
		for (int row = 0; row < 6; ++row) {
			int count = 1;
			// We will compare current element with the next
			for (int column = 0; column < 6; ++column) {
				//
				if (board[row][column] != null && board[row][column + 1] != null
						&& board[row][column].getColor() == (board[row][column + 1].getColor())) {
					++count;
					// System.out.println(count);
					// System.out.println(board[row][column].getColor().equals(board[row][column-1].getColor()));
				}

				else
					count = 1;

				// Check if there are 4 in a row.
				if (count >= 4) {
					// Return color of the winner
					return board[row][column].getOwner();
				}
			}
		}
		// Otherwise return character, which means nobody win in rows.
		return null;
	}

	public String checkWinnerDiag() {
		// There are two types of diagonals to check, starting from top moving
		// down/right, and starting from top moving down/left

		// top to bottom: down/right diagonal checker:
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 4; col++) {
				if (board[row][col] != null && board[row + 1][col + 1] != null && board[row + 2][col + 2] != null
						&& board[row + 3][col + 3] != null) {
					int color1 = board[row][col].getColor();
					int color2 = board[row + 1][col + 1].getColor();
					int color3 = board[row + 2][col + 2].getColor();
					int color4 = board[row + 3][col + 3].getColor();

					if (color1 == color2 && color1 == color3 && color1 == color4) {
						return board[row][col].getOwner();
					}
				}
			}
		}

		// top to bottom: down/left diagonal checker
		for (int row = 0; row < 3; row++) {
			for (int col = 6; col > 2; col--) {
				if (board[row][col] != null && board[row + 1][col - 1] != null && board[row + 2][col - 2] != null
						&& board[row + 3][col - 3] != null) {
					int color1 = board[row][col].getColor();
					int color2 = board[row + 1][col - 1].getColor();
					int color3 = board[row + 2][col - 2].getColor();
					int color4 = board[row + 3][col - 3].getColor();

					if (color1 == color2 && color1 == color3 && color1 == color4) {
						return board[row][col].getOwner();
					}
				}
			}
		}
		// return null if no win
		return null;
	}
}
