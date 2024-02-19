package Recursion;

public class SumOfDigits {
    public static int sumOfDigits(int n) {
        // Base case: if n is less than 10, return n itself
        if (n < 10) {
            return n;
        } else {
            // Recursive case: sum the rightmost digit (n % 10) with the sum of digits of the remaining number (n / 10)
            return n % 10 + sumOfDigits(n / 10);
        }
    }

    public static void main(String[] args) {
        // Test cases
        int num1 = 12345;
        int num2 = 9876;

        // Calculate and print the sum of digits for each test case
        System.out.println("Sum of digits of " + num1 + ": " + sumOfDigits(num1));
        System.out.println("Sum of digits of " + num2 + ": " + sumOfDigits(num2));
    }
}
