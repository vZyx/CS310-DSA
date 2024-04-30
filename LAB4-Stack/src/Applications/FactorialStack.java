package Applications;

import java.util.Stack;
/*
In this implementation, we use a Stack<Integer> to keep track of the values of n during the recursion.
We push the initial value of n onto the stack, and then we iterate until the stack becomes empty.
During each iteration, we pop the current value of n from the stack and compute the factorial accordingly.
If n is greater than 1, we push n - 1 onto the stack for the next recursive call. This process continues until we reach the base case (n <= 1).
 */
public class FactorialStack {

    public static int factorial(int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(n); // Push initial value of n to the stack

        int result = 1;

        while (!stack.isEmpty()) {
            int currentN = stack.pop(); // Pop the current value of n from the stack

            if (currentN <= 1) {
                // Base case: return 1 when n <= 1
                result *= 1;
            } else {
                // Recursive case: compute factorial(n - 1) and multiply with n
                result *= currentN;
                stack.push(currentN - 1); // Push n - 1 to the stack for the next recursive call
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int x = factorial(3);
        System.out.println("Factorial of 3: " + x);
    }
}
