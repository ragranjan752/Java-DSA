package Recursion;

import java.util.Scanner;

public class ElementExist {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {5,3,7,12,76,9,34,5};
        recPrint(arr,0);
        System.out.println();
        System.out.print("Enter Target : ");
        int ele = sc.nextInt();
        exists(arr,ele,0);

    }
    public static boolean exists(int[] arr, int ele, int idx){
        if (idx == arr.length) return false; // base case
        if(arr[idx] == ele) return true; // work
        return exists(arr,ele,idx+1); // call and work
    }
    public static void recPrint(int[] arr,int idx){
        if(idx == arr.length) return; // base case
        System.out.print(arr[idx]+" "); // work
        recPrint(arr,idx+1); // call
    }
}
