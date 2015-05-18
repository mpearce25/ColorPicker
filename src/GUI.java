import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;

import javax.swing.*;

public class GUI extends JPanel {

	private static JFrame frame = new JFrame();
	private static JLabel backgroundColor = new JLabel();
	private static JLabel colorInfo = new JLabel();
	private static JMenuBar menuBar = new JMenuBar();

	public GUI(String title) {
		frame.setTitle(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				try {
					displayGUI();
				} catch (AWTException e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
		/*Component listener = new Component();
		frame.getContentPane().add(listener);
		listener.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "doSomething");
		listener.getActionMap().put("doSomething", listener.getAction());
		

	    @Override
	    public void actionPerformed(ActionEvent action) {

	   
	    	try {
				ColorPicker.changeRun();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	   }
	         
	};*/
		
		
		
		//JButton component = new Jbutton("Button");
		//InputMap map = component.getInputMap(JComponent.WHEN_FOCUSED);
		
	}

	private static void displayGUI() throws AWTException {

		// //menu bar

		// /menu options
		menuBar.setOpaque(true);
		menuBar.setBackground(new Color(154, 165, 127));
		menuBar.setPreferredSize(new Dimension(270, 20));

		// /copy hex in menu bar
		JMenuItem copyHex = new JMenuItem("Copy Hex");
		copyHex.addActionListener(new copyHex());
		menuBar.add(copyHex);
		frame.setJMenuBar(menuBar);

		// ////copy rgb in menu bar
		JMenuItem copyRGB = new JMenuItem("Copy RGB");
		copyRGB.addActionListener(new copyRGB());
		menuBar.add(copyRGB);
		frame.setJMenuBar(menuBar);

		frame.setJMenuBar(menuBar);

		// //////// COlored square output
		backgroundColor.setOpaque(true);
		backgroundColor.setBackground(screenInfo.getColor());
		backgroundColor.setPreferredSize(new Dimension(250, 70));
		frame.getContentPane().add(backgroundColor, BorderLayout.CENTER);

		// ////////Color info output @ top

		colorInfo.setOpaque(true);
		colorInfo.setBackground(new Color(255, 255, 255));
		colorInfo.setPreferredSize(new Dimension(250, 35));
		frame.getContentPane().add(colorInfo, BorderLayout.NORTH);

		// ////////////
		
		
		
		
		

		// Display the window.
		frame.pack();
		frame.setVisible(true);

	}

	public void setBackgroundColor(Color color) {

		this.backgroundColor.setBackground(color);
		frame.getContentPane().add(backgroundColor, BorderLayout.CENTER);
	}

	public static void setColorText(String text) {
		colorInfo.setText(text);
	}

}

class copyRGB implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Utilities.setClipboard(screenInfo.getColorRGB());
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

class copyHex implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Utilities.setClipboard(screenInfo.getColorHex());
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
