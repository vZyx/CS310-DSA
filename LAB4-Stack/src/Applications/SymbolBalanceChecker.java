package Applications;

import java.util.Stack;


/*
This program defines a SymbolBalanceChecker class with a checkBalance method that takes a string input and returns true if the symbols are balanced and false otherwise.
The main method demonstrates how to use this method with both balanced and unbalanced strings
 */
public class SymbolBalanceChecker {

    public static boolean checkBalance(String input) {
        Stack<Character> stack = new Stack<>();

        for (char symbol : input.toCharArray()) {
            if (isOpenSymbol(symbol)) {
                stack.push(symbol);
            } else if (isCloseSymbol(symbol)) {
                if (stack.isEmpty() || !matches(stack.pop(), symbol)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
    // return True or False
    private static boolean isOpenSymbol(char symbol) {
        return symbol == '(' || symbol == '[' || symbol == '{';
    }

    private static boolean isCloseSymbol(char symbol) {
        return symbol == ')' || symbol == ']' || symbol == '}';
    }

    private static boolean matches(char openSymbol, char closeSymbol) {
        return (openSymbol == '(' && closeSymbol == ')') || (openSymbol == '[' && closeSymbol == ']') || (openSymbol == '{' && closeSymbol == '}');
    }

    public static void main(String[] args) {
        String balanced = "{[()]}";
        String unbalanced = "{[()}";

        System.out.println("Balanced: " + checkBalance(balanced));
        System.out.println("Unbalanced: " + checkBalance(unbalanced));
    }
}
