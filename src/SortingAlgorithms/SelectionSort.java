package SortingAlgorithms;

import java.util.Scanner;

public class SelectionSort {
    public static void print(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter Array Element include Zero : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        print(arr);
        System.out.println();
        for (int i = 0; i < n - 1; i++) {
            int min = Integer.MAX_VALUE;
            int MinIdx = -1;
            for (int j = i; j < n; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    MinIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[MinIdx];
            arr[MinIdx] = temp;
        }
        print(arr);
    }
}

//Time Complexity :

//Best Case: O(n²)
//Average Case: O(n²)
//Worst Case: O(n²)