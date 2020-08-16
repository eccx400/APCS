import java.util.*;


/**
 * You'll write the SearchEngine class that builds the index for a file and
 * generates the search results. Your class must use a Map object to hold the
 * word index. In this map, a key is a word (in lowercase letters) and the
 * associated value is a List<String>. The list holds all the lines in the file
 * that contain the corresponding keyword.
 * 
 * @author Eric Cheng
 * @version 20 Feburary 2015
 * @author Period - 2
 * @author Assignment - JM24.6 - Search Engine
 * @author Sources - Eric Cheng
 */
public class SearchEngine
{
    // Instance variable(s)
    private String myURL; // holds the name for the "url" (file name)

    private Map<String, List<String>> myIndex; // holds the word index


    // Constructor(s)
    public SearchEngine( String doge )
    {
        myURL = doge;
        myIndex = new HashMap<String, List<String>>( 20000 );
    }


    // Methods

    /**
     * public String getURL() Returns myUrl. I call this method from Giggle to
     * display the name of the file in which hits were found. In the present
     * version I already know the file name, but eventually an expanded version
     * of Giggle may need to index several files.
     * 
     * @return URL
     */
    public String getURL()
    {
        return myURL;
    }


    /**
     * Extracts all words from line, and, for each word, adds line to its list
     * of lines in myIndex. This method obtains a set of all words in line by
     * calling a private method parseWords(line) (see below). Use a
     * LinkedList<String> object to represent a list of lines associated with a
     * word.
     * 
     * @param line
     */
    public void add( String line )
    {
        Set<String> set = parseWords( line );

        for ( String word : set )
        {
            List<String> list = myIndex.get( word );

            if ( !( myIndex.containsKey( word ) ) )
            {
                list = new LinkedList<String>();
                myIndex.put( word, list );
            }
            list.add( line );
        }
    }


    /**
     * Returns the list of lines associated with word in myIndex.
     * 
     * @param word
     *            = get Word
     * @return list of lines
     */
    public List<String> getHits( String word )
    {
        return myIndex.get( word );
    }


    /**
     * Returns a set of all words in line. Use the same technique for extracting
     * all the words from line as you did in the Index Maker lab in Section
     * <...>: call line.split("\\W+"). Add all the elements from the resulting
     * array to a TreeSet. Skip empty words and convert each word to lower case
     * before adding it to the set. parseWords uses a set, as opposed to a list,
     * because we don’t want to index the same line multiple times when the same
     * word occurs several times in it. When we add words to the set, duplicates
     * are automatically eliminated
     * 
     * @param line
     * @return
     */
    private Set<String> parseWords( String line )
    {
        String[] split = line.split( "\\W+" );
        Set<String> newSet = new TreeSet<String>();

        for ( int count = 0; count < split.length; count++ )
        {
            if ( !split[count].isEmpty() )
            {
                newSet.add( split[count].toLowerCase() );
            }
        }
        return newSet;
    }


    /*************************************************************
     * For test purposes only not to be used in solution implementation
     */
    public Map<String, List<String>> getIndex()
    {
        return myIndex;
    }
}
