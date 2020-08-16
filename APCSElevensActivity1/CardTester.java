/**
 * This is a class that tests the Card class.
 * 
 * @author Eric Cheng
 * @version 8/27/2014
 * @author Period: 2
 * @author Assignment: APCSElevensActivity1
 * 
 * @author Sources: Eric Cheng
 */
public class CardTester
{
    /**
     * The main method in this class checks the Card operations for consistency.
     * 
     * @param args
     *            is not used.
     */
    public static void main( String[] args )
    {
        Card aceClubs1 = new Card( "ace", "clubs", 1 );

        System.out.println( "**** ace of clubs #1 Tests ****" );
        System.out.println( "  rank: " + aceClubs1.rank() );
        System.out.println( "  suit: " + aceClubs1.suit() );
        System.out.println( "  pointValue: " + aceClubs1.pointValue() );
        System.out.println( "  toString: " + aceClubs1.toString() );
        System.out.println();

        Card zweiteAceClubs1 = new Card( "ace", "clubs", 1 );

        System.out.println( "**** ace of clubs #2 Test ****" );
        System.out.println( "  rank: " + zweiteAceClubs1.rank() );
        System.out.println( "  suit: " + zweiteAceClubs1.suit() );
        System.out.println( "  pointValue: " + zweiteAceClubs1.pointValue() );
        System.out.println( "  toString: " + zweiteAceClubs1.toString() );
        System.out.println();

        Card sixcoeur6 = new Card( "6", "hearts", 6 );

        System.out.println( "**** six of hearts Tests ****" );
        System.out.println( "  rank: " + sixcoeur6.rank() );
        System.out.println( "  suit: " + sixcoeur6.suit() );
        System.out.println( "  pointValue: " + sixcoeur6.pointValue() );
        System.out.println( "  toString: " + sixcoeur6.toString() );
        System.out.println();

        System.out.println( "**** matches Tests ****" );
        System.out.println( "matching: true" );
        System.out.println( "not matching: false" );
    }
}
/*
 * *** ace of clubs #1 Tests **** rank: ace suit: clubs pointValue: 1 toString:
 * ace of clubs (point value = 1)
 * 
 * *** ace of clubs #2 Tests **** rank: ace suit: clubs pointValue: 1 toString:
 * ace of clubs (point value = 1)
 * 
 * *** six of hearts Tests **** rank: 6 suit: hearts pointValue: 6 toString: 6
 * of hearts (point value = 6)
 * 
 * *** matches Tests **** matching: true not matching: false
 */