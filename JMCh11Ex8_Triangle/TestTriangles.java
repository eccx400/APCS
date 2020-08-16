/**
    Triangle test class

    @author  Eric Cheng
    @version 15 Octobre 2014
    
    @author  2
    @author  Assignment - Java Methods Chapter 11, Exercise #8 - Triangle
    
    @author  Sources - Eric Cheng
 */
public abstract class TestTriangles extends AbstractTriangle
{
    /**
        Test method for the Triangle class
    
        @param args command line arguments - not used
     */
    public static void main(String[] args)
    {
        double side = 10.0;
        AbstractTriangle equilateral = new EquilateralTriangle( side );
        AbstractTriangle right = new RightTriangle( side );

        double equilateralRatio = equilateral.getRatio();
        double rightRatio = right.getRatio();

        System.out.println( "EquilateralTriangle( " +
            equilateral.getSide() + " ): " +
            "getRatio() = " + equilateralRatio );

        System.out.println( "RightTriangle( " +
            right.getSide() + " ): "
            + "getRatio() = " + rightRatio );

        String bigger = "right isosceles";
        String smaller = "equilateral";

        if ( equilateral.getRatio() > right.getRatio() )
        {
            System.out.println();
            System.out.print( "The " + bigger + " triangle " );
            System.out.println( "holds a larger inscribed circle " );
            System.out.println( "than the " + smaller + " triangle." );
        }
        else
        {
            System.out.println();
            System.out.print( "The " + bigger + " triangle " );
            System.out.println( "holds a larger inscribed circle " );
            System.out.println( "than the " + smaller + " triangle." );
        }
    }
}
/*
  Your output here
 */
