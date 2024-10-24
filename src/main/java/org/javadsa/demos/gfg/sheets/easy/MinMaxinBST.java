package org.javadsa.demos.gfg.sheets.easy;

import org.javadsa.demos.util.Node;

import java.util.ArrayList;

public class MinMaxinBST {
    static void inorder(Node root, ArrayList<Integer> sortedInorder) {

        // Base Case
        if (root == null) return;

        // Traverse left subtree
        inorder(root.left, sortedInorder);

        // Store the current node's data
        sortedInorder.add(root.data);

        // Traverse right subtree
        inorder(root.right, sortedInorder);
    }

    static int minValue_Recursion(Node root) {

        if (root == null) {
            return -1;
        }

        // Create an ArrayList to hold inorder elements
        ArrayList<Integer> sortedInorder
                = new ArrayList<>();

        // Call the recursive inorder function
        inorder(root, sortedInorder);

        // Return the first element, which is the minimum
        return sortedInorder.get(0); //size-1 for MAX element
    }

    public static int minValue_Iteration(Node root) {
        // base case
        if (root == null) {
            return -1;
        }

        Node curr = root;

        // leftmost node is minimum, so move till left is not null
        while (curr.left != null) {
            curr = curr.left; // For MAX, move till the right is not nul in the right subtree
        }

        // returning the data at the leftmost node
        return curr.data;
    }

    public static void main(String[] args) {

        // Representation of input binary search tree
        //        5
        //       / \
        //      4   6
        //     /     \
        //    3       7
        //   /
        //  1
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(6);
        root.left.left = new Node(3);
        root.right.right = new Node(7);
        root.left.left.left = new Node(1);

        System.out.println(minValue_Recursion(root));
        System.out.println(minValue_Iteration(root));
    }
}
