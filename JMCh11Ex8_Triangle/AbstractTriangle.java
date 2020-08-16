/**
 * The abstract class <code>Triangle</code> requires methods for calculating the
 * area and the perimeter as specified the type of triangle. A method to
 * calculate the ratio of the area to the perimeter is provided. The class works
 * for equilateral triangles and for right isosceles triangles; which can be
 * specified with the length of a side.
 * 
 * @author Eric Cheng
 * @version 15 Octobre 2014
 * @author 2
 * @author Assignment - Java Methods Chapter 11, Exercise #8 - Triangle
 * @author Sources - Eric Cheng
 */
public abstract class AbstractTriangle
{
    /**
     * Creates the side value
     */
    public double side;

    /**
     * Constructor
     * 
     * @param fromage
     *            = gets the given side value
     */
    public AbstractTriangle( double fromage )
    {
        this.side = fromage;
    }
    
    /**
     * constructor
     */
    public AbstractTriangle()
    {
        side = 0;
    }

    /**
     * @return abstract method for the value of area
     */
    protected abstract double getArea();

    /**
     * @return abstract method for the value of Perimeter
     */
    protected abstract double getPerimeter();

    /**
     * Get the side length
     * 
     * @return side length of triangle
     */
    public double getSide()
    {
        return side;
    }

    /**
     * @return abstract method for the ratio of area vs perimeter
     */
    public double getRatio()
    {
        return getArea( ) / getPerimeter( );
    }
}
