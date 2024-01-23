package Array;

public class DynamicArray {
    int capacity;
    int length;
    int[] arr;

    public DynamicArray() {
        capacity = 2;
        length = 0;
        arr = new int[2];
    }

    // Insert n in the last position of the array
    public void push(int n) {
        if (length == capacity) {
            this.resize();
        }

        // insert at next empty position
        arr[length] = n;
        length++;
    }

    public void resize() {
        // Create new array of double capacity
        capacity = 2 * capacity;
        int[] newArr = new int[capacity];

        // Copy elements to newArr
        for (int i = 0; i < length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    // Remove the last element in the array
    public void pop() {
        if (length > 0) {
            length--;
        }
    }

    // Get value at i-th index
    public int get(int i) {
        if (i < length) {
            return arr[i];
        }
        // Here we would throw an out of bounds exception
        return -1;
    }

    // Insert n at i-th index
    public void insert(int i, int n) {
        if (i < length) {
            arr[i] = n;
            return;
        }
        return;
        // Here we would throw an out of bounds exception
    }

    public void print() {
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        DynamicArray arr1 = new DynamicArray();

        // Demonstrate the functionality
        arr1.push(1);
        arr1.push(2);
        arr1.push(3);
        arr1.push(4);
        arr1.push(5);

        System.out.print("Original Array: ");
        arr1.print();

        arr1.pop();
        System.out.print("\nArray after popping: ");
        arr1.print();

        int valueAtIndex2 = arr1.get(2);
        System.out.print("\nValue at index 2: " + valueAtIndex2);

        arr1.insert(1, 10);
        System.out.print("\nArray after inserting 10 at index 1: ");
        arr1.print();
    }

}