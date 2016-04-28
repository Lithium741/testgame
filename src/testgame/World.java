package testgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

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
	private boolean start = false;
	private ArrayList<Shot> shots = new ArrayList<Shot>();

	public World() {

		setFocusable(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 830);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea txtrTitle = new JTextArea();
		txtrTitle.setBackground(Color.BLACK);
		txtrTitle.setForeground(Color.YELLOW);
		txtrTitle.setFont(new Font("Impact", Font.PLAIN, 38));
		txtrTitle.setText("Impact");
		txtrTitle.setBounds(222, 182, 279, 45);
		contentPane.add(txtrTitle);

		JTextArea txtrPressStartTo = new JTextArea();
		txtrPressStartTo.setFont(new Font("Impact", Font.PLAIN, 18));
		txtrPressStartTo.setForeground(Color.YELLOW);
		txtrPressStartTo.setBackground(Color.BLACK);
		txtrPressStartTo.setText("Press fire to start");
		txtrPressStartTo.setBounds(217, 221, 206, 62);
		contentPane.add(txtrPressStartTo);

		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// ...Perform a task...
				// System.out.println("timer");
				try {

					move();
					repaint();

				} catch (Exception e) {
					System.out.println("Thread");
				}
			}
		};

		int delay = 35;
		Timer timer = new Timer(delay, taskPerformer);
		timer.setInitialDelay(delay);

		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				ship.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				ship.keyPressed(e);
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					if (start = false) {
						start = true;
					} else if (start = true) {
						timer.start();
						txtrTitle.setVisible(false);
						txtrPressStartTo.setVisible(false);
					}
					shots.add(new Shot(ship.getX(), ship.getY(), 10));
				}
			}
		});

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		ship.paint(g2d);
		for (Shot temp : shots) {
			temp.paint(g2d);
		}
	}

	private void move() {
		ship.move();
		for (Shot temp : shots) {
			if (temp.getY() > 0) {
				temp.move();
			} else if (temp.getY() == 0) {
				removeShot(temp);
				System.out.println(shots.size());
			}
		}
	}

	public void removeShot(Shot temp) {
		shots.remove(temp);
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
}
