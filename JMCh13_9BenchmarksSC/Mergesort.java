/**
 * 
 * @author Eric Cheng
 * @version Nov 25, 2014
 * @author Period: 2
 * @author Assignment: JMCh13_9BenchmarksSC
 * 
 * @author Sources: Eric Cheng
 */
public class Mergesort extends StepCount
{
    /**
     * 
     */
    private double[] temp;


    /**
     * Sorts a[0], ..., a[size-1] in ascending order using the Mergesort
     * algorithm.
     * 
     * @param a
     *            = new array of doubles
     */
    public void sort( double[] a )
    {
        int n = a.length;
        temp = new double[n];
        recursiveSort( a, 0, n - 1 );
        addSteps( 1 ); // initialize outer = 0
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
        if ( to - from < 2 ) // Base case: 1 or 2 elements
        {
            addSteps( 3 );
            // 1 - boundary check of outer loop;
            // 2 - increment, outer++
            // 3 - initialization of inner loop
            if ( to > from && a[to] < a[from] )
            {
                double aTemp = a[to]; // swap a[to] and a[from]
                a[to] = a[from];
                a[from] = aTemp;
                addSteps( 3 );
                // 1 - boundary check of outer loop;
                // 2 - increment, outer++
                // 3 - initialization of inner loop
            }
        }
        else
        // Recursive case
        {
            int middle = ( from + to ) / 2;
            recursiveSort( a, from, middle );
            recursiveSort( a, middle + 1, to );
            merge( a, from, middle, to );
        }
    }


    /**
     * Merges a[from] ... a[middle] and a[middle+1] ... a[to] into one sorted
     * array a[from] ... a[to]
     * 
     * @param a
     *            = array of doubles
     * @param from
     *            = first element
     * @param middle
     *            = middle element
     * @param to
     *            = last element
     */
    private void merge( double[] a, int from, int middle, int to )
    {
        int i = from, j = middle + 1, k = from;
        addSteps(1);

        // While both arrays have elements left unprocessed:
        while ( i <= middle && j <= to )
        {
            if ( a[i] < a[j] )
            {
                temp[k] = a[i]; // Or simply temp[k] = a[i++];
                i++;
            }
            else
            {
                temp[k] = a[j];
                j++;
            }
            k++;
            addSteps( 2 ); // initialize outer = 0
        }
        addSteps( 15 ); // initialize outer = 0

        // Copy the tail of the first half, if any, into temp:
        while ( i <= middle )
        {
            temp[k] = a[i]; // Or simply temp[k++] = a[i++]
            i++;
            k++;
            addSteps( 15 ); // initialize outer = 0
        }

        // Copy the tail of the second half, if any, into temp:
        while ( j <= to )
        {
            temp[k] = a[j]; // Or simply temp[k++] = a[j++]
            j++;
            k++;
            addSteps( 15 ); // initialize outer = 0
        }

        // Copy temp back into a
        for ( k = from; k <= to; k++ )
        {
            a[k] = temp[k];
            addSteps( 3 );
            // 1 - boundary check of outer loop;
            // 2 - increment, outer++
            // 3 - initialization of inner loop
        }
    }
}
