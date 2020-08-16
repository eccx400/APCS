import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 * This class creates a moving orange disk that flashes across the sky by using
 * a timer and graphics
 * 
 * @author Eric Cheng
 * @version 8/27/2014
 * @author Period: 2
 * @author Assignment: JMCh05_MovingDisk
 * @author Sources: Eric Cheng
 */
public class MovingDisk extends JPanel implements ActionListener
{
    private int time;


    /**
     * Creates the timer, initiates the time, and start the timer
     */
    public MovingDisk()
    {
        time = 0;
        Timer clock = new Timer( 30, this );
        clock.start();
    }


    /**
     * Basic "run" method of the program. Sets 3 variables x,y,r and defines
     * them, colours the sky and greates an orange sun with specific dimensions
     * 
     * @param g = graphics components
     * 
     */
    public void paintComponent( Graphics g )
    {
        int x = 150 - (int)( 100 * Math.cos( 0.005 * Math.PI * time ) );
        int y = 130 - (int)( 75 * Math.sin( 0.005 * Math.PI * time ) );
        int r = 20;

        Color sky;
        if ( y > 130 )
        {
            sky = Color.BLACK;
        }
        else
        {
            sky = Color.CYAN;
        }

        setBackground( sky );
        super.paintComponent( g );

        g.setColor( Color.ORANGE );
        g.fillOval( x - r, y - r, 2 * r, 2 * r );
    }


    /**
     * Increments the time and resets
     * 
     * @param e = new event
     */
    public void actionPerformed( ActionEvent e )
    {
        time++;
        repaint();
    }


    /**
     * @param args
     *            = arguments array
     */
    public static void main( String[] args )
    {
        JFrame w = new JFrame( "Moving Disk" );
        w.setSize( 300, 150 );
        w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Container c = w.getContentPane();
        c.add( new MovingDisk() );
        w.setResizable( false );
        w.setVisible( true );
    }
}
