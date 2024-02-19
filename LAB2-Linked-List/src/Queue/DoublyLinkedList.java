package Queue;




public class DoublyLinkedList<E> {
    private DoublyLinkedListNode<E> head;
    private DoublyLinkedListNode<E> tail;

    public DoublyLinkedList() {
        // Create dummy head and tail nodes
        head = new DoublyLinkedListNode<>(null);
        tail = new DoublyLinkedListNode<>(null);
        // Connect head and tail
        head.next = tail;
        tail.prev = head;
    }
    class DoublyLinkedListNode<E> {
        E val;
        DoublyLinkedListNode<E> next;
        DoublyLinkedListNode<E> prev;

        public DoublyLinkedListNode(E val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    public void insertFirst(E val) {
        DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<>(val);
        newNode.prev = head;
        newNode.next = head.next;

        head.next.prev = newNode;
        head.next = newNode;
    }

    public void insertLast(E val) {
        DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<>(val);
        newNode.next = tail;
        newNode.prev = tail.prev;

        tail.prev.next = newNode;
        tail.prev = newNode;
    }

    public void removeFirst() {
        if (head.next != tail) {
            head.next.next.prev = head;
            head.next = head.next.next;
        }
    }

    public void removeEnd() {
        if (tail.prev != head) {
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
        }
    }

    public void print() {
        DoublyLinkedListNode<E> curr = head.next;
        while (curr != tail) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList<>();
        dll.insertFirst(1);
        dll.insertFirst(2);
        dll.insertLast(3);
        dll.insertLast(4);
        dll.print(); // Output: 2 -> 1 -> 3 -> 4 ->
        dll.removeFirst();
        dll.removeEnd();
        dll.print(); // Output: 1 -> 3 ->
    }
}
