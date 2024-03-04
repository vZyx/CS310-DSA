package Array;

import java.util.Scanner;

public class TwoDArrayOperations
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows for the array: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns for the array: ");
        int columns = scanner.nextInt();

        int[][] array = new int[rows][columns];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                array[i][j] = scanner.nextInt();
            }
        }

        System.out.println("displaying the array:");
        displayArray(array);

        System.out.println("Maximum value in the array: " + maximum(array));


        System.out.println("Sum of the array: " + sum(array));

        System.out.println("Average of the array: " + average(array));

        System.out.println("Even numbers in the array:");
        even(array);

        System.out.println("Odd numbers in the array:");
        odd(array);

        System.out.println("Square of array elements:");
        square(array);

        System.out.print("Enter the value to find: ");
        int value = scanner.nextInt();
        find(array, value);

        System.out.println("Enter the size of the second array:");
        int[][] array2 = new int[rows][columns];

        System.out.println("Enter the elements of the second array:");
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                array2[i][j] = scanner.nextInt();
            }
        }

        int[][] sumArray = addArrays(array, array2);
        System.out.println("Sum of the arrays:");
        displayArray(sumArray);

        int[][] differenceArray = subtractArrays(array, array2);
        System.out.println("Difference of the arrays:");
        displayArray(differenceArray);

        int[][] productArray = multiplyArrays(array, array2);
        System.out.println("Product of the arrays:");
        displayArray(productArray);

        scanner.close();
    }

    public static void displayArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int maximum(int[][] array)
    {
        int max = array[0][0];
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                if (array[i][j] > max)
                {
                    max = array[i][j];
                }
            }
        }
        return max;
    }

    public static int minimum(int[][] array) {
        int min = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                }
            }
        }
        return min;
    }

    public static void even(int[][] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                if (array[i][j] % 2 == 0)
                {
                    System.out.print(array[i][j] + " ");
                }
            }
        }
        System.out.println();
    }

    public static void odd(int[][] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                if (array[i][j] % 2 != 0)
                {
                    System.out.print(array[i][j] +  " ");
                }
            }
        }
        System.out.println();
    }

    public static void square(int[][] array)
    {
        System.out.println("squared: ");
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                System.out.print( array[i][j] * array[i][j] +  " " );
            }
        }
        System.out.println();
    }


    public static int sum(int[][] array)
    {
        int sum = 0;
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                sum += array[i][j];
            }
        }
        return sum;
    }

    public static double average(int[][] array)
    {
        int totalElements = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                totalElements++;
                sum += array[i][j];
            }
        }
        return (double) sum / totalElements;
    }


    public static void find(int[][] array, int value)
    {
        boolean found = false;
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                if (array[i][j] == value)
                {
                    System.out.println("Value " + value + " found at position (" + i + ", " + j + ")");
                    found = true;
                }
            }
        }
        if (!found)
        {
            System.out.println("Value " + value + " not found in the array");
        }
    }

    public static int[][] addArrays(int[][] array1, int[][] array2)
    {
        int[][] result = new int[array1.length][array1[0].length];
        for (int i = 0; i < array1.length; i++)
        {
            for (int j = 0; j < array1[i].length; j++)
            {
                result[i][j] = array1[i][j] + array2[i][j];
            }
        }
        return result;
    }

    public static int[][] subtractArrays(int[][] array1, int[][] array2)
    {
        int[][] result = new int[array1.length][array1[0].length];
        for (int i = 0; i < array1.length; i++)
        {
            for (int j = 0; j < array1[i].length; j++)
            {
                result[i][j] = array1[i][j] - array2[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplyArrays(int[][] array1, int[][] array2)
    {
        int[][] result = new int[array1.length][array2[0].length];
        for (int i = 0; i < array1.length; i++)
        {
            for (int j = 0; j < array2[0].length; j++)
            {
                for (int k = 0; k < array1[0].length; k++)
                {
                    result[i][j] += array1[i][k] * array2[k][j];
                }
            }
        }
        return result;
    }
}

