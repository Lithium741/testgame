package testgame;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Graphics2D;

public class RedShip extends EnemyShip {
	private int x;
	private int y = 0;
	private int WIDTH = 30;
	private int HEIGHT = 15;
	private int SPEED;
	private boolean border = true;
	JFrame world;
	
	public RedShip(int x, int SPEED, JFrame world) {
		this.x = x;
		this.SPEED = SPEED;
		this.world = world;
		System.out.println(world);
	}

	public void paint(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
}
