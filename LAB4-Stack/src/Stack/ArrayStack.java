package Stack;


// Generic implementation of array based stack
public class ArrayStack<T> {
    private T[] stackArray;
    private int top; // keeps track of the index of the top element in the stack. effectively serves as a pointer indicating the position of the topmost element in the stack array.
    private int maxSize; // maxSize is the upper bound

    // Constructor
    public ArrayStack(int size) {
        this.maxSize = size;
        this.stackArray = (T[]) new Object[maxSize];
        this.top = -1;
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
        return top + 1; // returns the value of top plus 1, which represents the current size of the stack.
    }

    // Top at the top element of the stack
    public T top() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return null;
        }
        return stackArray[top];
    }

    // Push an element onto the stack
    public void push(T value) {
        if (isFull()) {
            System.out.println("Stack is full. You couldn't push " + value);
            return;
        } else
        {
            top++;
            stackArray[top] = value;
            System.out.println("Pushed element: " + value);
        }
    }


    // Pop the top element from the stack
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        }
        return stackArray[top--];
    }

    // Display all elements from top to bottom in the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack elements: ");
        for (int i = top; i >= 0; i--) {
            System.out.println(stackArray[i]);
        }
    }

    // Clear all elements from the stack
    public void makeEmpty() {
        top = -1;
    }

    public static void main(String[] args)
    {
        ArrayStack<Integer> arrayStack = new ArrayStack<>(5);

        arrayStack.push(10);
        arrayStack.push(20);
        arrayStack.push(30);

        arrayStack.display();  // Display elements from top to bottom

        System.out.println("Top element: " + arrayStack.top());

        arrayStack.pop();  // Pop the top element {30}

        arrayStack.display();  // Display elements after popping

        arrayStack.makeEmpty();  // Clear the stack

        System.out.println("Is stack empty? " + arrayStack.isEmpty());

    }
}
