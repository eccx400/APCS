// Implements the list of messages for teletext

import java.awt.Graphics;


public class TeletextList
{
    private ListNode2<String> heading, topNode;


    /**
     * Creates a circular list of headlines. First creates a circular list with
     * one node, "Today's headlines:". Saves a reference to that node in
     * heading. Adds a node holding an empty string before heading and another
     * node holding an empty string after heading. Appends all the strings from
     * headlines to the list, after the blank line that follows heading,
     * preserving their order. Sets topNode equal to heading.
     * 
     * @param headlines
     *            Strings to add to circular list
     */
    public TeletextList( String[] headlines )
    {
        ListNode2<String> last = new ListNode2<String>( "", null, null );
        ListNode2<String> next = new ListNode2<String>( "", null, last );

        heading = new ListNode2<String>( "Today's headlines:", last, next );
        topNode = heading;
        last.setPrevious( next );
        last.setNext( heading );
        next.setPrevious( heading );

        int x = 0;
        while ( x < headlines.length)
        {
            ListNode2<String> node = new ListNode2<String>( headlines[x], next, last);
            next.setNext( node );
            last.setPrevious( node );
            next = node;
            x++;
        }
    }


    /**
     * Inserts a node with msg into the headlines list after the blank /line
     * that follows heading.
     * 
     * @param msg
     *            String to add to headlines list
     */
    public void insert( String msg )
    {
        ListNode2<String> last = heading.getNext();
        ListNode2<String> next = last.getNext();

        ListNode2<String> getNew = new ListNode2<String>( msg, last, next );

        last.setNext( getNew );
        next.setPrevious( getNew );
    }


    /**
     * Deletes the node that follows topNode from the headlines list, unless
     * that node happens to be heading or the node before or after heading that
     * holds a blank line.
     */
    public void delete()
    {
        if ( topNode.getNext().equals( heading )
            || topNode.getNext().equals( heading.getNext() )
            || topNode.getNext().equals( heading.getPrevious() ) )
        {
            return;
        }

        topNode.setNext( topNode.getNext().getNext() );
        topNode.getNext().getNext().setPrevious( topNode );
    }


    /**
     * Scrolls up the headlines list, advancing topNode to the next node.
     */
    public void scrollUp()
    {
        topNode = topNode.getNext();
    }


    /*
     * Adds a new node with msg to the headlines list before a given node.
     * Returns a referenece to the added node.
     */
    private ListNode2<String> addBefore( ListNode2<String> node, String msg )
    {
        ListNode2<String> getNode = new ListNode2<String>( msg,
            node.getPrevious(),
            node );
        node.getPrevious().setNext( getNode );
        node.setPrevious( getNode );
        return getNode;
    }


    /*
     * Adds a new node with msg to the headlines list after a given node.
     * Returns a referenece to the added node.
     */
    private ListNode2<String> addAfter( ListNode2<String> node, String msg )
    {
        ListNode2<String> getNode = new ListNode2<String>( msg,
            node,
            node.getNext() );
        node.setNext( getNode );
        node.getNext().setPrevious( getNode );
        return getNode;
    }


    /*
     * Removes a given node from the list.
     */
    private void remove( ListNode2<String> node )
    {
        ListNode2<String> str = heading;

        while (str.getNext() != null )
        {
            if ( str.equals( node ) )
            {
                str.getNext().setPrevious( str.getPrevious() );
                str.getPrevious().setNext( str.getNext() );
                str = str.getNext();
            }
        }
    }


    /*
     * Draws nLines headlines in g, starting with topNode at x, y and
     * incrementing y by lineHeight after each headline.
     */
    public void draw( Graphics g, int x, int y, int lineHeight, int nLines )
    {
        ListNode2<String> node = topNode;
        for(int n = 1; n <= nLines; n++ )
        {
            g.drawString( node.getValue(), x, y );
            y = y + lineHeight;
            node = node.getNext();
        }
    }


    /**
     * Returns a string representation of this TeletextList.
     * 
     * @return a string representation of this TeletextList.
     */
    public String toString()
    {
        String str = getClass().getName() + "[";
        String separator = "";

        for ( ListNode2<String> node = heading; node.getNext() != heading; node = node.getNext() )
        {
            str += ( separator + node.getValue() );
            separator = ", ";
        }

        return str + "]";
    }
}
