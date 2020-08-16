import java.awt.*;
import javax.swing.*;

/**
 * This program creates an optical illusion by drawing chequered squares per
 * row, creating a sense of bending in the lines although they are actually
 * parallel. This program uses nested for loops to draw out the pattern.
 * 
 * @author Eric Cheng
 * @version 22 Septembre 2014
 * @author Period - 2 Assignment - A12.6 - ParallelLines
 * 
 * @author Sources - Eric Cheng
 */
public class ParallelLines extends JPanel
{
    /**
     * JPanel paintComponent method 
     * @param g = Graphics G
     */
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g ); // Call JPanel's paintComponent method
                                   // to paint the background

        int width = getWidth();
        int height = getHeight();

        drawIllusion( g, width, height );
    }

    /**
     * This program uses for loops to create a "chequerboard" like pattern that
     * creates an optical illusion by creating rows of squares with different
     * offset values between them.
     * 
     * @param g
     *            = Graphics g
     * @param width
     *            = width of program
     * @param height
     *            = height of program
     */
    public void drawIllusion( Graphics g, int width, int height )
    {
        {
            int offset = 0;
            int initY = height / 8;

            for ( int row = 0; row < 8; row++ ) // First loop
            {
                // Draws the lines that determines the number of rows
                int square1x = row * height;
                g.drawLine( 0, square1x / 8, width, square1x / 8 );

                // calculate and add a horizontal offset
                if ( row % 2 == 0 ) // Even Rows (2nd, 6th)
                {
                    offset = width / 42;
                }
                else if ( row == 3 || row == 7 )
                {
                    offset = width / 21;
                }
                else
                {
                    offset = 0;
                }

                // Draw the square
                for ( int col = 0; col < 7; col++ ) // Second loop
                {
                    g.fillRect( offset + ( 2 * ( col * initY ) ),
                        ( row * initY ) + 1,
                        initY,
                        initY );
                }
            }
        }
    }

    /**
     * Main method for the program
     * @param args = arguments array
     */
    public static void main( String[] args )
    {
        JFrame w = new JFrame( "ParallelLines" );
        w.setBounds( 100, 100, 640, 480 );
        w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        ParallelLines panel = new ParallelLines();
        panel.setBackground( Color.WHITE );
        Container c = w.getContentPane();
        c.add( panel );
        w.setResizable( true );
        w.setVisible( true );
    }
}
