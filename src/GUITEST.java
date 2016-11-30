
/*
 * GUITEST.java
 * Authors: Sophia Yu, Ives Koulidiati, Cal Kothrade, Brian McKeown
 * ASU: Ira A. Fulton Schools of Engineering
 * 
 * SER215, Fall B Session
 * Final Project
 * 
 * This class tests the GUI interface. It is almost identical to the standard GUI class, except that it uses it's own main method for testing,
 * as well as prints a representation of the current status of the grid class, and move count, on the console, as the program runs. This is useful
 * for testing for seeing how the backend data is working behind the scenes, while the interface runs.
 */

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUITEST extends JFrame implements ActionListener {

	public static final int FRAME_WIDTH = 500;
	public static final int FRAME_HEIGHT = 350;
	public static final int GAME_WIDTH = 650;
	public static final int GAME_HEIGHT = 650;
	public static double version = 1.0;

	// Grid
	private static Grid grid = new Grid();

	// Token Array
	private Token[] tokenArray = new Token[42];

	// Players
	private static Player player1;
	private static Player player2;

	// TurnCounter
	private static TurnCounter turnCounter;

	// Game Logo
	private Image logo;

	// Screen 1 JLabels
	private JLabel introTitle = new JLabel("FIRST TO FOUR v" + version);
	private JLabel imageLabel = new JLabel("");

	// Screen 2 JLabels
	private JLabel topText = new JLabel("Please enter player usernames and colors:");
	private JLabel player1name = new JLabel("Player 1 User Name: ");
	private JLabel player2name = new JLabel("Player 2 User Name: ");
	private JLabel player1color = new JLabel("Player 1 Color: ");
	private JLabel player2color = new JLabel("Player 2 Color: ");

	// Screen 3 JLabels
	private JLabel name1 = new JLabel("Player1");
	private JLabel name2 = new JLabel("Player2");
	private JLabel wins1 = new JLabel("Wins");
	private JLabel wins2 = new JLabel("Wins");
	private JLabel loss1 = new JLabel("Loss");
	private JLabel loss2 = new JLabel("Loss");
	private JLabel draw1 = new JLabel("Draw");
	private JLabel draw2 = new JLabel("Draw");
	private static JLabel playerTurn = new JLabel("");

	// Screen 2 JTextFields
	private JTextField playerOneName = new JTextField("", 15);
	private JTextField playerTwoName = new JTextField("", 15);

	// Screen 2 JComboBoxes:
	private String[] colorArray = { "Black", "Red", "Green", "Orange", "Blue", "Purple" };
	private JComboBox playerOneColor = new JComboBox(colorArray);
	private JComboBox playerTwoColor = new JComboBox(colorArray);

	// Screen 1 JButtons:
	private JButton beginIntroButton = new JButton("Begin");
	private JButton exitButton = new JButton("Exit");
	private JButton infoButton = new JButton("Info");
	private JButton instructionsButton = new JButton("Instructions");

	// Screen 2 JButtons:
	private JButton playButton = new JButton("Let's Play!");
	private JButton instructions2button = new JButton("Instructions");
	private JButton info2button = new JButton("Info");
	private JButton exit2button = new JButton("Exit");

	// Screen 3 JButtons
	private JButton concede = new JButton("Concede");
	private JButton instructions3 = new JButton("Instructions");
	private JButton info3 = new JButton("Info");
	private JButton exit3 = new JButton("Exit");
	private JButton drop1 = new JButton("Drop");
	private JButton drop2 = new JButton("Drop");
	private JButton drop3 = new JButton("Drop");
	private JButton drop4 = new JButton("Drop");
	private JButton drop5 = new JButton("Drop");
	private JButton drop6 = new JButton("Drop");
	private JButton drop7 = new JButton("Drop");

	// Screen 1 inner panels:
	private JPanel introPanel = new JPanel();
	private JPanel imagePanel = new JPanel();
	private JPanel introButtons = new JPanel();

	// Screen 2 inner panels
	private JPanel screen2label = new JPanel();
	private JPanel player1namePanel = new JPanel();
	private JPanel player1colorPanel = new JPanel();
	private JPanel player2namePanel = new JPanel();
	private JPanel player2colorPanel = new JPanel();
	private JPanel screen2colorChoicePanel = new JPanel();
	private JPanel screen2buttonPanel = new JPanel();

	// Screen 3 inner panels
	private JPanel statsPanel = new JPanel();
	private JPanel playerTurnPanel = new JPanel();
	private JPanel dropButtonPanel = new JPanel();
	private JPanel gameBoardPanel = new JPanel();
	private JPanel button3panel = new JPanel();

	// Main Panels (Screen1,2, and 3)
	private JPanel mainPanel = new JPanel();
	private JPanel mainPanel2 = new JPanel();
	private JPanel mainPanel3 = new JPanel();

	// Screen 3 GridButton Array
	public static GridButton[] gameArray = new GridButton[42];

	/****** MAIN METHOD FOR TESTING *************/

	public static void main(String[] args) {

		GUITEST myApplication = new GUITEST();
		myApplication.setDefaultLookAndFeelDecorated(true);
		myApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/***************************************************************************/

	/*
	 * Constructor
	 */
	public GUITEST() {

		// create player objects
		player1 = new Player();
		player2 = new Player();

		// create turnCounter object
		turnCounter = new TurnCounter();

		// fill token array
		for (int i = 0; i < tokenArray.length; i++) {
			tokenArray[i] = new Token();
		}

		// design main Panels
		designMainPanel();
		designMainPanel2();
		addListeners();
		setTitle("First to Four v" + version);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(mainPanel);
		setVisible(true);

	}

	/************************************************************
	 * actionPerformed():Button Listener functions
	 ************************************************************/
	public void actionPerformed(ActionEvent evt) {
		// buttons fire this event
		Object sourceObject = evt.getSource();

		// Screen 1 begin button
		if (sourceObject == beginIntroButton) {
			remove(mainPanel);
			add(mainPanel2);
			setSize(FRAME_WIDTH, FRAME_HEIGHT);
			setVisible(true);
		}

		// Screen 1 instructions button
		if (sourceObject == instructionsButton) {
			String title = "Instructions";
			String msg = "- The purpose of this game is to be the first player"
					+ " to place four pieces in a row on the gameboard. "
					+ "\n- This can be either vertical, horizontal, or diagonal." + "\n- Players will take turns. "
					+ "\n- If no one reaches four in a row before the board"
					+ " is filled, the game will be declared a draw.\n- Use the DROP buttons "
					+ "to place pieces.";
			messageBox(msg, title);

		}

		// Screen 1 info Button
		if (sourceObject == infoButton) {
			String title = "information";
			String msg = "Creators:\n\n" + "- Sophia Yu\n" + "- Cal Kothrade\n" + "- Yves Koulidiati\n"
					+ "- Brian McKeown\n\n" + "Ira A. Fulton Schools of Engineering\n" + "Arizona State University\n"
					+ "SER215 Fall B Session, 2016";
			messageBox(msg, title);

		}
		// Screen 1 exit button
		if (sourceObject == exitButton) {
			System.exit(0);
		}
		// Screen 2 play button:
		if (sourceObject == playButton) {
			String name1 = playerOneName.getText();
			String name2 = playerTwoName.getText();
			int color1 = playerOneColor.getSelectedIndex() + 1;
			int color2 = playerTwoColor.getSelectedIndex() + 1;

			if (color1 != color2) {

				player1.setName(name1);
				player2.setName(name2);
				player1.setColor(color1);
				player2.setColor(color2);

				designMainPanel3();
				playerTurn.setText(player1.getName() + "'s Turn");

				remove(mainPanel2);
				add(mainPanel3);
				setSize(GAME_WIDTH, GAME_HEIGHT);
				setVisible(true);
			} else {
				messageBox("You cannot choose the same color!", "WOOPS!");
			}
		}
		// Screen 2 instructions button:
		if (sourceObject == instructions2button) {
			String title = "Instructions";
			String msg = "- The purpose of this game is to be the first player"
					+ " to place four pieces in a row on the gameboard. "
					+ "\n- This can be either vertical, horizontal, or diagonal." + "\n- Players will take turns. "
					+ "\n- If no one reaches four in a row before the board"
					+ " is filled, the game will be declared a draw.\n- Use the DROP buttons "
					+ "to place pieces.";
			messageBox(msg, title);
		}
		// Screen 2 info button:
		if (sourceObject == info2button) {
			String title = "information";
			String msg = "Creators:\n\n" + "- Sophia Yu\n" + "- Cal Kothrade\n" + "- Yves Koulidiati\n"
					+ "- Brian McKeown\n\n" + "Ira A. Fulton Schools of Engineering\n" + "Arizona State University\n"
					+ "SER215 Fall B Session, 2016";
			messageBox(msg, title);
		}

		// Screen 2 exit button:
		if (sourceObject == exit2button) {
			System.exit(0);
		}
		// Screen 3 concede button
		if (sourceObject == concede) {
			if (turnCounter.getPlayerTurn() % 2 == 0) {
				messageBox(player2.getName() + " forfeits this round!", "Forfeit");
				player1.addWinCount();
				player2.addLossCount();
				wins1.setText(String.valueOf(player1.getWinCount()));
				wins2.setText(String.valueOf(player2.getWinCount()));
				loss1.setText(String.valueOf(player1.getLossCount()));
				loss2.setText(String.valueOf(player2.getLossCount()));
				grid.clearBoard();
				playerTurn.setText(player1.getName() + "'s Turn");
				turnCounter.setPlayerTurn(1);

				for (int i = 0; i < gameArray.length; i++) {
					gameArray[i].setValue(0);
					gameArray[i].setImage(0);
					gameArray[i].setEmpty(true);
				}
			} else {
				messageBox(player1.getName() + " forfeits this round!", "Forfeit");
				player2.addWinCount();
				player1.addLossCount();
				wins1.setText(String.valueOf(player1.getWinCount()));
				wins2.setText(String.valueOf(player2.getWinCount()));
				loss1.setText(String.valueOf(player1.getLossCount()));
				loss2.setText(String.valueOf(player2.getLossCount()));
				grid.clearBoard();
				playerTurn.setText(player1.getName() + "'s Turn");
				turnCounter.setPlayerTurn(1);

				for (int i = 0; i < gameArray.length; i++) {
					gameArray[i].setValue(0);
					gameArray[i].setImage(0);
					gameArray[i].setEmpty(true);
				}
			}

		}
		// Screen 3 info button
		if (sourceObject == info3) {
			String title = "information";
			String msg = "Creators:\n\n" + "- Sophia Yu\n" + "- Cal Kothrade\n" + "- Yves Koulidiati\n"
					+ "- Brian McKeown\n\n" + "Ira A. Fulton Schools of Engineering\n" + "Arizona State University\n"
					+ "SER215 Fall B Session, 2016";
			messageBox(msg, title);

		}
		// Screen 3 instructions button
		if (sourceObject == instructions3) {
			String title = "Instructions";
			String msg = "- The purpose of this game is to be the first player"
					+ " to place four pieces in a row on the gameboard. "
					+ "\n- This can be either vertical, horizontal, or diagonal." + "\n- Players will take turns. "
					+ "\n- If no one reaches four in a row before the board"
					+ " is filled, the game will be declared a draw.\n- Use the DROP buttons "
					+ "to place pieces.";
			messageBox(msg, title);
		}

		// Screen 3 exit button:
		if (sourceObject == exit3) {
			System.exit(0);
		}
		// screen 3 drop1
		if (sourceObject == drop1) {
			if (gameArray[35].isEmpty()) {
				dropPiece(35);
			} else if (gameArray[28].isEmpty()) {
				dropPiece(28);
			} else if (gameArray[21].isEmpty()) {
				dropPiece(21);
			} else if (gameArray[14].isEmpty()) {
				dropPiece(14);
			} else if (gameArray[7].isEmpty()) {
				dropPiece(7);
			} else if (gameArray[0].isEmpty()) {
				dropPiece(0);
			}

		}
		// screen 3 drop2
		if (sourceObject == drop2) {
			if (gameArray[36].isEmpty()) {
				dropPiece(36);
			} else if (gameArray[29].isEmpty()) {
				dropPiece(29);
			} else if (gameArray[22].isEmpty()) {
				dropPiece(22);
			} else if (gameArray[15].isEmpty()) {
				dropPiece(15);
			} else if (gameArray[8].isEmpty()) {
				dropPiece(8);
			} else if (gameArray[1].isEmpty()) {
				dropPiece(1);
			}
		}
		// screen 3 drop3
		if (sourceObject == drop3) {
			if (gameArray[37].isEmpty()) {
				dropPiece(37);
			} else if (gameArray[30].isEmpty()) {
				dropPiece(30);
			} else if (gameArray[23].isEmpty()) {
				dropPiece(23);
			} else if (gameArray[16].isEmpty()) {
				dropPiece(16);
			} else if (gameArray[9].isEmpty()) {
				dropPiece(9);
			} else if (gameArray[2].isEmpty()) {
				dropPiece(2);
			}
		}
		// screen 3 drop4
		if (sourceObject == drop4) {
			if (gameArray[38].isEmpty()) {
				dropPiece(38);
			} else if (gameArray[31].isEmpty()) {
				dropPiece(31);
			} else if (gameArray[24].isEmpty()) {
				dropPiece(24);
			} else if (gameArray[17].isEmpty()) {
				dropPiece(17);
			} else if (gameArray[10].isEmpty()) {
				dropPiece(10);
			} else if (gameArray[3].isEmpty()) {
				dropPiece(3);
			}
		}
		// screen 3 drop5
		if (sourceObject == drop5) {
			if (gameArray[39].isEmpty()) {
				dropPiece(39);
			} else if (gameArray[32].isEmpty()) {
				dropPiece(32);
			} else if (gameArray[25].isEmpty()) {
				dropPiece(25);
			} else if (gameArray[18].isEmpty()) {
				dropPiece(18);
			} else if (gameArray[11].isEmpty()) {
				dropPiece(11);
			} else if (gameArray[4].isEmpty()) {
				dropPiece(4);
			}
		}
		// screen 3 drop6
		if (sourceObject == drop6) {
			if (gameArray[40].isEmpty()) {
				dropPiece(40);
			} else if (gameArray[33].isEmpty()) {
				dropPiece(33);
			} else if (gameArray[26].isEmpty()) {
				dropPiece(26);
			} else if (gameArray[19].isEmpty()) {
				dropPiece(19);
			} else if (gameArray[12].isEmpty()) {
				dropPiece(12);
			} else if (gameArray[5].isEmpty()) {
				dropPiece(5);
			}
		}
		// screen 3 drop7
		if (sourceObject == drop7) {
			if (gameArray[41].isEmpty()) {
				dropPiece(41);
			} else if (gameArray[34].isEmpty()) {
				dropPiece(34);
			} else if (gameArray[27].isEmpty()) {
				dropPiece(27);
			} else if (gameArray[20].isEmpty()) {
				dropPiece(20);
			} else if (gameArray[13].isEmpty()) {
				dropPiece(13);
			} else if (gameArray[6].isEmpty()) {
				dropPiece(6);
			}
		}

	}

	/*
	 * designMainPanel(): creates the screen 1 main panel
	 */
	public void designMainPanel() {
		// set and fill layouts for inner panels

		// intro Panel:
		introPanel.setLayout(new FlowLayout());
		introPanel.add(introTitle);

		// image Panel:
		logo = new ImageIcon(this.getClass().getResource("logo.png")).getImage();
		imagePanel.setLayout(new FlowLayout());
		imageLabel.setIcon(new ImageIcon(logo));
		imageLabel.setBounds(10, 53, 200, 200);
		imagePanel.add(imageLabel);

		// intro button panel:
		introButtons.setLayout(new FlowLayout());
		introButtons.add(beginIntroButton);
		introButtons.add(instructionsButton);
		introButtons.add(infoButton);
		introButtons.add(exitButton);

		// style and add all panels to mainPanel
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(Box.createVerticalGlue());
		mainPanel.add(introPanel);
		mainPanel.add(imagePanel);
		mainPanel.add(introButtons);
	}

	/*
	 * designMainPanel2(): creates the Screen 2 main panel
	 */
	public void designMainPanel2() {
		// top panel
		screen2label.setLayout(new FlowLayout());
		screen2label.add(topText);

		// player 1 name panel
		player1namePanel.setLayout(new FlowLayout());
		player1namePanel.add(player1name);
		player1namePanel.add(playerOneName);

		// player 1 color panel
		player1colorPanel.setLayout(new FlowLayout());
		player1colorPanel.add(player1color);
		player1colorPanel.add(playerOneColor);

		// player 2 name panel
		player2namePanel.setLayout(new FlowLayout());
		player2namePanel.add(player2name);
		player2namePanel.add(playerTwoName);

		// player 2 color panel
		player2colorPanel.setLayout(new FlowLayout());
		player2colorPanel.add(player2color);
		player2colorPanel.add(playerTwoColor);

		// button panel:
		screen2buttonPanel.setLayout(new FlowLayout());
		screen2buttonPanel.add(playButton);
		screen2buttonPanel.add(instructions2button);
		screen2buttonPanel.add(info2button);
		screen2buttonPanel.add(exit2button);

		// mainPanel2 setup:
		mainPanel2.setLayout(new BoxLayout(mainPanel2, BoxLayout.Y_AXIS));
		mainPanel2.add(Box.createVerticalGlue());
		mainPanel2.add(screen2label);
		mainPanel2.add(player1namePanel);
		mainPanel2.add(player1colorPanel);
		mainPanel2.add(player2namePanel);
		mainPanel2.add(player2colorPanel);
		mainPanel2.add(screen2colorChoicePanel);
		mainPanel2.add(screen2buttonPanel);
	}

	public void designMainPanel3() {
		// statsPanel setup
		statsPanel.setLayout(new FlowLayout());

		name1.setText(player1.getName());
		name2.setText(player2.getName());
		wins1.setText(String.valueOf(player1.getWinCount()));
		wins2.setText(String.valueOf(player2.getWinCount()));
		loss1.setText(String.valueOf(player1.getLossCount()));
		loss2.setText(String.valueOf(player2.getLossCount()));
		draw1.setText(String.valueOf(player1.getDrawCount()));
		draw2.setText(String.valueOf(player2.getDrawCount()));

		statsPanel.add(name1);
		statsPanel.add(wins1);
		statsPanel.add(loss1);
		statsPanel.add(draw1);
		statsPanel.add(name2);
		statsPanel.add(wins2);
		statsPanel.add(loss2);
		statsPanel.add(draw2);

		// playerTurnPanel
		playerTurnPanel.setLayout(new FlowLayout());
		playerTurnPanel.add(playerTurn);

		// dropButtonPanel
		dropButtonPanel.setLayout(new GridLayout(1, 7));
		dropButtonPanel.add(drop1);
		dropButtonPanel.add(drop2);
		dropButtonPanel.add(drop3);
		dropButtonPanel.add(drop4);
		dropButtonPanel.add(drop5);
		dropButtonPanel.add(drop6);
		dropButtonPanel.add(drop7);

		// gameBoardPanel setup
		gameBoardPanel.setLayout(new GridLayout(6, 7));

		int row = 0;
		int col = 0;
		for (int i = 0; i < 42; i++) {
			// for loop creates button for entire grid
			if (col > 6) {
				row++;
				col = 0;
			}

			gameArray[i] = new GridButton();
			gameArray[i].setCol(col);
			gameArray[i].setRow(row);
			gameArray[i].setEmpty(true);
			gameArray[i].setButtonNum(i);
			gameBoardPanel.add(gameArray[i]);
			col++;
		}

		// button3panel setup
		button3panel.setLayout(new FlowLayout());
		button3panel.add(concede);
		button3panel.add(instructions3);
		button3panel.add(info3);
		button3panel.add(exit3);

		// mainPanel3 setup:
		mainPanel3.setLayout(new BoxLayout(mainPanel3, BoxLayout.Y_AXIS));
		mainPanel3.add(Box.createVerticalGlue());
		mainPanel3.add(statsPanel);
		mainPanel3.add(playerTurnPanel);
		mainPanel3.add(dropButtonPanel);
		mainPanel3.add(gameBoardPanel);
		mainPanel3.add(button3panel);
	}

	/*
	 * addListeners(): This method adds action listeners to individual buttons
	 */
	public void addListeners() {

		// Screen 1 buttons
		beginIntroButton.addActionListener(this);
		infoButton.addActionListener(this);
		instructionsButton.addActionListener(this);
		exitButton.addActionListener(this);

		// Screen 2 buttons
		playButton.addActionListener(this);
		info2button.addActionListener(this);
		instructions2button.addActionListener(this);
		exit2button.addActionListener(this);

		// Screen 2 JTextFields
		playerOneName.addActionListener(this);
		playerTwoName.addActionListener(this);
		playerOneColor.addActionListener(this);
		playerTwoColor.addActionListener(this);

		// Screen 3 buttons
		concede.addActionListener(this);
		instructions3.addActionListener(this);
		info3.addActionListener(this);
		exit3.addActionListener(this);
		drop1.addActionListener(this);
		drop2.addActionListener(this);
		drop3.addActionListener(this);
		drop4.addActionListener(this);
		drop5.addActionListener(this);
		drop6.addActionListener(this);
		drop7.addActionListener(this);

	}

	/*
	 * messageBox(): This method displays JOptionPane message boxes as necessary
	 */
	public void messageBox(String message, String title) {
		JOptionPane.showMessageDialog(this, message, title, JOptionPane.PLAIN_MESSAGE);
	}

	public static TurnCounter borrowTurnCounter() {
		return turnCounter;
	}

	public static Player borrowPlayer1() {
		return player1;
	}

	public static Player borrowPlayer2() {
		return player2;
	}

	public static JLabel getPlayerTurnLabel() {
		return playerTurn;
	}

	public void dropPiece(int x) {
		if (turnCounter.getPlayerTurn() % 2 != 0) {
			gameArray[x].setValue(player1.getColor());
			gameArray[x].setImage(gameArray[x].getValue());
			gameArray[x].setEmpty(false);
			tokenArray[x].setOwner(player1.getName());
			tokenArray[x].setColor(player1.getColor());
			tokenArray[x].SetPosition(gameArray[x].getRow(), gameArray[x].getCol());
			grid.placeToken(tokenArray[x], gameArray[x].getCol());
			playerTurn.setText(player2.getName() + "'s Turn");
		} else {
			gameArray[x].setValue(player2.getColor());
			gameArray[x].setImage(gameArray[x].getValue());
			gameArray[x].setEmpty(false);
			tokenArray[x].setOwner(player2.getName());
			tokenArray[x].setColor(player2.getColor());
			tokenArray[x].SetPosition(gameArray[x].getRow(), gameArray[x].getCol());
			grid.placeToken(tokenArray[x], gameArray[x].getCol());
			playerTurn.setText(player1.getName() + "'s Turn");
		}
		turnCounter.setPlayerTurn(turnCounter.getPlayerTurn() + 1);

		// Check for wins!
		checkWinProcedure();

		/*
		 * Console Test:
		 */
		System.out.println("Turn: " + (turnCounter.getPlayerTurn() - 1)); // subtracts 1 to allign with TurnCounter
		System.out.println(grid.toString());
	}
	/*
	 * checkWinProcedure() Checks for wins horizontal, vertical, diagonal, and
	 * for a draw.
	 */

	public void checkWinProcedure() {

		if (grid.checkWinnerHorizontal() != null) {
			String name = grid.checkWinnerHorizontal();
			messageBox(name + " wins!", "Winner!");

			if (name.equals(player1.getName())) {
				player1.addWinCount();
				player2.addLossCount();
			}
			if (name.equals(player2.getName())) {
				player2.addWinCount();
				player1.addLossCount();
			}
			wins1.setText(String.valueOf(player1.getWinCount()));
			wins2.setText(String.valueOf(player2.getWinCount()));
			loss1.setText(String.valueOf(player1.getLossCount()));
			loss2.setText(String.valueOf(player2.getLossCount()));
			grid.clearBoard();
			playerTurn.setText(player1.getName() + "'s Turn");
			turnCounter.setPlayerTurn(1);

			for (int i = 0; i < gameArray.length; i++) {
				gameArray[i].setValue(0);
				gameArray[i].setImage(0);
				gameArray[i].setEmpty(true);
			}
		} else if (grid.checkWinnerVertical() != null) {
			String name = grid.checkWinnerVertical();
			messageBox(name + " wins!", "Winner!");

			if (name.equals(player1.getName())) {
				player1.addWinCount();
				player2.addLossCount();
			}
			if (name.equals(player2.getName())) {
				player2.addWinCount();
				player1.addLossCount();
			}
			wins1.setText(String.valueOf(player1.getWinCount()));
			wins2.setText(String.valueOf(player2.getWinCount()));
			loss1.setText(String.valueOf(player1.getLossCount()));
			loss2.setText(String.valueOf(player2.getLossCount()));
			grid.clearBoard();
			playerTurn.setText(player1.getName() + "'s Turn");
			turnCounter.setPlayerTurn(1);

			for (int i = 0; i < gameArray.length; i++) {
				gameArray[i].setValue(0);
				gameArray[i].setImage(0);
				gameArray[i].setEmpty(true);
			}
		} else if (grid.checkWinnerDiag() != null) {
			String name = grid.checkWinnerDiag();
			messageBox(name + " wins!", "Winner!");

			if (name.equals(player1.getName())) {
				player1.addWinCount();
				player2.addLossCount();
			}
			if (name.equals(player2.getName())) {
				player2.addWinCount();
				player1.addLossCount();
			}
			wins1.setText(String.valueOf(player1.getWinCount()));
			wins2.setText(String.valueOf(player2.getWinCount()));
			loss1.setText(String.valueOf(player1.getLossCount()));
			loss2.setText(String.valueOf(player2.getLossCount()));
			grid.clearBoard();
			playerTurn.setText(player1.getName() + "'s Turn");
			turnCounter.setPlayerTurn(1);

			for (int i = 0; i < gameArray.length; i++) {
				gameArray[i].setValue(0);
				gameArray[i].setImage(0);
				gameArray[i].setEmpty(true);
			}
		} else if (isDraw()) {

			messageBox("It's a Draw!", "Draw!");

			player1.addDrawCount();
			player2.addDrawCount();

			draw1.setText(String.valueOf(player1.getDrawCount()));
			draw2.setText(String.valueOf(player2.getDrawCount()));
			grid.clearBoard();
			playerTurn.setText(player1.getName() + "'s Turn");
			turnCounter.setPlayerTurn(1);

			for (int i = 0; i < gameArray.length; i++) {
				gameArray[i].setValue(0);
				gameArray[i].setImage(0);
				gameArray[i].setEmpty(true);
			}
		}
	}

	public boolean isDraw() {

		boolean isDraw = true;

		for (int i = 0; i < gameArray.length; i++) {
			if (gameArray[i].isEmpty) {
				isDraw = false;
				break;
			}
		}
		return isDraw;
	}
}