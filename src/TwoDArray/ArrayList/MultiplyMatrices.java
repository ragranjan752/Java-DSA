package TwoDArray.ArrayList;

import java.util.ArrayList;

public class MultiplyMatrices {
  public ArrayList<ArrayList<Integer>> multiply(int[][] mat1, int[][] mat2){
      int n = mat1.length;
      ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
      for (int i = 0; i < n; i++){
          ArrayList<Integer> list = new ArrayList<>();
          ans.add(list);
          for (int j = 0; j < n; j++){
              int sum = 0;
              for (int k = 0; k < n; k++){
                  sum += (mat1[i][k]*mat2[k][j]);
              }
              ans.get(i).add(sum);
          }
      }

      return ans;
  }
    public static void main(String[] args) {
        int[][] mat1 = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9, 10, 11, 12},
                {13,14, 15, 16}
        };
        int[][] mat2 = {{1, 2, 3, 4},
                     {5, 6, 7, 8},
                     {9, 10, 11, 12},
                     {15, 20, 21,22}
        };
        MultiplyMatrices obj = new MultiplyMatrices();
        ArrayList<ArrayList<Integer>> result = obj.multiply(mat1, mat2);
        // Print the result
        for (ArrayList<Integer> row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
