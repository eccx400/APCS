/**
 * Implements the game of Craps logic.
 * 
 * @author Eric Cheng
 * @version 10 Septembre 2014
 * @author Period: 2
 * @author Assignment: JMCh07_RollingDice
 * 
 * @author Sources: Eric Cheng
 */
public class CrapsGame
{
    private int point = 0;


    /**
     * Calculates the result of the next dice roll in the Craps game. The
     * parameter total is the sum of dots on two dice. point is set to the saved
     * total, if the game continues, or 0, if the game has ended. Returns 1 if
     * player won, -1 if player lost, 0 if player continues rolling.
     * 
     * @param total
     *            = The total of the sum of the die rolls in one turn
     * @return result = returns the result for win, lose, or continue
     */
    public int processRoll( int total )
    {
        int result = 0;
        
        if ( point == 0 ) // First Round
        {
            if ( ( total == 7 || total == 11 ) )
            {
                result = 1; // First round 7,11 Wins
                point = 0;
            }
            else if ( ( total == 2 || total == 3 || total == 12 ) )
            {
                result = -1; // First round 2,3,12 Loses
                point = 0;
            }
            else
            {
                point = total; // First round Other = Next Round
            }
        }
        else
        {
            if ( point == total ) // Second Round+
            {
                result = 1;
                point = 0;
            }
            else if ( total == 7 )
            {
                result = -1;
                point = 0;
            }
            else
            {
                result = 0;
            }
        }
        return result;
    }

    /**
     * Returns the saved point
     * 
     * @return point = saved point
     */
    public int getPoint()
    {
        return point;
    }
}