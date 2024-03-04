package Array;

import java.util.Scanner;

public class ArrayOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Square of Array Numbers:");
        square(array);

        System.out.println("Maximum Value: " + maximum(array));

        System.out.println("Minimum Value: " + minimum(array));

        System.out.println("Sum of Array: " + sum(array));

        System.out.println("Average of Array: " + average(array));

        System.out.println("Even Numbers:");
        even(array);

        System.out.println("Odd Numbers:");
        odd(array);

        System.out.print("Enter the value to find: ");
        int value = scanner.nextInt();
        find(array, value);

        System.out.println("Duplicates in Array:");
        duplicate(array);

        System.out.print("Enter the value to delete: ");
        int deleteValue = scanner.nextInt();
        array = delete(array, deleteValue);
        System.out.println("Updated Array:");
        displayArray(array);

        scanner.close();
    }

    public static void square(int[] array) {
        System.out.println("The array squared: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print((array[i] * array[i]) + " ");
        }
        System.out.println("");
    }

    public static int maximum(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int minimum(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static double average(int[] array) {
        return (double) sum(array) / array.length;
    }

    public static void even(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                System.out.print(array[i] + " ");
            }
        }
    }

    public static void odd(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                System.out.print(array[i] +  " ");
            }
        }
    }

    public static void find(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                System.out.println("Value " + value + " found at index " + i);
                return;
            }
        }
        System.out.println("Value " + value + " not found in the array");
    }

    public static void duplicate(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    System.out.println(array[i]);
                }
            }
        }
    }

    public static int[] delete(int[] array, int value) {
        int[] newArray = new int[array.length - 1];
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Value " + value + " not found in the array");
            return array;
        }
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != index) {
                newArray[j++] = array[i];
            }
        }
        return newArray;
    }

    public static void displayArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

