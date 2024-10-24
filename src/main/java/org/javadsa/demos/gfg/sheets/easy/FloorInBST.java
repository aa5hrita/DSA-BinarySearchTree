package org.javadsa.demos.gfg.sheets.easy;

import org.javadsa.demos.util.Node;

public class FloorInBST {
    static int floor(Node root, int x) {
        // Base case: return -1 if no floor found
        if (root == null) return -1;

        // If the root's data is equal to x,  we've found the floor
        if (root.data == x) return root.data;

        // If root's data is greater than x, search in the left subtree
        if (x < root.data) return floor(root.left, x);

        // Else, search in the right subtree and compare with current root
        int floorValue = floor(root.right, x);

        // If the right subtree returns a valid floor,
        // return that, otherwise return the current root's data
        return (floorValue <= x && floorValue != -1) ? floorValue : root.data;
    }

    public static void main(String[] args) {

        // Representation of the given tree
        //       10
        //       / \
        //      5  15
        //         / \
        //        12 30
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right = new Node(30);

        int x = 14;
        System.out.println(floor(root, x));
    }
}
