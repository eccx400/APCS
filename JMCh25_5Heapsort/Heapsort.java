/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author Eric Cheng
 * @version 8 March 2015
 * @author Period - 2
 * @author Assignment - JMCh25_5Heapsort
 * @author Sources - Eric Cheng
 */
public class Heapsort
{
    // Sorts a[0], ..., a[size-1] in ascending order
    // using the Mergesort algorithm
    public static void sort( double[] a )
    {
        int length = a.length; 
        for (int i = length/2; i >= 1; i--)
        {
            reheapDown(a, i, length);            
        }
        
        for( int i = 0; i < a.length; i++)
        {
            System.out.println(a[i]);
        }
        System.out.println();
         
        while( length >= 2 )
        {
            double temp = a[0];
            a[0] = a[length-1];
            a[length-1] = temp;
             
            length--;
            reheapDown(a, 1, length);
        }
        
        for( int count = 0; count < a.length; count++)
        {
            System.out.println(a[count]);
        }
        System.out.println();
         
    }


    // Should be private - made public for testing
    public static void reheapDown( double[] a, int i, int n )
    {
        while ( ( 2 * i < n && a[i - 1] < a[2 * i] ) || ( 2 * i - 1 < n && a[i - 1] < a[2 * i - 1] ) )
        {
            if ( 2 * i >= n || a[2 * i - 1] > a[2 * i] )
            {
                double temp = a[2 * i - 1];
                a[2 * i - 1] = a[i - 1];
                a[i - 1] = temp;
                i = 2 * i - 1;
            }
            else
            {
                double temp = a[2 * i];
                a[2 * i] = a[i - 1];
                a[i - 1] = temp;
                i = 2 * i;
            }
        }
    }
}
