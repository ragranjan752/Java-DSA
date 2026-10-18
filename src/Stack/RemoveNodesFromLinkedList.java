package Stack;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class RemoveNodesFromLinkedList {
    public ListNode removeNodes(ListNode head) {

        // 1. Reverse
        head = reverse(head);

        // 2. Remove nodes using max
        int max = head.val;
        ListNode temp = head;

        while (temp != null && temp.next != null) {

            if (temp.next.val < max) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
                max = temp.val;
            }
        }

        // 3. Reverse again
        return reverse(head);
    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
