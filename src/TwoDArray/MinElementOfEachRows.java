package TwoDArray;

public class MinElementOfEachRows {
    static void main() {
        int[][] arr = {{6, 0, 2, 7, 6}, {1, 3, 7, 2, 2}, {9, 9, 4, 5, 2}};
        System.out.println("Rows : " + arr.length + " " + "columns : " + arr[0].length);

        for (int i = 0; i < arr.length; i++) {

            int min = Integer.MAX_VALUE;

            for (int j = 0; j < arr[0].length; j++) {

                if (arr[i][j] < min) {
                    min = arr[i][j];
                }
            }

            System.out.println("Row " + i + " minimum = " + min);
        }
    }
}
