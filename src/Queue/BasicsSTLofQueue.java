package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class BasicsSTLofQueue {
    static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10); q.add(20); q.add(30);
        System.out.println(q+" "+q.peek());
        q.remove(); //10
        System.out.println(q+" "+q.size());
    }
}
