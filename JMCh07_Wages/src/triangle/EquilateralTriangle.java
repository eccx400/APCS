package triangle;

/**
 * Calculates the area and the perimeter of an equilateral triangle as specified
 * by the abstract Triangle superclass.
 * 
 * @author TODO Maggie Luo
 * @version TODO 10-15-13
 * @author TODO 4
 * @author Assignment - Java Methods Chapter 11, Exercise #6 - Triangle
 * @author Sources - TODO your sources
 */
public class EquilateralTriangle extends AbstractTriangle
{

    /**
     * constructor
     * 
     * @param side
     *            side length
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
     * 
     * @return calculates area of triangle
     */
    public double getArea()
    {
        return Math.sqrt( 3 ) / 4 * getSide() * getSide();
    }


    /**
     * @return calculates perimeter
     */
    public double getPerimeter()
    {
        return 3 * getSide();
    }

}
