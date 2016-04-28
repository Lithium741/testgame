package testgame;

import javax.swing.JPanel;

import com.sun.javafx.geom.Rectangle;

public class Sprite extends JPanel {

	private int x;
	private int y;
	private int WIDTH;
	private int HEIGHT;

	public Rectangle returnBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
}
