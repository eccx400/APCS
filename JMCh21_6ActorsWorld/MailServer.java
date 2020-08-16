import java.util.*;


/**
 * Here is the Mailserver sector of the code
 * 
 * @author Eric Cheng
 * @version 20 January 2015
 * 
 * @author Period - 2
 * @author Assignment - JMCh21_ActorsWorld
 * 
 * @author Sources - Eric Cheng
 */
public class MailServer extends LinkedList<Message>
{
    /**
     * New set for actor
     */
    private Set<Actor> actors;


    /**
     * Constructor
     */
    public MailServer()
    {
        actors = new TreeSet<Actor>();
    }


    /**
     * Add the actor to the set
     * 
     * @param actor
     *            = the actor to be added
     */
    public void signUp( Actor actor )
    {
        actors.add( actor );
    }


    /**
     * Dispatches the message which either sends msg to the recipient indicated
     * in msg (by calling the recipients receive(msg)), or, if the recipient is
     * null, to all registered subscribers (except the sender).
     * 
     * @param msg
     *            = the message to be sent
     */
    public void dispatch( Message msg )
    {
        if ( msg.getRecipient() == ( null ) )
        {
            for ( Actor act : actors )
            {
                act.receive( msg );
            }
        }
        else
        {
            msg.getRecipient().receive( msg );
        }
    }


    // for testing purposes only

    /**
     * This code returns the actors
     * 
     * @return = gets the actors
     */
    protected Set<Actor> getActors()
    {
        return actors;
    }
}
