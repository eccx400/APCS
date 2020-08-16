/**
 * This is a farm of animals that make sounds; Pig
 * 
 * @author Eric Cheng
 * @version 25 October 2014
 * 
 *          Period - 2 Assignment - A29.1 Old MacDonald
 * 
 *          Sources - Eric Cheng
 */
class Pig implements Animal
{
    private String classification;

    private String music;


    /**
     * Initializes a newly created Chick object so that it represents an Animal
     * of the specified type that makes the specified sound.
     * 
     * @param type
     *            the type of Chick
     * @param sound
     *            the sound the Chick makes
     */
    public Pig( String type, String sound )
    {
        classification = type;
        music = sound;
    }


    /**
     * Gets the sound of the type
     * 
     * @return the sound of the pig
     */
    public String getSound()
    {
        return music;
    }


    /**
     * Gets the classification of the type
     * 
     * @return the classification of the pig
     */
    public String getType()
    {
        return classification;
    }
}