package testgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.Timer;

import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;

public class World extends JFrame {

	GameBoard p;
	private JPanel contentPane;
	private Spaceship ship = new Spaceship(this);
	JTextArea txtrScore;
	private int score = 0;
	private ArrayList<Shot> shots = new ArrayList<Shot>();
	private ArrayList<RedShip> RShip = new ArrayList<RedShip>();
	private ArrayList<OrangeShip> OShip = new ArrayList<OrangeShip>();
	private boolean start = false;
	int a = 0;
	int eSpeed = 1;

	public World() {

		setFocusable(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 830);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtrScore = new JTextArea();
		txtrScore.setBackground(Color.BLACK);
		txtrScore.setForeground(Color.YELLOW);
		txtrScore.setFont(new Font("Impact", Font.PLAIN, 20));
		txtrScore.setText("Score: " + score);
		txtrScore.setBounds(1, 5, 100, 45);
		contentPane.add(txtrScore);

		JTextArea txtrLife = new JTextArea();
		txtrLife.setBackground(Color.BLACK);
		txtrLife.setForeground(Color.RED);
		txtrLife.setFont(new Font("Impact", Font.PLAIN, 20));
		txtrLife.setText("Life");
		txtrLife.setBounds(324, 5, 41, 45);
		contentPane.add(txtrLife);

		JTextArea txtrTitle = new JTextArea();
		txtrTitle.setBackground(Color.BLACK);
		txtrTitle.setForeground(Color.YELLOW);
		txtrTitle.setFont(new Font("Impact", Font.PLAIN, 38));
		txtrTitle.setText("Impact");
		txtrTitle.setBounds(217, 180, 279, 45);
		contentPane.add(txtrTitle);

		JTextArea txtrPressStartTo = new JTextArea();
		txtrPressStartTo.setFont(new Font("Impact", Font.PLAIN, 18));
		txtrPressStartTo.setForeground(Color.YELLOW);
		txtrPressStartTo.setBackground(Color.BLACK);
		txtrPressStartTo.setText("Press space to fire");
		txtrPressStartTo.setBounds(207, 224, 206, 62);
		contentPane.add(txtrPressStartTo);

		p = new GameBoard(ship, shots, RShip, OShip);
		p.setBackground(Color.BLACK);
		p.setLocation(0, 0);
		p.setSize(569, 792);
		contentPane.add(p);

		ActionListener taskPerformer = new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				try {
					move();
					repaint();
					a++;
					if ((a % 120) == 0) {
						RShip.add(
								new RedShip((int) (Math.random() * 585), 10, eSpeed, p, (int) (Math.random() * 2) + 1));
					}

					if (a == 1000) {
						OShip.add(new OrangeShip((int) (Math.random() * 585), 10, eSpeed, p,
								(int) (Math.random() * 2) + 1));
						a = 0;
					}

				} catch (Exception e) {
				}
			}
		};

		int delay = 13;
		Timer timer = new Timer(delay, taskPerformer);
		timer.setInitialDelay(delay);

		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 37) {
					ship.keyReleased(e);
				} else if (e.getKeyCode() == 39) {
					ship.keyReleased(e);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 37) {
					ship.keyPressed(e);
				}
				if (e.getKeyCode() == 39) {
					ship.keyPressed(e);
				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					if (start = true) {
						txtrTitle.setVisible(false);
						txtrPressStartTo.setVisible(false);
						timer.start();
						start = false;
					}
					shots.add(new Shot(ship.getX(), ship.getY(), 12));
				}
			}
		});

	}

	private void move() {
		if (p.getLife().getWIDTH() == 0) {
			System.exit(0);
		}
		ship.move();
		for (Shot temp : shots) {
			if (temp.getY() > 0) {
				temp.move();
			} else if (temp.getY() == 0) {
				removeShot(temp);
			}
		}
		for (RedShip temp : RShip) {
			if (temp.getY() < 770) {
				temp.move();
			} else if (temp.getY() >= 770) {
				removeRShip(temp);
				p.getLife().sDamage();
			}
		}

		for (OrangeShip temp : OShip) {
			if (temp.getY() < 770) {
				temp.move();
			} else if (temp.getY() >= 770) {
				removeOShip(temp);
				p.getLife().dDamage();
			}
		}

		for (RedShip tempS : RShip) {
			for (Shot temp : shots) {
				if (temp.returnBounds().intersects(tempS.hitbox())) {
					removeShot(temp);
					removeRShip(tempS);
					score++;
					txtrScore.setText("Score: " + score);
				}
			}
		}

		for (OrangeShip tempS : OShip) {
			for (Shot temp : shots) {
				if (temp.returnBounds().intersects(tempS.hitbox())) {
					removeShot(temp);
					removeOShip(tempS);
					score++;
					txtrScore.setText("Score: " + score);
				}
			}
		}

	}

	public void removeShot(Shot temp) {
		shots.remove(temp);
	}

	public void removeRShip(RedShip temp) {
		RShip.remove(temp);
	}

	public void removeOShip(OrangeShip temp) {
		OShip.remove(temp);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					World frame = new World();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public World getFrame() {
		return this;
	}
}
