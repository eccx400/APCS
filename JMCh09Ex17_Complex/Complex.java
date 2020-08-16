/**
 * Represents a complex number of the form a + bi. Provides methods for adding,
 * multiplying and calculating the absolute value.
 * 
 * @author Eric Cheng
 * @version 30 Septembre 2014
 * @author Period: 2
 * @author Assignment: JMCh09Ex17_Complex
 * 
 * @author Sources: Eric Cheng
 */
public class Complex
{
    private double real = 0;
    private double imaginary = 0;

    /**
     * Constructors
     * 
     * @param a = real num
     * @param b = imaginary num
     */
    Complex( double a, double b )
    {
        real = a;
        imaginary = b;
    }

    /**
     * Constructor
     * 
     * @param a = number
     */
    Complex( double a )
    {
        real = a;
    }

    /**
     * @return absolute value of complex num
     */
    public double abs()
    {
        double retourner = Math.sqrt( ( real * real )
            + ( imaginary * imaginary ) );
        return retourner;
    }

    /**
     * Adds two complex objects
     * 
     * @param other = Complex object
     * @return sum (complex object)
     */
    public Complex add( Complex other )
    {
        double nouveauReal = real + other.real;
        double nouveauImaginary = imaginary + other.imaginary;
        return new Complex( nouveauReal, nouveauImaginary );
    }

    /**
     * Use of double instead of object
     * 
     * @param cheezburger = number!
     * @return = sum of complex nums
     */
    public Complex add(double cheezburger )
    {
        return new Complex( real + cheezburger, imaginary ) ;
    }
    
    /**
     * @param other = Complex object
     * @return = product of complex object
     */
    public Complex multiply( Complex other )
    {
        double nouveauReal = real * other.real - imaginary * other.imaginary;
        double nouveauImaginary = real * other.imaginary + imaginary * other.real;
        return new Complex( nouveauReal, nouveauImaginary );
    }

    /**
     * Duplicate that uses doubles
     * 
     * @param cheezburger = number!
     * @return = product of complex nums
     */
    public Complex multiply( double cheezburger )
    {
        double nouveauReal = real * cheezburger;
        double nouveauImaginary = imaginary * cheezburger;
        return new Complex( nouveauReal, nouveauImaginary );
    }

    /**
     * Convert complex nums to string
     * 
     * @return Complex nums in string form
     */
    public String toString()
    {
        return real + " + " + imaginary + "i";
    }
}
