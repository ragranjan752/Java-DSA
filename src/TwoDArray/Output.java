package TwoDArray;

public class Output {
    static void main(String args[]) {
        int[][] arr = new int[3][4];
        System.out.println("Rows : "+arr.length+" "+"columns : "+arr[0].length);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
