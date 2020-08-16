/**
 * This is the main class that creates the voting panels
 * 
 * @author Eric Cheng
 * @version 9/5/2014
 * @author Period: 6
 * @author Assignment: JMCh06_10PieChart
 * 
 * @author Sources: Eric Cheng
 */
public class PollTest
{
    /**
     * This creates the 3 votes that the people are allowed to fix
     * 
     * @param args
     *            = arguments array
     */
    public static void main( String[] args )
    {
        PollDisplayPanel votingMachine = new PollDisplayPanel( "Tami",
            "Brian",
            "Liz" );
        votingMachine.vote1();
        votingMachine.vote2();
        votingMachine.vote2();
        System.out.println( votingMachine );
    }
}
