public class Wages
{
    private double wages;
    private int hours;
    private double rate;
    
    public double totalWages (int hours, double rate)
    {
        if (hours <= 40)
        {
            wages = 40 * rate;
        }
        else
        {
            wages = ((hours - 40) * (1.5 * rate)) + (40 * rate);
        }      
        return wages;
    }
}