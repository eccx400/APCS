import java.util.Iterator;


/**
 * Implements a singly-linked list.
 * 
 * @author Eric Cheng
 * @version 7 December 2014
 * @author Period - 2
 * @author Assignment - JMCh20_4 Lists
 * @author Sources - Maria & Gary Litvin
 */
public class SinglyLinkedList<E> implements Iterable<E>
{
    private ListNode<E> head;

    private int nodeCount;


    // Constructor: creates an empty list
    public SinglyLinkedList()
    {
        head = null;
        nodeCount = 0;
    }


    /**
     * Constructor: creates a list that contains all elements from the array
     * values, in the same order
     * 
     * @param values
     *            array containing all elements for this list
     */
    public SinglyLinkedList( E[] values )
    {
        ListNode<E> tail = null;
        for ( E value : values ) // for each value to insert
        {
            ListNode<E> node = new ListNode<E>( value, null );
            if ( head == null )
                head = node;
            else
                tail.setNext( node );
            tail = node; // update tail
        }

        nodeCount = values.length;
    }


    /**
     * Return true if this list is empty; otherwise returns false.
     * 
     * @return true if this list is empty; otherwise returns false.
     */
    public boolean isEmpty()
    {
        if ( nodeCount == 0 && head == null )
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    /**
     * Returns the number of elements in this list.
     * 
     * @return number of elements in this list.
     */
    public int size()
    {
        return nodeCount;
    }


    /**
     * Returns true if this list contains an Object equal to obj; otherwise
     * returns false.
     * 
     * @return true if this list contains an Object equal to obj
     */
    public boolean contains( Object obj )
    {
        ListNode<E> node;
        for ( node = head; node != null; node = node.getNext() )
        {
            if ( node.getValue().equals( obj ) )
            {
                return true;
            }
        }
        return false;
    }


    /**
     * Returns the index of the first Object equal to obj; if not found, returns
     * -1.
     * 
     * @param obj
     *            Object to find
     * @return the index of the first Object in equal to obj; if not found,
     *         returns -1.
     */
    public int indexOf( Object obj )
    {
        int count = 0;
        for ( ListNode<E> node = head; node != null; node = node.getNext() )
        {
            if ( node.getValue().equals( obj ) )
            {
                return count;
            }
            count++;
        }
        return -1;
    }


    /**
     * Adds obj to this collection. Returns true if successful; otherwise
     * returns false.
     * 
     * @param obj
     *            element to add to this collection
     * @return true if successful; otherwise returns false.
     */
    public boolean add( E obj )
    {
        ListNode<E> reNode = new ListNode<E>( obj, null );

        if ( head == null )
        {
            nodeCount++;
            head = reNode;
            return true;
        }

        for ( ListNode<E> end = head; end != null; end = end.getNext() )
        {
            if ( end.getNext() == null )
            {
                nodeCount++;
                end.setNext( reNode );
                return true;
            }
        }
        return false;
    }


    /**
     * Removes the first element that is equal to obj, if any. Returns true if
     * successful; otherwise returns false.
     * 
     * @param obj
     *            element to remove
     * @return true if successful; otherwise returns false.
     */
    public boolean remove( E obj )
    {
        ListNode<E> last = head;
        for ( ListNode<E> node = head; node != null; node = node.getNext() )
        {
            if ( node.getValue().equals( obj ) )
            {
                nodeCount--;
                last.setNext( node.getNext() );
                return true;
            }
            last = node;
        }
        return false;
    }


    /**
     * Returns the i-th element.
     * 
     * @param i
     *            element to get from the list
     * @return element at index i
     * @throws IndexOutOfBoundsException
     */
    public E get( int i )
    {
        if ( i <= 0 || i >= nodeCount )
        {
            throw new IndexOutOfBoundsException();
        }

        ListNode<E> node = head;

        int x = 0;
        while ( x < i )
        {
            node = node.getNext();
            x++;
        }

        return node.getValue();
    }


    /**
     * Replaces the i-th element with obj and returns the old value.
     * 
     * @param i
     *            index of element to replace
     * @param obj
     *            replacement element of element at index i
     * @return old value previously located at index i
     * @throws IndexOutOfBoundsException
     */
    public E set( int i, E obj )
    {
        if ( i <= 0 || i >= nodeCount )
        {
            throw new IndexOutOfBoundsException();
        }
         
        ListNode<E> node = head;
         
        int x = 0;
        while( x < i )
        {
            node = node.getNext();
            x++;
        }
         
        E old = node.getValue();
        node.setValue( obj );
        return old;
    }


    /**
     * Inserts obj to become the i-th element. Increments the size of the list
     * by one.
     * 
     * @param i
     *            insertion point in list for obj
     * @param obj
     *            element to insert into list
     * @throws IndexOutOfBoundsException
     */
    public void add( int i, E obj )
    {
        if ( i < 0 || i > nodeCount )
        {
            throw new IndexOutOfBoundsException();
        }

        if ( i == 0 )
        {
            ListNode<E> newHead = new ListNode<E>( obj, head );
            nodeCount++;
            head = newHead;
        }
        else
        {
            ListNode<E> tempNode = new ListNode<E>( obj, null );
            ListNode<E> node = head;
            ListNode<E> lastnode = node;

            int j = 0;
            while ( j < i )
            {
                lastnode = node;
                node = node.getNext();
                j++;
            }

            tempNode.setNext( node );
            lastnode.setNext( tempNode );
            nodeCount++;
        }

    }


    /**
     * Removes the i-th element and returns its value. Decrements the size of
     * the list by one.
     * 
     * @param i
     *            index of element to remove
     * @return element removed from this list
     */
    @SuppressWarnings("unchecked")
    public E remove( int i )
    {
        ListNode<E> tempNode = head;

        if ( nodeCount == 0 || i >= nodeCount || i < 0 )
        {
            throw new IndexOutOfBoundsException();
        }

        ListNode<E> apres = head.getNext();
        int count = 1;
        if ( i == 0 )
        {
            Object getObj = tempNode.getValue();
            if ( apres.getValue() != null )
            {
                ListNode<E> apresA = head.getNext().getNext();
                head = new ListNode<E>( apres.getValue(), apresA );
            }
            else
            {
                head = null;
            }
            nodeCount--;
            return (E)getObj;
        }

        count = 1;
        while ( count <= i )
        {
            if ( count == i )
            {
                Object obj = apres.getValue();
                tempNode = tempNode.getNext().getNext();
                if ( tempNode == null )
                {
                    apres.setValue( null );
                    nodeCount--;
                    return (E)obj;
                }
                else
                {
                    head = new ListNode<E>( tempNode.getValue(),
                        (ListNode<E>)apres.getNext().getValue() );
                    nodeCount--;
                    return (E)obj;
                }
            }

            tempNode = tempNode.getNext();
            apres = apres.getNext();
            count++;
        }
        return null;
    }


    /**
     * Returns a string representation of this list.
     * 
     * @return a string representation of this list.
     */
    public String toString()
    {
        ListNode<E> last = head;
        String str = "";

        if ( nodeCount == 0 )
        {
            return "";
        }

        int count = 0;
        while ( count < nodeCount )
        {
            if ( last == null )
            {
                return str;
            }

            if ( last.getValue() != null )
            {
                str += last.getValue().toString();
            }
            last = last.getNext();
            count++;
        }
        return str;
    }


    /**
     * Returns an iterator for this collection.
     * 
     * @return an iterator for this collection.
     */
    public Iterator<E> iterator()
    {
        return new SinglyLinkedListIterator<E>( head );
    }
}
