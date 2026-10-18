package TwoDArray;

public class snakePattern {
    static void main() {
        int[][] arr = {{6, 0, 2, 7, 6},
                       {1, 3, 7, 2, 2},
                       {9, 9, 4, 5, 2}};
        System.out.println("Rows : " + arr.length + " " + "columns : " + arr[0].length);
        for (int i = 0; i < arr.length; i++){
            if(i % 2 == 0) {
                for (int j = 0; j < arr[0].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            else{
                for (int j = arr[0].length - 1; j >= 0; j--)
                {
                    System.out.print(arr[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
}
