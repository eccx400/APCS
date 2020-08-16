import java.lang.reflect.Field;
import java.util.Scanner;


/**
 * Coins: This class accepts a certain amount of monetary change (in cents). The
 * output is a list of the number of quarters, dimes, nickels, and pennies that
 * will make that amount of change with the least number of coins possible.
 *
 * @author Eric Cheng
 * @version 9/3/2014
 * @author Period: 2
 * @author Assignment: Lab Activity 3.2 - Coins
 * @author Sources: TODO: Eric Cheng
 */
public class Coins
{
    private int myChange;

    /**
     * @param change
     *            = given change
     */
    public Coins( int change )
    {
        myChange = change;
    }

    /**
     * Using the least amount of coins possible return the given amount of
     * change using coins
     */
    public void calculate()
    {
        System.out.println( myChange + " cents =>" );
        int qChange = myChange / 25;
        int remain = myChange % 25;
        System.out.println( "Quarter(s)   " + qChange );
        int dChange = remain / 10;
        int remain2 = remain % 10;
        System.out.println( "Dime(s)      " + dChange );
        int nChange = remain2 / 5;
        int remain3 = remain2 % 5;
        System.out.println( "Nickel(s)    " + nChange );
        int cChange = remain3 / 1;
        System.out.println( "Cent(s)      " + cChange );
    }

    /**
     * Intended only for debugging.
     * 
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Easter.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields )
        {
            try
            {
                str += separator + field.getType().getName() + " "
                    + field.getName() + ":" + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }
            separator = ", ";
        }
        return str + "]";
    }


    /**
     * Tester for the Coins class.
     * 
     * @param args
     *            command line arguments - not used
     */
    public static void main( String[] args )
    {
        Scanner console = new Scanner( System.in );

        System.out.print( "Please enter the number of cents --> " );
        int cents = console.nextInt();

        Coins change = new Coins( cents );
        change.calculate();
    }
}
