import java.awt.Color;


/**
 * Represents a tile of the specified color (colored block).
 *
 * @author George Peck
 * @version Nov 25, 2007
 *
 * @author Sources: Cay Horstmann
 */
public class Tile
{
    /**
     * 
     */
    private Color color;


    /**
     * @param color = given colour
     */
    public Tile( Color color )
    {
        this.color = color;
    }


    /**
     * Constructor
     * 
     * @return the current colour
     */
    public Color getColor()
    {
        return color;
    }


    /**
     * @param color = set the Colour
     */
    public void setColor( Color color )
    {
        this.color = color;
    }


    /**
     * String
     * 
     * @return = get the Text
     */
    public String getText()
    {
        return "";
    }
}
