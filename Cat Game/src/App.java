import javax.swing.*;

class App {

	public static JFrame window = new JFrame("19290315");
	public static Board board = new Board();

	private static void initWindow() {
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		window.add(board);
		window.addKeyListener(board);

		window.setResizable(false);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

	public static void closeWindow() {
		window.dispose();
	}

	public static void restart() {
		window = new JFrame("19290315");
		Board.NUM_CATS = 7;
		board = new Board();
		initWindow();
	}

	public static void main(String[] args) {
		initWindow();

	}
}