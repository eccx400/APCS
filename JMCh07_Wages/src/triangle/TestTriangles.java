package triangle;
/**
 * Triangle test class
 * 
 * @author TODO Maggie Luo
 * @version TODO 10-15-13
 * @author TODO 4
 * @author Assignment - Java Methods Chapter 11, Exercise #6 - Triangle
 * @author Sources - TODO your sources
 */
public class TestTriangles
{
    /**
     * Test method for the Triangle class
     * 
     * @param args
     *            command line arguments - not used
     */
    public static void main( String[] args )
    {
        EquilateralTriangle e = new EquilateralTriangle( 5 );
        RightTriangle r = new RightTriangle( 5 );

        if ( e.getRatio() > r.getRatio() )
        {
            System.out.println( "equilateral triangle holds a bigger circle" );
        }
        else
        {
            System.out.println( "right triangle can hold a bigger circle" );
        }
    }
}
/*
 * Your output here
 */
