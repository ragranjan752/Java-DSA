package MergeSort;

public class TwoSortedArray {
    static void main(String[] args) {
        int[] arr = {10,20,60,90,120};
        int[] brr = {30,40,50,70,100,110,130,140};
        int[] crr = new int[arr.length + brr.length];

        merge(arr, brr, crr);

        for (int x : crr) {
            System.out.print(x + " ");
        }
    }
    public static void merge(int[] arr, int[] brr, int[] crr){
        int i = 0, j = 0,k = 0;
        while(i < arr.length && j < brr.length){
            if(arr[i] <= brr[j]) crr[k++] = arr[i++];
            else crr[k++] = brr[j++];
        }
        while (i<arr.length) crr[k++] = arr[i++];
        while(j<brr.length) crr[k++] = brr[j++];
    }
}
