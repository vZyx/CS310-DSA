package Applications;

import java.util.Stack;

/*
This example demonstrates how a stack can be used to manage nested function calls.
It iterates over an array of function names representing nested calls and uses a stack to keep track of the order of function calls.
The functions are then called in reverse order from the stack, simulating the execution of nested function calls.
*/
public class NestedFunctionCalls {
    public static void main(String[] args) {
        // Define a list of nested function calls
        String[] calls = {"func1", "func2", "func3", "func4", "func5"};

        // Call the outermost function
        callNestedFunction(calls);

        // another example
        /*
        In this example, the main method calls the foo method with an integer argument i.
        Inside foo, another integer variable k is defined and assigned the value of j + 1, then bar is called with k as an argument.
        Finally, bar method is called, and in a real application, actions would be performed inside it.

         */
        int i = 5;
        foo(i);
    }

    // Method to perform nested function calls using a stack
    public static void callNestedFunction(String[] calls) {
        Stack<String> functionStack = new Stack<>();

        // Push the outermost function onto the stack
        functionStack.push(calls[0]);
        System.out.println("Calling function: " + calls[0]);

        // Iterate over the remaining function calls
        for (int i = 1; i < calls.length; i++) {
            String currentFunction = calls[i];

            // Determine the depth of the nested function call
            int depth = functionStack.size() + 1;

            // Print the depth and the current function being called
            System.out.println("  ".repeat(depth) + "Calling function: " + currentFunction);

            // Push the current function onto the stack
            functionStack.push(currentFunction);
        }

        // Perform the nested function calls in reverse order
        System.out.println("Performing nested function calls:");
        while (!functionStack.isEmpty()) {
            String function = functionStack.pop();
            System.out.println("Calling function: " + function);
            // In a real application, you would call the function here
            // For demonstration purposes, we'll just print the function name
        }
    }

    public static void foo(int j) {
        int k;
        k = j + 1; // k = 5(i) + 1
        bar(k);
    }

    public static void bar(int m) {
        // In a real application, you would perform actions here
        // For demonstration purposes, we'll just print the value of m
        System.out.println("Value of m in bar(): " + m);
    }
}
