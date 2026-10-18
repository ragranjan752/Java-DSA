package TimeAndSpaceComplexity;

public class duplicateNumber {
    static void main() {
        // Brute Force Code
//        int[] arr = {5, 1, 3, 4, 2, 4};
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[i] == arr[j]) {
//                    System.out.println("Duplicate element: " + arr[i]);
//                    System.out.println("Found at indices: " + i + " and " + j);
//                }
//            }
//        }
//        // optimized approach code
//        int[] arr = {5, 1, 3, 4, 2, 4};
//        int n = arr.length;
//        boolean[] flag = new boolean[n+1];
//        for(int i = 0; i < n; i++){
//            int ele = arr[i];
//            if (flag[ele] == true) System.out.print(arr[i]+" ");
//            else flag[ele] = true;
//        }

        // Most Optimized Approach
        int[] arr = {5, 1, 3, 4, 2, 4};
        int n = arr.length;
        int sum = 0;
        int s = 0;
        int missing = 0;
        for (int i = 0; i < n; i++) {
         sum += arr[i];
         s = ((n - 1) * n) / 2;
         missing = sum - s;
        }
        System.out.print(sum + " ");
        System.out.println(s + " ");
        System.out.println(missing);
    }
}
