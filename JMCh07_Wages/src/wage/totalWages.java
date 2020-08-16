package wage;

public class totalWages
{
    double wages;
    int hours;
    double rate;
    
    public double totalWages (int hours, double rate)
    {
        if (hours <= 40)
        {
            wages = hours * rate;
        }
        else
        {
            wages = hours * rate * 1.5;
        }      
        return wages;
    }
}
