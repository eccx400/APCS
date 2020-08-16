/*** TODO Part (a) ***/

/**
 * A checker is an object that examines strings and accepts those strings that
 * meet a particular criterion.
 * 
 * @author Eric Cheng
 * @version Oct 13, 2014
 * @author Period: 2
 * @author Assignment: A11_3Checker
 * 
 * @author Sources: Eric Cheng
 */
public class SubstringChecker implements Checker
{
    /**
     * Declare new text
     */
    private String text;


    /**
     * @param fromage
     *            = gets the string
     */
    public SubstringChecker( String fromage )
    {
        text = fromage;
    }


    /**
     * Write the SubstringChecker class that implements the Checker interface.
     * The constructor should take a single String parameter that represents the
     * particular substring to be matched
     * 
     * @param doge
     *            = String to be tested
     * @return a string that contains the word
     */
    public boolean accept( String doge )
    {
        return doge.contains( text );
    }
}