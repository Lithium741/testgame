package testgame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import com.sun.javafx.geom.Rectangle;

public class Spaceship extends Sprite {
	private int x = 150;
	private int xa = 0;
	private int y = 710;
	private int WIDTH = 15;
	private int HEIGHT = 20;
	private World world;

	public Spaceship(World world) {
		this.world = world;
	}

	public void move() {
		if (x + xa > 0 && x + xa < world.getWidth() - 60) {
			x = x + xa;
		}
	}

	public void paint(Graphics2D g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}

	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 37)
			xa = -2;
		if (e.getKeyCode() == 39)
			xa = 2;
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
}