package Queue.lab;


public class LinkedList<E>
{

    //Nested Node inner-class:
    private static class Node<E>
    {
        private E data;         //reference to the data in the Node
        private Node<E> next;   //reference to the next Node in the list

        Node(E data, Node<E> next)
        {
            this.data = data;
            this.next = next;
        }//end of Node constructor

        E getData()
        {
            return data;
        }

        Node<E> getNext()
        {
            return next;
        }

        void setData(E data)
        {
            this.data = data;
        }

        void setNext(Node<E> next)
        {
            this.next = next;
        }
    }//end of Node class

    //Attributes
    private Node<E> head = null;   //reference to head node or null if empty
    private Node<E> tail = null;   //reference to tail node or null if empty
    private int size = 0;          //number of nodes in the list

    //Constructor(s)
    public LinkedList()
    {
    }

    //Accessor methods
    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return (size == 0);
    }

    public E ﬁrst()
    {
        if (isEmpty()) return null;
        return head.getData();  //or head.data directly
    }//end of first

    public E last()
    {
        if (isEmpty()) return null;
        return tail.getData();
    }//end of last


    //Operations on linkedList:
    public void display()
    {
        if (isEmpty())
        {
            System.out.println("\nEmpty List.. ");
            return;
        }//end if

        System.out.println("\nDisplay List: ");
        Node<E> current = head;
        int count = 1;
        while (current != null)
        {
            System.out.print("\tNode " + count + " :" + current.getData());
            current = current.getNext();  //or current.next
            count++;
        }//end loop

        //OR: using for-loop:
   /*   Node<E> current1 = head;
        for (int i=0; i<size;i++) {
            System.out.print("\tNode "+(i+1)+" :"+current1.getData());
            current1 = current1.getNext();
        }//end loop
       */

    }//end display

    public void findNode(E key)
    {
        if (isEmpty())
        {
            System.out.println("\nEmpty list...");
            return;
        }//end if

        Node<E> current = head;
        int counter = 1;
        while (current != null)
        {
            //For primitive data types /OR for objects use equals method that you have overridden it in your class
            if ((current.getData() == key) || ((current.getData()).equals(key)))
            {
                System.out.println("\nFound in position# " + counter);
                return;
            }//end if
            counter++;
            current = current.getNext();
        }//end loop

        //if not found i.e. current==null
        System.out.println("\nNot found...");
    }//end find

    public void removeFirst()
    {
        if (isEmpty())
        {
            System.out.println("\nEmpty list...");
            return;
        }//end if

        head = head.getNext();
        size--;
        //System.out.println("\nThe 1st node has been deleted successfully.. ");
        if (size == 0)
        {
            tail = null;
        } //if this was the last and only node.. ﬁx tail
    }//end of removeFirst

    public void addFirst(E data)
    {
        Node<E> newNode = new Node<E>(data, head);
        head = newNode;
        size++;
        //System.out.println("\nThe 1st node has been added successfully.. ");
        if (size == 1)
        {
            tail = head;
        }
    }//end of addFirst

    public void addLast(E data)
    {
        Node<E> newNode = new Node(data, null);
        if (size == 0)
        {
            head = newNode;
            tail = newNode;
        } else
        {
            tail.next = newNode;
            tail = newNode;
        }//end if
        size++;
        //System.out.println("\nThe last node has been added successfully.. ");
    }//end of addLast

    public void removeNode(E key)
    { //delete a node at any position
        if (isEmpty())
        {
            System.out.println("\nEmpty list...");
            return;
        }//end if

        Node<E> current = head;
        Node<E> prev = head;

        while ((current.getData() != key) && (!(current.getData()).equals(key)))
        {
            if (current.next == null)
            {
                System.out.println("\nNot found...");
                return;
            }
            prev = current;
            current = current.next;
        }//end loop

        //if found:
        if (current == head)
        {
            removeFirst();
        } else
        {
            prev.next = current.next;
            size--;
            //if removing the last node, fix the tail
            if (current == tail)
            {
                tail = prev;
            }
        }
    }//end removeNode

    public void addNode(E data, int position)
    { //add a node at any position
        //check if the position is correct (from 1 to size)
        if (position < 1 || position > size + 1)
        {
            System.out.println("\nInvalid Position...");
            return;
        }
        //Check if the position is 1 (ﬁrst node)
        if (position == 1)
        {
            addFirst(data);
            return;
        }

        //Check if the position is the last node
        if (position == size + 1)
        {
            addLast(data);
            return;
        }

        //any other location
        Node<E> newNode = new Node<E>(data, null);
        Node<E> current = head;

        int count = 1;
        while (count < position - 1)
        {
            current = current.getNext();
            count++;
        }
        //if found..
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;
    }//end of addNode

    public static void main(String[] args)
    {
        LinkedList myList = new LinkedList();

        myList.findNode(2);

        myList.addFirst("Nada");
        myList.addFirst(10);
        myList.addFirst('X');
        myList.addFirst(50.5);
        myList.display();

        myList.addFirst("Sara");
        myList.display();

        myList.removeNode('X');
        myList.display();

        myList.addNode("hi", 2);
        myList.display();

        myList.removeNode("Nada");
        myList.display();

        System.out.println("\n" + myList.last());
        myList.findNode(2);
    }
}
