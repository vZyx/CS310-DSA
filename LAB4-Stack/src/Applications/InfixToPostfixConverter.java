package Applications;

import java.util.Stack;

import java.util.Stack;

public class InfixToPostfixConverter {

    public static String infixToPostfix(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> opStack = new Stack<>();

        for (char token : infixExpression.toCharArray()) {
            if (Character.isLetterOrDigit(token)) {
                postfix.append(token); // Operand, append to output
            } else if (token == '(') {
                opStack.push(token); // Left parenthesis, push to stack
            } else if (token == ')') {
                // Right parenthesis, pop stack until '(' is encountered
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    postfix.append(opStack.pop()); // Append operators to output
                }
                if (!opStack.isEmpty()) {
                    opStack.pop(); // Discard '('
                } else {
                    throw new IllegalArgumentException("Mismatched parentheses");
                }
            } else {
                // Operator encountered
                while (!opStack.isEmpty() && precedence(token) <= precedence(opStack.peek())) {
                    postfix.append(opStack.pop()); // Append higher precedence operators to output
                }
                opStack.push(token); // Push current operator to stack
            }
        }

        // Pop any remaining operators from stack to output
        while (!opStack.isEmpty()) {
            if (opStack.peek() == '(') {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            postfix.append(opStack.pop());
        }

        return postfix.toString();
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0; // Parentheses
        }
    }

    public static void main(String[] args) {
        String infixExpression = "A + B ";
        try {
            String postfixExpression = infixToPostfix(infixExpression);
            System.out.println("Infix Expression: " + infixExpression);
            System.out.println("Postfix Expression: " + postfixExpression);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

