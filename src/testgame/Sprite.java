package testgame;

import java.util.ArrayList;

import javax.swing.JComponent;

import com.sun.javafx.geom.Rectangle;

public class Sprite extends JComponent {

	private int x;
	private int y;
	private int WIDTH;
	private int HEIGHT;

	public Rectangle returnBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
}
