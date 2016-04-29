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

	private JPanel contentPane;
	private Spaceship ship = new Spaceship(this);
	private ArrayList<Shot> shots = new ArrayList<Shot>();
	private ArrayList<RedShip> RShip = new ArrayList<RedShip>();
	private boolean start = false;
	int a = 0;

	public World() {

		setFocusable(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 830);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea txtrTitle = new JTextArea();
		txtrTitle.setBackground(Color.BLACK);
		txtrTitle.setForeground(Color.YELLOW);
		txtrTitle.setFont(new Font("Impact", Font.PLAIN, 38));
		txtrTitle.setText("Test");
		txtrTitle.setBounds(237, 179, 279, 45);
		contentPane.add(txtrTitle);

		JTextArea txtrPressStartTo = new JTextArea();
		txtrPressStartTo.setFont(new Font("Impact", Font.PLAIN, 18));
		txtrPressStartTo.setForeground(Color.YELLOW);
		txtrPressStartTo.setBackground(Color.BLACK);
		txtrPressStartTo.setText("Press fire to start");
		txtrPressStartTo.setBounds(217, 221, 206, 62);
		contentPane.add(txtrPressStartTo);

		GameBoard p = new GameBoard(ship, shots, RShip);
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
					if (a == 50) {
						RShip.add(new RedShip((int) (Math.random() * 585), 10, 2, p, (int) (Math.random() * 1)));
						a = 0;
					}

				} catch (Exception e) {
				}
			}
		};

		int delay = 35;
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
					shots.add(new Shot(ship.getX(), ship.getY(), 40));
				}
			}
		});

	}

	private void move() {
		ship.move();

		for (Shot temp : shots) {
			if (temp.getY() > 0) {
				temp.move();
			} else if (temp.getY() == 0) {
				removeShot(temp);
			}
		}
		for (RedShip temp : RShip) {
			if (temp.getY() < 710) {
				temp.move();
			} else if (temp.getY() == 710) {
				removeRShip(temp);
			}
		}
		for (Shot temp : shots) {
			for (RedShip temps : RShip) {
				if (temp.getBounds().intersects(temps.getBounds())) {
					removeShot(temp);
					temp.setVisible(false);
					removeRShip(temps);
					temps.setVisible(false);
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
