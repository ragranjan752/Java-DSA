package CyclicSort;

public class MissingElement {
    static void main(String[] args) {
        int[] arr = {9, -4, 0, 1, 7, 3, 3};
        System.out.println(missing(arr));
    }

    public static int missing(int[] arr) {
        int i = 0, n = arr.length;
        while(i < n){
            if(arr[i] <= 0) i++;
            else if(arr[i] > n) i++;
            else if(arr[i] == i + 1) i++; // already at correct place
            else if (arr[i] == arr[arr[i] - 1]) i++; // duplicate
            else swap(arr,i,arr[i] - 1);
        }
        for (i = 0; i < n; i++){ // first missing element
            if (arr[i] == i + 1) {
                continue;
            }

        }
        return i + 1;
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
