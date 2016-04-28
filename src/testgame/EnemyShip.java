package testgame;

import java.awt.Color;
import java.awt.Graphics2D;

public class EnemyShip extends Sprite {
	private int x;
	private int y = 0;
	private int WIDTH = 30;
	private int HEIGHT = 15;
	private int SPEED;
	private boolean border = true;
	World world;

	public EnemyShip() {

	}

	public EnemyShip(int x, int SPEED, World world) {
		this.x = x;
		this.SPEED = SPEED;
		this.world = world;
	}

	public void paint(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}

	public void move() {
		y += SPEED;
		if (x == 0) {
			border = true;
		} else if (x == world.getWidth()) {
			border = false;
		}
		if (border == true) {
			x += SPEED;
		} else if (border == false) {
			x -= SPEED;
		}
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

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
}
