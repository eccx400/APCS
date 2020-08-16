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
 * Sets the different squares so it becomes a 9x9 sudoku board
 * 
 * @author Eric Cheng
 * @author Kabir Kapoor
 * @date 5/23/2015
 * @author Assignment - JMCh999_FinalExam
 */
public class SetPanel extends JPanel
{
    /**
     * Constructor
     */
    public SetPanel()
    {
        setLayout( new GridBagLayout() );

        GridBagConstraints gbc = new GridBagConstraints();

        for ( int row = 0; row < 9; row++ )
        {
            for ( int col = 0; col < 9; col++ )
            {
                gbc.gridx = col;
                gbc.gridy = row;

                Cell panel = new Cell();
                Border border = null;

                if ( row >= 8 )
                {
                    if ( col < 8 )
                    {
                        border = new MatteBorder( 1, 1, 1, 0, Color.GRAY );
                    }
                    else
                    {
                        border = new MatteBorder( 1, 1, 1, 1, Color.GRAY );
                    }
                }
                else
                {
                    if ( col < 8 )
                    {
                        border = new MatteBorder( 1, 1, 0, 0, Color.GRAY );
                    }
                    else
                    {
                        border = new MatteBorder( 1, 1, 0, 1, Color.GRAY );
                    }
                }
                panel.setBorder( border );
                add( panel, gbc );
            }
        }
    }
}