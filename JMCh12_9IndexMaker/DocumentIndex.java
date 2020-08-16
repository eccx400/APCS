import java.util.ArrayList;

public class DocumentIndex extends ArrayList<IndexEntry>
{
    /**
    // Creates an empty DocumentIndex with the default
    // initial capacity.
     * 
     */
    public DocumentIndex()
    {
       ArrayList<IndexEntry> DocumentIndex = new ArrayList<IndexEntry>();
    }

    /**
    //  Creates an empty DocumentIndex with a given
    //  initial capacity.
     * 
     * @param initialCapacity = gets initial capacity
     */
    public DocumentIndex(int initialCapacity)
    {
       super(initialCapacity);
    }

    /**
    //  If word is not yet in this DocumentIndex,
    //  creates a new IndexEntry for word, and inserts
    //  it into this list in alphabetical order;
    //  adds num to this word's IndexEntry by calling
    //  its add(num) method.
     * 
     * @param word = get String
     * @param num = num to get added
     */
    public void addWord(String word, int num)
    {
        // USE: private int foundOrInserted(String word)
        get( foundOrInserted( word ) ).add( num );
    }

    /**
    //  For each word in str, calls addWord(word, num).
     * 
     * @param str = adds the word
     * @param num = adds the num
     */
    public void addAllWords(String str, int num)
    {
        String[] word = str.split( "\\W+" );
        for ( int i = 0; i < word.length; i++ )
        {
            if ( word[i].length() != 0 )
            {
                addWord( word[i], num );
            }
        }
    }

    /**
    // Tries to find an IndexEntry with a given word in this
    // DocumentIndex.  If not found, inserts a new EndexEntry for
    // word at the appropriate place (in lexicographical order).
    // Returns the index of the found or inserted IndexEntry
     * 
     * @param word = get Word for document index
     * @return new IndexEntry for word at appropriate place
     */
    private int foundOrInserted(String word)
    {
        if ( size() == 0 ) // Condition 1
        {
            add( new IndexEntry( word ) );
            return 0;
        }
        
        for ( int x = 0; x < size(); x++ )
        {
            String temp = get( x ).getWord();
            if ( word.compareToIgnoreCase( temp ) == 0 )
            {
                return x;
            }
            else if ( word.compareToIgnoreCase( temp ) < 0 )
            {
                add( x, new IndexEntry( word ) );
                return x;
            }
        }

        add( new IndexEntry( word ) );
        return ( size() - 1 );
    }
}
