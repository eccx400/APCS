/**
 * This is the in the hierarchy of the person class, and gives
 * the information of the teacher
 * 
 * @author Eric Cheng
 * @version 13 October 2014
 * @author Period - 2
 * @author Assignment - A11_1BackToSchool
 * @author Sources - Eric Cheng
 */
public class Teacher extends Person
{
    private double mySalary;
    private String mySubject;

    /**
     * @param myName
     *            = gets the name of the person (person class)
     * @param myAge
     *            = gets the age of the person (person class)
     * @param myGender
     *            = gets the gender of the person (person class)
     * @param subject
     *            = gets the subject of the teacher
     * @param salary
     *            = gets the salary of the teacher
     */
    public Teacher(
        String myName,
        int myAge,
        String myGender,
        String subject,
        double salary )
    {
        super( myName, myAge, myGender );
        mySubject = subject;
        mySalary = salary;
    }

    /**
     * @return gets the subject of the teacher
     */
    public String getSubject()
    {
        return mySubject;
    }

    /**
     * @return gets the salary of the teacher
     */
    public double getSalary()
    {
        return mySalary;
    }

    /**
     * sets the subject of the teacher with given subject
     * @param s = given subject
     */
    public void setSubject(String s)
    {
        mySubject = s;
    }

    /**
     * sets the salary of the teacher with the given subject
     * @param fromage = given salary
     */
    public void setSalary(double fromage)
    {
        mySalary = fromage;
    }

    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", subject: " + mySubject + ", salary: "
            + mySalary;
    }
}
