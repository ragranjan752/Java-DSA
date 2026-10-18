package SortingAlgorithms;
import java.util.Scanner;
public class ZeroAtEnd {
    public static void print(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter Array Element include Zero : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != 0) {

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        print(arr);
    }
}

//This is the optimal solution with:
//Time Complexity: O(n)
//Space Complexity: O(1)
