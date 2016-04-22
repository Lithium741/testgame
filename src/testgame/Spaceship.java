package testgame;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Spaceship extends JPanel{
	private int x = 242;
	private int xPoints[] = { 50, 90, 10, 50 };
	private int yPoints[] = { 0, 50, 50, 0 };
	private World world;

	public Spaceship(World world) {
		this.world = world;
	}

	public void paint(Graphics2D g) {
		g.fillPolygon(xPoints, yPoints, 4);
	}
	
	public void keyReleased(KeyEvent e) {
		x = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			x = -3;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			x = 3;
	}
}
