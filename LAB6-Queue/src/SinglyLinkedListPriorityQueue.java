

public class SinglyLinkedListPriorityQueue {
    class Node {
        int data;
        int key;
        Node next;

        Node(int data, int key, Node next) {
            this.data = data;
            this.key = key;
            this.next = next;
        }
    }
    private Node front;
    private int size;

    public SinglyLinkedListPriorityQueue() {
        front = null;
        size = 0;
    }

    // Method to insert a node with key and value into the correct position
    public void insert(int key, int value) {
        Node newNode = new Node(value, key, null);
        Node current = front;
        Node prev = null;

        while (current != null && key < current.key) {
            prev = current;
            current = current.next;
        }

        if (prev == null) {
            front = newNode;
        } else {
            prev.next = newNode;
        }
        newNode.next = current;
        size++;
    }

    // Method to remove and return the node with the maximum key
    public Node removeMax() {
        if (isEmpty()) {
            System.out.println("Queue is underflow");
            return null;
        }
        Node temp = front;
        front = front.next;
        size--;
        return temp;
    }

    // Method to return the node with the maximum key
    public Node getMax() {
        if (isEmpty()) {
            System.out.println("Queue is underflow");
            return null;
        }
        return front;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the size of the queue
    public int size() {
        return size;
    }
}
