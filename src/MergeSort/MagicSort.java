package MergeSort;


public class MagicSort {
    static void main(String[] args) {
        int[] arr = {5, 2, 8, 4,-100,1, 6, 7, 3, -5};
        mergeSort(arr);
        for (int ele : arr) System.out.print(ele + " ");
    }

    private static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n == 1) return;
        // step 1: Create 2 new empty arrays of size n/2 each
        int[] a = new int[n / 2];
        int[] b = new int[n - n / 2];
        // step 2: Copy & paste arr into a and b
        int idx = 0; // idx travel on arr
        for (int i = 0; i < a.length; i++) a[i] = arr[idx++];
        for (int i = 0; i < b.length; i++) b[i] = arr[idx++];
        // step 3: apply magic on a and b
        mergeSort(a);
        mergeSort(b);
        // step 4: merge 'a' and 'b' into arr
        merge(a, b, arr);
    }

    public static void merge(int[] a, int[] b, int[] crr) {
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) crr[k++] = a[i++];
            else crr[k++] = b[j++];
        }
        while (i < a.length) crr[k++] = a[i++];
        while (j < b.length) crr[k++] = b[j++];
    }
}

// algo & intuition -> divide and conqueror
// T.C -> O(2NlogN+1)
// S.C -> O(NlogN)

