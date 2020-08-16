public class Puzzle
{
    private String message = "Hello, World";
    
    public void hello()
    {
        System.out.println(message);
    }
    
    public static void main(String[] args)
    {
        Puzzle puzzle = new Puzzle();
        puzzle.hello();
    }
    
    /**
     * Other method
     */
    /* private static String message = "Hello, World";
    
    public static void hello()
    {
        System.out.println(message);
    }
    
    public static void main(String[] args)
    {
        hello();
    }*/
}