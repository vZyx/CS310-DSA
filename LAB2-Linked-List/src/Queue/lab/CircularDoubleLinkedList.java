package Queue.lab;

public class CircularDoubleLinkedList<E>
{

    // Nested Node inner-class:
    private static class Node<E>
    {
        private E data;            // reference to the data in the Node
        private Node<E> next;      // reference to the next Node in the list
        private Node<E> prev;      // reference to the previous Node in the list

        Node(E data, Node<E> next, Node<E> prev)
        {
            this.data = data;
            this.next = next;
            this.prev = prev;
        } // end of Node constructor

        E getData()
        {
            return data;
        }

        Node<E> getNext()
        {
            return next;
        }

        Node<E> getPrev()
        {
            return prev;
        }

        void setData(E data)
        {
            this.data = data;
        }

        void setNext(Node<E> next)
        {
            this.next = next;
        }

        void setPrev(Node<E> prev)
        {
            this.prev = prev;
        }
    } // end of Node class
    //--------------------------------------------------

    // Attributes
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    // Constructor(s)
    public CircularDoubleLinkedList()
    {
    }

    // Accessor methods
    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return (size == 0);
    }

    public E first()
    {
        if (isEmpty()) return null;
        return head.getData();
    } // end of first

    public E last()
    {
        if (isEmpty()) return null;
        return tail.getData();
    } // end of last

    //--------------------------------------------------
    // Operations on Circular Double linked List:

    public void displayForward()
    {
        if (isEmpty())
        {
            System.out.println("\nEmpty List.. ");
            return;
        } // end if

        System.out.print("\n********** Display List ***************\n");
        Node<E> current = head;
        int count = 1;
        do
        {
            System.out.println("Node " + count + " :" + current.getData());
            current = current.next;
            count++;
        } while (current != head);
        System.out.println("***************************************\n");
    } // end displayF

    public void displayBackward()
    {
        if (isEmpty())
        {
            System.out.println("\nEmpty List.. ");
            return;
        } // end if

        System.out.print("\n********** Display List ***************\n");
        Node<E> current = tail;
        int count = 1;
        do
        {
            System.out.println("Node " + count + " :" + current.getData());
            current = current.prev;
            count++;
        } while (current != tail);
        System.out.println("***************************************\n");
    } // end displayB
    //--------------------------------------------------

    public void findNode(E key)
    {
        if (isEmpty())
        {
            System.out.println("\nEmpty list...");
            return;
        } // end if

        Node<E> current = head;
        int counter = 1;
        do
        {
            if ((current.getData() == key) || ((current.getData()).equals(key)))
            {
                System.out.println("Found in position# " + counter);
                return;
            } // end if

            counter++;
            current = current.next;
        } while (current != head); // end loop

        // if not found i.e. current==head again
        System.out.println("\nNot found...");
    } // end find

    public void findDuplicate()
    { // works only with LL of similar data types
        if (isEmpty())
        {
            System.out.println("\nEmpty list...");
            return;
        } // end if

        if (size == 1)
        {
            System.out.println("\nNo duplicates...");
            return;
        } // end if

        Node<E> current1 = head;
        boolean flag = false;

        do
        {
            Node<E> current2 = current1.next;
            while (current2 != head)
            {
                if ((current1.getData() == current2.getData()) || ((current1.getData()).equals(current2.getData())))
                {
                    flag = true;
                    System.out.println("Duplicate nodes for " + current1.getData() + ">> " + current2.getData());
                    break; // with break it will find one duplicate only
                } // end if
                current2 = current2.next;
            } // end inner loop
            current1 = current1.next;
        } while (current1 != head); // end outer loop

        // if not found i.e. flag is never true
        if (!flag)
            System.out.println("There are no duplicates in the doubly circular linked list...");

    } // end findDuplicate
    //--------------------------------------------------

    public void addFirst(E data)
    {
        Node<E> newNode = new Node<>(data, null, null);

        if (isEmpty())
        {
            head = tail = newNode;
            newNode.next = head;
            newNode.prev = head;
        } else
        {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        } // end if-else
        size++;

        // System.out.println("\nThe 1st node has been added successfully.. ");
    } // end of addFirst

    public void addLast(E data)
    {
        Node<E> newNode = new Node<>(data, null, null);

        if (isEmpty())
        {
            head = tail = newNode;
            newNode.next = head;
            newNode.prev = head;
        } else
        {
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
            newNode.next = head;
            tail = newNode;
        } // end if-else
        size++;
        // System.out.println("\nThe last node has been added successfully.. ");
    } // end of addLast
    //--------------------------------------------------

    public void removeFirst()
    {
        if (isEmpty())
        {
            System.out.println("\nEmpty list...");
            return;
        } // end if

        head = head.next;
        tail.next = head;
        head.prev = tail;
        size--;
        System.out.println("\nThe 1st node has been deleted successfully.. ");

        if (size == 0)
        {
            tail = head = null;
        } // if this was the last and only node.. fix tail & head
    } // end of removeFirst

    public void removeLast()
    {
        if (isEmpty())
        {
            System.out.println("\nEmpty list...");
            return;
        } // end if

        tail = tail.prev;
        head.prev = tail;
        tail.next = head;
        size--;
        System.out.println("\nThe last node has been deleted successfully.. ");

        if (size == 0)
        {
            tail = head = null;
        }
    } // end of removeLast
    //--------------------------------------------------

    public void removeNode(E key)
    { // delete a node at any position
        if (isEmpty())
        {
            System.out.println("\nEmpty list...");
            return;
        } // end if

        Node<E> current = head;
        Node<E> prev = head;

        while ((current.getData() != key) && (!(current.getData()).equals(key)))
        {
            if (current.next == head)
            {
                System.out.println("\nNot found...");
                return;
            }
            prev = current;
            current = current.next;
        } // end loop

        // if found:
        if (current == head)
        {
            removeFirst();
        } else if (current == tail)
        {
            removeLast();
        } else
        {
            prev.next = current.next;
            current = current.next;
            current.prev = prev;
            size--;
            System.out.println("\nThe node has been deleted successfully.. ");
        } // end if-else
    } // end removeNode

    public void addNode(E data, int position)
    { // add a node at any position
        // check if the position is correct (from 1 to size)
        if (position < 1 || position > size + 1)
        {
            System.out.println("\nInvalid Position...");
            return;
        }
        // Check if the position is 1 (first node)
        if (position == 1)
        {
            addFirst(data);
            return;
        }
        // Check if the position is the last node
        if (position == size + 1)
        {
            addLast(data);
            return;
        }

        // any other location
        Node<E> newNode = new Node<>(data, null, null);
        Node<E> current = head;

        int count = 1;
        while (count < position - 1)
        {
            current = current.next;
            count++;
        }
        // if found..
        newNode.next = current.next;
        newNode.prev = current;

        Node<E> temp = current.next;
        current.next = newNode;
        temp.prev = newNode;

        size++;
        System.out.println("\nThe node has been added successfully at position " + position + ".. ");
    } // end of addNode

    public static void main(String[] args)
    {
        CircularDoubleLinkedList list = new CircularDoubleLinkedList<Course>();

        list.addFirst(new Course(121, "OOP1"));
        list.addFirst(new Course(333, "OOP2"));
        list.addFirst(new Course(444, "AI"));
        list.addFirst(new Course(512, "Data Structures"));
        list.addFirst(new Course(616, "Digital Hardware"));
        list.addLast(new Course(333, "Math1"));
        list.addFirst(new Course(512, "Math2"));
        list.addFirst(new Course(300, "Islamic"));
        list.addLast(new Course(444, "Physics"));

        list.displayForward();
        list.displayBackward();

        list.findDuplicate();

        System.out.print("\n** Find ID (333) : ");
        list.findNode(new Course(333, ""));

        System.out.println("\nFirst Node :" + list.first());
        System.out.println("Last Node :" + list.last());
        System.out.println("----------------------------------------");

        list.removeNode(new Course(333, ""));
        list.removeNode(new Course(333, ""));
        list.displayForward();

        System.out.println("First Node: " + list.first());
        System.out.println("Last Node: " + list.last());

    }//end of main
}

