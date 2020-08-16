// This applet shows a string of text inside a box.

import java.awt.*;
import javax.swing.*;

/**
 * This program displays "Hello, Applet" in white text over a blue background
 * 
 * @author Eric Cheng
 * @date 8/21/14
 * @Period 2
 * @Source Eric Cheng
 */
public class HelloApplet extends JApplet {
	public void init() {
		Container c = getContentPane();
		c.setBackground(Color.WHITE);
	}

	public void paint(Graphics g) {
		super.paint(g); // call JApplet's paint method
						// to paint the background
		g.setColor(Color.BLUE);
		g.fillRect(25, 40, 150, 45); // draw a rectangle 150 by 45
		g.setColor(Color.WHITE);
		g.drawString("Hello, Applet!", 60, 65);
	}
}
