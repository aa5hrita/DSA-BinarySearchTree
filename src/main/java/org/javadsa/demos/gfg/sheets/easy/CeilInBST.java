package org.javadsa.demos.gfg.sheets.easy;

import org.javadsa.demos.util.Node;

public class CeilInBST {

    static int findCeil(Node root, int input) {
        // Base case
        if (root == null) {
            return -1;
        }

        // We found equal key
        if (root.data == input) {
            return root.data;
        }

        // If root's key is smaller, ceil must be in the right subtree
        if (input > root.data) {
            return findCeil(root.right, input);
        }

        // Else, either left subtree or root has the ceil value
        int ceil = findCeil(root.left, input);
        
        return (ceil >= input) ? ceil : root.data;
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.right.left = new Node(10);
        root.right.right = new Node(14);

        // Testing for values from 0 to 15
        for (int i = 0; i < 16; i++) {
            System.out.println(i + " " + findCeil(root, i));
        }
    }
}
