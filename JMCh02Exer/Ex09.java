/**
 * This program prints out a robot face
 * 
 * @author Eric Cheng
 * @date 8/21/14
 * @Period 2
 * @Source Eric Cheng
 */
public class Ex09 {
	/**
	 * 
	 * @param args
	 *            = arguments array
	 */
	public static void main(String[] args) {
		first();
		second();
		third();
	}

	/**
	 * For loop for the first row, and prints out second row
	 */
	public static void first() {
		// Print two spaces to "center" the x's
		System.out.print("   ");

		// Used a for loop to iterate the x's 5 times
		for (int x = 0; x < 5; x++) {
			System.out.print("x");
		}

		System.out.println("\n  x     x"); // Second Line
	}

	/**
	 * Prints out middle section of robot face
	 */
	public static void second() {
		System.out.println("((  o o  ))"); // Third Line
		System.out.println("  |  V  |"); // Fourth Line
		System.out.println("  | === |"); // Fifth Line
	}

	/**
	 * Prints out last row using the same for loop format in first part
	 */
	public static void third() {
		// Print two spaces to "center" the dashes
		System.out.print("   ");

		// Used a for loop to iterate the dashes 5 times
		for (int x = 0; x < 5; x++) {
			System.out.print("-");
		}
	}
}
