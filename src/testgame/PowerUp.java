package testgame;

import java.awt.Color;
import java.awt.Graphics2D;

public class PowerUp extends Sprite {
	private int x;
	private int y;
	private int[] xPoints = { x, x + 4, x - 4, x };
	private int[] yPoints = { y, y - 4, y - 4, y };
	
	public PowerUp() {
		
	}

	public PowerUp(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void move() {
		for (int i = 0; i < xPoints.length; i++) {
			xPoints[i] += 4;
		}
		super.setY(super.getY() + 4);
	}

	public int[] getxPoints() {
		return xPoints;
	}

	public void setxPoints(int[] xPoints) {
		this.xPoints = xPoints;
	}

	public int[] getyPoints() {
		return yPoints;
	}

	public void setyPoints(int[] yPoints) {
		this.yPoints = yPoints;
	}

}
