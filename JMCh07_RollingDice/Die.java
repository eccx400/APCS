/**
 *  Simulates a six-sided die.
 *
 *  @author  Eric Cheng
 *  @version 10 Septembre 2014
 *  @author  Period: 2
 *  @author  Assignment: JMCh07_RollingDice
 *
 *  @author  Sources: Eric Cheng
 */
public class Die
{
    private int numDots;

    /**
     * Sets numDots to a random integer from 1 to 6
     */
    public void roll()
    {
        numDots = 1 + (int)(6 * Math.random() );
    }
    
    /**
     * Returns the value of the most recent roll.
     * @return numDots = returns the random integer
     */
    public int getNumDots()
    {
        return numDots;
    }
}
