import java.lang.reflect.*;


/**
 * This class implements a vendor that sells one kind of item. A vendor carries
 * out sales transactions.
 * 
 * @author Eric Cheng
 * @version 29 Septembre 2014
 * @author Period - 2
 * @author Assignment - Java Methods Ch09 - SnackBar
 * @author Sources - Eric Cheng
 */
public class Vendor
{
    /**
     * Fields: 
     */
    private int stock;
    
    private int price;
 
    private int deposit;
 
    private int change;
 
    private static double totalSales;
 


    /**
     * Constructor Parameters:
     * 
     * @param price
     *            = int price of a single item in cents
     * @param number
     *            = int number of items to place in stock
     */
    public Vendor( int lePrice, int number )
    {
        stock = number;
        price = lePrice;
    }


    /**
     * Parameters: int number of items to place in stock Return: None
     * 
     * @param number
     *            = int number of items to place in stock
     */
    public void setStock( int number )
    {
        stock = number;
    }


    /**
     * Returns the number of items currently in stock. Parameters: None Return:
     * int number of items currently in stock
     * 
     * @return num = number
     */
    public int getStock()
    {
        return stock;
    }


    /**
     * Adds a specified amount (in cents) to the deposited amount. Parameters:
     * int number of cents to add to the deposit Return: None
     * 
     * @param = int money
     */
    public void addMoney( int money )
    {
        if (stock > 0)
        {
            deposit += money;   
        }
    }


    /**
     * Returns the currently deposited amount (in cents). Parameters: None
     * Return: int number of cents in the current deposit
     * 
     * @return = deposit
     */
    public int getDeposit()
    {
        return deposit;
    }


    /**
     * Implements a sale. If there are items in stock and the deposited amount
     * is greater than or equal to the single item price, then adjusts the stock
     * and calculates and sets change and returns true; otherwise refunds the
     * whole deposit (moves it into change) and returns false.
     * 
     * Parameters: None
     * 
     * @return: boolean successful sale (true) or failure (false)
     */
    public boolean makeSale()
    {
        if ( stock > 0 && deposit >= price )
        {
            this.stock--;
            change = deposit - price;
            this.deposit = 0;
            totalSales += price / 100.0;
            return true;
        }
        else
        {
            change = deposit;
            this.deposit = 0;
            return false;
        }
    }


    /**
     * Returns and zeroes out the amount of change (from the last sale or
     * refund). Parameters: None Return: int number of cents in the current
     * change
     * 
     * @return = change
     */
    public int getChange()
    {
        int dummy1 = change;
        change = 0;
        return dummy1;
    }


    public static double getTotalSales()
    {
        double dummy2 = totalSales;
        totalSales = 0;
        return dummy2;
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
     * @return a string representation of this Vendor.
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
                str += separator + field.getName() + ":" + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }

            separator = ", ";
        }

        return str + "]";
    }
}
