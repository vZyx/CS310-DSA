package Stack;

public class IntStack
{
    private int[] elements;
    private int top; // keeps track of the index of the top element in the stack. effectively serves as a pointer indicating the position of the topmost element in the stack array.
    private final int maxSize; // maxSize is the upper bound

    // Constructor
    public IntStack(int size) {
        this.maxSize = size;
        this.elements = new int[maxSize];
        this.top = -1; // Initialize top as -1 to indicate an empty stack
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }


    // Check if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // Get the size of the stack
    public int size() {
        return top + 1; //returns the value of top plus 1, which represents the current size of the stack.
    }

    // Read the value at the top of the stack
    public int top() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No top element.");
            return -1;
        } else {
            return elements[top];
        }
    }

    // Push an element onto the stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push element: " + value);
        } else {
            top++;
            elements[top] = value;
            System.out.println("Pushed element: " + value);
        }
    }

    // Read and remove the value at the top of the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        } else {
            int poppedValue = elements[top];
            top--;
            return poppedValue;
        }
    }

    // Display all elements in the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack elements:");
            for (int i = top; i >= 0; i--) {
                System.out.println(elements[i]);
            }
        }
    }

    // Delete all elements from the stack
    public void makeEmpty() {
        top = -1; // Reset top to -1 to indicate an empty stack
        System.out.println("Stack is now empty.");
    }

    public static void main(String[] args) {
        // Create two stack instances
        IntStack S1 = new IntStack(3);
        IntStack S2 = new IntStack(3);

        // Push elements onto S1
        System.out.println("S1 ");
        S1.push(1);
        S1.push(2);
        S1.push(3);

        // Push/pop elements from S1 to S2
        System.out.println("S2 ");
        S2.push(S1.top()); //3
        S2.push(S1.pop()); //3
        S2.push(S1.top()); //2

        // Display the contents of S1 and S2
        System.out.print("S1 ");
        S1.display();
        System.out.print("S2 ");
        S2.display();
    }
}
