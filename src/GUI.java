import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

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
	}

	private static void displayGUI() throws AWTException {

		// //menu bar

		// /menu options
		menuBar.setOpaque(true);
		menuBar.setBackground(new Color(154, 165, 127));
		menuBar.setPreferredSize(new Dimension(270, 20));

		// /copy hex in menu bar
		JMenuItem copyHex = new JMenuItem("Copy Hex");
		copyHex.addActionListener(new MenuActionListener());
		menuBar.add(copyHex);
		frame.setJMenuBar(menuBar);

		// ////copy rgb in menu bar
		JMenuItem copyRGB = new JMenuItem("Copy RGB");
		copyRGB.addActionListener(new MenuActionListener());
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

class MenuActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {

		String action = e.getActionCommand();
		switch (action) {
		case "Copy RGB":
			try {
				setClipboard(screenInfo.getColorRGB());
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "Copy Hex": 
			try {
				setClipboard(screenInfo.getColorHex());
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}
	
	private void setClipboard(String text){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();

        clipboard.setContents(new StringSelection(text), null);
	}
}
