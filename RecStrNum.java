import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
* This program uses recursion to determine,
* length of string.
*
* @author  Sarah Andrew
* @version 1.0
*
* @since 2023-03-05.
*/

public final class RecStrNum {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private RecStrNum() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        // Pass path to file as parameter.
        final File file = new File("input.txt");
        final File fileOut = new File("output.txt");

        // Usage of try catch to detect error.
        try {
            // Create FileWriter object to write to file.
            final FileWriter fW = new FileWriter(fileOut);
            // Create Scanner object to read from file.
            final Scanner sc = new Scanner(file);
            // Create PrintWriter object to write to file.
            final PrintWriter write = new PrintWriter(fW);

            while (sc.hasNextLine()) {
                // Read line as string.
                final String newLine = sc.nextLine();

                // Declare variable.
                final String aStr = newLine;

                // Checking for empty lines
                // blank inputs.
                if (newLine.isEmpty()) {
                    // Display to user.
                    write.println("No strings found on line.");
                    System.out.println("No strings found on line.");

                    // Set the length of the string to 0.
                    final int lengthStr = 0;

                    // Display to user.
                    System.out.println("Therefore, length of string is: "
                            + lengthStr);
                    write.println("Therefore, length of string is: "
                            + lengthStr);
                    continue;
                }

                // Call function.
                final int lengthStr =
                    strLength(newLine);

                // Display results.
                System.out.println("The original string is: " + aStr);
                System.out.println("The length of the string is: "
                        + lengthStr);

                // Write to console.
                write.println("The original string is: " + aStr);
                write.println("The length of string is: "
                    + lengthStr);
            }
            // Closes scanner & writer.
            write.close();
            sc.close();
        } catch (IOException error) {
            // Displays error to user.
            System.out.println("An error occurred: "
                    + error.getMessage());
        }
    }

    /**
    * This function uses recursion to
    * determine length of string.
    * Reference from https://www.geeksforgeeks.org/program-
    * for-length-of-a-string-using-recursion/.
    *
    * @param someStr passed
    * @return someStr.
    */

    public static int strLength(String someStr) {
        // Checking to see if end of line
        // is reached.
        if ("".equals(someStr)) {
            // Returns value to main.
            return 0;
        // Case if the string is length of
        // 1.
        } else if (someStr.length() == 1) {
            return 1;
        } else {
            // Return the length of string,
            // whist, calling the function
            // recursively.
            return 1 + strLength(someStr.substring(1));
        }
    }
}
