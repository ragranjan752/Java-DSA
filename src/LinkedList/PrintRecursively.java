package LinkedList;

public class PrintRecursively {
    public static void displayRecurs(Node head) {
        if (head == null) return; // Base case
        System.out.print(head.val + " "); // work
        displayRecurs(head.next); // Recursive call
    }

    static void main(String[] args) {
        Node a = new Node(10);
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
        displayRecurs(a);
    }
}