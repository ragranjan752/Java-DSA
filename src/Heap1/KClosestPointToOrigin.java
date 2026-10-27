package Heap1;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Arrays;

class Triplet implements Comparable<Triplet> {
    int dist;
    int x;
    int y;

    Triplet(int dist, int x, int y) {
        this.dist = dist;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Triplet t) {
        return Integer.compare(this.dist, t.dist);
    }
}

public class KClosestPointToOrigin {

    public int[][] KClosest(int[][] points, int k) {

        // Max Heap: farthest point stays at the top
        PriorityQueue<Triplet> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            // Squared distance from origin (0, 0)
            int dist = x * x + y * y;

            pq.add(new Triplet(dist, x, y));

            // Keep only k closest points
            if (pq.size() > k) {
                pq.remove();
            }
        }

        int[][] ans = new int[k][2];

        // Extract the remaining k points
        for (int i = 0; i < k; i++) {
            Triplet top = pq.remove();
            ans[i][0] = top.x;
            ans[i][1] = top.y;
        }
        return ans;
    }

    public static void main(String[] args) {

        KClosestPointToOrigin obj = new KClosestPointToOrigin();

        int[][] points = {
                {1, 3},
                {-2, 2},
                {5, 8},
                {0, 1}
        };

        int k = 2;

        int[][] result = obj.KClosest(points, k);

        System.out.println("K Closest Points:");

        for (int[] point : result) {
            System.out.println(Arrays.toString(point));
        }
    }
}