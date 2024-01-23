package Array;
import java.util.ArrayList;
import java.util.List;

public class Arraylist
{
    public static void main(String[] args) {


        // create ArrayList
        //or
        //List<String>    languages = new ArrayList<>();
        ArrayList<String> languages = new ArrayList<>();

        // add() method without the index parameter
        // Add elements to ArrayList
        languages.add("Java");
        languages.add("Python");
        languages.add("Swift");
        languages.add("dog");
        System.out.println("ArrayList: " + languages);

        // get the element from the arraylist
        String index_1 = languages.get(1);
        System.out.println("Element at index 1: " + index_1);

        // change the element of the array list
        languages.set(2, "JavaScript"); // swift --> js
        System.out.println("Modified ArrayList: " + languages);

        // remove element from index 2
        String str = languages.remove(3);
        System.out.println("Updated ArrayList: " + languages);

//        System.out.println();


        // iterate using for-each loop (iter)
        System.out.print("Accessing individual elements:  ");
        for (String element : languages){
            System.out.print(element + " ");

        }


    }


}
/*

Methods of ArrayList Class


size()
	Returns the length of the arraylist.


sort()
	Sort the arraylist elements.


clone()
	Creates a new arraylist with the same element, size, and capacity.


contains()
	Searches the arraylist for the specified element and returns a boolean result.


ensureCapacity()
	Specifies the total element the arraylist can contain.


isEmpty()
	Checks if the arraylist is empty.


indexOf()
	Searches a specified element in an arraylist and returns the index of the element.
 */