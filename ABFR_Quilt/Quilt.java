import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/**
 * A patchwork quilt can be made by sewing together many blocks, all of the same
 * size. Each individual block is made up of a number of small squares cut from
 * fabric. A block can be represented as a two-dimensional array of nonblank
 * characters, each of which stands for one small square of fabric. The entire
 * quilt can also be represented as a two-dimensional array of completed blocks.
 * The example below shows an array that represents a quilt made of 9 blocks (in
 * 3 rows and 3 columns). Each block contains 20 small squares (of 4 rows by 5
 * columns). The quilt uses 2 different fabric squares, represented by the
 * characters 'x' and '.'.
 * 
 * @author Eric Cheng
 * @version:20 April 2015
 * @author Period: 2
 * @author Assignment: AB Free Response Quilt
 * 
 * @author Sources: Eric Cheng
 */
public class Quilt
{
    char[][] myBlock; // stores pattern for one block

    int myRowsOfBlocks; // number of rows of blocks in the quilt

    int myColsOfBlocks; // number of columns of blocks in the quilt


    /**
     * Precondition: quiltBlock refers to an initialized quilt block,
     * rowsOfBlocks > 0, colsOfBlocks > 0 postcondition: myRowsOfBlocks and
     * myColsOfBlocks are initialized to the number of rows and columns of
     * blocks that make up the quilt; myBlock has been initialized to the block
     * pattern of quiltBlock.
     * 
     * @param quiltBlock
     * @param rowsOfBlocks
     * @param colsOfBlocks
     */
    public Quilt( char[][] quiltBlock, int rowsOfBlocks, int colsOfBlocks )
    {
        myBlock = quiltBlock;
        myRowsOfBlocks = rowsOfBlocks;
        myColsOfBlocks = colsOfBlocks;
    }


    /**
     * precondition: startRow >= 0; startCol >= 0; startRow + myBlock.numrows()
     * <= qmat.numrows(); startCol + myBlock.numcols() <= qmat.numcols();
     * postcondition: myBlock has been copied into the matrix qmat with its
     * upper-left corner at the position startRow, startCol
     * 
     * @param startRow
     * @param startCol
     * @param qmat
     */
    public void placeBlock( int startRow, int startCol, char[][] qmat )
    {
        for ( int r = 0; r < myBlock.length; r++ )
        {
            for ( int c = 0; c < myBlock[r].length; c++ )
            {
                qmat[startRow + r][startCol + c] = myBlock[r][c];
            }
        }
    }


    // precondition: startRow >= 0; startCol >= 0;
    // startRow + myBlock.length <= qmat.length;
    // startCol + myBlock[0].length <= qmat[0].length;
    // postcondition: a flipped version of myBlock has been copied into the
    // matrix qmat with its upper-left corner at the position
    // startRow, startCol
    public void placeFlipped( int startRow, int startCol, char[][] qmat )
    {
        for ( int r = 0; r < myBlock.length; r++ )
        {
            for ( int c = 0; c < myBlock[r].length; c++ )
            {
                qmat[startRow + r][startCol + c] = myBlock[myBlock.length - r
                    - 1][c];
            }
        }
    }


    public char[][] quiltToMat() // checkerboard alternation
    {
        char[][] quilt = new char[myRowsOfBlocks * myBlock.length][myBlock[0].length
            * myColsOfBlocks];
        for ( int r = 0; r < quilt.length; r += myBlock.length )
        {
            for ( int c = 0; c < quilt[r].length; c += myBlock[0].length )
            {
                if ( ( ( r + c ) / ( myBlock.length ) ) % 2 != 0 )
                {
                    placeFlipped( r, c, quilt );
                }
                else
                {
                    placeBlock( r, c, quilt );
                }
            }
        }
        return quilt;
    }


    /*
     * Intended only for testing.
     */
    public char[][] getMyBlock()
    {
        return myBlock;
    }


    public int getMyRowsOfBlocks()
    {
        return myRowsOfBlocks;
    }


    public int getMyColsOfBlocks()
    {
        return myColsOfBlocks;
    }


    /**
     * Test Quilt class.
     * 
     * @param args
     *            command-line parameters (not used)
     */
    public static void main( String[] args )
    {
        char[][] qBlock = { { 'x', '.', '.', '.', 'x' },
            { '.', 'x', '.', 'x', '.' }, { '.', '.', 'x', '.', '.' },
            { '.', '.', 'x', '.', '.' } };

        Quilt q = new Quilt( qBlock, 3, 3 );

        char[][] quilt = q.quiltToMat();

        for ( char r[] : quilt )
        {
            for ( char ch : r )
            {
                System.out.print( ch );
            }
            System.out.println();
        }

    }
}
