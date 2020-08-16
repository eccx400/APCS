import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


/**
 * Implements the game of Craps logic.
 * 
 * @author Eric Cheng
 * @version 10 Septembre 2014
 * @author Period: 2
 * @author Assignment: JMCh07_RollingDice
 * 
 * @author Sources: Eric Cheng
 */
public class Craps extends JFrame
{
    /**
     * Constructor for the Craps Game
     */
    public Craps()
    {
        super( "Craps" );

        DisplayPanel display = new DisplayPanel();
        CrapsTable table = new CrapsTable( display );
        ControlPanel controls = new ControlPanel( table );

        JPanel panel = new JPanel();
        panel.setLayout( new BorderLayout() );
        panel.setBorder( new EmptyBorder( 0, 5, 0, 5 ) );
        panel.add( display, BorderLayout.NORTH );
        panel.add( table, BorderLayout.CENTER );
        panel.add( controls, BorderLayout.SOUTH );

        Container c = getContentPane();
        c.add( panel, BorderLayout.CENTER );
    }

    /**
     * The main method of the Applet
     * 
     * @param args
     *            = arguments array
     */
    public static void main( String[] args )
    {
        Craps window = new Craps();
        window.setBounds( 100, 100, 320, 240 );
        window.setDefaultCloseOperation( EXIT_ON_CLOSE );
        window.setVisible( true );
    }
}
