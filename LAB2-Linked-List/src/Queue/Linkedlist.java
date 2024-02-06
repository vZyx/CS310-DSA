package Queue;
import java.util.LinkedList;
public class Linkedlist
{
    public static void main(String[] args) {
        // create linked list
        LinkedList<String> animals = new LinkedList<>();

        // Add elements to LinkedList
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Cow");
        System.out.println("animals LinkedList: " + animals);

        // add() method with the index parameter
        animals.add(1, "Horse");
        System.out.println("Updated LinkedList: " + animals);

        // create linked list
        LinkedList<String> languages= new LinkedList<>();

        // add elements in the linked list
        languages.add("Java");
        languages.add("Python");
        languages.add("JavaScript");
        languages.add("Java");
        System.out.println("languages LinkedList: " + languages);

        // get the element from the linked list
        String str = languages.get(1);
        System.out.println("Element at index 1: " + str);


        // change elements at index 3
        languages.set(3, "Kotlin");
        System.out.println("Updated LinkedList: " + languages);

        // remove elements from index 1
        String strr = languages.remove(1);
        System.out.println("Removed Element: " + strr);

        System.out.println("Updated LinkedList: " + languages);

        LinkedList<String> myLinkedlist = new LinkedList<>();
        myLinkedlist.add("One");
        myLinkedlist.add("Two");
        myLinkedlist.add("Three");
        myLinkedlist.add("Four");

        System.out.println(myLinkedlist);

        System.out.println("HEAD: " + myLinkedlist.peekFirst()); // return the head
        System.out.println("TAIL: " + myLinkedlist.peekLast());  // return the tail
        System.out.println("Length: " + myLinkedlist.size());      // return the Length
    }
}
