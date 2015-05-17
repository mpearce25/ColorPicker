import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class GUI extends JPanel {

	static JFrame frame = new JFrame();
	static JLabel backgroundColor = new JLabel();
	static JMenuBar menuBar = new JMenuBar();
	static JLabel colorInfo = new JLabel();

	public GUI(String title) {
		frame.setTitle(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		backgroundColor.setBackground(new Color(255, 255, 255));

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				try {
					displayGUI();
				} catch (AWTException e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static void displayGUI() throws AWTException {

		menuBar.setOpaque(true);
		menuBar.setBackground(new Color(154, 165, 127));
		menuBar.setPreferredSize(new Dimension(200, 20));

		// Create a yellow label to put in the content pane.

		// JLabel yellowLabel = new JLabel();
		backgroundColor.setOpaque(true);
		backgroundColor.setBackground(screenInfo.getColor());
		backgroundColor.setPreferredSize(new Dimension(200, 180));

		// Set the menu bar and add the label to the content pane.
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(backgroundColor, BorderLayout.CENTER);

		// Display the window.
		frame.pack();
		frame.setVisible(true);

	}

	public void setBackgroundColor(Color color) {
		// frame.getContentPane().remove(backgroundColor);

		this.backgroundColor.setBackground(color);
		frame.getContentPane().add(backgroundColor, BorderLayout.CENTER);
	}

	public static void setMenuBarTitle() {

	}

	public static void setLabelText(JLabel label, String text) {
		label.setText(text);
	}
	
	

}
