package NotChecker;

/*** Part (c) ***/
// TODO complete documentation

public class NotChecker implements Checker
{
    public Checker text;

    public NotChecker(Checker fromage)
    {
        text = fromage;
    }
    
    public boolean accept( String doge )
    {
        return !( text.accept( doge ));
    }
}
