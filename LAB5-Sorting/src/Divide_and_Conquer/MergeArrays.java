package Divide_and_Conquer;

import java.util.ArrayList;

public class MergeArrays {
    public static int[] merge(int[] a, int[] b) {
        ArrayList<Integer> c = new ArrayList<>();

        while (a.length > 0 && b.length > 0) {
            if (a[0] < b[0]) {
                c.add(a[0]);
                int[] temp = new int[a.length - 1];
                System.arraycopy(a, 1, temp, 0, temp.length);
                a = temp;
            } else {
                c.add(b[0]);
                int[] temp = new int[b.length - 1];
                System.arraycopy(b, 1, temp, 0, temp.length);
                b = temp;
            }
        }

        while (a.length > 0) {
            c.add(a[0]);
            int[] temp = new int[a.length - 1];
            System.arraycopy(a, 1, temp, 0, temp.length);
            a = temp;
        }

        while (b.length > 0) {
            c.add(b[0]);
            int[] temp = new int[b.length - 1];
            System.arraycopy(b, 1, temp, 0, temp.length);
            b = temp;
        }

        int[] result = new int[c.size()];
        for (int i = 0; i < c.size(); i++) {
            result[i] = c.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7};
        int[] b = {2, 4, 6, 8};

        int[] c = merge(a, b);

        System.out.println("Merged array:");
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
    }
}
