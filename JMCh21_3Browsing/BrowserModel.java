// import java.util.List;
import java.util.Stack;


/**
 *
 * @author Eric Cheng
 * @version 18 January 2015
 * @author Period: 2
 * @author Assignment: JMCh21_Browsing
 *
 * @author Sources: Eric Cheng
 */
public class BrowserModel
{
    private BrowserView myView;

    private Stack<Integer> backStk;

    private Stack<Integer> forwardStk;

    private int topLine = 0;


    /**
     * Constructor of the method
     * 
     * @param view
     *            = new browser view
     */
    public BrowserModel(BrowserView view)
    {
        myView = view;
        backStk = new Stack<Integer>();
        forwardStk = new Stack<Integer>();
        myView.update( topLine );
    }


    /**
     * Moves to the next text
     */
    public void forward()
    {
        if ( hasForward() )
        {
            backStk.push( topLine );
            topLine = forwardStk.pop();
            myView.update( topLine );
        }
    }


    /**
     * Moves to the previous text
     */
    public void back()
    {
        if ( hasBack() )
        {
            forwardStk.push( topLine );
            topLine = backStk.pop();
            myView.update( topLine );
        }
    }


    /**
     * Go back to home
     */
    public void home()
    {
        myView.update( 0 );
        topLine = 0;
    }


    /**
     * Move to the following text
     * 
     * @param x
     *            = input integer
     */
    public void followLink( int x )
    {
        myView.update( x );
        backStk.push( topLine );
        topLine = x;
    }


    /**
     * @return true if there is anything after
     */
    public boolean hasForward()
    {
        return !forwardStk.isEmpty();
    }


    /**
     * @return true if there is anything previous
     */
    public boolean hasBack()
    {
        return !backStk.isEmpty();
    }


    // The following are for test purposes only

    /**
     * @return the backStack
     */
    protected Stack<Integer> getBackStk()
    {
        return backStk;
    }


    /**
     * @return the forward stack
     */
    protected Stack<Integer> getForwardStk()
    {
        return forwardStk;
    }


    /**
     * @return the top line
     */
    protected int getTopLine()
    {
        return topLine;
    }
}
