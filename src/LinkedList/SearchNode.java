package LinkedList;

class Linked { // User-defined data structure

    Node head;
    Node tail;
    int size;

    // Search for a value and return its index
    int search(int val) {

        if (head == null) {
            return -1;
        }

        Node temp = head;
        int idx = 0;

        while (temp != null) {

            if (temp.val == val) {
                return idx;
            }

            temp = temp.next;
            idx++;
        }

        return -1;
    }

    // Print the linked list
    void print() {

        if (head == null) {
            return;
        }

        Node temp = head;

        while (temp != null) {

            System.out.print(temp.val + " ");

            temp = temp.next; // Very important
        }

        System.out.println();
    }
}

public class SearchNode {

    public static void main(String[] args) {

        Linked l = new Linked();

        Node a = new Node(10);
        Node b = new Node(200);
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(50);
        Node f = new Node(5);

        // Connecting nodes
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = null;

        // Set head and tail
        l.head = a;
        l.tail = f;
        l.size = 6;

        // Print linked list
        l.print();

        // Search for 5
        System.out.println("Index of 5: " + l.search(5));

        // Search for 200
        System.out.println("Index of 200: " + l.search(200));

        // Search for a value that doesn't exist
        System.out.println("Index of 100: " + l.search(100));
    }
}