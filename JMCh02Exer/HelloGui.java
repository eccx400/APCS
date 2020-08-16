/**
 *  This program displays a message in a window.
 */

import java.awt.*;
import javax.swing.*;

/**
 * This program displays GUI demo interface
 * 
 * @author Eric Cheng
 * @date 8/21/14
 * @Period 2
 * @Source Eric Cheng
 */
public class HelloGui extends JFrame {
	/**
	 * Constructor
	 */
	public HelloGui() // Constructor
	{
		super("GUI Demo"); // Set the title bar
		Container c = getContentPane();
		c.setBackground(Color.CYAN);
		c.setLayout(new FlowLayout());
		c.add(new JTextField(" Hello, GUI!", 10));
	}

	/**
	 * @param args
	 *            = arguments array
	 */
	public static void main(String[] args) {
		HelloGui window = new HelloGui();

		// Set this window's location and size:
		// upper-left corner at 300, 300; width 200, height 100
		window.setBounds(300, 300, 200, 100);

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
