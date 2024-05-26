package lab;

public class StackLinkedList<E> {

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
    }//end of Node class

    private Node<E> top=null;
    private int size=0;

    public StackLinkedList() { }

    public boolean isEmpty(){return size==0;}
    public int size() {return size;}

    public E top() {
        if (isEmpty()) return null;
        return top.data;
    }//end of top

    public void push(E value){
        Node<E> newNode=new Node(value,top);
        top=newNode;
        size++;
        System.out.println(value + " has been PUSHED successfully!");
    }//end of push

    public void display(){
        if (isEmpty()) {
            System.out.println("\nERROR: Empty Stack!");
            return;
        }//end if

        System.out.print("\n********** Display Stack **************\n");

        Node<E> current=top;
        while(current!=null)
        {
            System.out.println(current.data);
            current=current.next;
        }//end loop

        System.out.println("***************************************\n");
    }//end of display

    public void pop() {
        if (isEmpty()) {
            System.out.println("\nERROR: Stack Underflow!");
            return;
        }//end if

        System.out.println(top.data + " has been POPPED successfully!");
        top = top.next;
        size--;
    }//end of pop

    public void makeEmpty(){
        top=null;
        size=0;
    }//end of makeEmpty


    public static void main(String[] args) {

        StackLinkedList stack1=new StackLinkedList();

        System.out.println( "Testing a Stack using SLL: ");
        System.out.println("***************************");

        //1. start pushing elements
        stack1.push(10);
        stack1.push(30.5);
        stack1.push('A');
        stack1.push("Water");
        stack1.display();

        System.out.println("Top of stack: "+ stack1.top());
        System.out.println("Size of stack: "+ stack1.size()+"\n");

        //2. start poping:
        stack1.pop();
        stack1.pop();
        stack1.pop();
        stack1.pop();
        stack1.pop();  //stack underflow
        stack1.display();  //empty stack

        System.out.println("Top of stack: "+ stack1.top());
        System.out.println("Size of stack: "+ stack1.size());

    }//end of main
}//end of class
