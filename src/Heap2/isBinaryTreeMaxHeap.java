package Heap2;

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class isBinaryTreeMaxHeap {

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        isBinaryTreeMaxHeap obj = new isBinaryTreeMaxHeap();

        System.out.println("Complete Tree: " + obj.isCompleteTree(root));

        // Convert BST to Max Heap
        convertToMaxHeap(root);
        System.out.println("Max Heap converted.");

        // Uncomment this if you want to test Greater Sum Tree
        // obj.convert(root);
    }

    // Check whether the binary tree is complete
    public boolean isCompleteTree(Node root) {
        if (root == null) {
            return true;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        boolean flag = false;

        while (!q.isEmpty()) {
            Node curr = q.remove();

            if (curr == null) {
                flag = true;
            } else {
                // No non-null node is allowed after a null node
                if (flag) {
                    return false;
                }

                q.add(curr.left);
                q.add(curr.right);
            }
        }

        return true;
    }

    // Index used while assigning sorted values to the tree
    static int idx;

    // Convert a BST into a Max Heap while keeping its structure
    public static void convertToMaxHeap(Node root) {
        idx = 0;

        ArrayList<Integer> ans = new ArrayList<>();

        // Store BST values in sorted order
        inorder(root, ans);

        // Assign values in postorder to create a Max Heap
        postOrder(root, ans);
    }

    // Inorder traversal stores values in ascending order
    public static void inorder(Node root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }

        inorder(root.left, ans);
        ans.add(root.data);
        inorder(root.right, ans);
    }

    // Postorder traversal assigns larger values to parent nodes
    public static void postOrder(Node root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }

        postOrder(root.left, ans);
        postOrder(root.right, ans);

        root.data = ans.get(idx++);
    }

    // Convert BST into a Greater Sum Tree
    // Each node becomes the sum of its value and all greater values
    int sum = 0;

    public Node convert(Node root) {
        sum = 0;
        reverseInorder(root);
        return root;
    }

    // Reverse inorder visits nodes in descending order
    public void reverseInorder(Node root) {
        if (root == null) {
            return;
        }

        reverseInorder(root.right);

        sum += root.data;
        root.data = sum;

        reverseInorder(root.left);
    }
}