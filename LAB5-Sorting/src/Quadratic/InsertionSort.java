package Quadratic;

import java.util.Arrays;

public class InsertionSort
{

    public static void insertionSort(int[] array) {
        // Loop through each element in the array starting from the second element (start from 1)
        for (int i = 1; i < array.length; i++) {
            // Store the value of the current element in a temporary variable
            int valueToInsert = array[i];

            // Start from the previous index of the current element
            int j = i - 1;

            // Move elements of array that are greater than valueToInsert to one position ahead of their current position
            // This loop also shifts elements to the right to make space for the insertion of valueToInsert
            while (j > -1 && valueToInsert < array[j]) {
                array[j+1] = array[j];          // Shift the element to the right
                array[j] = valueToInsert;      // Insert valueToInsert into the correct position
                j--;                           // Move to the previous element
            }
        }
    }



    public static void main(String[] args) {

        int[] myArray = {4,2,6,5,1,3};

        insertionSort(myArray);

        System.out.println( Arrays.toString(myArray) );

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6]

         */

    }

}
/*
void insertionSort(int array[]) {
    int size = array.length;

    for (int step = 1; step < size; step++) {
      int key = array[step];
      int j = step - 1;

      // Compare key with each element on the left of it until an element smaller than
      // it is found.
      // For descending order, change key<array[j] to key>array[j].
      while (j >= 0 && key < array[j]) {
        array[j + 1] = array[j];
        --j;
      }

      // Place key at after the element just smaller than it.
      array[j + 1] = key;
    }
  }

  
*/