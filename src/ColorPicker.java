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


				gui.setBackgroundColor(screenInfo.getColor());
				gui.setColorText("Hex: " + screenInfo.getColorHex() + "\t\tRGB: " + screenInfo.getColorRGB());
				
			}
		}
	}
	
	
}
