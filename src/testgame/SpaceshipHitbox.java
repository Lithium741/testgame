package testgame;

import java.awt.Color;
import java.awt.Graphics2D;

public class SpaceshipHitbox extends Spaceship {

	public SpaceshipHitbox(World world) {
		super(world);
	}

	public void paint(Graphics2D g) {
		g.setColor(new Color(0, 0, 0, 0));
		g.fillRect(super.getX(), 392, 30, 20);
	}
}
