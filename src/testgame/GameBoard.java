package testgame;

import javax.swing.JComponent;
import java.awt.*;
import java.util.ArrayList;


public class GameBoard extends JComponent {
	
	Spaceship ship;
	private ArrayList<Shot> shots = new ArrayList<Shot>();
	
	GameBoard() {
		
		
	}

	GameBoard(Spaceship ship, ArrayList<Shot> shots) {
		this.ship  = ship;
		this.shots =shots;
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		if (ship!=null)  {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
			ship.paint(g2d);
			for (Shot temp : shots) {
				temp.paint(g2d);
			}
		}
		//for (EnemyShip temp : RShip) {
			//temp.paint(g2d);
		//}
		//System.out.print("p");
		//repaint();
	}


}
