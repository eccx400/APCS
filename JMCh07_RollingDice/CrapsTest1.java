import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

/**
 * Implements a rolling die object.
 *
 * @author Eric Cheng
 * @version 10 Septembre 2014
 * @author Period: 2
 * @author Assignment: JMCh07_RollingDice
 *
 * @author Sources: Eric Cheng
 */
public class CrapsTest1 extends JFrame implements ActionListener
{
    private CrapsGame game;
    private JTextField input;
    private JTextArea display;
    
    /**
     * Constructor
     */
    public CrapsTest1()
    {
        super( "Craps: Test 1" );

        Container c = getContentPane();
        c.setLayout( new FlowLayout() );

        c.add( new JLabel( "Next roll:" ) );
        input = new JTextField( 5 );
        input.setBackground( Color.YELLOW );
        input.addActionListener( this );
        c.add( input );

        display = new JTextArea( 10, 20 );
        display.setEditable( false );
        display.setBackground( Color.WHITE );
        c.add( new JScrollPane( display,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER ) );

        game = new CrapsGame();
    }
 
    /**
     * Called when a number is entered into the JTextField input
     * 
     * @param e = Action event
     */
    public void actionPerformed( ActionEvent e )
    {
        String s = input.getText().trim();
        int total = Integer.parseInt( s );
        int result = game.processRoll( total );
        int point = game.getPoint();
        input.setText( "" );
        display.append( total + ":  Result = " + result + " Point = " + point
            + "\n" );
    }


    /**
     * Main method of test
     * 
     * @param args = arguments array
     */
    public static void main( String[] args )
    {
        CrapsTest1 window = new CrapsTest1();
        window.setBounds( 100, 100, 300, 240 );
        window.setDefaultCloseOperation( EXIT_ON_CLOSE );
        window.setResizable( false );
        window.setVisible( true );
    }
}
