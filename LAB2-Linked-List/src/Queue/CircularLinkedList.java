package Queue;


public class CircularLinkedList<E> {

    //Nested Node inner-class:
    private static class Node<E> {
        private E data; //reference to the data in the Node
        private Node next; //reference to the next Node in the list

        //constructor
        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public Node()
        {
        }

        E getData() {
            return data;
        }

        void setData(E data) {
            this.data = data;
        }

        Node<E> getNext() {
            return next;
        }

        void setNext(Node<E> next) {
            this.next = next;
        }
    }//end of Node class

    //Attributes
    private  Node<E> head = null; //reference to the first Node in the list
    private  Node<E> tail = null; //reference to the last Node in the list
    private  int length = 0; //number of nodes in the list

    //Constructor
    public CircularLinkedList(E value) {
        Node<E> newNode = new Node<E>(value, null);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    //Accessor methods
    public int getLength() {
        return length;
    }

    public E first()
    {
        if (isEmpty()) return null;
        return head.getData();
    }

    public E last()
    {
        if (isEmpty()) return null;
        return tail.getData();
    }
    public boolean isEmpty() {
        return (length == 0);
    }


    //Operations on linkedList:
    /*
it moves the head reference to point to the next node in the list. This effectively shifts all nodes in the list one position to the right.
After moving the head reference, it updates the tail reference to point to the new head node, ensuring that the circular structure of the linked list is maintained.
     */
    public void rotate() {
        if (!isEmpty()) {
            head = head.next; // Move head to the next node
            tail = tail.next; // Update tail to the new head
        }//end if
    }//end of rotate


    public void display() {
        if (isEmpty()) {
            System.out.println("\nEmpty List.. ");
            return;
        }//end if
        System.out.println("\nDisplay List: ");
        Node<E> current = head;
        int count = 1;
        do {
            System.out.print("\tNode " + count + " :" + current.getData());
            current = current.getNext();
            count++;
        } while (current != head);
    }

    // Algorithm: Searching
    // Input: Circular LinkedList, Value
    // Output: Display Node number when value found
    public void search(E key) {
        if (isEmpty()) {
            System.out.println("\nEmpty list...");
            return;
        }//end if
        Node<E> current = head;
        int counter = 1;
        do {
            //For primitive data types /OR for objects use equals method that you have overridden it in your class
            if ((current.getData() == key) || ((current.getData()).equals(key))) {
                System.out.println("\nFound in position# " + counter);
                return;
            } // end if
            counter++;
            current = current.getNext();
        } while (current != head); //end loop
        //if not found i.e. current==head again
        System.out.println("\nNot found...");
    }//end find


    // Algorithm: deleteFirst
    // Input: Circular LinkedList
    // Output: update Circular LinkedList
    public void deleteFirst() {
        if (isEmpty()) {
            System.out.println("\nEmpty list...");
            return;
        }//end if
        head = head.getNext();
        tail.setNext(head); //tail.next=head;
        length--;
        System.out.println("\nThe 1st node has been deleted successfully.. ");
        if (length == 0) {
            tail = head = null;
        } //if this was the last and only node.. fix tail& head
    }//end of removeFirst


    // Algorithm: delete
    // Input: Circular LinkedList, Value
    // Output: update Circular LinkedList
    // Remove the last element from the list
    public void deleteLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            Node<E> current = head;
            while (current.getNext() != tail) {
                current = current.getNext();
            }
            current.setNext(head); // update next reference of the second last node to point to head
            tail = current; // update tail to point to the second last node
        }
        length--;
    }


    public void addFirst(E data) {
        Node<E> newNode = new Node(data, head);
        head = newNode;
        if (length == 0) {
            tail = head;
        }
        tail.next = head;
        length++;
        System.out.println("\nThe 1st node has been added successfully.. ");
    }//end of addFirst

    public void addLast(E data) {
        Node<E> newNode = new Node(data, null);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }//end if
        length++;
        tail.next = head;
        System.out.println("\nThe last node has been added successfully.. ");
    }//end of addLast

    // Add an element at the specified position in the list
    public void addAtPosition(E value, int position) {
        if (position < 0 || position > length) {
            throw new IllegalArgumentException("Invalid position");
        }
        if (position == 0) {
            addFirst(value);
        } else if (position == length) {
            addLast(value);
        } else {
            Node<E> newNode = new Node<>(value, null);
            Node<E> current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            length++;
        }
    }

    // Remove the node at the specified position from the list
    public void deleteNodeAtPosition(int position) {
        if (position < 0 || position >= length) {
            throw new IllegalArgumentException("Invalid position");
        }
        if (position == 0) {
            deleteFirst();
        } else {
            Node<E> current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            length--;
        }
    }

    public static void main(String[] args) {
        CircularLinkedList<String> myList = new CircularLinkedList<>("null");

        // Adding elements to the list
        myList.addLast("Apple");
        myList.addLast("Banana");
        myList.addLast("Orange");

        // Displaying the list
        System.out.println("Initial list:");
        myList.display();

        // Searching for an element
        myList.search("Banana");

        // Deleting the first node
        myList.deleteFirst();
        System.out.println("\nList after deleting first node:");
        myList.display();

        // Deleting a node at position 1
        myList.deleteNodeAtPosition(1);
        System.out.println("\nList after deleting node at position 1:");
        myList.display();

        // Adding an element at position 1
        myList.addAtPosition("Grapes", 1);
        System.out.println("\nList after adding 'Grapes' at position 1:");
        myList.display();

        // Deleting the last node
        myList.deleteLast();
        System.out.println("\nList after deleting last node:");
        myList.display();
    }


}


