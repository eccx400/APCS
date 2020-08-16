// Question 2-13-b

import java.awt.*;
import java.awt.Graphics.*;

import javax.swing.*;

/**
 * This program displays a target logo on a white background. This program
 * prints out a robot face
 * 
 * @author Eric Cheng
 * @date 8/21/14
 * @Period 2
 * @Source Eric Cheng
 */
public class Target extends JPanel {
	/**
	 * Set shapes and colour
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Call JPanel's paintComponent method
									// to paint the background
		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;
		g.setColor(Color.RED);
		g.fillOval(xCenter - 25, yCenter - 25, 75, 75);
		g.setColor(Color.WHITE);
		g.fillOval(xCenter - 12, yCenter - 12, 50, 50);
		g.setColor(Color.RED);
		g.fillOval(xCenter, yCenter, 25, 25);
	}

	/**
	 * @param args
	 *            = arguments array
	 */
	public static void main(String[] args) {
		JFrame window = new JFrame("Red Cross");
		window.setBounds(300, 300, 200, 200);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Target panel = new Target();
		panel.setBackground(Color.WHITE);
		Container c = window.getContentPane();
		c.add(panel);
		window.setVisible(true);
	}
}