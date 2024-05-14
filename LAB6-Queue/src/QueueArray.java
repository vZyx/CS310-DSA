
// Linear QueueArray
public class QueueArray {
    private int front = 0 , rear = 0,  capacity = 0,  size = 0;
    private int[] Queue;

    // Constructor to initialize the queue
    public QueueArray(int maxSize) {
        Queue = new int[maxSize];
        this.capacity = maxSize;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {return size == 0;}

    // Method to check if the queue is full
    public boolean isFull() {return size == capacity;}

    // Method to add an element to the rear of the queue
    public void EnQueue(int value) {
        if (isFull()) {
            System.out.println("Queue is overflow. Cannot enqueue.");
            return;
        }
        Queue[rear] = value;
        rear = rear + 1; // Rear increases by 1 after each EnQueue
        size = size + 1;
        System.out.println( value + " - Added to Queue - ");
    }

    // Method to remove an element from the front of the queue
    public int DeQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty (underflow). Cannot dequeue.");
            return -1; // or throw an exception
        }
        int temp = Queue[front];
        front = front + 1;  // Front increases by 1 after each DeQueue
        size = size - 1;
        System.out.println( temp + " - Deleted from Queue - ");
        return temp;
    }

    // Method to get the element at the front of the queue
    public int getFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1; // or throw an exception
        }
        return Queue[front]; //1st element
    }

    // Method to get the element at the rear of the queue
    public int getRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1; // or throw an exception
        }
        return Queue[rear - 1]; // last element
    }

    // Method to get the size of the queue
    public int getSize() {
        return size;
    }

    // Method to display the elements of the queue
    public void Display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        for (int i = front; i < rear; i++) {
            System.out.print(Queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueArray queue = new QueueArray(5);
        queue.EnQueue(10);
        queue.EnQueue(20);
        queue.EnQueue(30);
        queue.EnQueue(40);

        queue.DeQueue();
        queue.DeQueue();
        System.out.println("Front: " + queue.getFront());
        System.out.println("size: " + queue.getSize());
        queue.Display();
//        queue.EnQueue(4);
//        queue.EnQueue(20);
//        queue.EnQueue(50);
//        queue.EnQueue(10);
//        queue.EnQueue(60);
//        queue.EnQueue(90);
//        queue.Display(); //
//        System.out.println("Front element: " + queue.getFront()); // 4
//        System.out.println("Rear element: " + queue.getRear()); // 90
//        queue.DeQueue(); // 4
//        queue.Display(); //
//        System.out.println("Size of queue: " + queue.getSize()); // 5
    }
}
