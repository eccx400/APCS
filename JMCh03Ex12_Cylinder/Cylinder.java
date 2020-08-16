/**
 * This is a program that calculates the value of a cylinder Using the
 * circle.java class as a guide, and the knowledge that the volume of a cylinder
 * = the area of base * h, you can find the volume of the cylinder.
 *
 * @author Eric Cheng
 * @version 8/27/2014
 * @author Period: 2
 * @author Assignment: JMCh03Ex12_Cylinder
 * @author Sources: Eric Cheng
 */
public class Cylinder
{
    // implement data fields
    /**
     * Initiate radius and height
     */
    private double radius;
    private double height;

    // implement constructor
    /**
     * @param r
     *            = double radius
     * @param h
     *            = double height
     */
    public Cylinder( double r, double h )
    {
        radius = r;
        height = h;
    }

    /**
     * @return height of cylinder
     */
    public double getHeight()
    {
        return height;
    }

    // implement methods
    /**
     * @return the volume of cylinder
     */
    public double getVolume()
    {
        return Math.PI * radius * radius * height;
    }
}
