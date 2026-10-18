package SortingAlgorithms;

import java.util.Arrays;

public class BinarySearch {

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void main(String[] args) {

        int[] arr = {5, -2, 6, 7, 2, 0, 7, 2};
        int target = 100;

        Arrays.sort(arr);

        print(arr);

        int lo = 0;
        int hi = arr.length - 1;

        boolean found = false;

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            if (arr[mid] > target) {
                hi = mid - 1;

            } else if (arr[mid] < target) {
                lo = mid + 1;

            } else {
                System.out.println("\nFound");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nNot Found");
        }
    }
}