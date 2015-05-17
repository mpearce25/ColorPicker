import java.awt.*;

import javax.swing.*;

public class ColorPicker extends JPanel {

	public static void main(String[] a) throws AWTException {

		GUI gui = new GUI("Color Finder");
		startColorPicker(gui);

		
	}
	
	public static void startColorPicker(GUI gui) throws AWTException{
		
		Color color = new Color(255, 255, 255);

		for (int i = 0; i < 100;) {
			if (!color.equals(screenInfo.getColor())) {
				color = screenInfo.getColor();
				System.out.println(screenInfo.getColor());

				gui.setBackgroundColor(gui, screenInfo.getColor());
			}
		}
	}
}
