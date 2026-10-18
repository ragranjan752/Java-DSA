package Recursion;

public class RecursionOnArrays {
    static void main(String[] args) {
        int[] arr = {5,3,7,12,76,9,34,5};
        System.out.print("Array : ");
        recPrint(arr,0);
    }
    public static void recPrint(int[] arr,int idx){
        if(idx == arr.length) return; // base case
        System.out.print(arr[idx]+" "); // work
        recPrint(arr,idx+1); // call
    }
}