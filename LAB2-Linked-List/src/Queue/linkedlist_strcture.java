package Queue;


class List_Node {
    int val;
    ListNode next;

    public List_Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class linkedlist_strcture
{

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public linkedlist_strcture(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
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


    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) return null;
        Node temp = head;
        Node pre = head;
        while(temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }


    public static void main(String[] args) {
        linkedlist_strcture myLinkedList = new linkedlist_strcture(4);
//      linkedlist1
        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();

        System.out.println("\nLinked List1: ");
        myLinkedList.printList();

//      linkedlist2
        linkedlist_strcture myLinkedList2 = new linkedlist_strcture(1);
        myLinkedList2.makeEmpty();
        myLinkedList2.append(1);
        myLinkedList2.append(2);

        myLinkedList2.getHead();
        myLinkedList2.getTail();
        myLinkedList2.getLength();

        System.out.println("\nLinked List2: ");
        myLinkedList2.printList();

//        linkedlist3
        linkedlist_strcture myLinkedList3 = new linkedlist_strcture(1);
        myLinkedList3.append(2);

        // (2) Items - Returns 2 Node
        System.out.println(myLinkedList3.removeLast().value);
        // (1) Item - Returns 1 Node
        System.out.println(myLinkedList3.removeLast().value);
        // (0) Items - Returns null
        System.out.println(myLinkedList3.removeLast());

    }



}

