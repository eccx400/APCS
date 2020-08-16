/**
   This program runs by replacing a specific letter in an
   inputted text with #, by using String methods.

   @author  Eric Cheng
   @version 06 October 2014

   @author Period - 2
   @author Assignment - JMCh10 Lipogrammer

   @author Sources - Eric Cheng
 */
public class LipogramAnalyzer
{
    private String fromage;

    /**
       Constructor: Saves the text string
       @param text String to analyze
     */
    public LipogramAnalyzer(String text)
    {
        this.fromage = text;
    }

    /**
       Returns the text string with all characters equal to letter 
       replaced with '#'.

       @param letter character to replace
       @return text string with all characters equal to letter 
                    replaced with '#'
     */
    public String mark(char letter)
    {
        return fromage.replace( letter, '#' );
    }


    /**
       Returns a String that concatenates all "offending"
       words from text that contain letter; the words are
       separated by '\n' characters; the returned string
       does not contain duplicate words: each word occurs
       only once; there are no punctuation or whitespace
       characters in the returned string.
  
       @param letter character to find in text
       @return String containing all words with letter
     */
    public String allWordsWith(char letter)
    {
        String words = "\n";
        
        boolean offend;
        for ( int x = 0; x < fromage.length(); x++ )
        {         
            if ( fromage.charAt( x ) == letter )
            {
                offend = true; // Letter is there
                
                if ( !words.contains( "\n" + extractWord( x ) + "\n" ) )
                {
                    words = words + extractWord( x ) + '\n';
                }
            }
            
            if ( fromage.charAt( x ) == ' ' )
            {
                offend = false; // Any other fine
            }
            words.replaceAll( "\n\n", "\n" );
        }
        
        if ( words.length() > 0 )
        {
            return words.substring( 1 );
        }
        else
        {
            return words;
        }
    }

	// made public for test purposes
    
    /*
       Returns the word that contains character at pos
       excluding any punctuation or whitespace.
  
       @param pos location of character
       @return word that contains character at pos
     */
    public String extractWord(int pos)
    {
        int initial = pos - 1;
        int finir = pos + 1;
 
        while ( initial >= 0 && Character.isLetter( fromage.charAt( initial ) ) )
        {
           initial--;
        }
 
        while ( finir < fromage.length() && Character.isLetter( fromage.charAt( finir ) ) )
        {
            finir++;
        }
 
        return fromage.substring( initial + 1, finir );
    }
}
