/**
 * This is a named cow class, which has the name for the cow
 * 
 * @author Eric Cheng
 * @version 25 October 2014
 * 
 *          Period - 2 Assignment - A29.1 Old MacDonald
 * 
 *          Sources - Eric Cheng
 */
class NamedCow extends Cow
{
    private String nom;
    
    /**
     * constructor
     * 
     * @param type
     *            type of animal
     * @param name
     *            name of animal
     * @param sound
     *            sound of animal
     */
    public NamedCow( String type, String name, String sound )
    {
        super( type, sound );
        nom = name;
    }
 
    /**
     * 
     * returns the animal's name
     * 
     * @return the animal's name
     */
    public String getName()
    {
        return nom;
    }
}
