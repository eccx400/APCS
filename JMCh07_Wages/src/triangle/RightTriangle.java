package triangle;

/**
 * Calculates the area and the perimeter of a right triangle as specified by the
 * abstract Triangle superclass.
 * 
 * @author Maggie Luo
 * @version 10-15-13
 * @author TODO 4
 * @author Assignment - Java Methods Chapter 11, Exercise #6 - Triangle
 * @author Sources - TODO your sources
 */
public class RightTriangle extends AbstractTriangle
{

    /**
     * 
     * @param side
     *            side length
     */
    public RightTriangle( double side )
    {
        super( side );
    }


    /**
     * default constructor
     */
    public RightTriangle()
    {
        super();
    }


    /**
     * @return area of triangle
     */
    public double getArea()
    {
        return getSide() * getSide() / 2;
    }


    /**
     * @return perimeter of triangle
     */
    public double getPerimeter()
    {
        return ( 2 + Math.sqrt( 2.0 ) ) * getSide();
    }
}
