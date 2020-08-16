/**
 * This is the in the hierarchy of the person class, and gives
 * the information of the student
 * 
 * @author Eric Cheng
 * @version 13 October 2014
 * @author Period - 2
 * @author Assignment - A11_1BackToSchool
 * @author Sources - Eric Cheng
 */
public class Student extends Person
{
    /**
     * Gives idnum 
     */
    public static String myIdNum; // Student Id Number
    
    /** 
     * Gives the gpa
     */
    public static double myGPA; // grade point average


    /**
     * @param name
     *            = name of the person (person class)
     * @param age
     *            = age of the person (person class)
     * @param gender
     *            = gender of the person (person class)
     * @param idNum
     *            = id number of the student
     * @param gpa
     *            = gpa of the studnet
     */
    public Student(
        String name,
        int age,
        String gender,
        String idNum,
        double gpa )
    {
        // use the super class' constructor
        super( name, age, gender );

        // initialize what's new to Student
        myIdNum = idNum;
        myGPA = gpa;
    }

    /**
     * @return gets the id number of the student
     */
    public String getIdNum()
    {
        return myIdNum;
    }

    /**
     * @return gets the GPA of the student
     */
    public double getGPA()
    {
        return myGPA;
    }

    /**
     * @param idNum
     *            = sets the Id number of the studnet with the given ID number
     */
    public void setIdNum( String idNum )
    {
        myIdNum = idNum;
    }

    /**
     * @param gpa
     *            = sets the GPA of the student with a given gpa
     */
    public void setGPA( double gpa )
    {
        myGPA = gpa;
    }

    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", student id: " + myIdNum + ", gpa: "
            + myGPA;
    }
}
