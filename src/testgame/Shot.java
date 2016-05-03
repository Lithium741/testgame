package testgame;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.*;

public class Shot extends Sprite {

	private int x;
	private int y;
	private int WIDTH = 3;
	private int HEIGHT = 15;
	private int shotSpeed;

	public Shot(int x, int y, int shotSpeed) {
		this.x = x;
		this.y = y;
		this.shotSpeed = shotSpeed;
	}

	public void paint(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x - 1, y, WIDTH, HEIGHT);
	}

	public void move() {
		y -= shotSpeed;
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
