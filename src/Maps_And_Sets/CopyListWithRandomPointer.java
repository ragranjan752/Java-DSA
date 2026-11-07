package Maps_And_Sets;

import java.util.HashMap;

public class CopyListWithRandomPointer {

    // Step 1: Create a deep copy of the linked list
    // Copy only data and next pointers
    public static Node deepCopy(Node head1) {

        Node temp1 = head1;

        // Dummy node for the new linked list
        Node head2 = new Node(-1);
        Node temp2 = head2;

        while (temp1 != null) {

            // Create a new node with the same data
            Node t = new Node(temp1.data);

            // Connect the new node
            temp2.next = t;

            // Move both pointers forward
            temp2 = temp2.next;
            temp1 = temp1.next;
        }

        // Return the copied linked list
        return head2.next;
    }

    public static Node cloneLinkedList(Node a) {

        // Step 1: Copy the linked list using next pointers
        Node b = deepCopy(a);

        // Step 2: Store original and copied nodes in HashMap
        HashMap<Node, Node> map = new HashMap<>();

        Node tempA = a;
        Node tempB = b;

        while (tempA != null) {

            // Map original node to its copied node
            map.put(tempA, tempB);

            tempA = tempA.next;
            tempB = tempB.next;
        }

        // Step 3: Copy random pointers
        tempA = a;

        while (tempA != null) {

            // Get the corresponding copied node
            tempB = map.get(tempA);

            // Connect its random pointer to the copied random node
            tempB.random = map.get(tempA.random);

            tempA = tempA.next;
        }

        // Return the cloned linked list
        return b;
    }
}