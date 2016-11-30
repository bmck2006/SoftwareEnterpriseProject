
/*
 * GridButton.java
 * Authors: Sophia Yu, Ives Koulidiati, Cal Kothrade, Brian McKeown
 * ASU: Ira A. Fulton Schools of Engineering
 * 
 * SER215, Fall B Session
 * Final Project
 * 
 * This class creates and controls the many gameboard buttons on the graphical user interface. 
 */

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class GridButton extends JButton {

	ImageIcon blank, black, red, green, orange, blue, purple;
	int value = 0;
	int row = 0;
	int col = 0;
	int buttonNum;
	boolean isEmpty;
	/*
	 * 0: Nothing 1: black 2: red 3: green 4: orange 5: blue 6: purple
	 */

	// Constructor
	public GridButton() {

		blank = new ImageIcon(this.getClass().getResource("blank.png"));
		black = new ImageIcon(this.getClass().getResource("black.png"));
		red = new ImageIcon(this.getClass().getResource("red.png"));
		green = new ImageIcon(this.getClass().getResource("green.png"));
		orange = new ImageIcon(this.getClass().getResource("orange.png"));
		blue = new ImageIcon(this.getClass().getResource("blue.png"));
		purple = new ImageIcon(this.getClass().getResource("purple.png"));

		setIcon(blank);
		isEmpty = true;
	}

	public int getButtonNum() {
		return buttonNum;
	}

	public void setButtonNum(int buttonNum) {
		this.buttonNum = buttonNum;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public ImageIcon getBlank() {
		return blank;
	}

	public ImageIcon getBlack() {
		return black;
	}

	public ImageIcon getRed() {
		return red;
	}

	public ImageIcon getGreen() {
		return green;
	}

	public ImageIcon getOrange() {
		return orange;
	}

	public ImageIcon getBlue() {
		return blue;
	}

	public ImageIcon getPurple() {
		return purple;
	}

	// SetImage() Method:
	public void setImage(int num) {

		value = num;

		switch (value) {
		case 0:
			setIcon(blank);
			break;
		case 1:
			setIcon(black);
			break;
		case 2:
			setIcon(red);
			break;
		case 3:
			setIcon(green);
			break;
		case 4:
			setIcon(orange);
			break;
		case 5:
			setIcon(blue);
			break;
		case 6:
			setIcon(purple);
			break;
		}
	}
}
