package TwoDArray;

public class Rotate90DegreeMatrix {
    public static void print(int[][] arr){
        for (int[] a : arr){
            for (int ele : a){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] arr = {{2,8,3,4},
                {7,2,1,6},
                {5,5,4,1},
                {3,1,8,2}};
        System.out.println("Rows : " + arr.length + " " + "columns : " + arr[0].length);
        print(arr);
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < i; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        System.out.println("After Transpose");
        print(arr);
        System.out.println("After 90 Degree Transpose");
        for(int j = 0; j < arr[0].length; j++){
            int start = 0, end = arr[0].length - 1;
            while(start < end){
                int temp = arr[j][start];
                arr[j][start] = arr[j][end];
                arr[j][end] = temp;
                start++;
                end--;
            }
        }
        print(arr);
    }
    }
