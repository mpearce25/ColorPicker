import java.awt.AWTException;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


public class KeyListener extends JPanel {
	
	Action pressedAction;
	
	public KeyListener(){
	
	Action pressedAction = new AbstractAction(){

	    @Override
	    public void actionPerformed(ActionEvent action) {

	   
	    	try {
				ColorPicker.changeRun();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	   }
	         
	};
	
}
	
	public Action getAction(){
		return pressedAction;
		
	}

	
}
