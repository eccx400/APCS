import java.util.Scanner;

/**
 * This is a class that tests the Cylinder class.
 *
 * @author Eric Cheng
 * @version 8/27/2014
 * @author Period: 2
 * @author Assignment: JMCh03Ex12_Cylinder
 * @author Sources: Eric Cheng
 */
public class CylinderTest
{
    /**
     * The main method in this class checks the Cylinder operations for
     * consistency.
     * 
     * @param args
     *            is not used.
     */
    public static void main( String[] args )
    {
        Scanner kb = new Scanner( System.in );

        System.out.print( "Enter the radius: " );
        double r = kb.nextDouble();
        System.out.print( "Enter the height: " );
        double h = kb.nextDouble();
        Circle circle = new Circle( r );
        double area = circle.getArea();
        double volume = area * h; // volume = area x height
        System.out.println( "radius = " + r + " height =" + h + " volume = "
            + volume );
    }
}