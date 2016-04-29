package testgame;

import javax.swing.JComponent;
import java.awt.*;
import java.util.ArrayList;

public class GameBoard extends JComponent {

	Spaceship ship;
	private ArrayList<Shot> shots = new ArrayList<Shot>();
	private ArrayList<RedShip> RShip = new ArrayList<RedShip>();

	GameBoard() {

	}

	GameBoard(Spaceship ship, ArrayList<Shot> shots, ArrayList<RedShip> RShip) {
		this.ship = ship;
		this.shots = shots;
		this.RShip = RShip;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		if (ship != null) {
			ship.paint(g2d);
			for (Shot temp : shots) {
				temp.paint(g2d);
			}
			for (RedShip temp : RShip) {
				temp.paint(g2d);
			}
		}
	}

}
