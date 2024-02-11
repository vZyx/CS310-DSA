package Queue;

public class SinglyLinkedList_implementation<E>
{
    // inner class (nested class)
    private class Node<E>
    {
        private E value;
        private Node<E> next; // pointer  to a node

        public Node(E value) {
            this.value = value;
        }
    }

    private Node<E> head; //pointer
    private Node<E> tail; //pointer
    private int length = 0;

    public SinglyLinkedList_implementation(E value) {
        Node<E> newNode = new Node<E>(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public SinglyLinkedList_implementation() {}
    //Access Methods

    //Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }
    // prints all the nodes
    public void printList() {
        // Check if the list is empty
        if (isEmpty()) {
            System.out.println("Empty List... ");
        }

        // Start traversal from the head of the list
        /*
        head
          ↓
        [ 1 ] → [ 2 ] → [ 3 ] → null
          ↑       ↑       ↑
        temp
         */
        Node<E> temp = head; // Initialize a reference "pointer" to the head
        int counter = 1; // Initialize a counter to track node positions

        // Traverse the list and print each node's value
        while (temp != null) {
            // Print the current node's value along with its position
            System.out.println("Node#" + counter + ": " + temp.value + " ");

            // Move to the next node
            temp = temp.next; // Move current to the next node
            counter++; // Increment counter for the next node
        }
    }

    //prints the head of LinkedList if not empty
    public void getHead() {
        if (isEmpty()) { // head == null
            System.out.println("Head: null"); // If the list is empty, return null
        } else {
            System.out.println("Head: " + head.value);
        }
    }
    //prints the tail of LinkedList if not empty
    public void getTail() {
        if (isEmpty()) {
            System.out.println("Tail: null"); // If the list is empty, return null
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }
    // prints the size
    public void getLength() {
        System.out.println("Length: " + length);
    }
    // make the linkelist point to null
    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public int find(E element) {
        Node<E> temp = head;

        int index = 0;
        while (temp != null) {
            if (temp.value.equals(element)) {
                return index; // Element found at current index
            }
            temp = temp.next;
            index++;
        }
        return -1; // Element not found in the list
    }

    // add node to the end
    public void append(E value) {
        // Create a new node with the provided value
        Node<E> newNode = new Node(value);

        // If the list is empty, set both head and tail to the new node
        if (length == 0) {
            head = newNode; // Set the head to the new node
            tail = newNode; // Set the tail to the new node
        } else {
            // If the list is not empty, append the new node to the end
            tail.next = newNode; // Make the current tail point to the new node
            tail = newNode; // Update the tail to the new node
        }

        // Increment the length of the list
        length++;
    }
    // add node at the beginning
    public void prepend(E value) {
        // Create a new node with the provided value
        Node<E> newNode = new Node(value);

        // If the list is empty, set both head and tail to the new node
        if (length == 0) {
            head = newNode; // Set the head to the new node
            tail = newNode; // Set the tail to the new node
        } else {
            // If the list is not empty, prepend the new node to the beginning
            newNode.next = head; // Make the new node point to the current head
            head = newNode;      // Update the head to the new node
        }

        // Increment the length of the list
        length++;
    }
    //Remove last node
    public Node<E> removeLast() {
        // Check if the list is empty
        if (length == 0) return null; // If the list is empty, return null

        // Initialize references for traversal
        Node<E> temp = head; // Initialize temp to the head
        Node<E> pre = head;  // Initialize pre to the head

        // Traverse the list to find the last node
        while (temp.next != null) {
            pre = temp;      // Update pre to the current node
            temp = temp.next; // Move temp to the next node
        }

        // Update the tail to the second-to-last node
        tail = pre;        // Update tail to pre
        tail.next = null;  // Remove the reference to the last node

        // Update the length of the list
        length--;

        // If the list becomes empty, update head and tail to null
        if (length == 0) {
            head = null;
            tail = null;
        }

        // Return the removed node
        return temp;
    }
    //Remove First node
    public Node<E> removeFirst() {
        // Check if the list is empty
        if (length == 0) return null; // If the list is empty, return null

        // Save reference to the first node
        Node temp = head;

        // Move head to the next node (removing the first node)
        head = head.next;

        // Disconnect the removed node from the list
        temp.next = null;

        // Decrement the length of the list
        length--;

        // If the list becomes empty, update tail to null
        if (length == 0) {
            tail = null;
        }

        // Return the removed node
        return temp;
    }

    public Node<E> remove(int index) {
        // Check if the index is out of bounds
        if (index < 0 || index >= length) return null;

        // Check if the node to be removed is the first node
        if (index == 0) return removeFirst();

        // Check if the node to be removed is the last node
        if (index == length - 1) return removeLast();

        // Get a reference to the node before the node to be removed
        Node<E> prev = get(index - 1);

        // Get a reference to the node to be removed
        Node<E> temp = prev.next;

        // Remove the node from the list
        prev.next = temp.next;
        temp.next = null;

        // Decrement the length of the list
        length--;

        // Return the removed node
        return temp;
    }

    public Node<E> get(int index) {
        // Check if the index is out of bounds
        if (index < 0 || index >= length) return null; // If the index is out of bounds, return null
        // Initialize a temporary node to traverse the list
        Node<E> temp = head;
        // Traverse the list to find the node at the specified index
        for (int i = 1; i < index; i++) {
            temp = temp.next; // Move temp to the next node
        }

        // Return the node at the specified index
        return temp;
    }

    public boolean set(int index, E value) {
        Node<E> temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, E value)  {
        // Check if the index is out of bounds
        if (index < 0 || index > length) return false; // If the index is out of bounds, return false

        // Check if insertion is at the beginning of the list
        if (index == 0) {
            prepend(value); // Call the prepend method to insert at the beginning
            return true;    // Return true to indicate successful insertion
        }

        // Check if insertion is at the end of the list
        if (index == length) {
            append(value);  // Call the append method to insert at the end
            return true;    // Return true to indicate successful insertion
        }

        // Create a new node with the specified value
        Node newNode = new Node(value);

        // Get a reference to the node before the insertion point
        Node temp = get(index - 1);

        // Insert the new node between the previous node and its next node
        newNode.next = temp.next; // Set the next of the new node to the next of the previous node
        temp.next = newNode;      // Set the next of the previous node to the new node

        // Increment the length of the list
        length++;

        // Return true to indicate successful insertion
        return true;
    }
    // Reverse nodes
    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;

        Node after = temp.next;
        Node before = null;

        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }



        public static void main(String[] args)
        {
        // linkedlist  lab 3
        System.out.println("\nLinked List: ");
        SinglyLinkedList_implementation myList = new SinglyLinkedList_implementation();
        myList.prepend("707");
        myList.prepend(2322);
        myList.printList();


        // linkedlist1
        SinglyLinkedList_implementation myLinkedList1 = new SinglyLinkedList_implementation(4);
        System.out.println("\nLinked List1: ");
        myLinkedList1.getHead();
        myLinkedList1.getTail();
        myLinkedList1.getLength();
        myLinkedList1.printList();

        // linkedlist2
        System.out.println("\nLinked List2: ");
        SinglyLinkedList_implementation myLinkedList2 = new SinglyLinkedList_implementation(1);
        myLinkedList2.makeEmpty();
        myLinkedList2.append(1);
        myLinkedList2.append(2);
        myLinkedList2.getHead();
        myLinkedList2.getTail();
        myLinkedList2.getLength();
        myLinkedList2.printList();

        // linkedlist3
        System.out.println("\nLinked List3: ");
        SinglyLinkedList_implementation myLinkedList3 = new SinglyLinkedList_implementation(1);
        myLinkedList3.append(2);

        // (2) Items - Returns 2 Node
        System.out.println(myLinkedList3.removeLast().value);
        // (1) Item - Returns 1 Node
        System.out.println(myLinkedList3.removeLast().value);
        // (0) Items - Returns null
        System.out.println(myLinkedList3.removeLast());

        // LinkedList4
        System.out.println("\nLinked List4: ");
        SinglyLinkedList_implementation myLinkedList4 = new SinglyLinkedList_implementation(1);
        myLinkedList4.append(2);
        myLinkedList4.append(3);
        myLinkedList4.append(4);

        System.out.println(myLinkedList4.get(2).value);

        myLinkedList4.printList();

        //LinkedList5
        System.out.println("LinkedList5: ");
        SinglyLinkedList_implementation myLinkedList5 = new SinglyLinkedList_implementation(0);
        myLinkedList5.append(1);
        myLinkedList5.append(2);
        myLinkedList5.append(3);

        System.out.println("Linked List 5 before set():");
        myLinkedList5.printList();

        myLinkedList5.set(2, 99);

        System.out.println("\nLinked List 5 after set():");
        myLinkedList5.printList();

        //LinkedList6
        System.out.println("LinkedList6: ");
        SinglyLinkedList_implementation myLinkedList6 = new SinglyLinkedList_implementation(0);
        myLinkedList6.append(2);
        myLinkedList6.printList();

        //LinkedList7
        System.out.println("LinkedList7: ");
        SinglyLinkedList_implementation myLinkedList7 = new SinglyLinkedList_implementation(1);
        myLinkedList7.append(2);
        myLinkedList7.append(3);
        myLinkedList7.append(4);
        myLinkedList7.reverse();

        myLinkedList7.printList();



    }



}

