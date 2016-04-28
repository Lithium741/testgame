package testgame;

import java.awt.Color;
import java.awt.Graphics2D;

public class RedShip extends EnemyShip {
	private int x;
	private int y = 0;
	private int WIDTH = 30;
	private int HEIGHT = 15;
	private int SPEED;
	private boolean border = true;
	World world;
	
	public RedShip(int x, int SPEED, World world) {
		this.x = x;
		this.SPEED = SPEED;
		this.world = world;
	}

	public void paint(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
}
