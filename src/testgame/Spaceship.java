package testgame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import com.sun.javafx.geom.Rectangle;

public class Spaceship extends Sprite {
	private int x = 150;
	private int xPoints[] = { x, x + 20, x - 20, x };
	private int xa = 0;
	private int y = 400;
	private int yPoints[] = { y, y + 15, y + 15, y };
	private int WIDTH = 15;
	private int HEIGHT = 20;
	private World world;
	private int defense = 5;

	public Spaceship(World world) {
		this.world = world;
	}

	public void move() {
		for (int i = 0; i < xPoints.length; i++) {
			xPoints[i] += xa;
		}
		x += xa;
	}

	public void paint(Graphics2D g) {
		g.setColor(Color.YELLOW);
		g.drawPolygon(xPoints, yPoints, 4);
	}

	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 37)
			xa = -6;
		if (e.getKeyCode() == 39)
			xa = 6;
	}

	public Rectangle returnBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getXa() {
		return xa;
	}

	public void setXa(int xa) {
		this.xa = xa;
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

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}
}