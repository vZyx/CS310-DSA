package Queue;

public class SinglyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public SinglyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next; //current now point to next node
        }
    }

    // Method to search for a value in the linked list
    void search(int value) {
        Node current = head;
        int position = 1;

        boolean found = false;

        while (current != null) {
            if (current.value == value) {
                System.out.println("Node with value " + value + " found at position " + position);
                found = true;
                break;
            }
            current = current.next;
            position++;
        }

        if (!found) {
            System.out.println("Value " + value + " not found in the linked list");
        }
    }

    // Method to delete the first node from the linked list
    void deleteFirst() {
        if (head == null) {
            System.out.println("Linked list is empty. No node to delete.");
            return;
        }
        head = head.next;
    }

    // Method to add a node with the given value at the beginning of the linked list
    void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    // Method to insert a node with the given value at the specified position in the linked list
    void addAtPos(int value, int pos) {
        if (pos < 1 || pos > length + 1) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 1) {
            addFirst(value);
            return;
        }

        Node newNode = new Node(value);
        Node current = head;
        int count = 1;

        while (count < pos - 1 && current != null) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position out of range");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
        length++;
    }

    // Method to find the maximum value in the linked list
    int findMax() {
        if (head == null) {
            System.out.println("List is empty");
            return Integer.MIN_VALUE; // Return minimum value of integer if list is empty
        }

        int max = head.value;
        Node current = head.next;

        while (current != null) {
            if (current.value > max) {
                max = current.value;
            }
            current = current.next;
        }
        return max;
    }

    // Method to find the minimum value in the linked list
    int findMin() {
        if (head == null) {
            System.out.println("List is empty");
            return Integer.MAX_VALUE; // Return maximum value of integer if list is empty
        }

        int min = head.value;
        Node current = head.next;

        while (current != null) {
            if (current.value < min) {
                min = current.value;
            }
            current = current.next;
        }
        return min;
    }

    // Method to delete a node with a specific value from the linked list
    void delete(int value) {
        if (head == null) {
            System.out.println("Linked list is empty. No node to delete.");
            return;
        }

        if (head.value == value) {
            head = head.next;
            return;
        }

        Node prev = head;
        Node current = head.next;

        while (current != null && current.value != value) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            prev.next = current.next;
        } else {
            System.out.println("Value not found in the linked list.");
        }
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }


    public static void main(String[] args)
    {

    }
}
