package testgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Shot extends JPanel {

	private int x;
	private int y = 400;
	private int shotSpeed;

	public Shot(int x, int shotSpeed) {
		this.x = x;
		this.shotSpeed = shotSpeed;
	}

	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x + 15, y, 5, 5);
	}

	public void move() {
		y -= shotSpeed;
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

	public int getShotSpeed() {
		return shotSpeed;
	}

	public void setShotSpeed(int shotSpeed) {
		this.shotSpeed = shotSpeed;
	}
}
