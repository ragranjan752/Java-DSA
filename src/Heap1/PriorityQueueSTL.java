package Heap1;

import java.util.*;

class Pair implements Comparable<Pair> {
    int ele;
    int freq;

    Pair(int ele, int freq) {
        this.ele = ele;
        this.freq = freq;
    }

    // Sort by frequency ascending.
    // If frequencies are equal, smaller element comes first.
    public int compareTo(Pair p) {
        if (this.freq == p.freq) {
            return Integer.compare(this.ele, p.ele);
        }
        return Integer.compare(this.freq, p.freq);
    }
}

public class solved {

    public static void main(String[] args) {

        // Input for kth smallest element
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(5);
        pq.add(8);
        pq.add(2);
        pq.add(0);
        pq.add(3);
        pq.add(1);
        pq.add(7);
        pq.add(6);

        System.out.println("6th Smallest: " + kthSmallestEle(pq, 6));

        // Input for nearly sorted array
        int[] arr = {5, 8, 2, 0, 3, 1, 7, 6};

        nearlySorted(arr, 5);

        System.out.println("Sorted Array: " + Arrays.toString(arr));

        // Last Stone Weight
        int[] stones = {2, 7, 4, 1, 8, 1};

        System.out.println("Last Stone Weight: "
                + lastStoneWeight(stones));

        // Top K frequent elements
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        solved obj = new solved();

        System.out.println("Top K Frequent: "
                + obj.topKFreq(nums, k));
    }

    // Find kth smallest element using a Max Heap
    public static int kthSmallestEle(PriorityQueue<Integer> arr, int k) {

        if (k < 1 || k > arr.size()) {
            throw new IllegalArgumentException("Invalid value of k");
        }

        // Max Heap: largest element stays at the root
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int ele : arr) {
            pq.add(ele);

            // Keep only the k smallest elements
            if (pq.size() > k) {
                pq.remove();
            }
        }

        // Root is the kth smallest element
        return pq.peek();
    }

    // Sort a nearly sorted array using a Min Heap
    // Assumption: each element is at most k positions away
    // from its correct sorted position
    public static void nearlySorted(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int idx = 0;

        for (int ele : arr) {
            pq.add(ele);

            // Keep at most k + 1 elements in the heap
            if (pq.size() > k + 1) {
                arr[idx++] = pq.remove();
            }
        }

        // Add remaining elements in ascending order
        while (!pq.isEmpty()) {
            arr[idx++] = pq.remove();
        }
    }

    // Find the last remaining stone using a Max Heap
    public static int lastStoneWeight(int[] stones) {

        // Largest stone stays at the root
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int ele : stones) {
            pq.add(ele);
        }

        // Smash the two heaviest stones
        while (pq.size() > 1) {
            int first = pq.remove();
            int second = pq.remove();

            // Add the difference if weights are unequal
            if (first != second) {
                pq.add(first - second);
            }
        }

        // Return remaining stone, or 0 if none remain
        return pq.isEmpty() ? 0 : pq.remove();
    }

    // Find the k most frequent elements using a Min Heap
    public ArrayList<Integer> topKFreq(int[] arr, int k) {

        if (k <= 0) {
            return new ArrayList<>();
        }

        // Count the frequency of every element
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        // Min Heap: lowest frequency stays at the root
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int ele : map.keySet()) {
            int freq = map.get(ele);

            pq.add(new Pair(ele, freq));

            // Keep only the k most frequent elements
            if (pq.size() > k) {
                pq.remove();
            }
        }

        // Collect the selected elements
        ArrayList<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            Pair top = pq.remove();
            ans.add(top.ele);
        }

        // Sort result for consistent ascending output
        Collections.sort(ans);

        return ans;
    }
}
