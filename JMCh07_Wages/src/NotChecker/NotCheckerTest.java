package NotChecker;

    public class NotCheckerTest
    {
        public static void main(String[] args)
        {
            Checker aChecker = new SubstringChecker( "artichokes" );
            Checker kChecker = new SubstringChecker( "kale" );
        
            Checker a = new NotChecker(aChecker);
            Checker k = new NotChecker(kChecker);
       
        }
    }