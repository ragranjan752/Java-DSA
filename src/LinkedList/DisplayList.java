package LinkedList;

public class DisplayList {
    public static void display(Node head) {
        System.out.print(head.val + " ");
        System.out.print(head.next.val + " ");
        System.out.print(head.next.next.val + " ");
        System.out.print(head.next.next.next.val + " ");
        System.out.print(head.next.next.next.next.val + " ");
        System.out.print(head.next.next.next.next.next.val + " ");
    }

    static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(200);
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(50);
        Node f = new Node(5);
        //System.out.println(a.next);
        // connecting now
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        display(a);
    }
}
