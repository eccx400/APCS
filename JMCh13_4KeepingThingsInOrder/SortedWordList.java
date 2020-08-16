 /**
 * Implements a sorted list of words
 * 
 * @author Eric Cheng
 * @version 15 November 2014
 * @author Period - 6
 * @author Assignment - Java Methods 13.4 Lab: Keeping Things in Order
 * @author Sources - Eric Cheng
 */
public class SortedWordList extends java.util.ArrayList<String>
{
    /**
     * constructor
     */
    public SortedWordList()
    {
        super();
    }


    /**
     * constructor
     * 
     * @param fromage
     *            = array size
     */
    public SortedWordList( int fromage )
    {
        super( fromage );
    }


    /**
     * Check array for string
     * 
     * @param str
     *            the string
     * @return true if the array list contains the string
     */
    public boolean contains( String str )
    {
        if ( indexOf( str ) != -1 )
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    /**
     * Searches for string in arraylist using binary
     * 
     * @param str
     *            string to be found
     * @return get index or -1 if the string isn't found
     */
    public int indexOf( String str )
    {

        int droit = size() - 1;
        int gauche = 0;
        while ( droit >= gauche )
        {
            int test = str.compareToIgnoreCase( this.get( ( gauche + droit ) / 2 ) );
            if ( test < 0 )
            {
                droit = ( gauche + droit ) / 2 - 1;
            }
            else if ( test > 0 )
            {
                gauche = ( gauche + droit ) / 2 + 1;
            }
            else
            {
                return ( gauche + droit ) / 2;
            }
        }
        return -1; // If not found
    }


    /**
     * 
     * @param i
     *            index
     * @param word
     *            get Word
     */
    public String set( int i, String word )
    {
        if ( i == 0 && word.compareTo( this.get( i + 1 ) ) < 0
            || word.compareTo( this.get( i - 1 ) ) > 0 )
        {
            return super.set( i, word );
        }

        throw new IllegalArgumentException( "word =" + word + " i =" + i );
    }


    /**
     * 
     * @param i
     *            index
     * @param word
     *            get Word
     */
    public void add( int i, String word )
    {
        if ( i == 0 && word.compareToIgnoreCase( get( 0 ) ) < 0 || i == size()
            && word.compareToIgnoreCase( get( size() - 1 ) ) > 0
            || word.compareToIgnoreCase( get( i - 1 ) ) > 0
            && word.compareToIgnoreCase( get( i ) ) < 0 )
        {
            super.add( i, word );
        }
        else
        {
        throw new IllegalArgumentException( "word = " + word + " i = " + i );
        }
    }


    /**
     * @param word
     *            word to be added
     */
    public boolean add( String word )
    {
        if ( this.contains( word ) )
        {
            return false;
        }

        int droit = size() - 1;
        int gauche = 0;
        while ( droit >= gauche )
        {
            int test = word.compareToIgnoreCase( this.get( ( gauche + droit ) / 2 ) );
            if ( test < 0 )
            {
                droit = ( gauche + droit ) / 2 - 1;
            }
            else if ( test > 0 )
            {
                gauche = ( gauche + droit ) / 2 + 1;
            }
        }
        super.add( droit + 1, word );
        return true;
    }


    /**
     * Define a new method merge(SortedWordList additionalWords). This method
     * should insert into this list in alphabetical order all the words from
     * additionalWords that are not already in this list. merge should be
     * efficient. You may not use any temporary arrays or lists. Each element
     * from this list should move at most once, directly into its proper
     * location. To achieve this while avoiding IndexOutOfBounds errors, you
     * first need to add some dummy elements to the list. Save the current size
     * of the list, then append to it n arbitrary strings, where n =
     * additionalWords.size(). Call super.add("") to append an empty string or
     * just call addAll(additionalWords) once. Now merge the lists, starting at
     * the end of each list and at the end of the added space. At each step
     * decide which of the two lists should supply the next element for the next
     * vacant location.
     * 
     * @param additionalWords
     *            = sort the word
     */
    public void merge( SortedWordList additionalWords )
    {
        for ( String x : additionalWords )
        {
            add( x );
        }
    }
}

/*
 * set(0, "Amy") = Aaron set(4, "Ellen") = Ellen set(4, "Evan") = Ellen names1 =
 * [Amy, Barb, Connie, Dan, Evan, Frank] contains("Amy") = true indexOf("Amy") =
 * 0 contains("Ben") = false indexOf("Ben") = -1 contains("Dan") = true
 * indexOf("Dan") = 3 names2 = [Aaron, Amy, Ben, Claire, Connie, Debby, Eve,
 * Fiona, Frank, Gina] names1 + names2 = [Aaron, Amy, Barb, Ben, Claire, Connie,
 * Dan, Debby, Evan, Eve, Fiona, Frank, Gina] [Aaron, Amy, Barb, Ben, Claire,
 * Connie, Dan, Debby, Evan, Eve, Fiona, Frank, Gina]
 */
