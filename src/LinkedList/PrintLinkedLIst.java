package LinkedList;

import java.util.Scanner;

public class PrintLinkedLIst {
    public static void display(Node head) {
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val+" ");
            temp = temp.next;  // very important
        }
//        for (Node temp = head; temp != null; temp = temp.next) {
//            System.out.print(temp.val + " ");
//        }

        System.out.println();
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node a = new Node(sc.nextInt());
        Node b = new Node(200);
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(50);
        Node f = new Node(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = null;
        display(a);
    }
}
