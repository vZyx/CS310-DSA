

public class CircularQueueLinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        public void setLink(Node next) {
            this.next = next;
        }

        public Node getLink() {
            return this.next;
        }
    }

    private Node rear, front;
    private int size;

    // Constructor to initialize the circular queue
    public CircularQueueLinkedList() {
        rear = null;
        size = 0;
    }

    // Method to check if the circular queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to add an element to the rear of the circular queue
    public void EnQueue(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            front = newNode;
            rear  = newNode; // Update rear for the first element
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        rear.next = front; // Ensure circular structure
        size++;
    }


    // Method to remove an element from the front of the circular queue
    public int DeQueue() {
        if (isEmpty()) {
            System.out.println("Queue is underflow");
            return -1; // or throw an exception
        }
        int data = front.data;
        front = front.next;
        rear.next = front;

        size--;
        return data;
    }

    public void Display() {
        if (isEmpty()) {
            System.out.println("Circular Queue is empty");
            return;
        }
        Node current = rear.next;
        System.out.print("Circular Queue: ");
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != rear.next);
        System.out.println();
    }



    public static void main(String[] args) {
        CircularQueueLinkedList queue = new CircularQueueLinkedList();

        // Enqueue elements
        queue.EnQueue(1);
        queue.EnQueue(2);
        queue.EnQueue(3);

        // Display the queue
        System.out.print("Queue after EnQueue operations: ");
        queue.Display();

        // Dequeue elements
        System.out.println("Dequeued element: " + queue.DeQueue());
        System.out.println("Dequeued element: " + queue.DeQueue());

        // Display the queue after Dequeue operations
        System.out.print("Queue after DeQueue operations: ");
        queue.Display();
    }

    }


