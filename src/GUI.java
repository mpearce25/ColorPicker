import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;


public class GUI extends JPanel{

	static JFrame frame = new JFrame();
	static JLabel backgroundColor = new JLabel();
	
	
	
	public GUI(String title){
		frame.setTitle(title);
		backgroundColor.setBackground(new Color(255,255,255));
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					displayGUI(frame);
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
	}
	
	private static void displayGUI(JFrame frame) throws AWTException {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create the menu bar. Make it have a green background.
		JMenuBar greenMenuBar = new JMenuBar();
		greenMenuBar.setOpaque(true);
		greenMenuBar.setBackground(new Color(154, 165, 127));
		greenMenuBar.setPreferredSize(new Dimension(200, 20));

		// Create a yellow label to put in the content pane.

		//JLabel yellowLabel = new JLabel();
		backgroundColor.setOpaque(true);
		backgroundColor.setBackground(screenInfo.getColor());
		backgroundColor.setPreferredSize(new Dimension(200, 180));

		// Set the menu bar and add the label to the content pane.
		frame.setJMenuBar(greenMenuBar);
		frame.getContentPane().add(backgroundColor, BorderLayout.CENTER);

		// Display the window.
		frame.pack();
		frame.setVisible(true);

	}
	
	public void setBackgroundColor(GUI gui, Color color){
		gui.backgroundColor.setBackground(color);
		frame.getContentPane().add(backgroundColor, BorderLayout.CENTER);
	}
	
	public static JFrame getFrame(){
		return frame;
		
	}

}
