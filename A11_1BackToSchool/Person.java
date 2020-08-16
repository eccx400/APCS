/**
 * This is the person class which returns the information of 
 * every person
 * 
 * @author Eric Cheng
 * @version 13 October 2014
 * @author Period - 2
 * @author Assignment - A11_1BackToSchool
 * @author Sources - Eric Cheng
 */
public class Person
{
    private String myName; // name of the person
    private int myAge; // person's age
    private String myGender; // 'M' for male, 'F' for female

    /**
     * @param name
     *            = name
     * @param age
     *            = age
     * @param gender
     *            = gender
     */
    public Person( String name, int age, String gender )
    {
        myName = name;
        myAge = age;
        myGender = gender;
    }

    /**
     * @return the name of the person
     */
    public String getName()
    {
        return myName;
    }

    /**
     * @return the age of the person
     */
    public int getAge()
    {
        return myAge;
    }

    /**
     * @return the gender of the person
     */
    public String getGender()
    {
        return myGender;
    }

    /**
     * @param name
     *            = sets the name of the person with given name
     */
    public void setName( String name )
    {
        myName = name;
    }

    /**
     * @param age
     *            = sets the age of the person with a given age
     */
    public void setAge( int age )
    {
        myAge = age;
    }

    /**
     * @param gender
     *            = sets the gender of the person with a given gender
     */
    public void setGender( String gender )
    {
        myGender = gender;
    }

    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return myName + ", age: " + myAge + ", gender: " + myGender;
    }
}