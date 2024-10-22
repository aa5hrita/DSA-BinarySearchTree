package org.javadsa.demos.basicOps;


import org.javadsa.demos.util.Node;

public class SearchBST {

    // function to search a key in a BST and return the node or null
    static Node search_recursively(Node root, int key) {
        // Base Cases: root is null or key is present at  root
        if (root == null || root.data == key)
            return root;

        // Key is greater than root's key, search teh right subtree
        if (key > root.data)
            return search_recursively(root.right, key);

        // Key is smaller than root's key, search teh left subtree
        return search_recursively(root.left, key);
    }

    static boolean search_iteration(Node root, int x) {

        Node curr = root;

        while (curr != null) {
            if (curr.data == x)
                return true; //if found
            else if (curr.data < x)
                curr = curr.right; // search right subtree
            else
                curr = curr.left; // search left subtree
        }
        return false; // if x is not found
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        // Searching for keys in the BST
        System.out.println(search_recursively(root, 19) != null ? "Found" : "Not Found");
        System.out.println(search_recursively(root, 80) != null ? "Found" : "Not Found");
        System.out.println(search_iteration(root, 12) ? "Found" : "Not Found");
        System.out.println(search_iteration(root, 40) ? "Found" : "Not Found");

    }
}
