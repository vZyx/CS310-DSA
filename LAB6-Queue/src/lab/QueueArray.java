package lab;

public class QueueArray<E> {
    //Nested Node inner-class:
    private static class Node<E> {
        private E data;
        private Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }//end of Node constructor

        E getData() { return data;  }
        Node<E> getNext() {  return next;  }

        void setData(E data) {  this.data = data; }
        void setNext(Node<E> next) { this.next = next; }

        public String toString(){return data+"";} //to enable printing data after calling getFront or deQueue cause E is not recognizable
    }//end of Node class

    private Node<E> front=null, rear=null;
    private int size=0;

    public QueueArray() { }

    public boolean isEmpty(){return size==0;}
    public int size() {return size;}

    public Node<E> getFront() {
        if (isEmpty()) return null;
        return front;
    }//end of getFront

    public Node<E> getRear() {
        if (isEmpty()) return null;
        return rear;
    }//end of getRear


    public void enQueue(E value){  //like addLast in a LL
        Node<E> newNode = new Node(value, null);
        if (size == 0)
        {
            front = newNode;
            rear = newNode;
        }
        else{
            rear.next = newNode;
            rear = newNode;
        }//end if
        size++;
        System.out.println(value + " - Added to Queue");
    }//end of enQueue

    public Node<E> deQueue() {  //like removeFirst in a LL
        if (isEmpty()) {
            System.out.println("\nERROR: Queue Underflow!");
            return null;
        }//end if

        Node<E> temp=front;
        front = front.next;
        size--;
        if (size == 0) { rear = null; }
        System.out.println(temp.data + "- Deleted from Queue");
        return temp;
    }//end of deQueue

    public void display(){
        if (isEmpty()) {
            System.out.println("\nERROR: Empty Queue!");
            return;
        }//end if
        System.out.print("\n********** Display Queue **************\n");

        Node<E> current=front;
        while(current!=null)
        {
            System.out.println(current.data);
            current=current.next;
        }//end loop
        System.out.println("***************************************\n");
    }//end of display

    public static void main(String[] args)
    {
        System.out.println("Testing a Queue using Circular Array:");
        System.out.println("*************************************");

        QueueArray q1 = new QueueArray();
        q1.enQueue(10);
        q1.enQueue(20);
        q1.enQueue(30);
        q1.enQueue(40);
        q1.enQueue(50);
        q1.display();
        q1.deQueue();
        q1.deQueue();
        q1.deQueue();
        q1.display();
        q1.enQueue(60);
        q1.display();

        //-------------------------------------------------------------

        System.out.println("Testing a Queue using Linear Linked List:");
        System.out.println("*****************************************");

        QueueArray q2 = new QueueArray();
        q2.enQueue(10);
        q2.enQueue(20);
        q2.enQueue(30);
        q2.enQueue(40);
        q2.display();
        q2.deQueue();
        q2.deQueue();
        System.out.println("Front Element: "+ q2.getFront());
        System.out.println("Rear Element: "+ q2.getRear());
        q2.enQueue(50);
        q2.display();
    }//end of main

}//end of class
