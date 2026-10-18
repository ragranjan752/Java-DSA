package SortingAlgorithms;

public class BubbleSortDesecndingOrder {
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Input array
        int[] arr = {5, -2, 6, 7, 2, 0, 7, 2};
        int n = arr.length;

        System.out.println("Before Sorting:");
        print(arr);

        // Outer loop for each pass
        for (int i = 0; i < n - 1; i++) {

            // Counts the number of swaps in the current pass
            int swaps = 0;

            // Compare adjacent elements
            // Last 'i' elements are already sorted
            for (int j = 0; j < n - 1 - i; j++) {

                // Swap if elements are in the wrong order
                if (arr[j] < arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    // Increase swap count
                    swaps++;
                }
            }

            // If no swaps occurred, array is already sorted
            if (swaps == 0) {
                break;
            }
        }

        System.out.println("After Sorting:");
        print(arr);
    }
}
