package Applications;

import java.util.Scanner;
import java.util.Stack;
/*
    We use Scanner to read input data, and hasNext() method to check for the end of the input (EOF).
    We create a Stack<String> to store the data elements.
    We read data elements one by one and push them onto the stack until reaching EOF.
    Then, we pop data elements from the stack and print them, effectively reversing the order of the input data.
    Finally, we close the scanner to release system resources.
 */
public class DataReverser {
    public static void main(String[] args) {
        // Create a scanner to read input
        Scanner scanner = new Scanner(System.in);
        // Create a stack to store data elements
        Stack<String> stack = new Stack<>();

        // Read data until EOF
        while (scanner.hasNext()) {
            String data = scanner.next(); // Read next data element
            stack.push(data); // Push data onto the stack
        }

        // Print data elements in reverse order
        while (!stack.isEmpty()) {
            String reversedData = stack.pop(); // Pop data from the stack
            System.out.println(reversedData); // Print the reversed data
        }

        // Close the scanner
        scanner.close();
    }
}
