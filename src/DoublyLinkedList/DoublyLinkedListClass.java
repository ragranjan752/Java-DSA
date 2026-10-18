package DoublyLinkedList;

import java.util.List;

class ListNode { // user define data type
    int val;
    ListNode next;
    ListNode pre;

    ListNode(int val) {
        this.val = val;
    }
}

class DLL {
    ListNode head;
    ListNode tail;
    int size;

    void InsertAtHead(int val) {
        ListNode temp = new ListNode(val);
        if (head == null) head = tail = temp;
        else {
            temp.next = head;
            head.pre = temp;
            head = temp;
        }
        size++;
    }

    void InsertAtTail(int val) {
        ListNode temp = new ListNode(val);
        if (head == null) head = tail = temp;
        else {
            tail.next = temp;
            temp.pre = tail;
            tail = temp;
        }
        size++;
    }

    void DelAtHead() {
        if (size == 0) {
            System.out.print("List is Empty");
            return;
        }
        if (size == 1) head = tail = null;
        else {
            head = head.next;
            head.pre = null;
        }
        size--;
    }

    void DelAtTail() {
        if (size == 0) {
            System.out.print("List is Empty");
            return;
        }
        if (size == 1) head = tail = null;
        else {
            tail = tail.pre;
            tail.next = null;
        }
        size--;
    }

    void InsertAtIndex(int idx, int val) {
        if (idx < 0 || idx > size) {
            System.out.print("Invalid Index!");
            return;
        }
        if (idx == 0) {
            InsertAtHead(val);
            return;
        }
        if (idx == size) {
            InsertAtTail(val);
            return;
        }
        ListNode a = new ListNode(val);
        ListNode temp = head;

        for (int i = 1; i <= idx - 1; i++) {
            temp = temp.next;
        }
        a.pre = temp;
        a.next = temp.next;
        temp.next = a;
        a.next.pre = a;
        size++;
    }

    void DelAtIndex(int idx) {

        if (idx < 0 || idx >= size) {
            System.out.print("Invalid Index!");
            return;
        }

        if (idx == 0) {
            DelAtHead();
            return;
        }

        if (idx == size - 1) {
            DelAtTail();
            return;
        }

        ListNode temp = head;

        for (int i = 1; i <= idx; i++) {
            temp = temp.next;
        }

        temp.pre.next = temp.next;
        temp.next.pre = temp.pre;

        size--;
    }

    void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void displayReverse() {
        ListNode temp = tail;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.pre;
        }
        System.out.println();
    }
}

public class DoublyLinkedListClass {
    static void main(String[] args) {
        DLL list = new DLL();
        list.InsertAtHead(10);
        list.InsertAtHead(20);
        list.InsertAtHead(30);
        list.InsertAtHead(40);
        list.display();
        list.InsertAtTail(50);
        list.display();
        //list.displayReverse();
        list.DelAtHead();
        list.display();
        list.DelAtTail();
        list.display();
        list.InsertAtIndex(3, 20);
        list.display();
        list.DelAtIndex(1);
        list.display();
    }
}
