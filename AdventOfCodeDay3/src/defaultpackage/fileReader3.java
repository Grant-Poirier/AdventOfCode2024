package defaultpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class fileReader3 {

    // Extract the first valid multiplication command from the given line
    public String extractMult(String line) {
        int start = line.indexOf("mul(");
        if (start == -1) {
            return ""; // No valid command found
        }

        int end = line.indexOf(")", start); // Find the closing parenthesis after "mul("
        if (end == -1) {
            return ""; // No valid closing parenthesis, invalid command
        }

        // Extract and return the command
        return line.substring(start, end + 1); // Include the closing parenthesis
    }

    // Parse and compute the result of a valid "mul(X,Y)" command
    public int computeMult(String command) {
        if (command.isEmpty()) {
            return 0; // No command to process
        }

        try {
            // Extract the numbers inside "mul(X,Y)"
            int start = command.indexOf("(");
            int comma = command.indexOf(",");
            int end = command.indexOf(")");

            int num1 = Integer.parseInt(command.substring(start + 1, comma).trim());
            int num2 = Integer.parseInt(command.substring(comma + 1, end).trim());

            return num1 * num2; // Return the product
        } catch (Exception e) {
            return 0; // Handle any parsing errors gracefully
        }
    }

    public static void main(String[] args) {
        File file = new File("input3.txt");
        fileReader3 processor = new fileReader3();
        int totalSum = 0;

        try {
            Scanner scanner = new Scanner(file);

            // Read each line and process it
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                while (true) {
                    // Extract the next valid "mul" command
                    String command = processor.extractMult(line);

                    if (command.isEmpty()) {
                        break; // No more valid commands in the line
                    }

                    // Compute the result of the command and add to the total sum
                    totalSum += processor.computeMult(command);

                    // Remove the processed command from the line
                    line = line.substring(line.indexOf(command) + command.length());
                }
            }

            scanner.close();
            System.out.println("Total sum of valid `mul` commands: " + totalSum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}