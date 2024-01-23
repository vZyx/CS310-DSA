package Array;

public class DataStructures_Lab1
{
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 4, 5, 6, 7};
        int[][] arr2 = {{2, 3, 4, 0}, {3, 0, 1, 2}, {3, 4, 6, 8}};

        int max = arr1[0];
        for (int i = 0; i < 6; i++) {
            if (arr1[i] > max) {
                max = arr1[i];
            }
        }
        System.out.println("Max in arr1: " + max);

        int min = arr1[0];
        for (int i = 0; i < 6; i++) {
            if (arr1[i] < min) {
                max = arr1[i];
            }
        }
        System.out.println("Min in arr1: " + min);
        max = arr2[0][0];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr2[i][j] > max) {
                    max = arr2[i][j];
                }
            }
        }

        System.out.println("Max in arr2: " + max);
        min = arr2[0][0];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr2[i][j] < min) {
                    min = arr2[i][j];
                }
            }
        }

        System.out.println("Min in arr2: " + min);
        int sum = 0;
        double avg = 0.0;
        for (int i = 0; i < 6; i++) {
            sum += arr1[i];
        }
        avg = sum / 6.0;
        System.out.println("Sum in arr1: " + sum + " Avg: " + avg);

        sum = 0;
        avg = 0.0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                sum += arr2[i][j];
            }
        }
        avg = sum / 12.0;
        System.out.println("Sum in arr2: " + sum + " Avg: " + avg);

        System.out.print("Even numbers in arr1: ");
        for (int i = 0; i < 6; i++) {
            if (arr1[i] % 2 == 0) {
                System.out.print(arr1[i] + " ");
            }
        }

        System.out.print("\nOdd numbers in arr1: ");
        for (int i = 0; i < 6; i++) {
            if (arr1[i] % 2 != 0) {
                System.out.print(arr1[i] + " ");
            }
        }

        System.out.print("\nEven numbers in arr2: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr2[i][j] % 2 == 0) {
                    System.out.print(arr2[i][j] + " ");
                }
            }
        }

        System.out.print("\nOdd numbers in arr2: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr2[i][j] % 2 != 0) {
                    System.out.print(arr2[i][j] + " ");
                }
            }
        }

        System.out.print("\nSquare of numbers in arr1: ");
        for (int i = 0; i < 6; i++) {
            System.out.print(arr1[i] * arr1[i] + " ");
        }

        System.out.println("\nSquare of numbers in arr2:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print((arr2[i][j] * arr2[i][j]) + "\t");
            }
            System.out.println();
        }


        int[] arr3 = {10, 10, 20, 5, 100, 2};
        int[] arr4 = new int[6];

        for (int i = 0; i < 6; i++) {
            arr4[i] = arr1[i] + arr3[i];
        }
        System.out.print("arr4: ADDITION of arr1 and arr3: ");
        for (int i = 0; i < 6; i++) {
            System.out.print(arr4[i] + " ");
        }

        int[][] arr5 = {{1, 1, 2}, {2, 5, 2}, {4, 4, 4}, {3, 0, 0}};
        int[][] arr6 = new int[3][3];

        System.out.println("\narr6: MULTIPLICATION of arr2 and arr5: ");
        for (int k = 0; k < 3; k++) {
            for (int j = 0; j < 3; j++) {
                for (int i = 0; i < 4; i++)
                    arr6[k][j] = arr6[k][j] + arr2[k][i] * arr5[i][j];
            }
        }
        for (int k = 0; k < 3; k++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr6[k][j]+" ");
            }
            System.out.println();
        }
    }
}
