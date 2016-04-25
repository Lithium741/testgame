package testgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
		txtrTitle.setText("Impact");
		txtrTitle.setBounds(222, 182, 279, 45);
		contentPane.add(txtrTitle);

		JTextArea txtrPressStartTo = new JTextArea();
		txtrPressStartTo.setFont(new Font("Impact", Font.PLAIN, 18));
		txtrPressStartTo.setForeground(Color.YELLOW);
		txtrPressStartTo.setBackground(Color.BLACK);
		txtrPressStartTo.setText("Press start to start :D");
		txtrPressStartTo.setBounds(203, 222, 206, 62);
		contentPane.add(txtrPressStartTo);

		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// ...Perform a task...
				// System.out.println("timer");
				try {

					repaint();
					ship.move();
					box.move();

				} catch (Exception e) {
					System.out.println("Thread");
				}
			}
		};

		int delay = 50;
		Timer timer = new Timer(delay, taskPerformer);
		timer.setInitialDelay(delay);

		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				ship.keyReleased(e);
				box.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				ship.keyPressed(e);
				box.keyPressed(e);
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					if (start = false) {
						txtrTitle.setVisible(false);
						start = true;
					} else if (start = true) {
						timer.start();
					}
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
		box.paint(g2d);
	}

	private JPanel contentPane;
	private Spaceship ship = new Spaceship(this);
	private SpaceshipHitbox box = new SpaceshipHitbox(this);
	private boolean start = false;

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
