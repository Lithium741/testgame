package testgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Shot extends JPanel {

	private int x = 50;
	private int y = 400;
	private int shotSpeed;

	public Shot(int x, int y, int shotSpeed) {
		this.x = x;
		this.y = y;
		this.shotSpeed = shotSpeed;
	}

	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, 20, 20);
	}

	public void move() {
		y = y - shotSpeed;
	}
}
