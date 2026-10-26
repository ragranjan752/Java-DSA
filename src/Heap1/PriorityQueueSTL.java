package Heap1;
import java.util.*;

public class PriorityQueueSTL {
    static void main(String[] args) {

        // Min Heap: smallest element stays at the root
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(10);
        pq.add(20);
        pq.add(-30);

        // peek() returns the smallest element without removing it
        System.out.println(pq.peek());  // -30

        pq.add(35);

        // Smallest element is still -30
        System.out.println(pq.peek());  // -30

        // Returns the total number of elements
        System.out.println(pq.size());  // 4

        // Removes and returns the smallest element
        System.out.println(pq.remove());  // -30

        // Now 10 is the smallest element
        System.out.println(pq.peek());  // 10

        // Prints the internal heap representation, not sorted order
        System.out.println(pq);  // [10, 20, 35]

        // Adding more elements to the PriorityQueue
        pq.add(5);
        pq.add(8);
        pq.add(2);
        pq.add(0);
        pq.add(3);
        pq.add(1);
        pq.add(7);
        pq.add(6);

        // Iterating over the queue does not guarantee sorted order
        for (int ele : pq) {
            System.out.print(ele + " ");
        }

        System.out.println();

        // Repeatedly removes the smallest element
        // Therefore, elements are printed in ascending order
        // The queue becomes empty after this loop
        while (!pq.isEmpty()) {
            System.out.print(pq.remove() + " ");
        }
    }
}