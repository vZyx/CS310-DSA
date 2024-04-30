package Stack;

public class IntLinkedListStack {
    // Node class for the linked list
    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // Top of the stack
    private Node top;
    // Size of the stack
    private int size;

    // Constructor
    public IntLinkedListStack() {
        top = null;
        size = 0;
    }

    public IntLinkedListStack(int value)
    {
        Node newNode = new Node(value);
        top = newNode;
        size = 1;
    }

    // Push operation to add an element to the top of the stack
    public void push(int value) {
        Node newNode = new Node(value);
        if (size == 0)
        {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
            size++;
            System.out.println("Pushed element: " + value);
        }
    }

    // Pop operation to remove and return the element from the top of the stack
    public int pop()
    {
        if (isEmpty())
        {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE; // Return a sentinel value
            } else {
            int poppedValue = top.value;
            top = top.next;
            size--;
            return poppedValue;
        }
    }

    // Top operation to return the element at the top of the stack without removing it
    public int top() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE; // Return a sentinel value
        }
        return top.value;
    }

    // Size operation to return the size of the stack
    public int size() {
        return size;
    }

    // isEmpty operation to check if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Display operation to print all elements in the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Stack elements:");
        Node current = top;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    // Empty operation to remove all elements from the stack
    public void empty() {
        top = null;
        size = 0;
        System.out.println("Stack is emptied");
    }

    public static void main(String[] args) {
        IntLinkedListStack stack = new IntLinkedListStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Top element: " + stack.top());

        stack.display();

        stack.empty();
        System.out.println("Stack size after emptying: " + stack.size());
    }
}

