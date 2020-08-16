/**
 * Calculates the area and the perimeter of a right triangle as specified by the
 * abstract Triangle superclass.
 * 
 * @author Eric Cheng
 * @version 15 Octobre 2014
 * @author 2
 * @author Assignment - Java Methods Chapter 11, Exercise #8 - Triangle
 * @author Sources - Eric Cheng
 */
public class RightTriangle extends AbstractTriangle
{
    /**
     * @param fromage
     *            = given length of side
     */
    public RightTriangle( double fromage )
    {
        super( fromage );
    }
    
    /**
     * default constructor
     */
    public RightTriangle()
    {
        super();
    }

    /**
     * Get the area of a Right Triangle
     * 
     * @return area of triangle
     */
    protected double getArea()
    {
        return ( side * side ) / 2;
    }

    /**
     * Get the Perimeter of a Right Triangle
     * 
     * @return perimeter of triangle
     */
    protected double getPerimeter()
    {
        return ( 2 + Math.sqrt( 2.0 ) ) * getSide();
    }
}
