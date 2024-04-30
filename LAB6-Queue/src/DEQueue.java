
// Double-Ended Queue (DEQueue)
// Can add and delete from both front and rear
public class DEQueue {
    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    private Node front;
    private Node rear;
    private int size;

    // Constructor to initialize the DEQueue
    public DEQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Method to check if the DEQueue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to add an element to the front of the DEQueue
    public void EnQueueFront(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            front = newNode;
            rear  = newNode;
        } else {
            front.prev = newNode;
            newNode.next = front;
            front = newNode;
        }
        size++;
    }

    // Method to add an element to the rear of the DEQueue
    public void EnQueueRear(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            front = newNode;
            rear  = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
        size++;
    }

    // Method to remove an element from the front of the Double Linked-List (DeQueueFront)
    public void DeQueueFront() {
        if (isEmpty()) {
            System.out.println("Queue is underflow");
            return;
        }

        front = front.next;
        if (front != null) {
            front.prev = null;
        } else {
            rear = null; // If front becomes null, rear should also be null
        }
        size--;

    }

    // Method to remove an element from the rear of the Double Linked-List (DeQueueRear)
    public void DeQueueRear() {
        if (isEmpty()) {
            System.out.println("Queue is underflow");
            return;
        }

        rear = rear.prev;
        if (rear != null) {
            rear.next = null;
        } else {
            front = null; // If rear becomes null, front should also be null
        }
        size--;
    }

    // Method to display the elements of the DEQueue
    public void Display() {
        if (isEmpty()) {
            System.out.println("DEQueue is empty");
            return;
        }
        Node current = front;
        System.out.print("DEQueue: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DEQueue queue = new DEQueue();

        // Enqueue elements to the front
        queue.EnQueueFront(5);
        queue.EnQueueFront(3);
        queue.EnQueueRear(7);

        // Display the DEQueue
        queue.Display(); // DEQueue: 3 5 7

        // Dequeue elements from the front and rear
        queue.DeQueueFront(); // Dequeued element from the front: 3
        queue.DeQueueRear(); // Dequeued element from the rear: 5

        // Display the DEQueue after dequeue operations
        queue.Display(); // DEQueue: 5
    }

}
