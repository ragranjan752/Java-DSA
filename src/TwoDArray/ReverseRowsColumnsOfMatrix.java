package TwoDArray;

public class ReverseRowsColumnsOfMatrix {
    static void main() {
        int[][] arr = {{2,8,3,4,7},
                       {7,2,1,6,3},
                       {5,5,4,1,4},
                       {3,1,8,2,6}};
        System.out.println("Rows : " + arr.length + " " + "columns : " + arr[0].length);
        for (int i = arr.length - 1; i >= 0; i--){
            for (int j = arr[0].length - 1; j >= 0; j--){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
