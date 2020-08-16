/*** Part (c) ***/

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
public class NotChecker implements Checker
{
    /**
     * Get text
     */
    public Checker text;


    /**
     * @param fromage
     *            = get Checker
     */
    public NotChecker( Checker fromage )
    {
        text = fromage;
    }


    /**
     * Another implementation of the Checker interface is the NotChecker, which
     * contains the following: • A one-parameter constructor that takes one
     * Checker object • An accept method that returns true if and only if its
     * Checker object does NOT accept the string
     * 
     * A NotChecker accepts any string that does NOT contain a particular
     * substring.
     * 
     * @param doge
     *            = given string
     * @return A string that does not contain text
     */
    public boolean accept( String doge )
    {
        return !text.accept( doge );
    }
}
