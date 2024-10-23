package org.javadsa.demos.gfg.sheets.easy;

import org.javadsa.demos.util.Node;

public class CheckForBST {

    // Function to check if the tree is a valid BST
    static boolean isValidBST(Node root, int[] prev) {
        if (root == null) return true;

        // Check the left subtree
        if (!isValidBST(root.left, prev)) return false;

        // Check current node value against previous value
        if (prev[0] >= root.data) return false;

        // Update previous value to current node's value
        prev[0] = root.data;

        // Check the right subtree
        return isValidBST(root.right, prev);
    }

    // Wrapper function to call the recursive function
    static boolean isBST(Node root) {

        // we need to make one size array to hold previous value
        int[] prev = {Integer.MIN_VALUE};
        return isValidBST(root, prev);
    }

    public static void main(String[] args) {

        // Create a sample binary tree
        //      4
        //    /   \
        //   2     5
        //  / \
        // 1   3

        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        if (isBST(root)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
