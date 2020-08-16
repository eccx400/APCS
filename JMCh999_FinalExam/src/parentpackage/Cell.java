package parentpackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;


/**
 * Creates mouse adapter for each cell
 * 
 * @author Eric Cheng
 * @author Kabir Kapoor
 * @date 5/23/2015
 * @author Assignment - JMCh999_FinalExam
 */
public class Cell extends JPanel
{
    /**
     * 
     */
    private Color defaultBackground;


    /**
     * Constructor
     */
    public Cell()
    {
        addMouseListener( new MouseAdapter()
        {
            public void mouseEntered( MouseEvent e )
            {
                defaultBackground = getBackground();
                setBackground( Color.RED );
            }


            public void mouseExited( MouseEvent e )
            {
                setBackground( defaultBackground );
            }
        } );
    }


    @Override
    /*
     * (non-Javadoc)
     * 
     * @see javax.swing.JComponent#getPreferredSize()
     */
    public Dimension getPreferredSize()
    {
        return new Dimension( 50, 50 );
    }
}
