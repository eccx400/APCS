import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.AudioClip;

/**
 * The applet in Figure 12-1 is a "fortune teller." When the user presses the
 * "Next" button, the applet displays a message randomly chosen from an array of
 * messages.
 * 
 * @author Eric Cheng
 * @version 21 October 2014
 * @author Period - 2
 * @author Assignment - Lab 12.3: Fortune Teller
 * @author Sources - Eric Cheng
 */
public class FortuneTeller extends JApplet implements ActionListener
{
    // Declare an array of "fortunes" (strings):

    /**
     * Creates an array of length 7 with fortunes
     */
    String[] fortune = new String[8];
    {
        fortune[0] = "Be careful on Tuesday. ";
        fortune[1] = "Don't look behind you.";
        fortune[2] = "Your talents will be recognized and rewarded.";
        fortune[3] = "Trust your gut feeling.You will get an A on a test.";
        fortune[4] = "A secret admirer will soon show how they feel. ";
        fortune[5] = "The one you love is closer than you think.";
        fortune[6] = "You will be rich. ";
        fortune[7] = "Someone close will leave soon";
    }

    /**
     * Get display
     */
    private JTextField display;

    /**
     * Get audio
     */
    private AudioClip ding;

    /**
     * Creates the applet to run
     */
    public void init()
    {
        ding = getAudioClip( getDocumentBase(), "ding.wav" );

        display = new JTextField( "  Press \"Next\" to see your fortune...", 30 );
        display.setBackground( Color.WHITE );
        display.setEditable( false );

        JButton go = new JButton( "Next" );
        go.addActionListener( this );

        Container c = getContentPane();
        c.setLayout( new FlowLayout() );
        c.add( display );
        c.add( go );
    }

    /**
     * @param e
     *            = Gets a random number and displays the fortune
     */
    public void actionPerformed( ActionEvent e )
    {
        ding.play();

        // Pick a random fortune:
        int rand = (int)( Math.random() * 8 );

        display.setText( "  " + fortune[rand] );
    }
}
