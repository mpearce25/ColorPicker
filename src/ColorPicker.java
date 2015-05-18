import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class ColorPicker extends JPanel {

	static boolean enterPressed = false;
	static GUI gui;
	
	public static void main(String[] a) throws AWTException {

		gui = new GUI("Color Finder");
		startColorPicker(gui);
	}
		
		

	public static void startColorPicker(GUI gui) throws AWTException {

		Color color = new Color(255, 255, 255);

		

		while (!enterPressed) {
			if (!color.equals(screenInfo.getColor())) {

				gui.setBackgroundColor(screenInfo.getColor());
				gui.setColorText("Hex: " + screenInfo.getColorHex()
						+ "\t\tRGB: " + screenInfo.getColorRGB());

			}
		}
	}
	
	public static void changeRun() throws AWTException{
		
		if (enterPressed){
			enterPressed = false;
			startColorPicker(gui);
			System.out.println("test");
		}
		else {
			enterPressed = true;
			
			System.out.println("test");
		}
	}
	

}
