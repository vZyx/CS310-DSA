package Recursion;

public class Factorial {

    public static int factorial(int n)
    {
        // Base case: factorial of 0 is 1
        if (n == 0) return 1;
        else
        {
            //Recursive case: factorial of n is n multiplied by factorial of (n-1)
            return n * factorial(n - 1);
        }
    }


    public static void main(String[] args) {

        System.out.println( factorial(1) );

    }

}
