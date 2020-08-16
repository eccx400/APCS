import java.lang.reflect.Array;
import java.util.*;


/**
 * RPN Calculator
 *
 * @author Eric Cheng
 * @version 15 January 2015
 * @author Period: 2
 * @author Assignment: AB31RPN Calculator
 *
 * @author Sources: Eric Cheng
 */
public class RPN
{
    Scanner scan = new Scanner( System.in );

    private Stack<Integer> myStack;

    private Queue<String> myQ;

    private String start;

    private ArrayList<String> arr;


    /**
     * Constructs an RPN Calculator
     */
    public RPN()
    {
        System.out.println( "Enter the following 5 postfix problems:" );
        myStack = new Stack<Integer>();
        myQ = new LinkedList<String>();
        start = new String();
    }


    /**
     * **** Used for testing - Do Not Remove ***
     * 
     * Constructs an RPN Calculator and then redirects the Scanner input to the
     * supplied string.
     * 
     * @param console
     *            replaces console input
     */
    public RPN( String console )
    {
        this();
        scan = new Scanner( console );
    }


    /**
     * TODO Write your method description here.
     */
    public void calculate()
    {
        try
        {
            String start = "";
            while ( !start.equals( "Q" ) && !( start.equals( "q" ) ) )
            {
                System.out.println( "Enter character "
                    + "(or Q and q to quit): " );
                start = scan.next();
                if ( !start.equals( "Q" ) && !( start.equals( "q" ) ) )
                {
                    myQ.add( start );
                    if ( isOperator( start ) )
                    {
                        if ( start.equals( "+" ) )
                        {
                            myStack.push( myStack.pop() + myStack.pop() );
                        }
                        else if ( start.equals( "-" ) )
                        {
                            myStack.push( -myStack.pop() + myStack.pop() );
                        }
                        else if ( start.equals( "*" ) )
                        {
                            myStack.push( myStack.pop() * myStack.pop() );
                        }
                        else if ( start.equals( "/" ) )
                        {
                            int first = myStack.pop().intValue();
                            int second = myStack.pop().intValue();
                            // Pop twice
                            if ( first == 0 )
                            {
                                System.out.println( "The RPN equation attempted to divide by zero." );
                            }
                            else
                            {
                                Integer result = (Integer)( second / first );
                                myStack.push( result );
                            }
                        }
                    }
                    else
                    {
                        myStack.push( Integer.parseInt( start ) );
                    }
                }
                if ( start.equals( "q" ) || start.equals( "Q" ) )
                {
                    toString( myQ );
                    break;
                }
            }
        }
        catch ( Exception e )
        {
            System.out.println( "Error: Cannot return" );
        }
    }


    public boolean isOperator( String start )
    {
        return ( start.equals( "+" ) || start.equals( "-" )
            || start.equals( "*" ) || start.equals( "/" ) );
    }


    public void toString( Queue<String> myQ )
    {
        int count = 0;
        String str = new String();
        for ( String fromage : myQ )
        {
            System.out.print( fromage + " " );
        }
        System.out.print( "= " );
        System.out.println( myStack.pop() );
    }


    /**
     * Instantiates an RPN Calculator and invokes it calculate method
     * 
     * @param args
     *            command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        RPN rpn = new RPN();
        rpn.calculate();
    }
}