import java.util.*;


/**
 * Implements a priority queue based on a min-heap.
 * 
 * @author Eric Cheng
 * @version 4 March 2015
 * @author Period - 2
 * @author Assignment - JMCh25_4HeapPriorityQueue
 * @author Sources - Eric Cheng
 */
public class HeapPriorityQueue
{
    private static final int DFLT_CAPACITY = 101;

    private Object[] items;

    private int numItems;

    private final Comparator<Object> comparator;


    public HeapPriorityQueue()
    {
        this( DFLT_CAPACITY, null );
    }


    public HeapPriorityQueue( Comparator<Object> c )
    {
        this( DFLT_CAPACITY, c );
    }


    public HeapPriorityQueue( int initialCapacity )
    {
        this( initialCapacity, null );
    }


    public HeapPriorityQueue( int initialCapacity, Comparator<Object> c )
    {
        items = new Object[initialCapacity + 1];
        comparator = c;
    }


    /**
     * Returns true if this priority queue is empty; otherwise returns false.
     */
    public boolean isEmpty()
    {
        return numItems == 0;
    }


    /**
     * Returns the highest priority element without removing it from this
     * priority queue.
     */
    public Object peek()
    {
        if ( numItems == 0 )
        {
            throw new NoSuchElementException();
        }
        return items[1];
    }


    /**
     * Adds obj to this priority queue; returns true.
     */
    public boolean add( Object obj )
    {
        numItems++;
        if ( numItems >= items.length ) // items[0] is not used
            growCapacity();
        items[numItems] = obj;
        reheapUp();
        return true;
    }


    /**
     * Removes and returns the highest priority item.
     */
    public Object remove()
    {
        if ( numItems == 0 )
        {
            throw new NoSuchElementException();
        }

        Object minObject = items[1];
        items[1] = items[numItems];
        numItems--;
        reheapDown();
        return minObject;
    }


    // **************************************************************************

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private boolean lessThan( Object obj1, Object obj2 )
    {
        if ( comparator != null )
            return comparator.compare( obj1, obj2 ) < 0;
        else
            return ( (Comparable)obj1 ).compareTo( obj2 ) < 0;
    }


    public void reheapDown()
    {

        int counter = 1;
        while ( ( items[counter * 2 + 1] != null || items[counter * 2] != null )
            && ( lessThan( items[counter * 2], items[counter] ) && lessThan( items[counter * 2 + 1],
                items[counter] ) ) )
        {
            Object temp = items[counter];
            if ( lessThan( items[counter * 2], items[counter * 2 + 1] ) )
            {
                items[counter] = items[counter * 2];
                items[counter * 2] = temp;
                counter = counter * 2;
            }
            else
            {
                items[counter] = items[counter * 2 + 1];
                items[counter * 2 + 1] = temp;
                counter = counter * 2 + 1;
            }
        }
    }


    public void reheapUp()
    {
        int num = numItems;
        while ( items[num / 2] != null && lessThan( items[num], items[num / 2] ) )
        {
            Object temp = items[num / 2];
            items[num / 2] = items[num];
            items[num] = temp;
            num = num / 2;
        }
    }


    private void growCapacity()
    {
        Object[] tempItems = new Object[2 * items.length - 1];
        System.arraycopy( items, 0, tempItems, 0, items.length );
        items = tempItems;
    }


    /**
     * returns the String containing all the elements in level order
     * 
     * @return the String containing all the elements in level order
     */
    public String toString()
    {
        String str = "";
        for ( int x = 1; x <= numItems; x++ )
        {
            str = str + items[x].toString() + "\n";
        }
        return str;
    }
}
