package testgame;

import java.awt.Color;
import java.awt.Graphics2D;

public class Life extends Sprite {
	
	GameBoard board;
	private int X = 365;
	private int Y = 8;
	private int WIDTH = 200;
	private int HEIGHT = 20;
	GameBoard game;
	
	public Life(GameBoard game) {
		this.game = game;
	}
	
	public void paint(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect(X, Y, WIDTH, HEIGHT);
		g.drawRect(X, Y, 200, HEIGHT);
	}
	
	public void sDamage() {
		WIDTH -= (10 - game.getShip().getDefense());
	}
	
	public void dDamage() {
		WIDTH -= (20 - game.getShip().getDefense());
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}
}
