
//  CircularQueue Array
public class CircularQueue {
    private int[] queue;
    private int front = 0, rear = 0, capacity = 0, size = 0;

    // Constructor to initialize the circular queue
    public CircularQueue(int MaxSize) {
        queue = new int[MaxSize];
        this.capacity = MaxSize;
    }

    // Method to check if the circular queue is empty
    public boolean isEmpty() {return size == 0;}

    // Method to check if the circular queue is full
    public boolean isFull() {return size == capacity;}

    // Method to add an element to the rear of the circular queue
    public void EnQueue(int value) {
        if (isFull()) {
            System.out.println("Queue is overflow");
            return;
        }
        queue[rear] = value;
        rear = (rear + 1) % capacity;
        size++;
        System.out.println( value + " - Added to Queue - ");
    }

    // Method to remove an element from the front of the circular queue
    public int DeQueue() {
        if (isEmpty()) {
            System.out.println("Queue is underflow");
            return -1; // or throw an exception
        }
        int temp = queue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println( temp + " - Deleted from Queue - ");
        return temp;
    }

    // Method to get the size of the circular queue
    public int getSize() { return size;}

    // Method to get the front element of the circular queue
    public int getFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1; // or throw an exception
        }
        return queue[front];
    }

    // Method to get the rear element of the circular queue
    public int getRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1; // or throw an exception
        }
        return queue[(rear - 1 + capacity) % capacity];
    }


    // Method to display the elements of the circular queue
    public void Display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue: ");
        for (int i = front; i < rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.EnQueue(1);
        queue.EnQueue(2);
        queue.EnQueue(3);
        queue.Display(); // Queue: 1 2 3
        System.out.println("Dequeued element: " + queue.DeQueue()); // 1
        queue.Display(); // Queue: 2 3
        System.out.println("Size of queue: " + queue.getSize()); // 2
    }
}
