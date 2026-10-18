package TwoDArray;

public class sumOfMatrix {
    static void main() {
        int[][] arr = {{6,0,2,7,6},{1,3,7,2,2},{9,9,4,5,2}};
        System.out.println("Rows : "+arr.length+" "+"columns : "+arr[0].length);
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                sum = sum + arr[i][j];
            }
        }
        System.out.print(sum+" ");
    }
}
