package SortingAlgorithms;

public class MountainPeak {

    public static int findPeak(int[] arr) {

        int lo = 0;
        int hi = arr.length - 1;

        while (lo < hi) {

            int mid = lo + (hi - lo) / 2;

            if (arr[mid] < arr[mid + 1]) {
                // Peak right side mein hai
                lo = mid + 1;
            } else {
                // Peak left side mein hai ya mid khud peak hai
                hi = mid;
            }
        } 

        return lo;
    }
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 2};

        int index = findPeak(arr);

        System.out.println("Peak Element: " + arr[index]);
        System.out.println("Peak Index: " + index);
    }
}