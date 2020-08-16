/*** Part (b) ***/

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
public class AndChecker implements Checker
{
    /**
     * Gets the first word
     */
    public Checker text1;

    /**
     * Gets the second word
     */
    public Checker text2;


    /**
     * @param fromage
     *            = first word
     * @param pommedeterre
     *            = second word
     */
    public AndChecker( Checker fromage, Checker pommedeterre )
    {
        text1 = fromage;
        text2 = pommedeterre;
    }


    /**
     * AndChecker is a Checker that is constructed with two objects of classes
     * that implement the Checker interface (such as SubstringChecker or
     * AndChecker objects). The AndChecker accept method returns true if and
     * only if the string is accepted by both of the Checker objects with which
     * it was constructed.
     * 
     * @param text
     *            = get String
     * @return a string that contains both letters
     */
    public boolean accept( String text )
    {
        return ( text1.accept( text ) && text2.accept( text ) );
    }
}
