package triangle;

/**
 * The abstract class <code>Triangle</code> requires methods for calculating the
 * area and the perimeter as specified the type of triangle. A method to
 * calculate the ratio of the area to the perimeter is provided. The class works
 * for equilateral triangles and for right isosceles triangles; which can be
 * specified with the length of a side.
 * 
 * @author Maggie Luo
 * @version 10-15-13
 * @author Assignment - Java Methods Chapter 11, Exercise #6 - Triangle
 * @author Sources - TODO your sources
 */
public abstract class AbstractTriangle
{
    private double side;


    /**
     * constructor
     * 
     * @param side
     *            side length
     */
    public AbstractTriangle( double side )
    {
        this.side = side;
    }


    /**
     * constructor
     */
    public AbstractTriangle()
    {
        side = 0;
    }


    /**
     * 
     * @return the side length
     */
    public double getSide()
    {
        return side;
    }


    /**
     * 
     * @return the area of the triangle
     */
    public abstract double getArea();


    /**
     * 
     * @return the perimeter of the area
     */
    public abstract double getPerimeter();


    /**
     * 
     * @return ratio of area to perimeter
     */
    public double getRatio()
    {
        return getArea() / getPerimeter();
    }
}
