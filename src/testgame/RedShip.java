package testgame;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class RedShip extends EnemyShip {
	private int WIDTH = 15;
	private int HEIGHT = 30;
	int LoR;

	public RedShip(int x, int y, int SPEED, JComponent gameBoard, int LoR) {
		super.setX(x);
		super.setY(y);
		super.setSPEED(SPEED);
		super.setGameBoard(gameBoard);
		this.LoR = LoR;
		if (LoR == 1) {
			super.setBorder(false);
		} else if (LoR == 2) {
			super.setBorder(true);
		}
	}

	public void paint(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect(super.getX(), super.getY(), WIDTH, HEIGHT);
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
}
