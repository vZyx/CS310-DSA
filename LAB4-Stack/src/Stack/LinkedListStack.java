package Stack;

import java.util.EmptyStackException;

public class LinkedListStack<E> {

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> top;
    private int size;

    public LinkedListStack() {
        this.top = null;
        this.size = 0;
    }

    public void push(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            E removedData = top.data;
            top = top.next;
            size--;
            return removedData;
        }
    }

    public E top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        Node<E> current = top;
        System.out.print("Stack: \n");
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
    }

    public void makeEmpty() {
        top = null;
        size = 0;
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top());
        System.out.println("Stack size: " + stack.size());

        stack.display();

        System.out.println("Popped element: " + stack.pop());
        stack.display();

        stack.makeEmpty();
        System.out.println("Stack is empty: " + stack.isEmpty());
    }
}

