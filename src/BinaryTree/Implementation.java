package BinaryTree;

import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

class Pair {
    Node node;
    int level;

    Pair(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}

public class Implementation {
    static void main(String[] args) {
        //        3
        //       /\
        //      4  2
        //     /\  /\
        //   -1  1 6 9
        Node a = new Node(3);  // root
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(-1);
        Node e = new Node(1);
        Node f = new Node(6);
        Node g = new Node(9);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        display(a);
        System.out.println();
        System.out.print("PreOrder: ");
        preorder(a);
        System.out.println();
        System.out.print("Inorder: ");
        inorder(a);
        System.out.println();
        System.out.print("PostOrder: ");
        postorder(a);
        System.out.println();
        System.out.println("Size: "+size(a));
        System.out.println("Sum: "+sum(a));
        System.out.println("Product: "+product(a));
        System.out.println("Levels: "+level(a));
        System.out.print("Level Order: ");
        levelOrder(a);
        System.out.println("Level Wise Order: ");
        levelOrderLineWise(a);
        System.out.println("levelOrderTraversal: "+levelOrderTraversal(a));
        System.out.println(TwoDLevelOrderTraversal(a));
        for (int i = 0; i <level(a); i++){
            kThLevel(a,0,i);
            System.out.println();
        }
        System.out.println(zigzagLevelOrder(a));
        System.out.println("path: "+binaryTreePaths(a));
    }

    private static void levelOrderLineWise(Node root) {
        Queue<Pair> q = new LinkedList<>();
        int currLevel = 0;
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair front = q.remove();
            Node node = front.node;
            int level = front.level;
            if (front.level != currLevel) {
                currLevel++;
                System.out.println();
            }
            System.out.print(front.node.val + " ");
            if (node.left != null) q.add(new Pair(node.left, level + 1));
            if (node.right != null) q.add(new Pair(node.right, level + 1));
        }
        System.out.println();
    }

    private static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node front = q.remove();
            System.out.print(front.val + " ");
            if (front.left != null) q.add(front.left);
            if (front.right != null) q.add(front.right);
        }
        System.out.println();
    }

    public static ArrayList<Integer> levelOrderTraversal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node front = q.remove();
            ans.add(front.val);
            if (front.left != null) q.add(front.left);
            if (front.right != null) q.add(front.right);
        }
        return ans;
    }

    public static List<List<Integer>> TwoDLevelOrderTraversal(Node root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node front = q.remove();

                level.add(front.val);

                if (front.left != null) q.add(front.left);
                if (front.right != null) q.add(front.right);
            }

            ans.add(level);
        }

        return ans;
    }

    private static void kThLevel(Node root, int level, int k){
        if(root == null) return;
        if(level ==k) System.out.print(root.val+" ");
        kThLevel(root.left,level+1,k);
        kThLevel(root.right,level+1,k);
    }

    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                Node front = q.remove();

                if (leftToRight) {
                    level.addLast(front.val);
                } else {
                    level.addFirst(front.val);
                }

                if (front.left != null) q.add(front.left);
                if (front.right != null) q.add(front.right);
            }

            ans.add(level);
            leftToRight = !leftToRight;
        }

        return ans;
    }

    public static List<String> binaryTreePaths(Node root) {
        List<String> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();

        dfs(root, arr, ans);
        return ans;
    }

    private static void dfs(Node root, List<Integer> arr, List<String> ans) {
        if (root == null) return;

        arr.add(root.val);

        if (root.left == null && root.right == null) {
            StringBuilder path = new StringBuilder();

            for (int i = 0; i < arr.size(); i++) {
                if (i > 0) path.append("->");
                path.append(arr.get(i));
            }

            ans.add(path.toString());
        }

        dfs(root.left, arr, ans);
        dfs(root.right, arr, ans);

        arr.remove(arr.size() - 1);
    }

    private static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    private static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    private static void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    private static int level(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(level(root.left), level(root.right));
    }

    private static void display(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        display(root.left); // left ki sari values print kar dega ye
        display(root.right); // right ki sari values print kar dega ye
    }

    private static int size(Node root) {
        if (root == null) return 0;
        int leftSize = size(root.left);
        int rightSize = size(root.right);
        return 1 + leftSize + rightSize;
    }

    private static int sum(Node root) {
        if (root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }

    private static int product(Node root) {
        if (root == null) return 1;
        return root.val * product(root.left) * product(root.right);
    }
}