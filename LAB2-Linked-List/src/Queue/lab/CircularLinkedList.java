package Queue.lab;

public class CircularLinkedList<E> {

    //Nested Node inner-class:
    private static class Node<E> {
        private E data;         //reference to the data in the Node
        private Node next;      //reference to the next Node in the list

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }//end of Node constructor

        E getData() { return data;  }
        Node<E> getNext() {  return next;  }

        void setData(E data) {  this.data = data; }
        void setNext(Node<E> next) { this.next = next; }
    }//end of Node class

    //Attributes
    private Node<E> head = null;   //reference to the first Node in the list
    private Node<E> tail = null;   //reference to the last Node in the list
    private int size = 0;          //number of nodes in the list

    //Constructor(s)
    public CircularLinkedList() { }

    //Accessor methods
    public int size() { return size; }
    public boolean isEmpty() {return (size == 0);}

    public E first() {
        if (isEmpty()) return null;
        return head.getData();
    }//end of first

    public E last() {
        if (isEmpty()) return null;
        return tail.getData();
    }//end of last
    //Operations on linkedList:
    public void rotate() {
        if (!isEmpty()) {
            head = head.next;  //or: head.getNext()
            tail=tail.next;
        }//end if
    }//end of rotate

    public void display() {
        if(isEmpty()){
            System.out.println("\nEmpty List.. ");
            return;
        }//end if

        System.out.println("\nDisplay List: ");
        Node<E> current = head;
        int count=1;
        do{
            System.out.print("\tNode "+count+" :"+current.getData());
            current = current.getNext();
            count++;
        }while(current!=head);

        //M->or using for-loop:
     /* Node current1 = head;
        for (int i=0; i<size;i++) {
            System.out.print("\tNode "+(i+1)+" :"+current1.getData());
            current1 = current1.getNext();
        }//end loop
       */

    }//end display

    public void findNode(E key) {
        if (isEmpty()) {
            System.out.println("\nEmpty list...");
            return;
        }//end if

        Node<E> current = head;
        int counter = 1;
        do{
            //For primitive data types /OR for objects use equals method that you have overridden it in your class
            if ((current.getData() == key) || ((current.getData()).equals(key)))
            {
                System.out.println("\nFound in position# " + counter);
                return;
            }//end if

            counter++;
            current = current.getNext();
        }while(current!=head); //end loop

        //if not found i.e. current==head again
        System.out.println("\nNot found...");
    }//end find

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("\nEmpty list...");
            return;
        }//end if

        head = head.getNext();
        tail.setNext(head); //tail.next=head;
        size--;
        //System.out.println("\nThe 1st node has been deleted successfully.. ");

        if (size == 0) { tail =head = null; } //if this was the last and only node.. ﬁx tail& head
    }//end of removeFirst

    public void addFirst(E data) {
        Node<E> newNode = new Node(data, head);
        head = newNode;
        if (size == 0){ tail = head; }
        tail.next=head;
        size++;
        //System.out.println("\nThe 1st node has been added successfully.. ");
    }//end of addFirst

    public void addLast(E data) {
        Node<E> newNode = new Node(data, null);
        if (size == 0)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
        }//end if
        size++;
        tail.next=head;
        //System.out.println("\nThe last node has been added successfully.. ");
    }//end of addLast

    public void removeNode(E key) { //delete a node at any position
        if (isEmpty()) {
            System.out.println("\nEmpty list...");
            return;
        }//end if

        Node<E> current = head;
        Node<E> prev = head;

        while ( (current.getData() != key) && (!(current.getData()).equals(key)))
        {
            if (current.next == head) {
                System.out.println("\nNot found...");
                return;
            }
            prev = current;
            current = current.next;
        }//end loop

        //if found:
        if (current == head) {
            removeFirst();
        }
        else
        {
            prev.next = current.next;
            size--;
            //if removing the last node, fix the tail
            if (current == tail) { tail=prev;}
        }
    }//end removeNode

    public void addNode(E data, int position) { //add a node at any position
        //check if the position is correct (from 1 to size)
        if (position < 1 || position > size+1) {
            System.out.println("\nInvalid Position...");
            return;
        }
        //Check if the position is 1 (ﬁrst node)
        if (position == 1) {
            addFirst(data);
            return;
        }
        //Check if the position is the last node
        if (position == size+1) {
            addLast(data);
            return;
        }//end if

        //any other location
        Node<E> newNode = new Node<E>(data, null);
        Node<E> current = head;

        int count = 1;
        while (count < position - 1) {
            current = current.getNext();
            count++;
        }//end loop

        //if found..
        newNode.setNext(current.getNext()); //newNode.next=current.next;
        current.setNext(newNode);           //current.next=newNode;
        size++;
    }//end of addNode
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        list.addLast(10);
        list.addFirst(20);
        list.addFirst("DS");
        list.addFirst(new Person("Nada","Bahrain"));
        list.addLast("Java");
        list.addLast(7);
        list.display();
        System.out.println("\nFirst element: " + list.first());
        System.out.println("\nLast element: " + list.last());
        System.out.println("\nAdd At Position 8: ");
        list.addNode(600,8);
        System.out.println("\nAdd At Position 2: ");
        list.addNode(50, 2);
        list.display();
        System.out.println("\ncalling Rotate Method 1st time: ");
        list.rotate();
        list.display();
        System.out.println("\ncalling Rotate Method 2nd time: ");
        list.rotate();
        list.display();

        list.findNode(new Person("Nada","Bahrain"));
        list.removeNode(new Person("Nada","Bahrain"));
        list.display();
    }//end of main

}//end of CircularLinkedList class
