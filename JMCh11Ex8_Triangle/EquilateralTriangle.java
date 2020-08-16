/**
 * Calculates the area and the perimeter of an equilateral triangle as specified
 * by the abstract Triangle superclass.
 * 
 * @author Eric Cheng
 * @version 15 Octobre 2014
 * @author 2
 * @author Assignment - Java Methods Chapter 11, Exercise #8 - Triangle
 * @author Sources - Eric Cheng
 */
public class EquilateralTriangle extends AbstractTriangle
{
    /**
     * @param side
     *            length
     */
    public EquilateralTriangle( double side )
    {
        super( side );
    }
    
    /**
     * default constructor
     */
    public EquilateralTriangle()
    {
        super();
    }

    /**
     * Get the area of Equilateral Triangle
     * 
     * @return area of triangle
     */
    protected double getArea( )
    {
        return Math.sqrt( 3 ) / 4 * getSide() * getSide();
    }

    /**
     * Get the perimeter of Equilateral Triangle
     * 
     * @return perimeter of triangle
     */
    protected double getPerimeter( )
    {
        return side * 3;
    }
}
