

public class QueueLinkedList {
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

    private Node front, rear;
    private int size;

    // Constructor to initialize the queue
    public QueueLinkedList() {
        front = null;
        rear = null;
        size = 0;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {return size == 0;}

    // Method to get the size of the queue
    public int getSize() {return size;}

    // Method to get the element at the front of the queue
    public int getFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1; // or throw an exception
        }
        return front.data;
    }

    // Method to get the element at the rear of the queue
    public int getRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1; // or throw an exception
        }
        return rear.data;
    }

    // Method to add an element to the rear of the queue
    public void Enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Method to remove an element from the front of the queue
    public int Dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1; // or throw an exception
        }
        int data = front.data;
        front = front.next;
        size--;
        if (size == 0) {
            rear = null;
        }
        return data;
    }

    // Method to display the elements of the queue
    public void Display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        Node current = front;
        System.out.print("Queue: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();
        queue.Enqueue(1);
        queue.Enqueue(2);
        queue.Enqueue(3);
        queue.Display(); // Queue: 1 2 3

        System.out.println("Front element: " + queue.getFront()); // 1
        System.out.println("Rear element: " + queue.getRear()); // 3
        queue.Dequeue();
        queue.Display(); // Queue: 2 3
        System.out.println("Size of queue: " + queue.getSize()); // 2
    }
}
