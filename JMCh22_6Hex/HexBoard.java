/**
 * A human observer can glance at a Hex board and immediately tell whether one
 * of the players has won. Not so in a computer program: it takes some
 * computations to find out whether there is a chain of stones of a particular
 * color connecting two opposite sides of the board. Our task is to develop an
 * algorithm and write a method that does this.
 * 
 * @author Eric Cheng
 * @version 22 January 2015
 * @author Period - 2
 * @author Assignment - JM Ch22.6 - Hex
 * @author Sources - Eric Cheng
 */
public class HexBoard extends CharMatrix
{
    public HexBoard( int rows, int cols )
    {
        super( rows, cols );
    }


    public boolean isBlack( int r, int c )
    {
        return charAt( r, c ) == 'b';
    }


    public boolean isWhite( int r, int c )
    {
        return charAt( r, c ) == 'w';
    }


    public boolean isGray( int r, int c )
    {
        return charAt( r, c ) == 'x';
    }


    public void setBlack( int r, int c )
    {
        setCharAt( r, c, 'b' );
    }


    public void setWhite( int r, int c )
    {
        setCharAt( r, c, 'w' );
    }


    public void setGray( int r, int c )
    {
        setCharAt( r, c, 'x' );
    }


    /**
     * Returns true if there is a contiguous chain of black stones that starts
     * in col 0 and ends in the last column of the board; otherwise returns
     * false.
     */
    public boolean blackHasWon()
    {
        for ( int r = 0; r < numRows(); r++ )
        {
            areaFill( r, 0 );
        }

        int z = 0;
        for ( int r = 0; r < numRows(); r++ )
        {
            if ( isGray( r, numCols() - 1 ) )
            {
                z++;
            }
        }

        for ( int r = 0; r < numRows(); r++ )
        {
            for ( int c = 0; c < numCols(); c++ )
            {
                if ( isGray( r, c ) )
                {
                    setBlack( r, c );
                }
            }
        }
        
        if (z == 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }


    /**
     * Fills the contiguous area that contains r,c with gray color. Does nothing
     * if r, c is out of bounds or is not black.
     */
    public void areaFill( int r, int c )
    {
        if ( isInBounds( r, c ) && isBlack( r, c ) )
        {
            setGray( r, c );

            areaFill( r, c - 1 );

            areaFill( r, c + 1 );

            areaFill( r - 1, c - 1 );

            areaFill( r - 1, c );

            areaFill( r + 1, c );

            areaFill( r + 1, c + 1 );

        }
    }


    /**
     * toString method
     */
    public String toString()
    {
        String s = "";

        for ( int r = 0; r < numRows(); r++ )
        {
            for ( int c = 0; c < numCols(); c++ )
            {
                if ( isBlack( r, c ) )
                    s += 'B';
                else if ( isWhite( r, c ) )
                    s += 'W';
                else if ( isGray( r, c ) )
                    s += 'X';
                else
                    s += '.';
            }
            s += '\n';
        }
        return s;
    }


    // ****************************************************************

    private boolean isInBounds( int row, int col )
    {
        return row < numRows() && col < numCols() && row >= 0 && col >= 0;
    }
}
