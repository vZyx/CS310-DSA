package Applications;

import java.util.Stack;
/*

 */
public class ExpressionEvaluator {

    // Method to check if a given character is an operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    // Method to compare precedence of operators. This method assigns precedence values to operators. Higher precedence values indicate higher priority.
    private static int precedence(char operator) {
        switch(operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0; // For '('
        }
    }

    // Method to convert infix expression to postfix
    /* infixToPostfix(String infix) Method:
    This method converts an infix expression to postfix notation.
    It iterates over each character in the infix expression.
    If the character is a digit, it's added directly to the postfix string.
    If the character is an opening parenthesis '(', it's pushed onto the stack.
    If the character is a closing parenthesis ')', it pops operators from the stack and appends them to the postfix string until an opening parenthesis '(' is encountered.
    If the character is an operator (+, -, *, /), it compares its precedence with the top operator on the stack. If the precedence of the current operator is lower or equal, it pops operators from the stack and appends them to the postfix string until a lower-precedence operator or an opening parenthesis '(' is encountered. Then, the current operator is pushed onto the stack.
    Finally, it pops any remaining operators from the stack and appends them to the postfix string.
    */
    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : infix.toCharArray()) {
            if (Character.isDigit(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Discard '('
            } else if (isOperator(ch)) {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    //Method to evaluate postfix expression
    /*
    evaluatePostfix(String postfix) Method:
    This method evaluates a postfix expression and returns the result.
    It iterates over each character in the postfix expression.
    If the character is a digit, it's converted to an integer and pushed onto the stack.
    If the character is an operator (+, -, *, /), it pops the top two operands from the stack, performs the operation, and pushes the result back onto the stack.
    After processing all characters, the final result is the only element left on the stack.
     */
    public static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();

        for (char ch : postfix.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(ch - '0'); // Convert char to int
            } else if (isOperator(ch)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch(ch) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        // Example usage
        String infixExpression = "3 + 2 * 4";
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
        int result = evaluatePostfix(postfixExpression);
        System.out.println("Result: " + result);
    }
}
