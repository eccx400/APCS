package newTestLab;

import java.util.*;

public class printX
{
    public void printX(int n)
    {
      if (n <= 0)
        System.out.print(0);
      else
      {
        printX(n - 1);
        System.out.print(n);
        printX(n - 2);
      }
    }
    
    public static void main(String[] args)
    {
        printX x = new printX();
        x.printX(3);
    }
}
