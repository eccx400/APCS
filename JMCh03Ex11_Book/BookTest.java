/**
 * This is a class that tests the Book class.
 *
 * @author Eric Cheng
 * @version 8/25/2014
 * @author Period: 2
 * @author Assignment: JMCh03Ex11_Book
 *
 * @author Sources: Eric Cheng
 */
public class BookTest
{
    /**
     * The main method in this class checks the Book operations for consistency.
     * 
     * @param args
     *            is not used.
     */
    public static void main( String[] args )
    {
        Book livre = new Book( 3 ); // New object

        livre.getNumPages();// Get Page #, then iterate 3 times
        System.out.println( livre.numPages );
        livre.getCurrentPage();
        System.out.println( livre.currentPage );
        livre.nextPage();
        livre.getCurrentPage();
        System.out.println( livre.currentPage );
        livre.nextPage();
        livre.getCurrentPage();
        System.out.println( livre.currentPage );
        livre.nextPage();
        livre.getCurrentPage();
        System.out.println( livre.currentPage );
    }
}
