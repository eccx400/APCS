import java.util.*;
import java.lang.reflect.*;
import java.text.DecimalFormat;


/**
 * Represents a stock in the SafeTrade project
 */
public class Stock
{
    public static DecimalFormat money = new DecimalFormat( "0.00" );

    private String stockSymbol;

    private String companyName;

    private double loPrice, hiPrice, lastPrice;

    private int volume;

    private PriorityQueue<TradeOrder> buyOrders, sellOrders;


    public Stock( String symbol, String name, double price )
    {
        stockSymbol = symbol;
        companyName = name;
        loPrice = price;
        hiPrice = price;
        volume = 0;
        lastPrice = price;
        sellOrders = new PriorityQueue<TradeOrder>( 1, new PriceComparator() );
        buyOrders = new PriorityQueue<TradeOrder>( 1,
            new PriceComparator( false ) );
    }


    public String getQuote()
    {
        String ret = companyName + " (" + stockSymbol + ")" + '\n';
        ret += "Price: " + money.format( lastPrice ) + "  hi: "
            + money.format( hiPrice ) + "  lo: " + money.format( loPrice )
            + "  vol: " + sellOrders.size() + '\n';
        if ( !sellOrders.isEmpty() )
        {
            if ( sellOrders.peek().isLimit() )
            {
                ret += "Ask: " + money.format( sellOrders.peek().getPrice() )
                    + " size: " + sellOrders.peek().getShares() + "  ";
            }
            else
            {
                ret += "Ask: market " + "size: "
                    + sellOrders.peek().getShares() + "  ";
            }
        }
        else
        {
            ret += "Ask: none  ";
        }

        if ( buyOrders.isEmpty() )
        {
            ret += "Bid: none";
        }
        else
        {
            if ( buyOrders.peek().isLimit() )
            {
                ret += "Bid: " + money.format( buyOrders.peek().getPrice() )
                    + " size: " + buyOrders.peek().getShares();
            }
            else
            {
                ret += "Bid: market" + " size: " + buyOrders.peek().getShares();
            }
        }

        return ret;

    }


    public void placeOrder( TradeOrder order )
    {
        String mes = "New order:  ";
        if ( order.isBuy() )
        {
            buyOrders.add( order );
            mes += "Buy " + stockSymbol + " (" + companyName + ")" + "\n";
        }
        else
        {
            sellOrders.add( order );
            mes += "Sell " + stockSymbol + " (" + companyName + ")" + "\n";
            volume += order.getShares();
        }

        if ( !order.isMarket() )
        {
            mes += order.getShares() + " shares at " + "$"
                + money.format( order.getPrice() ) + "\n";
        }
        else
        {
            mes += order.getShares() + " shares at " + "market" + "\n";
        }

        Trader sen = order.getTrader();
        sen.receiveMessage( mes );
        executeOrders();

    }


    protected void executeOrders()
    {
        double price = 0.0;
        TradeOrder buy = buyOrders.peek();
        TradeOrder sell = sellOrders.peek();
        if ( buy == null || sell == null )
        {
            return;
        }

        if ( buy.isLimit() && sell.isLimit()
            && buy.getPrice() >= sell.getPrice() )
        {
            price = sell.getPrice();
        }
        else if ( buy.isLimit() && sell.isLimit() )
        {
            return;
        }
        else if ( buy.isLimit() )
        {
            price = buy.getPrice();
        }
        else if ( sell.isLimit() )
        {
            price = sell.getPrice();
        }
        else
        {
            price = lastPrice;
        }

        int shares = Math.min( buy.getShares(), sell.getShares() );
        buy.subtractShares( shares );
        sell.subtractShares( shares );
        if ( buy.getShares() == 0 )
        {
            buyOrders.remove();
        }
        if ( sell.getShares() == 0 )
        {
            sellOrders.remove();
        }
        if ( price < loPrice )
        {
            loPrice = price;
        }
        else if ( price > hiPrice )
        {
            hiPrice = price;
        }

        Trader buyer = buy.getTrader();
        Trader seller = sell.getTrader();
        String b = "You bought: " + shares + " " + stockSymbol + " at "
            + money.format( price ) + " amt " + money.format( price * shares );
        String s = "You sold: " + shares + " " + stockSymbol + " at "
            + money.format( price ) + " amt " + money.format( price * shares );
        buyer.receiveMessage( b );
        seller.receiveMessage( s );
        volume += shares;
        executeOrders();
    }


    //
    // The following are for test purposes only
    //

    protected String getStockSymbol()
    {
        return stockSymbol;
    }


    protected String getCompanyName()
    {
        return companyName;
    }


    protected double getLoPrice()
    {
        return loPrice;
    }


    protected double getHiPrice()
    {
        return hiPrice;
    }


    protected double getLastPrice()
    {
        return lastPrice;
    }


    protected int getVolume()
    {
        return volume;
    }


    protected PriorityQueue<TradeOrder> getBuyOrders()
    {
        return buyOrders;
    }


    protected PriorityQueue<TradeOrder> getSellOrders()
    {
        return sellOrders;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Stock.
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
}
