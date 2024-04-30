package Quadratic;

import java.util.Arrays;

public class BubbleSort {

    // Method tp perform the bubble sort
    public static void bubbleSort(int[] array) {
        // loop to access each array element
        for (int i = array.length - 1; i > 0; i--) {
            // loop to compare array elements
            for (int j = 0; j < i; j++) {
                // compare two adjacent element.  change > to < to sort in descending order
                if (array[j] > array[j+1]) {
                    // swapping occurs if elements are not in the intended order
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {

        int[] myArray = {4,2,6,5,1,3};

        bubbleSort(myArray);

        System.out.println( (Arrays.toString(myArray)) );

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6]

         */

    }

}
/*
        Another Way
    int size = array.length;

    // loop to access each array element
    for (int i = 0; i < size - 1; i++)

    // loop to compare array elements
      for (int j = 0; j < size - i - 1; j++)
*/
