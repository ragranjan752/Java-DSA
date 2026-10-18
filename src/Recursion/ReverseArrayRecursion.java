package Recursion;

public class ReverseArrayRecursion {
    static void main(String[] args) {
        int[] arr = {5,3,7,12,76,9,34,5};
        System.out.print("Reverse Array : ");
        recPrint(arr,0);
    }
    public static void recPrint(int[] arr,int idx){
        if(idx == arr.length) return; // base case
        recPrint(arr,idx+1); // call
        System.out.print(arr[idx]+" "); // work
    }
}
