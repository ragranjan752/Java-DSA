package SortingAlgorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class CommonElements {

    public static void print(int[] a, int[] b) {

        System.out.print("First Array : ");
        for (int ele : a) {
            System.out.print(ele + " ");
        }

        System.out.println();

        System.out.print("Second Array : ");
        for (int ele : b) {
            System.out.print(ele + " ");
        }

        System.out.println();
    }
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 1st Array Size : ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.print("Enter 1st Array Elements : ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.print("Enter 2nd Array Size : ");
        int m = sc.nextInt();
        int[] b = new int[m];
        System.out.print("Enter 2nd Array Elements : ");
        for (int j = 0; j < m; j++) {
            b[j] = sc.nextInt();
        }
        print(a, b);
        ArrayList<Integer> common = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {

                if (a[i] == b[k] && !common.contains(a[i])) {
                    common.add(a[i]);
                }

            }
        }
        System.out.println("Common Elements : " + common);
    }
}