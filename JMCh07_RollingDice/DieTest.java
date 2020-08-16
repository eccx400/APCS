/**
 * This is the main method used to test the rolling die
 * 
 * @author Eric Cheng
 * @version 10 Septembre 2014
 * @author Period: 2
 * @author Assignment: JMCh07_RollingDice
 * 
 * @author Sources: Eric Cheng
 *
 */
public class DieTest
{
    /**
     * @param args = arguments array
     */
    public static void main( String[] args )
    {
        Die die = new Die();
        die.roll();
        System.out.println( die.getNumDots() );
        die.roll();
        System.out.println( die.getNumDots() );
        die.roll();
        System.out.println( die.getNumDots() );
        die.roll();
        System.out.println( die.getNumDots() );
        die.roll();
        System.out.println( die.getNumDots() );
        die.roll();
        System.out.println( die.getNumDots() );
    }
}
