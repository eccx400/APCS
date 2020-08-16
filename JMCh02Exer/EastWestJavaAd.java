// This applet displays a message moving horizontally
// across the screen.There are 2 messages,"East or West",
// and "Java is Best", which fires every 2 seconds

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This program displays moving "East and West", alternate with "Java is best"
 * 
 * @author Eric Cheng
 * @date 8/21/14
 * @Period 2
 * @Source Eric Cheng
 */
public class EastWestJavaAd extends JApplet implements ActionListener {
	private int xPos, yPos; // hold the coordinates of the banner
	public int msgID = 1;

	/**
	 * Initializes the timer
	 */
	public void init() {
		Container c = getContentPane();
		c.setBackground(Color.WHITE);
		xPos = 100;
		yPos = 100;
		Timer clock = new Timer(2000, this); // fires every 2000 milliseconds
												// (aka 2 sec)
		clock.start();
		msgID = -msgID; // Switch!
	}

	// Called automatically after a repaint request
	public void paint(Graphics g) {
		super.paint(g);
		// If statement to state when to print according to msgID
		if (msgID == 1) {
			g.drawString("East or West", xPos, yPos);
		} else {
			g.drawString("Java is Best", xPos, yPos);
		}
	}

	// Called automatically when the timer fires
	public void actionPerformed(ActionEvent e) {
		Container c = getContentPane();

		// changes the text
		msgID = -msgID;

		repaint();
	}
}