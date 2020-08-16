import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
public class CrapsStats extends JFrame implements ActionListener
{
    private CrapsGame game;

    private JTextField numberIn, statsOut;

    /**
     * Constructor for the Craps Test
     */
    public CrapsStats()
    {
        super( "Craps test" );

        Container c = getContentPane();
        c.setLayout( new FlowLayout() );

        c.add( new JLabel( "Number of games to run:" ) );

        numberIn = new JTextField( 5 );
        numberIn.addActionListener( this );
        c.add( numberIn );

        statsOut = new JTextField( 18 );
        statsOut.setEditable( false );
        c.add( statsOut );

        game = new CrapsGame();
    }

    /** 
     * Called when a number is entered in the numberIn text field
     */
    public void actionPerformed( ActionEvent e )
    {
        String s = numberIn.getText();
        int nGames = Integer.parseInt( s );
        int result, gameCount = 0, winCount = 0;
        Die die1 = new Die();
        Die die2 = new Die();

        while ( gameCount < nGames )
        {
            die1.roll();
            die2.roll();
            int total = die1.getNumDots() + die2.getNumDots();
            result = game.processRoll( total );
            if ( result != 0 )
                gameCount++;
            if ( result > 0 )
                winCount++;
        }
        numberIn.setText( "" );
        statsOut.setText( " Games: " + gameCount + " Wins: " + winCount );
    }

    /**
     * Creates applet to run 
     * 
     * @param args = arguments array
     */
    public static void main( String args[] )
    {
        CrapsStats window = new CrapsStats();
        window.setBounds( 100, 100, 300, 100 );
        window.setDefaultCloseOperation( EXIT_ON_CLOSE );
        window.setResizable( false );
        window.setVisible( true );
    }
}
