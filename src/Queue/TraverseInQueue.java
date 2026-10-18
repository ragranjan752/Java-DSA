package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TraverseInQueue {

    // Queue ko display karne ke liye
    private static void display(Queue<Integer> q) {

        int n = q.size();

        for (int i = 1; i <= n; i++) {

            // Front element print karo
            System.out.print(q.peek() + " ");

            // Front element remove karke back me add karo
            q.add(q.remove());
        }

        System.out.println();
    }

    // Queue me given index par value add karna
    public static void addAtIndex(Queue<Integer> q, int idx, int val) {

        // Invalid index check
        if (idx < 0 || idx > q.size()) {
            System.out.println("Invalid Index!");
            return;
        }

        int n = q.size();

        // idx tak ke elements ko rotate karo
        for (int i = 1; i <= idx; i++) {
            q.add(q.remove());
        }

        // New value add karo
        q.add(val);

        // Remaining old elements ko rotate karo
        for (int i = 1; i <= n - idx; i++) {
            q.add(q.remove());
        }
    }
    public static Queue<Integer> reverseQueue(Queue<Integer> q) {
        Stack<Integer> st = new Stack<>();

        while (!q.isEmpty()) {
            st.push(q.remove());
        }

        while (!st.isEmpty()) {
            q.add(st.pop());
        }

        return q;
    }
    public int FindTheWinner(int n, int k){
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++){
            q.add(i);
        }
        while (q.size()>1){
            for (int i = 1; i <= k - 1; i++){
                q.add(q.remove());
            }
            q.remove();  // kth will be remove
        }
        return q.peek();
    }
    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();

        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        display(q);
        addAtIndex(q, 2, 60);
        display(q);
        reverseQueue(q);
        display(q);
    }
}