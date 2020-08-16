/**
 * 
 * @author Eric Cheng
 * @version Nov 25, 2014
 * @author Period: 2
 * @author Assignment: JMCh13_9BenchmarksSC
 * 
 * @author Sources: Eric Cheng
 */
public class SelectionSort extends StepCount
{
    /**
     * Sorts a[0], ..., a[size-1] in ascending order using Selection Sort.
     * 
     * @param a
     *            = new array of doubles
     */
    public void sort( double[] a )
    {
        addSteps( 1 ); // initialize outer = 0
        for ( int n = a.length; n > 1; n-- )
        {
            addSteps( 3 );
            // 1 - boundary check of outer loop;
            // 2 - increment, outer++
            // 3 - initialization of inner loop
            // Find the index iMax of the largest element
            // among a[0], ..., a[n-1]:

            int iMax = 0;
            for ( int i = 1; i < n; i++ )
            {
                addSteps( 3 );
                // 1 - boundary check of outer loop;
                // 2 - increment, outer++
                // 3 - initialization of inner loop
                if ( a[i] > a[iMax] )
                {
                    addSteps( 3 ); // swap of list[inner] & list[inner + 1]
                    iMax = i;
                }
            }

            // Swap a[iMax] with a[n-1]:
            swap( a, iMax, n - 1 );

            // Decrement n (accomplished by n-- in the for loop).
        }
    }
}
