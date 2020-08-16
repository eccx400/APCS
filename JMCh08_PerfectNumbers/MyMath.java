/**
 * These are the programs to calculate different mathmatical methods using while
 * loops
 *
 * @author Eric Cheng
 * @version 26 Septembre 2014
 * @author Period: 2
 * @author Assignment: JMCh08_PerfectNumbers
 *
 * @author Sources: Eric Cheng
 */
public class MyMath
{
    /**
     * Returns true if n is a prime; otherwise returns false.
     * 
     * @param n
     *            number to check if prime
     * @return true if n is a prime; otherwise returns false
     */
    public static boolean isPrime( int n )
    {
        if ( n <= 1 )
        {
            return false;
        }

        int m = 2;

        while ( m * m <= n )
        {
            if ( n % m == 0 )
            {
                return false;
            }
            m++;
        }
        return true;
    }


    /**
     * Long version of isPrime Returns true if n is a prime; otherwise returns
     * false.
     * 
     * @param n
     *            number to check if prime, long
     * @return true if n is a prime; otherwise returns false
     */
    public static boolean isPrime( long n )
    {
        if ( n <= 1 )
        {
            return false;
        }

        long m = 2;

        while ( m * m <= n )
        {
            if ( n % m == 0 )
            {
                return false;
            }
            m++;
        }
        return true;
    }


    /**
     * Question 8-15 Returns the n-th Fibonacci number
     * 
     * Find and read a few informative websites dedicated to Fibonacci numbers.
     * The following recursive method returns the n-th Fibonacci number:
     * 
     * // Returns the n-th Fibonacci number. // Precondition: n >= 1 public
     * static long fibonacci(int n) { if (n == 1 || n == 2) return 1; else
     * return fibonacci(n - 1) + fibonacci(n - 2); } Rewrite it without
     * recursion, using one loop.
     *
     * @param n
     *            = Fibonacci number to find
     * @return fibonacci = n-th Fibonacci number
     */
    public static long fibonacci( int n )
    {
        int number = n;
        if ( number == 1 || number == 2 ) // Condition
        {
            return 1;
        }

        int vieux = 1;
        int nouveau = 1;
        int fibonacci = 1;
        for ( int i = 3; i <= number; i++ )
        {
            fibonacci = vieux + nouveau; // Find sum of previous 2 numbers
            vieux = nouveau; // Set new number to old
            nouveau = fibonacci; // Set next number to current

        }
        return fibonacci; // Fibonacci number
    }


    /**
     * Returns true if n is a perfect number, false otherwise.
     * 
     * @param n
     *            number to test
     * @return true if n is a perfect number, false otherwise.
     */
    public static boolean isPerfect( int n )
    {
        int sum = 0;
        for ( int i = 1; i <= ( n / 2 ); i++ )
        {
            if ( n % i == 0 )
            {
                sum += i;
            }
        }
        return sum == n;
    }


    /**
     * Prints the first n perfect numbers
     * 
     * @param n
     *            number of perfect numbers to print
     */
    public static void printPerfectNums( int n )
    {
        System.out.println( "Perfect numbers: " );
        int count = 0;
        for ( int k = 1; count < n; k++ )
        {
            if ( isPerfect( k ) )
            {
                System.out.print( k + " " );
                count++;
            }
        }
        System.out.println();
    }


    /**
     * Prints the first n Mersenne primes
     * 
     * @param n
     *            number of Mersenne primes to print
     */
    public static void printMersennePrimes( int n )
    {
        System.out.println( "Mersenne primes: " );

        int x = 1;
        int num = 0;
        while ( num < n )
        {
            if ( isPrime( Math.round( ( Math.pow( 2, x ) - 1 ) ) ) )
            {
                num++;
                System.out.print( (int)( Math.pow( 2, x ) - 1 ) + " " );
            }
            x++;
        }
        System.out.println();
    }


    /**
     * Prints the first n even perfect numbers
     * 
     * @param n
     *            = number of even Perfect Numbers to print
     */
    public static void printEvenPerfectNums( int n )
    {
        System.out.println( "Even perfect numbers: " );

        int count = 0;
        long x;
        for ( x = 1; count < n; x++ )
        {
            if ( isPrime( (long)Math.pow( 2, x ) - 1 ) )
            {
                System.out.print( (long)( Math.pow( 2, x ) - 1 )
                    * (long)( Math.pow( 2, x - 1 ) ) + " " );
                count++;
            }
        }
        System.out.println();
    }


    /*********************************************************************/

    /**
     * The main method for this class
     * 
     * @param args
     *            = arguments array
     */
    public static void main( String[] args )
    {
        int n = 19;
        System.out.println( n + "-th Fibonacci number = " + fibonacci( n ) );

        printPerfectNums( 4 );
        printMersennePrimes( 6 );
        printEvenPerfectNums( 6 );
    }
}

/*
 * 19-th Fibonacci number = 4181 Perfect numbers: 6 28 496 8128 Mersenne primes:
 * 3 7 31 127 8191 131071 524287 Even perfect numbers: 6 28 496 8128 33550336
 * 8589869056 137438691328
 */