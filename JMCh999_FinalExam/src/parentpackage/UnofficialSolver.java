package parentpackage;

import java.applet.*;

import java.awt.*;


/**
 * The Unofficial Sudoku solver; it utilises a double array to store values and
 * the method finishes the sudoku puzzles
 * 
 * @author Eric Cheng
 * @author Kabir Kapoor
 * @date 5/23/2015
 * @author Assignment - JMCh999_FinalExam
 */
public class UnofficialSolver extends Applet implements Runnable
{

    protected int sample[][];

    protected Button grid[][];


    /**
     * Creates the sample puzzle
     */
    private void createsample()
    {
        sample = new int[9][9];

        for ( int row = 0; row < 9; row++ )
            for ( int col = 0; col < 9; col++ )
                sample[row][col] = 0;

        sample[0][0] = 9;
        sample[0][4] = 2;
        sample[0][6] = 7;
        sample[0][7] = 5;

        sample[1][0] = 6;
        sample[1][4] = 5;
        sample[1][7] = 4;

        sample[2][1] = 2;
        sample[2][3] = 4;
        sample[2][7] = 1;

        sample[3][0] = 2;
        sample[3][2] = 8;

        sample[4][1] = 7;
        sample[4][3] = 5;
        sample[4][5] = 9;
        sample[4][7] = 6;

        sample[5][6] = 4;
        sample[5][8] = 1;

        sample[6][1] = 1;
        sample[6][5] = 5;
        sample[6][7] = 8;

        sample[7][1] = 9;
        sample[7][4] = 7;
        sample[7][8] = 4;

        sample[8][1] = 8;
        sample[8][2] = 2;
        sample[8][4] = 4;
        sample[8][8] = 6;
    }


    /**
     * Creates the grid
     */
    private void creategrid()
    {
        setLayout( new GridLayout( 9, 9 ) );

        grid = new Button[9][9];

        for ( int row = 0; row < 9; row++ )
            for ( int col = 0; col < 9; col++ )
            {
                grid[row][col] = new Button();
                add( grid[row][col] );
            }
    }


    /**
     * Updates the grid
     */
    private void updategrid()
    {
        for ( int row = 0; row < 9; row++ )
            for ( int col = 0; col < 9; col++ )
                if ( sample[row][col] != 0 )
                    grid[row][col].setLabel( String.valueOf( sample[row][col] ) );
                else
                    grid[row][col].setLabel( "" );
    }


    /**
     * Initializes the grid
     */
    public void init()
    {
        createsample();
        creategrid();
        updategrid();
    }


    /**
     * Inspects row for a specified number
     * 
     * @param row
     *            = row checked
     * @param num
     *            = number to be searched for
     * @return true if number is not found
     */
    private boolean inspectRow( int row, int num )
    {
        for ( int col = 0; col < 9; col++ )
            if ( sample[row][col] == num )
                return false;

        return true;
    }


    /**
     * Inspects column for a specified number
     * 
     * @param col
     *            = column checked
     * @param num
     *            = number to be searched for
     * @return true if number is not found
     */
    private boolean inspectCol( int col, int num )
    {
        for ( int row = 0; row < 9; row++ )
            if ( sample[row][col] == num )
                return false;

        return true;
    }


    /**
     * Inspects column for a specified number
     * 
     * @param row
     *            = row checked
     * @param col
     *            = column checked
     * @param num
     *            = number to be searched for
     * @return true if number is not found
     */
    private boolean inspectBox( int row, int col, int num )
    {
        row = ( row / 3 ) * 3; // returns normalized row value
        col = ( col / 3 ) * 3; // returns normalized column value

        for ( int r = 0; r < 3; r++ )
            for ( int c = 0; c < 3; c++ )
                if ( sample[row + r][col + c] == num )
                    return false;

        return true;
    }


    /**
     * Starts applet
     */
    public void start()
    {
        ( new Thread( this ) ).start();
    }


    /**
     * Runs program
     */
    public void run()
    {
        try
        {
            Thread.sleep( 1000 );
            solve( 0, 0 );
        }
        catch ( Exception e )
        {
            System.out.println( "ERROR!" );
        }
    }


    /**
     * Recursively solves the board, starting at a board cell
     * 
     * @param row
     *            = row of cell
     * @param col
     *            = column of cell
     * @throws Exception
     *             thrown if error detected
     */
    public void solve( int row, int col ) throws Exception
    {
        if ( row > 8 )
            throw new Exception( "Solution Identified" );

        if ( sample[row][col] != 0 )
            goOn( row, col );
        else
        {
            for ( int num = 1; num < 10; num++ )
            {
                if ( inspectRow( row, num ) && inspectCol( col, num )
                    && inspectBox( row, col, num ) )
                {
                    sample[row][col] = num;
                    updategrid();

                    Thread.sleep( 1000 );
                    goOn( row, col );
                }
            }

            sample[row][col] = 0;
            updategrid();
        }
    }


    /**
     * Solves the next piece of the board
     * 
     * @param row
     *            = row of initial cell
     * @param col
     *            = column of initial cell
     * @throws Exception
     *             thrown if error detected
     */
    public void goOn( int row, int col ) throws Exception
    {
        if ( col < 8 )
            solve( row, col + 1 );
        else
            solve( row + 1, 0 );
    }
}
