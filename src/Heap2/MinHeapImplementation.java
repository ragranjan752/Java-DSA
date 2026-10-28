package Heap2;

import java.util.Arrays;

class Heap {
    private int[] arr;

    // Heap is 1-indexed. idx points to the next empty position.
    private int idx = 1;

    // Returns the minimum element without removing it
    int peek() {
        if (idx == 1) {
            System.out.println("Heap is Empty");
            return -1;
        }

        return arr[1];
    }

    // Inserts an element and maintains the Min Heap property
    void add(int ele) {
        if (idx == arr.length) {
            System.out.println("Heap is Full");
            return;
        }

        // Insert the element at the end
        arr[idx++] = ele;

        // Heapify up: move the element toward the root
        int root = idx - 1;

        while (root != 1) {
            int parent = root / 2;

            // Swap if the child is smaller than its parent
            if (arr[root] < arr[parent]) {
                int temp = arr[root];
                arr[root] = arr[parent];
                arr[parent] = temp;

                root = parent;
            } else {
                break;
            }
        }
    }

    // Removes and returns the minimum element
    int remove() {
        if (idx == 1) {
            System.out.println("Heap is Empty");
            return -1;
        }

        // Store the minimum element
        int min = arr[1];

        // Move the last element to the root
        arr[1] = arr[idx - 1];
        idx--;

        // Heapify down: move the root to its correct position
        int root = 1;

        while (true) {
            int left = 2 * root;
            int right = 2 * root + 1;

            // Stop if there are no children
            if (left > size()) {
                break;
            }

            // Find the smaller child
            int smallerChild = left;

            if (right <= size() && arr[right] < arr[left]) {
                smallerChild = right;
            }

            // Stop if the parent is already smaller than or equal to its child
            if (arr[root] <= arr[smallerChild]) {
                break;
            }

            // Swap parent with the smaller child
            int temp = arr[root];
            arr[root] = arr[smallerChild];
            arr[smallerChild] = temp;

            root = smallerChild;
        }

        return min;
    }

    // Returns the number of elements in the heap
    int size() {
        return idx - 1;
    }

    // Initializes the heap with the given capacity
    Heap(int capacity) {
        arr = new int[capacity + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
    }

    // Prints heap elements in array order
    void display() {
        for (int i = 1; i < idx; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class MinHeapImplementation {
    public static void main(String[] args) {
        Heap h = new Heap(10);

        h.add(10);
        h.add(15);
        h.add(8);
        h.add(9);
        h.add(4);

        h.display();

        System.out.println(h.remove());

        h.add(2);
        h.display();

        System.out.println(h.remove());
        h.display();
    }
}