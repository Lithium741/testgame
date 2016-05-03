package testgame;

import java.awt.Color;
import java.awt.Graphics2D;

public class DShot extends PowerUp{
	
	public DShot(int x, int y) {
		super.setX(x);
		super.setY(y);
	}
	
	public void paint(Graphics2D g) {
		g.setColor(Color.CYAN);
		g.fillPolygon(super.getxPoints(), super.getyPoints(), 3);
	}
}
