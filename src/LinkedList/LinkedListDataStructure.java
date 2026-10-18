package LinkedList;

class Node { // user define data type
    int val;
    Node next;  // null

    Node(int val) {
        this.val = val;
    }
}

class Linkedlist {// user define data structure
    Node head; // null
    Node tail; // null
    int size;

    int search(int val) {
        if (head == null) return -1;
        Node temp = head;
        int idx = 0;
        while (temp != null) {
            if (temp.val == val) return idx;
            temp = temp.next;
            idx++;
        }
        return -1;
    }
    int get(int idx){
        Node temp = head;
        for (int i = 1; i <= idx; i++){
            temp = temp.next;
        }
        return temp.val;
    }
    void insert(int val, int idx) {
        if (idx < 0 || idx > size) {
            System.out.print("Invalid");
            return;
        }
        if (idx == 0) addAtHead(val);
        else if (idx == size) addAtTail(val);
        else {
            Node temp = head;
            for (int i = 1; i <= idx - 1; i++) {
                temp = temp.next;
            }
            Node t = new Node(val);
            t.next = temp.next;
            temp.next = t;
            size++;
        }
    }

    void addAtTail(int val) {
        Node temp = new Node(val);
        if (tail == null) head = tail = temp;
        else {
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    public void addAtHead(int val) {
        Node temp = new Node(val);
        if (head == null) head = tail = temp;
        else {
            temp.next = head;
            head = temp;
        }
        size++;
    }

    public void deleteAtHead() {
        if (head == null) {
            System.out.print("List is empty");
            return;
        }
        head = head.next;
        if (head == null) tail = null;
        size--;
    }
    void delAtTail(int idx){
        if(idx < 0 || idx >= size){
            System.out.println("invalid index!");
        }
        if(idx == 0){
            deleteAtHead();
            return;
        }
        Node temp = head;
        for(int i = 1; i <= idx - 1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next; // delete
        if(idx == size - 1) tail = temp; // we are deleting tail
        size--;
    }

    public void display() {
        if (head == null) return;
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class LinkedListDataStructure {
    static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        ll.addAtTail(3);
        ll.addAtTail(30);
        ll.addAtTail(13);
        ll.addAtTail(33);
        ll.display();
        ll.addAtHead(50);
        ll.addAtHead(25);
        ll.display();
        ll.deleteAtHead();
        ll.display();
        ll.insert(80, 2);
        ll.display();
        System.out.println("Node at index: "+ll.search(80));
        System.out.println("Node Index: "+ll.get(4));
        ll.delAtTail(3);
        ll.display();
    }
}