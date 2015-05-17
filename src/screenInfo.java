import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Robot;

public class screenInfo {

	public static doublePoint getMouseCoordinates() {

		double x = MouseInfo.getPointerInfo().getLocation().getX();
		double y = MouseInfo.getPointerInfo().getLocation().getY();

		return new doublePoint(x, y);
	}

	public static Color getColor() throws AWTException {

		Robot bot = new Robot();
		doublePoint mouseLocation = getMouseCoordinates();

		return (bot.getPixelColor( (int)mouseLocation.getX(), (int)mouseLocation.getY()));

	}
}
