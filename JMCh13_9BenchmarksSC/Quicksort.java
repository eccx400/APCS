/**
 * 
 * @author Eric Cheng
 * @version Nov 25, 2014
 * @author Period: 2
 * @author Assignment: JMCh13_9BenchmarksSC
 * 
 * @author Sources: Eric Cheng
 */
public class Quicksort extends StepCount
{
    /**
     * Sorts a[0], ..., a[size-1] in ascending order using the Quicksort
     * algorithm.
     * 
     * @param a
     *            = array of doubles
     */
    public void sort( double[] a )
    {
        addSteps( 1 ); // initialize outer = 0
        recursiveSort( a, 0, a.length - 1 );
    }


    /**
     * Recursive helper method: sorts a[from], ..., a[to]
     * 
     * @param a
     *            = new array doubles
     * @param from
     *            = first element
     * @param to
     *            = last element
     */
    private void recursiveSort( double[] a, int from, int to )
    {
        if ( from >= to )
            return;
        addSteps( 1 ); // initialize outer = 0

        // Choose pivot a[p]:
        int p = ( from + to ) / 2;
        // The choice of the pivot location may vary:
        // you can also use p = from or p = to or use
        // a fancier method, say, the median of the above three.

        // Partition:

        int i = from;
        int j = to;
        while ( i <= j )
        {
            if ( a[i] <= a[p] )
            {
                i++;
            }
            else if ( a[j] >= a[p] )
            {
                j--;
            }
            else
            {
                swap( a, i, j );
                i++;
                j--;
            }
            addSteps( 4 ); // initialize outer = 0
        }

        // Finish partitioning:

        if ( p < j ) // place the pivot in its correct position
        {
            swap( a, j, p );
            p = j;
        }
        else if ( p > i )
        {
            swap( a, i, p );
            p = i;
        }
        addSteps( 1 ); // initialize outer = 0

        // Sort recursively:
        recursiveSort( a, from, p - 1 );
        recursiveSort( a, p + 1, to );
    }
}
