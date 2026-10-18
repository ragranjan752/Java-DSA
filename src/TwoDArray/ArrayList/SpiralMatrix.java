package TwoDArray.ArrayList;

import java.util.ArrayList;

public class SpiralMatrix {
    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return ans;
        }

        int m = mat.length;
        int n = mat[0].length;

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top row
            for (int j = left; j <= right; j++) {
                ans.add(mat[top][j]);
            }
            top++;

            // Traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                ans.add(mat[i][right]);
            }
            right--;

            // Traverse from right to left along the bottom row (if any row remains)
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    ans.add(mat[bottom][j]);
                }
                bottom--;
            }

            // Traverse from bottom to top along the left column (if any column remains)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(mat[i][left]);
                }
                left++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9, 10, 11, 12},
                {13,14, 15, 16}
        };

        SpiralMatrix obj = new SpiralMatrix();
        ArrayList<Integer> result = obj.spirallyTraverse(mat);

        // Print the result
        for (int val : result) {
            System.out.print(val + " ");
        }
        // Expected output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
    }
}