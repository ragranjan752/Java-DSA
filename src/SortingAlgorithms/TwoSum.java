package SortingAlgorithms;

import java.util.Scanner;

public class TwoSum {
    public static void print(int[] a) {
        for (int ele : a) {
            System.out.print(ele + " ");
        }
    }
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Size : ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.print("Enter Array Elements : ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.print("Array : ");
        print(a);
        System.out.print("\nEnter Target : ");
        int target = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] + a[j] == target) {
                    System.out.println("\nTarget Found!");
                    System.out.println("Indices : " + i + " , " + j);
                    System.out.println("Values : " + a[i] + " + " + a[j] + " = " + target);
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        if (!found) {
            System.out.println("\nTarget Not Found");
        }
    }
}

//Time Complexity
//Time: O(n²)
//Space: O(1)