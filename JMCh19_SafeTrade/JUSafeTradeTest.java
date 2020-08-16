import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.regex.*;

import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;


/**
 * SafeTrade tests: TradeOrder PriceComparator Trader Brokerage StockExchange
 * Stock
 *
 * @author Ajinkya Nene
 * @author Eric Cheng
 * @author Adish Jain
 * @version 3.27.15
 * @author Assignment: JM Chapter 19 - SafeTrade
 * 
 * @author Sources: none
 *
 */
public class JUSafeTradeTest
{
    // --Test TradeOrder
    /**
     * TradeOrder tests: TradeOrderConstructor - constructs TradeOrder and then
     * compare toString TradeOrderGetTrader - compares value returned to
     * constructed value TradeOrderGetSymbol - compares value returned to
     * constructed value TradeOrderIsBuy - compares value returned to
     * constructed value TradeOrderIsSell - compares value returned to
     * constructed value TradeOrderIsMarket - compares value returned to
     * constructed value TradeOrderIsLimit - compares value returned to
     * constructed value TradeOrderGetShares - compares value returned to
     * constructed value TradeOrderGetPrice - compares value returned to
     * constructed value TradeOrderSubtractShares - subtracts known value &
     * compares result returned by getShares to expected value
     */
    private String symbol = "GGGL";

    private boolean buyOrder = true;

    private boolean marketOrder = true;

    private int numShares = 123;

    private int numToSubtract = 24;

    private double price = 123.45;


    @Test
    public void tradeOrderConstructor()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        String toStr = to.toString();

        assertTrue( "<< Invalid TradeOrder Constructor >>",
            toStr.contains( "TradeOrder[Trader trader:null" )
                && toStr.contains( "java.lang.String symbol:" + symbol )
                && toStr.contains( "boolean buyOrder:" + buyOrder )
                && toStr.contains( "boolean marketOrder:" + marketOrder )
                && toStr.contains( "int numShares:" + numShares )
                && toStr.contains( "double price:" + price ) );
    }


    @Test
    public void TradeOrderToString()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertNotNull( to.toString() );
    }


    @Test
    public void tradeOrderGetTrader()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertNull( "<< TradeOrder: " + to.getTrader() + " should be null >>",
            to.getTrader() );
    }


    @Test
    public void tradeOrderGetSymbol()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertEquals( "<< TradeOrder: " + to.getTrader() + " should be "
            + symbol + " >>", symbol, to.getSymbol() );
    }


    @Test
    public void tradeOrderIsBuy()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );

        assertTrue( "<< TradeOrder: " + to.isBuy() + " should be " + buyOrder
            + " >>", to.isBuy() );
    }


    @Test
    public void tradeOrderIsSell()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertFalse( "<< TradeOrder: " + to.isSell() + " should be "
            + !buyOrder + " >>", to.isSell() );
    }


    @Test
    public void tradeOrderIsMarket()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertTrue( "<< TradeOrder: " + to.isMarket() + " should be "
            + marketOrder + " >>", to.isMarket() );
    }


    @Test
    public void tradeOrderIsLimit()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );

        assertFalse( "<< TradeOrder: " + to.isLimit() + " should be "
            + !marketOrder + ">>", to.isLimit() );
    }


    @Test
    public void tradeOrderGetShares()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertTrue( "<< TradeOrder: " + to.getShares() + " should be "
            + numShares + ">>", numShares == to.getShares()
            || ( numShares - numToSubtract ) == to.getShares() );
    }


    @Test
    public void tradeOrderGetPrice()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertEquals( "<< TradeOrder: " + to.getPrice() + " should be " + price
            + ">>", price, to.getPrice(), 0.0 );
    }


    @Test
    public void tradeOrderSubtractShares()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        to.subtractShares( numToSubtract );
        assertEquals( "<< TradeOrder: subtractShares(" + numToSubtract
            + ") should be " + ( numShares - numToSubtract ) + ">>", numShares
            - numToSubtract, to.getShares() );
    }


    // --Test TraderWindow Stub
    @Test
    public void traderWindowConstructor()
    {
        TraderWindow tw = new TraderWindow( null );
        assertNotNull( tw );
    }


    @Test
    public void traderWindowShowMessage()
    {
        TraderWindow tw = new TraderWindow( null );
        assertNotNull( tw );
        tw.showMessage( null );
    }


    // --Test PriceComparator

    @Test
    public void priceComparatorConstructorNoParam()
    {
        PriceComparator p = new PriceComparator();
        assertNotNull( p );
        p.toString();
    }


    @Test
    public void priceComparatorConstructorParam()
    {
        PriceComparator p = new PriceComparator();
        assertNotNull( p );
    }


    @Test
    public void priceComparatorToString()
    {
        PriceComparator p = new PriceComparator();
        assertNotNull( p.toString() );
    }

    @Test
    public void priceComparatorGetAscending()
    {
        PriceComparator p = new PriceComparator();
        assertTrue( p.getAscending() == true );
    }

    @Test
    public void priceComparatorCompare()
    {
        PriceComparator p = new PriceComparator();
        TradeOrder order1 = new TradeOrder( null,
            symbol,
            buyOrder,
            true,
            numShares,
            price );
        TradeOrder order2 = new TradeOrder( null,
            symbol,
            buyOrder,
            true,
            numShares,
            price );

        assertTrue( p.compare( order1, order2 ) == 0 );

        TradeOrder order3 = new TradeOrder( null,
            symbol,
            buyOrder,
            true,
            numShares,
            price );
        TradeOrder order4 = new TradeOrder( null,
            symbol,
            buyOrder,
            false,
            numShares,
            price );

        assertTrue( p.compare( order3, order4 ) == -1 );

        TradeOrder order5 = new TradeOrder( null,
            symbol,
            buyOrder,
            false,
            numShares,
            price );
        TradeOrder order6 = new TradeOrder( null,
            symbol,
            buyOrder,
            true,
            numShares,
            price );

        assertTrue( p.compare( order5, order6 ) == 1 );

        TradeOrder order7 = new TradeOrder( null,
            symbol,
            buyOrder,
            false,
            numShares,
            price + 1 );
        TradeOrder order8 = new TradeOrder( null,
            symbol,
            buyOrder,
            false,
            numShares,
            price );

        assertTrue( p.compare( order7, order8 ) == 100 );

    }


    // --Test Trader

    @Test
    public void traderConstructor()
    {
        Trader t = new Trader( new Brokerage( new StockExchange() ),
            "ajinkya",
            "ajinkya" );
        assertNotNull( t.getName() );
        assertNotNull( t.getPassword() );
        assertNotNull( t.mailbox() );

        String s = t.toString();
        assertTrue( s.contains( "Brokerage brokerage" )
            && s.contains( "Trader" ) );
    }


    @Test
    public void traderGetName()
    {
        Trader trade = new Trader( new Brokerage( new StockExchange() ),
            "EricChe",
            "EricChe" );
        // System.out.println( trade.getName() );
        assertEquals( trade.getName(), "EricChe" );
    }


    @Test
    public void traderGetPassword()
    {
        Trader trade = new Trader( new Brokerage( new StockExchange() ),
            "Test",
            "Test" );
        assertEquals( trade.getPassword(), "Test" );
    }


    @Test
    public void traderHasMessages()
    {
        Trader trade = new Trader( new Brokerage( new StockExchange() ),
            "Test",
            "Test" );
        trade.receiveMessage( "Test" );
        assertTrue( trade.hasMessages() );
    }


    @Test
    public void traderToString()
    {
        Trader trade = new Trader( new Brokerage( new StockExchange() ),
            "Test",
            "Test" );
        assertNotNull( trade.toString() );
    }


    @Test
    public void traderCompareTo()
    {
        Trader a = new Trader( new Brokerage( new StockExchange() ),
            "aaaa",
            "aaaa" );
        Trader b = new Trader( new Brokerage( new StockExchange() ),
            "aaaa",
            "aaaa" );

        assertTrue( a.compareTo( b ) == 0 );

        b = new Trader( new Brokerage( new StockExchange() ), "bbbb", "aaaa" );

        assertTrue( a.compareTo( b ) == -1 );

        a = new Trader( new Brokerage( new StockExchange() ), "cccc", "aaaa" );

        assertTrue( a.compareTo( b ) == 1 );

    }


    @Test
    public void traderEquals()
    {
        Trader a = new Trader( new Brokerage( new StockExchange() ),
            "aaaa",
            "aaaa" );
        Trader b = new Trader( new Brokerage( new StockExchange() ),
            "aaaa",
            "aaaa" );

        assertTrue( a.equals( b ) );

        b = new Trader( new Brokerage( new StockExchange() ), "bbbb", "aaaa" );

        assertFalse( a.equals( b ) );
    }


    @Test
    public void traderReceiveMessage()
    {
        Trader t = new Trader( new Brokerage( new StockExchange() ),
            "aaaa",
            "aaaa" );

        t.receiveMessage( "Mhey" );
        assertTrue( t.hasMessages() );
    }


    @Test
    public void traderGetQuote()
    {
        StockExchange a = new StockExchange();
        a.listStock( symbol, symbol, price );
        Trader t = new Trader( new Brokerage( a ), "aaaa", "aaaa" );
        t.getQuote( "GGGL" );
        String mes = "";
        Queue<String> q = t.mailbox();
        while ( !q.isEmpty() )
        {
            mes += q.remove();
        }
        assertTrue( mes.contains( "GGGL" ) );

    }


    @Test
    public void traderPlaceOrder()
    {
        StockExchange a = new StockExchange();
        a.listStock( symbol, symbol, price );
        Trader t = new Trader( new Brokerage( a ), "aaaa", "aaaa" );
        t.placeOrder( new TradeOrder( t,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price ) );
        String mes = "";
        Queue<String> q = t.mailbox();
        while ( !q.isEmpty() )
        {
            mes += q.remove();
        }
        assertTrue( mes.contains( "GGGL" ) );

    }


    @Test
    public void traderQuit()
    {
        Brokerage a = new Brokerage( new StockExchange() );
        Trader t = new Trader( a, "aaaa", "aaaa" );
        t.quit();
        assertTrue( true );

    }


    // --Test Brokerage
    @Test
    public void brokerageConstructor()
    {
        Brokerage test = new Brokerage( null );
        String toStr = test.toString();
        // System.out.println( toStr );
        assertTrue( "<<Null Brokerage Contstructor>>",
            toStr.contains( "StockExchange exchange:null" ) );
    }


    @Test
    public void brokerageAddUser()
    {
        Brokerage test = new Brokerage( null );
        int val = test.addUser( "A", "A" );
        assertTrue( val == -1 );
        val = test.addUser( "ajinkya", "a" );
        assertTrue( val == -2 );
        val = test.addUser( "ajinkya", "ajinkya" );
        assertTrue( val == 0 );
        val = test.addUser( "ajinkya", "ajinkya" );
        assertTrue( val == -3 );
    }


    @Test
    public void brokerageLogin()
    {
        Brokerage test = new Brokerage( null );
        int val = test.login( "ajinkya", "ajinkya" );
        assertTrue( val == -1 );
        test.addUser( "ajinkya", "ajinkya" );
        val = test.login( "ajinkya", "aj" );
        assertTrue( val == -2 );
        val = test.login( "ajinkya", "ajinkya" );
        assertTrue( val == 0 );
        val = test.login( "ajinkya", "ajinkya" );
        assertTrue( val == -3 );
    }


    @Test
    public void brokerageLogout()
    {
        Brokerage test = new Brokerage( null );
        test.addUser( "ajinkya", "ajinkya" );
        test.logout( new Trader( test, "ajinkya", "ajinkya" ) );
        int val = test.login( "ajinkya", "ajinkya" );
        assertTrue( val == 0 );
    }


    @Test
    public void brokerageGetQuote()
    {
        StockExchange add = new StockExchange();
        Brokerage test = new Brokerage( add );
        Trader t = new Trader( test, "ajinkya", "ajinkya" );
        add.listStock( "GGGL", "Google", 1.00 );
        test.getQuote( "GGGL", t );
        String mes = "";
        Queue<String> q = t.mailbox();
        while ( !q.isEmpty() )
        {
            mes += q.remove();
        }
        assertTrue( mes.contains( "GGGL" ) );
    }


    @Test
    public void brokeragePlaceOrder()
    {
        StockExchange add = new StockExchange();
        Brokerage test = new Brokerage( add );
        Trader t = new Trader( test, "ajinkya", "ajinkya" );
        TradeOrder order = new TradeOrder( t,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        add.listStock( "GGGL", "Google", 1.00 );
        test.placeOrder( order );
        String mes = "";
        Queue<String> q = t.mailbox();
        while ( !q.isEmpty() )
        {
            mes += q.remove();
        }
        // System.out.println( mes );
        assertTrue( mes.contains( "New order:" ) );
    }


    @Test
    public void brokerageToString()
    {
        Brokerage test = new Brokerage( null );
        assertNotNull( test.toString() );
    }


    @Test
    public void brokerageGetTraders()
    {
        Brokerage test = new Brokerage( null );
        assertNotNull( test.getTraders() );
    }
    
    @Test
    public void brokerageGetLoggedTraders()
    {
        Brokerage test = new Brokerage( null );
        assertNotNull( test.getLoggedTraders() );
    }
    // --Test StockExchange

    @Test
    public void stockExchangeConstructor()
    {
        StockExchange s = new StockExchange();

        assertNotNull( s.getListedStocks() );

        String aa = s.toString();

        assertTrue( aa.contains( "StockExchange" ) );
    }


    @Test
    public void stockExchangeToString()
    {
        StockExchange s = new StockExchange();

        assertNotNull( s.toString() );
    }


    @Test
    public void stockExchangeGetQuote()
    {
        StockExchange s = new StockExchange();
        s.listStock( symbol, symbol, price );
        String aa = s.getQuote( symbol );
        assertTrue( aa.contains( "GGGL" ) );
    }


    @Test
    public void stockExchangePlaceOrder()
    {
        StockExchange s = new StockExchange();
        Trader a = new Trader( new Brokerage( s ), "ajinkya", "ajinkya" );
        s.listStock( symbol, symbol, price );
        s.placeOrder( new TradeOrder( a,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price ) );
        String mes = "";
        Queue<String> q = a.mailbox();
        while ( !q.isEmpty() )
        {
            mes += q.remove();
        }
        assertTrue( mes.contains( "GGGL" ) );
    }


    @Test
    public void stockExchangeGetListedStocks()
    {
        StockExchange s = new StockExchange();
        assertTrue( s.getListedStocks().isEmpty() );
    }


    @Test
    public void stockExchangeListStock()
    {
        StockExchange s = new StockExchange();
        s.listStock( symbol, symbol, price );
        Map<String, Stock> m = s.getListedStocks();
        assertTrue( m.containsKey( symbol ) );
    }


    @Test
    public void stockConstructor()
    {
        Stock test = new Stock( symbol, symbol, price );
        String toStr = test.toString();
        assertTrue( "<<Valid Stock Contstructor>>",
            toStr.contains( "java.lang.String stockSymbol:" + symbol )
                && toStr.contains( "java.lang.String companyName:" + symbol )
                && toStr.contains( "java.lang.String companyName:" + symbol )
                && toStr.contains( "int volume:" + 0 ) );
    }

    @Test
    public void stockGetBuyOrders()
    {
        Stock t = new Stock( symbol, symbol, price );
        assertNotNull( t.getBuyOrders() );
    }
    
    @Test
    public void stockGetSellOrders()
    {
        Stock t = new Stock( symbol, symbol, price );
        assertNotNull( t.getSellOrders() );
    }
    
    @Test
    public void stockGetQuote()
    {
        StockExchange add = new StockExchange();
        Brokerage test = new Brokerage( add );
        Trader t = new Trader( test, "ajinkya", "ajinkya" );
        add.listStock( "GGGL", "Google", 1.00 );
        test.getQuote( "GGGL", t );
        String mes = "";
        Queue<String> q = t.mailbox();
        while ( !q.isEmpty() )
        {
            mes += q.remove();
        }
        assertTrue( mes.contains( "GGGL" ) );
    }


    @Test
    public void stockPlaceOrder()
    {
        StockExchange add = new StockExchange();
        Brokerage test = new Brokerage( add );
        Trader t = new Trader( test, "ajinkya", "ajinkya" );
        TradeOrder order = new TradeOrder( t,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        add.listStock( "GGGL", "Google", 1.00 );
        test.placeOrder( order );
        String mes = "";
        Queue<String> q = t.mailbox();
        while ( !q.isEmpty() )
        {
            mes += q.remove();
        }
        // System.out.println( mes );
        assertTrue( mes.contains( "New order:" ) );
    }

    @Test
    public void stockExecuteOrders()
    {
        String name = "Google";

        Trader trader = new Trader( null, "ajinkya", "ajinkya" );

        Stock st = new Stock( symbol, name, price );

        // both limit orders, break case
        TradeOrder a = new TradeOrder( trader,
            symbol,
            buyOrder,
            !marketOrder,
            numShares - 1,
            price - 1 );
        
        st.placeOrder( a );

        TradeOrder b = new TradeOrder( trader,
            symbol,
            !buyOrder,
            !marketOrder,
            numShares,
            price );
        
        st.placeOrder( b );

        st.executeOrders();
        
        assertTrue( !st.getBuyOrders().isEmpty() );
        assertTrue( !st.getSellOrders().isEmpty() );

        // both limit orders, reg case
        a = new TradeOrder( trader,
            symbol,
            buyOrder,
            !marketOrder,
            numShares - 1,
            price + 1 );
        st.placeOrder( a );

        b = new TradeOrder( trader,
            symbol,
            !buyOrder,
            !marketOrder,
            numShares,
            price - 1 );
        st.placeOrder( b );

        st.executeOrders();
        assertTrue( st.getBuyOrders().isEmpty() );
        assertTrue( !st.getSellOrders().isEmpty() );

        // buy is limit, sell is market
        a = new TradeOrder( trader,
            symbol,
            buyOrder,
            !marketOrder,
            numShares - 1,
            price + 1 );
        st.placeOrder( a );

        b = new TradeOrder( trader,
            symbol,
            !buyOrder,
            marketOrder,
            numShares,
            price );
        st.placeOrder( b );

        st.executeOrders();
        
        assertTrue( st.getBuyOrders().isEmpty() );
        assertTrue( !st.getSellOrders().isEmpty() );

        // buy is market, sell is limit
        a = new TradeOrder( trader,
            symbol,
            buyOrder,
            marketOrder,
            numShares - 1,
            price + 1 );
        st.placeOrder( a );

        b = new TradeOrder( trader,
            symbol,
            !buyOrder,
            !marketOrder,
            numShares,
            price );
        st.placeOrder( b );

        st.executeOrders();
        assertTrue( st.getBuyOrders().isEmpty() );
        assertTrue( !st.getSellOrders().isEmpty() );

        // both market orders
        a = new TradeOrder( trader,
            symbol,
            buyOrder,
            marketOrder,
            numShares - 1,
            price + 1 );
        st.placeOrder( a );

        b = new TradeOrder( trader,
            symbol,
            !buyOrder,
            marketOrder,
            numShares,
            price );
        st.placeOrder( b );

        st.executeOrders();
        assertTrue( st.getBuyOrders().isEmpty() );
        assertTrue( !st.getSellOrders().isEmpty() );
    }

    public void stockToString()
    {
        Stock test = new Stock( symbol, symbol, price );
        assertNotNull( test.toString() );
    }

    // Remove block comment below to run JUnit test in console
    /*
     * public static junit.framework.Test suite() { return new
     * JUnit4TestAdapter( JUSafeTradeTest.class ); }
     * 
     * public static void main( String args[] ) {
     * org.junit.runner.JUnitCore.main( "JUSafeTradeTest" ); }
     */
}
