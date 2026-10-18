package MergeSort;

public class CountInversions {
    static int count = 0;
    static void main(String[] args) {
        int[] arr = {5, 2, 8, 4,1, 6, 7, 3};
        count = 0;
        mergeSort(arr);
        System.out.println();
        System.out.println("Total Inversion : "+count);
    }
    private static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return;
        // step 1: Create 2 new empty arrays of size n/2 each
        int[] a = new int[n / 2];
        int[] b = new int[n - n / 2];
        // step 2: Copy & paste arr into a and b
        int idx = 0; // idx travel on arr
        for (int i = 0; i < a.length; i++)
            a[i] = arr[idx++];
        for (int i = 0; i < b.length; i++)
            b[i] = arr[idx++];
        // step 3: apply magic on a and b
        mergeSort(a);
        mergeSort(b);
        // step 4: merge 'a' and 'b' into arr
        merge(a, b, arr);
    }

    public static void merge(int[] a, int[] b, int[] c) {
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {

            if (a[i] <= b[j]) {
                c[k++] = a[i++];
            }
            else {
                // Print all inversion pairs
                for (int x = i; x < a.length; x++) {
                    System.out.print("(" + a[x] + "," + b[j] + ")");
                }

                // Count all remaining elements of a
                count += (a.length - i);

                c[k++] = b[j++];
            }
        }

        while (i < a.length)
            c[k++] = a[i++];

        while (j < b.length)
            c[k++] = b[j++];
    }
}