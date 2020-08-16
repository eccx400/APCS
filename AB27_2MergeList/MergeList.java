import java.util.*;
import java.io.*;

/**
   Implements a recursive mergesort on a LinkedList data type

   @author  Eric Cheng
   @version 1 December 2012

   @author Period - 2
   @author Assignment - AB27.1 MergeList

   @author Sources - Eric Cheng
 */
public class MergeList
{
    private Scanner inFile;
 
    private String myFile;
 
    /**
     * Open a file containing id/inventory pairs of data
     * 
     * @param fileName
     *            File to be opened
     */
    public MergeList( String fileName )
    {
        myFile = fileName;
    }
 
    /**
     * Reads a file containing id/inv data pairs. The first line of the file
     * contains the number of id/inventory integer pairs listed on subsequent
     * lines.
     * 
     * @param list
     *            Reference to LinkedList<Item> to which data will be added
     */
    public void readData( LinkedList<Item> list )
    {
        int id;
        int inv;
 
        try
        {
            inFile = new Scanner( new File( myFile ) );
            while ( inFile.hasNext() )
            {
                id = inFile.nextInt();
                inv = inFile.nextInt();
                list.addFirst( new Item( id, inv ) );
            }
        }
        catch ( IOException i )
        {
            System.out.println( "Error: " + i.getMessage() );
        }
    }
 
    /**
     * Prints contents of list
     * 
     * @param list
     *            LinkedList<Item> to be printed
     */
    public void printList( LinkedList<Item> list )
    {
        Iterator<Item> iter = list.iterator();
 
        System.out.printf( "%5s%16s", "Id", "Inventory\n" );
        while ( iter.hasNext() )
        {
            Item temp = iter.next();
            System.out.printf( "%7d%10d\n", temp.getId(), temp.getInv() );
        }
        System.out.println();
    }
 
    /**
     * Splits listA into two parts. listA retains the first half of the list,
     * listB contains the last half of the original list.
     * 
     * @param listA
     *            Original list. reduced by half after split.
     * @param listB
     *            Contains last half of the original list
     */
    public void split( LinkedList<Item> listA, LinkedList<Item> listB )
    {
        // Debug message for stub routine - remove when method is complete

        Iterator fromage = listA.listIterator( listA.size() / 2 );
        while ( fromage.hasNext() )
        {
            listB.add( (Item)( fromage.next() ) );
            fromage.remove();
        }
    }
 
    /**
     * Two linked lists listA and listB are merged into a single linked list
     * mergedList. They are placed in mergedList starting with the smallest item
     * on either list and continue working up to to largest item.
     * 
     * @param listA
     *            LinkedList<Item> in nondecreasing order
     * @param listB
     *            LinkedList<Item> in nondecreasing order
     * @return LinkedList<Item> containing all the values from lists listA and
     *         listB, in nondecreasing order
     */
    public LinkedList<Item> merge(
        LinkedList<Item> listA,
        LinkedList<Item> listB )
    {
        // Debug message for stub routine - remove when method is complete
 
        // make sure the target list is empty
        LinkedList<Item> mergedList = new LinkedList<Item>();
 
        ListIterator<Item> iA = listA.listIterator();
        ListIterator<Item> iB = listB.listIterator();
 
        while ( iA.hasNext() && iB.hasNext() )
        {
            Item getA = iA.next();
            Item getB = iB.next();
 
            if ( 0 > getA.compareTo( getB ))
            {
                mergedList.add( getA );
                iB.previous();
            }
            else
            {
                mergedList.add( getB );
                iA.previous();
            }
        }
        
        while ( iB.hasNext() )
        {
            mergedList.add( iB.next() );
        }
 
        while ( iA.hasNext() )
        {
            mergedList.add( iA.next() );
        }
 
        return mergedList;
    }
 
 
    /**
     * The linked list is returned in sorted order. Sorted order has the
     * smallest item first and the largest item last. The ordering is determined
     * by the order defined in the Comparable class. The method uses the
     * mergesort technique and must be recursive.
     * 
     * @param listA
     *            LinkedList<Item> to be sorted
     * @return LinkedList<Item> in sorted (nondecreasing) order
     */
    public LinkedList<Item> mergeSort( LinkedList<Item> listA )
    {
        LinkedList<Item> listB = new LinkedList<Item>();
 
        if ( listA == null )
        {
            return null;
        }
 
        // Don't sort an empty list or a list with one node
        if ( listA.size() <= 1 )
        {
            return listA;
        }
 
        // Split the list in half. If uneven then make left one larger.
        split( listA, listB );
 
        return merge( mergeSort( listA ), mergeSort( listB ) );
    }
 
 
    /**
     * Reverses the order of a list
     * 
     * @param list
     *            LinkedList<Item> to be reversed
     * @return LinkedList<Item> in reverse order
     */
    public LinkedList<Item> reverseList( LinkedList<Item> list )
    {
        // Debug message for stub routine - remove when method is complete
 
        LinkedList<Item> reversedList = new LinkedList<Item>();
 
        Iterator<Item> x = list.iterator();
        while ( x.hasNext() )
        {
            reversedList.addFirst( x.next() );
        }
 
        return reversedList;
    }
}

/*
 Original list

   Id      Inventory
  12328        63
   7282        73
   8303        90
  15320        82
  15814        60
  15917        51
  12705        14
  13066         8
    206        31
  18061         3
  14088        92
  18871        69
    184        14
  17911        96
  19967        45
  18465        27
  18410        56
   2370        65
  18618        64
    196        60

List after MergeSort

   Id      Inventory
    184        14
    196        60
    206        31
   2370        65
   7282        73
   8303        90
  12328        63
  12705        14
  13066         8
  14088        92
  15320        82
  15814        60
  15917        51
  17911        96
  18061         3
  18410        56
  18465        27
  18618        64
  18871        69
  19967        45

Reversed list

   Id      Inventory
  19967        45
  18871        69
  18618        64
  18465        27
  18410        56
  18061         3
  17911        96
  15917        51
  15814        60
  15320        82
  14088        92
  13066         8
  12705        14
  12328        63
   8303        90
   7282        73
   2370        65
    206        31
    196        60
    184        14
*/
