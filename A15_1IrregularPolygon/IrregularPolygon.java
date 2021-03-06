import java.awt.Color;
import java.awt.geom.*;
import java.util.*;
import gpdraw.*;


/**
 * This draws the polygons and gives its area and perimeters
 * 
 * @author Eric Cheng
 * @version 4 Novembre 2014
 * 
 * @author Period - 2
 * @author Assignment - A15_1IrregularPolygon
 * 
 * @author Sources - Eric Cheng
 */
public class IrregularPolygon
{
    /**
     * For drawing the given polygon
     */
    private DrawingTool pen; // = new DrawingTool( new SketchPad( 300, 300, 0 ) );

    /**
     * Arraylist for the polygon
     */
    private ArrayList<Point2D.Double> myPolygon;


    // constuctors

    /**
     * Constructor for the array list
     */
    public IrregularPolygon()
    {
        myPolygon = new ArrayList<Point2D.Double>();
    }


    // public methods

    /**
     * Add method
     * 
     * @param aPoint
     */
    public void add( Point2D.Double aPoint )
    {
        myPolygon.add( aPoint );
    }


    /**
     * @return perimeter = perimeter of the given polygon
     */
    public double perimeter()
    {
        if ( myPolygon.isEmpty() )
        {
            return 0;
        }

        double perimeter = 0;
        int x = 0;
        for ( x = 0; x < myPolygon.size(); x++ )
        {
            Point2D.Double previous = (Point2D.Double)myPolygon.get( x );
            if ( x == myPolygon.size() - 1 )
            {
                perimeter += ( previous ).distance( (Point2D.Double)myPolygon.get( 0 ) );
            }
            else
            {
                perimeter += ( previous ).distance( (Point2D.Double)myPolygon.get( x + 1 ) );
            }
        }
        return perimeter;
    }


    /**
     * 
     * Get Area using Shoelace Formula: (0.5)(Math.abs(x1y2 + x2y3 + x3y1 - x2y1
     * - x3y2 - x1y3))
     * 
     * @return area = area of certain pentagon
     */
    public double area()
    {
        int x = 0;
        double area = 0;
        for ( x = 0; x < myPolygon.size(); x++ )
        {
            Point2D.Double fromage = (Point2D.Double)myPolygon.get( x );

            area += fromage.getX()
                * myPolygon.get( ( x + 1 ) % myPolygon.size() ).getY();

            area -= fromage.getY()
                * myPolygon.get( ( x + 1 ) % myPolygon.size() ).getX();
        }
        area = Math.abs( area ) / 2;
        return area;
    }


    /**
     * Draws out the given shape
     */
    public void draw()
    {
        if ( myPolygon.isEmpty() )
        {
            return;
        }
        
        // Start
        pen.up();
        Point2D.Double location = myPolygon.get( 0 );
        pen.move( location.getX(), location.getY() );
        pen.down();

        int x = 0;
        for ( x = 1; x < myPolygon.size(); x++ )
        {
            location = myPolygon.get( x );

            pen.move( location.getX(), location.getY() );
        }

        pen.move( location.getX(), location.getY() );
    }
}
