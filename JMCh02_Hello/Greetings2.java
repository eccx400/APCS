
/**
 *  This program represents the first assignment of the APCS class of the
 *  2014-2015 school year.
 *  This program uses the scanner method to allow the user to input their
 *  first and and last name, and using the information, returns the message
 *  "Hello...., Welcome to Java"
 *
 *  @author  Eric Cheng
 *  @version 8/20/2014
 *  @author  Period: 6
 *  @author  Assignment: JMCh02_Hello - Greetings2.java
 *
 *  @author  Sources: Eric Cheng
 */

import java.util.*;

public class Greetings2
{
	/**
	 * @param args = arguments array
	 */
	public static void main(String[] args)
	{
		//Allows the keyboard to input data
		Scanner kboard = new Scanner(System.in);
		
		//Allows user to enter first and last name
		System.out.print("Enter your first name: ");
		String firstName = kboard.nextLine();
		System.out.print("Enter your last name: ");
		String lastName = kboard.nextLine();
		
		//Prints out message
		System.out.println("Hello, " + firstName + " " + lastName);
		System.out.println("Welcome to Java!");
		
	}
}
