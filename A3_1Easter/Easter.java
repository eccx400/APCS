import java.lang.reflect.*;
import java.util.Scanner;

/**
 * @author Eric Cheng
 * @version 9/3/2014
 * @author Period: 2
 * @author Assignment: A3_1Easter
 * 
 * @author Sources: Eric Cheng
 */
public class Easter
{
    private int y;
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int k;
    private int r;
    private int m;
    private int n;
    private int p;

    /**
     * Set y = User inputted year
     * 
     * @param year
     *            = given year
     */
    public Easter( int year )
    {
        y = year;
    }

    /**
     * This is the process to find Easter day on a given year. The value n gives
     * the month and the value of p + 1 gives the day of the month.
     * 
     * Let y be the year (such as 1583 or 2003). Divide y by 19 and call the
     * remainder a. Ignore the quotient. Divide y by 100 and get a quotient b
     * and a remainder c. Divide b by 4 and get a quotient d and a remainder e.
     * Divide b + 8 by 25 and get a quotient f. Ignore the remainder. Divide b -
     * f + 1 by 3 and get a quotient g. Ignore the remainder. Divide 19 * a + b
     * - d - g + 15 by 30 and get a remainder h. Ignore the quotient. Divide c
     * by 4 and get a quotient i and a remainder k. Divide 32 + 2 * e + 2 * i -
     * h - k by 7 and get a remainder r. Ignore the quotient. Divide a + 11 * h
     * + 22 * r by 451 and get a quotient m. Ignore the remainder. Divide h + r
     * - 7 * m + 114 by 31 and get a quotient n and a remainder p.
     * 
     */
    public void calculate()
    {
        a = y % 19;
        System.out.println( "a = " + a ); // Get Remainder a
        b = y / 100;
        System.out.println( "b = " + b ); // Get Quotient b
        c = y % 100;
        System.out.println( "c = " + c ); // Get Remainder c
        d = b / 4;
        System.out.println( "d = " + d ); // Get Quotient d
        e = b % 4;
        System.out.println( "e = " + e ); // Get Remainder e
        f = ( b + 8 ) / 25;
        System.out.println( "f = " + f ); // Get Quotient f
        g = ( b - f + 1 ) / 3;
        System.out.println( "g = " + g ); // Get Quotient g
        h = ( 19 * a + b - d - g + 15 ) % 30;
        System.out.println( "h = " + h ); // Get Remainder h
        i = c / 4;
        System.out.println( "i = " + i ); // Get Quotient i
        k = c % 4;
        System.out.println( "k = " + k ); // Get Remainder k
        r = ( 32 + 2 * e + 2 * i - h - k ) % 7;
        System.out.println( "r = " + r ); // Get Remainder r
        m = ( a + 11 * h + 22 * r ) / 451;
        System.out.println( "m = " + m ); // Get Quotient m
        n = ( h + r - 7 * m + 114 ) / 31;
        System.out.println( "n = " + n ); // Get Quotient n
        p = ( h + r - 7 * m + 114 ) % 31;
        System.out.println( "p = " + p ); // Get Remainder p
    }


    /**
     * Intended only for debugging.
     * 
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Easter.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields )
        {
            try
            {
                str += separator + field.getType().getName() + " "
                    + field.getName() + ":" + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }
            separator = ", ";
        }
        return str + "]";
    }


    /**
     * @param args
     *            = arguments array
     */
    public static void main( String[] args )
    {
        Scanner console = new Scanner( System.in );

        System.out.print( "Please enter the year (yyyy) --> " );
        int year = console.nextInt();

        Easter bunny = new Easter( year );
        bunny.calculate();
    }
}
