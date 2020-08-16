/**
 * This is the lowest in the hierarchy of the person class, and
 * is a subclass of the student class
 * 
 * @author Eric Cheng
 * @version 13 October 2014
 * @author Period - 2
 * @author Assignment - A11_1BackToSchool
 * @author Sources - Eric Cheng
 */
public class CollegeStudent extends Student
{
    /**
     * Gives the year
     */
    public int myYear;
    
    /**
     * Gives the major
     */
    public String myMajor;

    /**
     * @param name
     *            = name of person (person class)
     * @param age
     *            = age of person (person class)
     * @param gender
     *            = Gender of person (person class)
     * @param iD
     *            = id of student (student class)
     * @param gpa
     *            = gpa of student (student class)
     * @param year
     *            = year of student
     * @param major
     *            = major of student
     */
    public CollegeStudent(
        String name,
        int age,
        String gender,
        String iD,
        double gpa,
        int year,
        String major )
    {
        super( name, age, gender, iD, gpa );
        myYear = year;
        myMajor = major;
    }

    /**
     * @return = year
     */
    public int getYear()
    {
        return myYear;
    }

    /**
     * @return = major
     */
    public String getMajor()
    {
        return myMajor;
    }

    /**
     * Sets year = getYear
     * @param fromage = given Year
     */
    public void setYear(int fromage)
    {
        myYear = fromage;
    }

    /**
     * sets Major
     * @param s = given Major
     */
    public void setMajor(String s)
    {
        myMajor = s;
    }

    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", year: " + myYear + ", major: " + myMajor;
    }
}
