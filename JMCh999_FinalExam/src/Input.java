import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import parentpackage.GUI;

    
// Inner class to be used as ActionEvent listener for all JTextFields
public class Input extends GUI implements ActionListener
{

    @Override
    public void actionPerformed( ActionEvent e )
    {
        // Determine the (row, col) of the JTextField that triggered the event
        int rowSelected = -1;
        int colSelected = -1;

        // Get the source object that fired the event
        JTextField source = (JTextField)e.getSource();
        // Scan all rows and columns, and match with the source object
        boolean found = false;
        for ( int row = 0; row < GRID_SIZE && !found; ++row )
        {
            for ( int col = 0; col < GRID_SIZE && !found; ++col )
            {
                if ( tfCells[row][col] == source )
                {
                    rowSelected = row;
                    colSelected = col;
                    found = true; // break the inner/outer loops
                }
            }
        }

        /*
         * [TODO 4] 1. Get the input String via
         * tfCells[rowSelected][colSelected].getText() 2. Convert the String to
         * int via Integer.parseInt(). 3. Assume that the solution is unique.
         * Compare the input number with the number in the puzzle. If they are
         * the same, display in green; otherwise, display in red.
         */

        // [TODO 5] Check if the player has solved the puzzle after this move
    }
}