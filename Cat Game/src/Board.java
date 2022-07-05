import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.*;

public class Board extends JPanel implements ActionListener, KeyListener {

	private final int DELAY = 25;
	public static final int TILE_SIZE = 60;
	public static final int ROWS = 12;
	public static final int COLUMNS = 12;
	public static int NUM_CATS = 7;
	private static final long serialVersionUID = 490905409104883233L;

	private Timer timer;
	private Player player;
	private ArrayList<Cat> cats;
	private ArrayList<Cloud> clouds;
	private Coin coin;
	private boolean gameOver;
	private int level;

	public Board() {
		setPreferredSize(new Dimension(TILE_SIZE * COLUMNS, TILE_SIZE * ROWS));
		setBackground(new Color(100, 149, 237));
		player = new Player();
		cats = populateItems();
		newCoin();
		newCloud();
		level = 1;

		timer = new Timer(DELAY, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			if (!gameOver) {
			player.tick();

			collectCoins();
			for (Cat cat : cats) {
				if (cat.getY() < 0) {
					cats = populateItems();
				}
			}
			for (Cloud cloud : clouds) {
				if (cloud.getY() < 0) {
					newCloud();
				}
			}
			if (coin.getY() < 0) {
				newCoin();
			}
			for (Cat cat : cats) {
				cat.goUp(0.15);
			}
			for (Cloud cloud : clouds) {
				cloud.goUp(0.1);
			}
			coin.goUp(0.1);
			if (Integer.parseInt(player.getScore()) == 500) {
				player.addScore(50);
				level = 2;
				NUM_CATS++;
			}
			if (Integer.parseInt(player.getScore()) == 1050) {
				player.addScore(100);
				level = 3;
				NUM_CATS++;
			}
			if (Integer.parseInt(player.getScore()) == 1650) {
				player.addScore(150);
				level = 4;
				NUM_CATS++;
			}
			if (Integer.parseInt(player.getScore()) == 2300) {
				player.addScore(200);
				level = 5;
				NUM_CATS++;
			}
			repaint();
		}
		if (gameOver) {

			repaint();
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawScore(g);
		drawLevel(g, level);
		for (Cat cat : cats) {
			cat.draw(g, this);
		}
		for (Cloud cloud : clouds) {
			cloud.draw(g, this);
		}
		player.draw(g, this);
		coin.draw(g, this);
		
		Toolkit.getDefaultToolkit().sync();
		if (gameOver) {
			drawGameOver(g);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		player.keyPressed(e);
		if (gameOver & e.getKeyCode() == KeyEvent.VK_SPACE) {
			App.closeWindow();
			App.restart();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	private void drawScore(Graphics g) {
		String text = "Score : " + player.getScore();
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(30, 201, 139));
		g2d.setFont(new Font("Lato", Font.BOLD, 25));
		FontMetrics metrics = g2d.getFontMetrics(g2d.getFont());
		Rectangle rect = new Rectangle(0, TILE_SIZE * (ROWS - 1), TILE_SIZE * COLUMNS, TILE_SIZE);
		int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
		int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
		g2d.drawString(text, x, y);
	}

	private void drawGameOver(Graphics g) {
		String text = "GAME OVER";
		String text2 = "Press 'Space' to Restart";
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(0, 0, 0));
		g2d.setFont(new Font("Lato", Font.BOLD, 45));
		FontMetrics metrics = g2d.getFontMetrics(g2d.getFont());
		Rectangle rect = new Rectangle(0, TILE_SIZE * (ROWS - 7), TILE_SIZE * COLUMNS, TILE_SIZE);
		int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
		int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
		g2d.drawString(text, x, y);
		g2d.drawString(text2, x - 120, y + 60);
	}

	private void drawLevel(Graphics g, int level) {
		String text = "Level " + level;
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(255, 140, 0));
		g2d.setFont(new Font("Lato", Font.BOLD, 45));
		FontMetrics metrics = g2d.getFontMetrics(g2d.getFont());
		Rectangle rect = new Rectangle(0, TILE_SIZE * 1, TILE_SIZE * COLUMNS, TILE_SIZE);
		int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
		int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
		g2d.drawString(text, x, y);
	}

	private ArrayList<Cat> populateItems() {
		ArrayList<Cat> catList = new ArrayList<>();
		ArrayList<Integer> columns = new ArrayList<Integer>();
		for (int i = 0; i < COLUMNS; i++) {
			columns.add(i);
		}
		Collections.shuffle(columns);
		for (int i = 0; i < NUM_CATS; i++) {
			int catX = columns.get(i);
			int catY = 10;

			catList.add(new Cat(catX, catY));
		}

		return catList;
	}

	public void newCoin() {
		Random rand = new Random();
		coin = new Coin(rand.nextInt(10), 10);
	}

	public void newCloud() {
		Random rand = new Random();
		ArrayList<Cloud> cloudList = new ArrayList<>();
		cloudList.add(new Cloud(rand.nextInt(10), 13));
		cloudList.add(new Cloud(rand.nextInt(10), 10));
		cloudList.add(new Cloud(rand.nextInt(10), 7));
		cloudList.add(new Cloud(rand.nextInt(10), 4));
		cloudList.add(new Cloud(rand.nextInt(10), 1));
		clouds = cloudList;
	}

	private void collectCoins() {
		for (Cat cat : cats) {
			if (player.getPos().equals(new Point(cat.getX(), cat.getY()))) {
				gameOver = true;
				cats = new ArrayList<Cat>();
			}
		}
		if (player.getPos().x == coin.getX() & (player.getPos().y * TILE_SIZE) > (coin.getYdouble() - 60)
				& (player.getPos().y * TILE_SIZE) < (coin.getYdouble() + 60)) {
			player.addScore(100);
			newCoin();
		}
	}

}
