package org.javadsa.demos.basicOps;

import org.javadsa.demos.util.Node;

public class DeletionInBST3Cases {
    
    static Node deleteNode(Node root, int targetValue) {

        if (root == null) return root;

        // If key to be searched is in a subtree
        if (targetValue < root.data) {
            root.left = deleteNode(root.left, targetValue); //search left subtree
        } else if (targetValue > root.data) {
            root.right = deleteNode(root.right, targetValue); //search right subtree
        } else {
            // If root matches with the given data

            // CASE 1: When both children are present
            if (root.left != null && root.right != null) {

                Node successor = getSuccessor(root.right); // finding minimum element from right
                root.data = successor.data; // replacing current node with minimum node from right subtree.
                root.right = deleteNode(root.right, successor.data); //delete successor(minimum node) node

            } else if (root.right != null) root = root.right; // CASE 2a: When root has only right child

            else if (root.left != null) root = root.left;  // CASE 2b: When root has only left child

            else root = null; // CASE 3: When root is leaf node
        }
        return root;
    }

    // Function to find the node with minimum element.
    static Node getSuccessor(Node curr) {
        if (curr.left == null)
            return curr;
        else {
            return getSuccessor(curr.left);
        }
    }

    // Utility function to do inorder traversal
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right = new Node(18);

        int x = 15;
        root = deleteNode(root, x);
        inorder(root);
    }
}
