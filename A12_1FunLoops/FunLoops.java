/**
 * A class to solve various loop problems
 * 
 * @author Eric Cheng
 * @version 9/24/2014 Period - 2 Assignment - A12.1 - FunLoops
 * 
 *          Sources - Eric Cheng
 */
public class FunLoops
{
    /**
     * @param n
     *            = Input integer n number of magic squares
     */
    public void magicsquare( int n )
    {
        System.out.println( "Magic Squares" );

        long x = 1;
        long count = 0;
        long storeSum = 0;
        long storePlus = 0;

        while ( count < n )
        {

            long sq = x * x;
            long sum = storeSum;
            long plus = storePlus;
            while ( sum < sq )
            {
                plus += 1;
                sum = sum + plus;
            }

            if ( sum == sq )
            {
                count++;
                System.out.println( count + ": " + (long)sum );
            }
            sq = storeSum;
            plus = storePlus;
            x++;
        }
    }


    /**
     * There is a different method to solve the greatest common divisor, which
     * can be given the equation gcd(a,b) = (a*b)/lcm(a,b) By doing simple
     * algebra, you get lcm(a,b) = (a*b)/gcd(a,b) To solve for GCD, you find the
     * greater number of the two, and subtract the lower number from it to
     * ensure you have the least common denominator
     * 
     * @param a
     *            = given integer a
     * @param b
     *            = given integer b
     * @return = least common denominator
     */
    public int lcm( int a, int b )
    {
        int dummy1 = a;
        int dummy2 = b;

        while ( dummy1 != dummy2 )
        {
            if ( dummy1 > dummy2 )
            {
                dummy1 -= dummy2;
            }
            else
            {
                dummy2 -= dummy1;
            }
        }
        int gcd = dummy1;
        double least = ( (double)( a * b ) ) / gcd;
        return (int)least;
    }


    /**
     * @param args
     *            = afguments array
     */
    public static void main( String[] args )
    {
        FunLoops fun = new FunLoops();

        fun.magicsquare( 4 );
        System.out.println();

        System.out.println( "LCM (15, 18) = " + fun.lcm( 15, 18 ) );
        System.out.println( "LCM (40, 12) = " + fun.lcm( 40, 12 ) );
        System.out.println( "LCM (2, 7) = " + fun.lcm( 2, 7 ) );
        System.out.println( "LCM (100, 5) = " + fun.lcm( 100, 5 ) );
        System.out.println();

        fun.magicsquare( 10 );
    }
}
