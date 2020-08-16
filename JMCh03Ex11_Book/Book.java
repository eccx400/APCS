/**
 * This is a program that creates a class book, and gets the current page and
 * then give the next one
 * 
 * @author Eric Cheng
 * @version 8/25/2014
 * @author Period: 2
 * @author Assignment: JMCh03Ex11_Book
 * 
 * @author Sources: Eric Cheng
 */
public class Book
{
    // implement data fields
    /**
     * Initiate numPages and currentPage
     */
    public int numPages;

    public int currentPage;


    // implement constructor
    /**
     * @param x
     *            = page#
     */
    public Book( int x )
    {
        currentPage = 1;
        numPages = x;
    }


    // implement methods
    /**
     * Get next page through increment
     */
    public void nextPage()
    {
        if ( currentPage < numPages )
        {
            currentPage++;
        }
    }


    /**
     * @return number page
     */
    public int getNumPages()
    {
        return numPages;
    }


    /**
     * @return current page
     */
    public int getCurrentPage()
    {
        return currentPage;
    }
}
