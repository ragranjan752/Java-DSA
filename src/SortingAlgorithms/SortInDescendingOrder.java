package SortingAlgorithms;

public class SortInDescendingOrder {
    static void main() {
        int[] arr = {100,91,87,76,66,52,43,35,29,13,5};
        int tar = 29;
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == tar) {
                System.out.println("Found at index: " + mid);
                break;
            }
            else if (arr[mid] > tar) {
                lo = mid + 1;

            } else if (arr[mid] < tar) {
                hi = mid - 1;

            } else {
                System.out.println("\nFound");
                break;
            }
        }
    }
}
