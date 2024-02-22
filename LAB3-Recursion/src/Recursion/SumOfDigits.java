package Recursion;
/*
Given a non-negative integer n, return the sum of its digits recursively (no loops).
Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6),
while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
*/
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
        int num1 = 126;
        int num2 = 5;
        int num3 = -8;

        // Calculate and print the sum of digits for each test case
        System.out.println("Sum of digits of " + num1 + ": " + sumOfDigits(num1));
        System.out.println("Sum of digits of " + num2 + ": " + sumOfDigits(num2));
        System.out.println("Sum of digits of " + num3 + ": " + sumOfDigits(num3));
    }
}
