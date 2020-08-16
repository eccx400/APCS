public class wageTest
{
   public static void main(String[] args)
   {
       Wages wage = new Wages();
       
       double doge = wage.totalWages( 45, 12.50 );
       
       System.out.println (doge);
   }
}