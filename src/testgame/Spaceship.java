package testgame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Spaceship extends JPanel {
	private int x = 50;
	private int xa = 0;
	private World world;

	public Spaceship(World world) {
		this.world = world;
	}

	public void move() {
		if (x + xa > 0 && x + xa < world.getWidth() - 60)
			x = x + xa;
	}

	public void paint(Graphics2D g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, 400, 30, 10);
		g.fillOval(x+8, 392, 15, 15);
	}

	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 37)
			xa = -20;
		if (e.getKeyCode() == 39)
			xa = 20;
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

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
}