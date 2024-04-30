package Applications;

import java.util.Stack;

public class MissingBracketsChecker {

    public static boolean checkMissingBrackets(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false; // There's a closing bracket without corresponding opening bracket
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') || (ch == ']' && top != '[') || (ch == '}' && top != '{')) {
                    return false; // Mismatched opening and closing brackets
                }
            }
        }

        return stack.isEmpty(); // Stack should be empty if all brackets are matched
    }

    public static void main(String[] args) {
        String expression1 = "{[()]()}";
        String expression2 = "{[(])}";
        String expression3 = "{{[[(())]]}}";

        System.out.println("Expression 1 has missing brackets: " + checkMissingBrackets(expression1));
        System.out.println("Expression 2 has missing brackets: " + checkMissingBrackets(expression2));
        System.out.println("Expression 3 has missing brackets: " + checkMissingBrackets(expression3));
    }
}

