/**
 * Implements the minimum requirements specified by the Animal interface
 * 
 * @author George Peck
 * @version June 22, 2003
 * 
 *          Period - 1-7 Assignment - A29.1 - Old MacDonald
 * 
 *          Sources - Roger Frank
 */
public class Cow implements Animal
{
    private String classification;

    private String music;


    /**
     * Initializes a newly created Cow object so that it represents an Animal of
     * the specified type that makes the specified sound.
     * 
     * @param type
     *            the type of Cow
     * @param sound
     *            the sound the Cow makes
     */
    public Cow( String type, String sound )
    {
        classification = type;
        music = sound;
    }


    /**
     * Gets the sound of the type
     * 
     * @return the sound of the cow
     */
    public String getSound()
    {
        return music;
    }


    /**
     * Gets the classification of the type
     * 
     * @return the type of the cow
     */
    public String getType()
    {
        return classification;
    }
}
