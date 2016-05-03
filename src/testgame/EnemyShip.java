package testgame;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.JComponent;
import javax.swing.JFrame;

public abstract class EnemyShip extends Sprite {
	private int x;
	private int y;
	private int WIDTH = 30;
	private int HEIGHT = 15;
	private int SPEED;
	private boolean border;
	private JComponent gameBoard;

	public EnemyShip() {

	}

	public void move() {
		y += SPEED;
		if (x <= 10) {
			border = true;
		} else if (x >= 560) {
			border = false;
		}
		if (border == true) {
			x += SPEED;
		} else if (border == false) {
			x -= SPEED;
		}
	}
	
	public Rectangle hitbox() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}

	public int getSPEED() {
		return SPEED;
	}

	public void setSPEED(int sPEED) {
		SPEED = sPEED;
	}

	public boolean isBorder() {
		return border;
	}

	public void setBorder(boolean border) {
		this.border = border;
	}

	public JComponent getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(JComponent gameBoard) {
		this.gameBoard = gameBoard;
	}
}
