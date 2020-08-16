/**
   This is a farm of animals that make sounds; Chick
  
   @author  Eric Cheng
   @version 25 October 2014

   Period - 2
   Assignment - A29.1 Old MacDonald

   Sources - Eric Cheng
 */
public class Chick implements Animal
{
    private String classification;

    private String music1;
    
    private String music2;


    /**
     * Constructor method of the Chick = Gets 2 sounds
     * 
     * @param type
     *            the type of Chick
     * @param sound1
     *            the 1st sound the Chick makes
     * @param sound2
     *            the 2nd sound the Chick makes
     */
    public Chick( String type, String sound1, String sound2 )
    {
        classification = type;
        music1 = sound1;
        music2 = sound2;
    }


    /**
     * Gets the sound of the type
     * 
     * @return the music according to conditions
     */
    public String getSound()
    {
        if ( music2.isEmpty() )
        {
            return music1;
        }

        if ( Math.random() > 0.5 )
        {
            return music1;
        }
        else
        {
            return music2;
        }
    }


    /**
     * Gets the classification of the type
     * 
     * @return the classification of the Chick
     */
    public String getType()
    {
        return classification;
    }
}