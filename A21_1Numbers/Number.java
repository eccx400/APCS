import java.util.*;


/**
 * Write a number class that represents a number with a given base. The number
 * class has two constructors. The default constructor sets the base at 10 and
 * the value to 0. The other constructor accepts a decimal value and a base. The
 * constructors will have to create all of the digits (as objects of the digit
 * class) and store them in some kind of list. Create a toString method and an
 * increment method. These two methods will use the corresponding methods of the
 * digit class to do most of the work for them.
 * 
 * @author Eric Cheng
 * @version 6 April 2015
 * @author Period - 2
 * @author Assignment - A21_1Numbers
 * @author Sources - Eric Cheng
 */
public class Number
{
    private int base;

    private double value;

    private Digit digit;

    private ArrayList<Digit> arr;


    public Number()
    {
        base = 10;
        value = 0;
        arr = new ArrayList<Digit>();
        digit = new Digit();
        arr.add( digit );
    }


    public Number( double v, int b )
    {
        base = b;
        value = v;
        arr = new ArrayList<Digit>();
        while ( value > 0 )
        {
            Digit digit = new Digit( value % base, base );
            arr.add( digit );
            value = (int)value / base;
        }
    }

    public void increment()
    {
        int index = 0;
        Digit digit = arr.get( index );

        while ( digit.increment() )
        {
            arr.set( index, digit );
            index++;
            
            if ( index >= arr.size() )
            {
                arr.add( new Digit( 1, base ) );
                break;
            }
            
            digit = arr.get( index );
        }
    }
    
    public String toString()
    {
        String str = "";
        Stack<String> s = new Stack<String>();
        Iterator<Digit> iter = arr.listIterator();
        Digit temp;

        while ( iter.hasNext() )
        {
            temp = iter.next();
            s.push( temp.toString() );
        }

        while ( !(s.isEmpty() ))
            str = str + s.pop();
        return str;
    }
}