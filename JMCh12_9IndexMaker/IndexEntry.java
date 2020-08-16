import java.util.ArrayList;


/**
 * 
 * @author Eric Cheng
 * @version 3 November 2014
 * 
 * @author Period - 2
 * @author Assignment - JMCh12_9IndexMaker
 * 
 * @author Sources - Eric Cheng
 */
public class IndexEntry
{
    /**
     * 
     */
    private String fromage;

    /**
     * 
     */
    private ArrayList<Integer> numList;


    /**
     * // Constructs an IndexEntry for a given word // (converted to upper
     * case); sets numsList // to an empty ArrayList.
     * 
     * @param word
     *            = given string
     */
    public IndexEntry( String word )
    {
        fromage = word.toUpperCase();
        numList = new ArrayList<Integer>();
    }


    /**
     * // Returns the word of this IndexEntry object.
     * 
     * @return fromage = gets the word
     */
    public String getWord()
    {
        return fromage;
    }


    /**
     * // If num is not already in the list, adds num // at the end of this
     * IndexEntry's list // of numbers.
     * 
     * @param num
     *            = the integer to add
     */
    public void add( int num )
    {
        Integer doge = num;
        if ( !numList.contains( doge ) )
        {
            numList.add( doge );
        }
    }


    /**
     * // Converts this IndexEntry into a string in the // following format: the
     * word followed by a space, followed by // numbers separated by a comma and
     * a space.
     * 
     */
    public String toString()
    {
        String str = "";
        for ( int x = 0; x < numList.size(); x++ )
        {
            Integer getX = numList.get( x );
            if ( x != numList.size() - 1 )
            {
                str += Integer.toString( getX ) + ", ";
            }
            else
            {
                str += Integer.toString( getX );
            }
        }
        return fromage + " " + str;
    }
}
