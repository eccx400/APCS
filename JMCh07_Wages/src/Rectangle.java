public class Rectangle
{
    int w;
    int h;
    public Rectangle (int width, int height)
    {
        if (width > 0 && height > 0)
        {
            w = width;
            h = height;
        }
    }
    
    public Rectangle()
    {
        w = 1;
        h = 1;
    }
    
    public int isSquare( )
    {
        return w;
    }
    public void quadratize ( )
    {
        double area = w * h;
        double sideLength = Math.sqrt (area);
        int length = (int)Math.round(sideLength);
        int w = length;
        int h = length;
    
    }
    
    public static void main(String[] args)
    {
        Rectangle r1 = new Rectangle(1,1);
        Rectangle r2 = new Rectangle(1,3);
        Rectangle r3 = new Rectangle(1,4);
        Rectangle r4 = new Rectangle(1,5);
        Rectangle r5 = new Rectangle(1,6);
        
        r1.quadratize();
        r2.quadratize();
        r3.quadratize();
        r4.quadratize();
        r5.quadratize();
        
        System.out.println("Square: " + r1);
    }
}