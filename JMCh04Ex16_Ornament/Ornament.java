import java.awt.*;
import javax.swing.*;

/**
 * This program draws an ornament of nested triangles
 * 
 * @author Eric Cheng   
 * @version 16 Septembre 2014
 * 
 * @author Period - 6
 * @author Assignment - Ch04 Ex4-16 Ornament
 * 
 * @author Sources - Eric Cheng
 */
public class Ornament extends JPanel
{
    /** 
     * Graphics class + Paint component
     * Sets the dimensions of the triangles
     * 
     * @param g = Graphics object
     */
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g ); // Call JPanel's paintComponent method
                                   // to paint the background
        drawTriangles( g, 100, 80, 64 );
    }

    /**
     * Draws an ornament made of triangles in Graphics g with the base midpoint
     * at (x, y) and base half-length r
     * 
     * @param g = Graphics object
     * @param x = Base length
     * @param y = Y value/ Height
     * @param r = center/ midpoint
     */
    public void drawTriangles( Graphics g, int x, int y, int r )
    {
        g.drawLine( x - r , y , x + r , y ); // Base
        g.drawLine( x - r , y , x , y - r );
        g.drawLine( x + r , y , x, y - r );
        
        int halfR = r / 2; // New base midpoint
        
        g.drawLine( ( x - halfR ) , y - halfR , x , y );
        g.drawLine( ( x + halfR ) , y - halfR , x , y );
    
        if ( r > 4 ) // Recursive method
        {
            drawTriangles( g, x - halfR, y , halfR ); // Left
            drawTriangles( g, x + halfR, y , halfR ); // Right
        }
    }

    /**
     * Main method for the ornaments lab
     * 
     * @param args = arguments array
     */
    public static void main( String[] args )
    {
        JFrame w = new JFrame( "Triangles" );
        w.setBounds( 300, 300, 200, 120 );
        w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Ornament panel = new Ornament();
        panel.setBackground( Color.WHITE );
        Container c = w.getContentPane();
        c.add( panel );
        w.setResizable( false );
        w.setVisible( true );
    }
}
