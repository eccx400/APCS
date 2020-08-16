/**
 * This is the main method to test the classes
 * 
 * @author Eric Cheng
 * @version 13 October 2014
 * @author Period - 2
 * @author Assignment - A11_1BackToSchool
 * @author Sources - Eric Cheng
 */
public class BackToSchool
{
    /**
     * @param args
     *            = arguments array
     */
    public static void main(String[] args  )
    {
        Person bob = new Person( "Coach Bob", 27, "M" );
        System.out.println( bob );

        Student lynne = new Student( "Lynne Brooke", 16, "F", "HS95129", 3.5 );
        System.out.println( lynne );

        Teacher mrJava = new Teacher( "Duke Java",
            34,
            "M",
            "Computer Science",
            50000 );
        System.out.println( mrJava );

        CollegeStudent ima = new CollegeStudent( "Ima Frosh",
            18,
            "F",
            "UCB123",
            4.0,
            1,
            "English" );
        System.out.println( ima );
    }
}
