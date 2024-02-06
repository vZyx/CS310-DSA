package Queue;




public class SinglyLinkedList_implementation<E>
{

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            this.element = e;
            this.next = n;
        }

        public Node(E element) {
            this.element = element;
        }

        public E get_element(){
            return this.element;
        }

        public Node<E> getNext() {
            return this.next;
        }

        public void setNext(Node<E> n) {
            this.next = n;
        }
    }


    private Node<E> head;
    private Node<E> tail;
    private int length = 0;

    public SinglyLinkedList_implementation(E e) {
        Node<E> newNode = new Node<E>(e);
        this.head = null;
        this.tail = null;
        this.length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.element);
            temp = temp.next;
        }
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.element);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.element);
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
        Node<E> newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node<E> removeLast() {
        if (length == 0) return null;
        Node<E> temp = head;
        Node<E> pre = head;
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
        SinglyLinkedList_implementation myLinkedList = new SinglyLinkedList_implementation(4);
//      linkedlist1
        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();

        System.out.println("\nLinked List1: ");
        myLinkedList.printList();

//      linkedlist2
        SinglyLinkedList_implementation myLinkedList2 = new SinglyLinkedList_implementation(1);
        myLinkedList2.makeEmpty();
        myLinkedList2.append(1);
        myLinkedList2.append(2);

        myLinkedList2.getHead();
        myLinkedList2.getTail();
        myLinkedList2.getLength();

        System.out.println("\nLinked List2: ");
        myLinkedList2.printList();

//        linkedlist3
        SinglyLinkedList_implementation myLinkedList3 = new SinglyLinkedList_implementation(1);
        myLinkedList3.append(2);

        // (2) Items - Returns 2 Node
        System.out.println(myLinkedList3.removeLast().element);
        // (1) Item - Returns 1 Node
        System.out.println(myLinkedList3.removeLast().element);
        // (0) Items - Returns null
        System.out.println(myLinkedList3.removeLast());

    }



}

