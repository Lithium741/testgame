package testgame;

import javax.swing.JComponent;
import java.awt.*;
import java.util.ArrayList;

public class GameBoard extends JComponent {

	private Spaceship ship;
	private Life life = new Life(this);
	private int lifeValue = 200;
	private ArrayList<Shot> shots = new ArrayList<Shot>();
	private ArrayList<RedShip> RShip = new ArrayList<RedShip>();
	private ArrayList<OrangeShip> OShip = new ArrayList<OrangeShip>();

	GameBoard() {

	}

	GameBoard(Spaceship ship, ArrayList<Shot> shots, ArrayList<RedShip> RShip, ArrayList<OrangeShip> OShip) {
		this.ship = ship;
		this.shots = shots;
		this.RShip = RShip;
		this.OShip = OShip; 
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		if (ship != null) {
			life.paint(g2d);
			ship.paint(g2d);
			for (Shot temp : shots) {
				temp.paint(g2d);
			}
			for (RedShip temp : RShip) {
				temp.paint(g2d);
			}
			for (OrangeShip temp : OShip) {
				temp.paint(g2d);
			}
		}
	}

	public int getLifeValue() {
		return lifeValue;
	}

	public void setLifeValue(int lifeValue) {
		this.lifeValue = lifeValue;
	}

	public Spaceship getShip() {
		return ship;
	}

	public void setShip(Spaceship ship) {
		this.ship = ship;
	}

	public Life getLife() {
		return life;
	}

	public void setLife(Life life) {
		this.life = life;
	}

}
