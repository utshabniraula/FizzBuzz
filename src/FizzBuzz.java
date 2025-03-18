/**
 * FizzBuzz Program
 * This program takes three command-line arguments:
 * - The first number represents the "Fizz" condition.
 * - The second number represents the "Buzz" condition.
 * - The third number represents the range (upper limit) up to which the FizzBuzz logic will be applied.
 *
 * Author: Utshab Niraula
 */

public class FizzBuzz {
    public static void main(String[] args) {
        // Ensure exactly three arguments are provided
        if (args.length != 3) {
            System.err.println("Please provide exactly 3 command-line arguments.");
        } else {
            // Parse the command-line arguments to integers
            int arg_1 = Integer.parseInt(args[0]); // First number (Fizz condition)
            int arg_2 = Integer.parseInt(args[1]); // Second number (Buzz condition)
            int arg_3 = Integer.parseInt(args[2]); // Upper limit for the loop

            // Iterate from 1 to the given upper limit
            for (int i = 1; i <= arg_3; i++) {
                // Check if the number is divisible by both arg_1 and arg_2
                if (i % arg_1 == 0 && i % arg_2 == 0) {
                    System.out.println("FizzBuzz");
                } else if (i % arg_1 == 0) { // Check if divisible by arg_1
                    System.out.println("Fizz");
                } else if (i % arg_2 == 0) { // Check if divisible by arg_2
                    System.out.println("Buzz");
                } else { // If none of the above, print the number itself
                    System.out.println(i);
                }
            }
        }
    }
}
