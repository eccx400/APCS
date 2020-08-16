/**
 * A price comparator for trade orders.
 */
public class PriceComparator implements java.util.Comparator<TradeOrder>
{
    private boolean ascending;


    public PriceComparator()
    {
        super();
        ascending = true;
    }


    public PriceComparator( boolean asc )
    {
        super();
        ascending = asc;
    }


    public int compare( TradeOrder order1, TradeOrder order2 )
    {
        if ( order1.isMarket() && order2.isMarket() )
        {
            return 0;
        }
        else if ( order1.isMarket() && order2.isLimit() )
        {
            return -1;

        }
        else if ( order1.isLimit() && order2.isMarket() )
        {

            return 1;

        }
        else if ( ascending )
        {
            return (int)( order1.getPrice() * 100 - order2.getPrice() * 100 );
        }
        else
        {
            return (int)( order2.getPrice() * 100 - order1.getPrice() * 100 );
        }

    }


    public boolean getAscending()
    {
        return ascending;
    }
}
