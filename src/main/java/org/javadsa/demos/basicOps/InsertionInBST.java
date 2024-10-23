package org.javadsa.demos.basicOps;

import org.javadsa.demos.util.Node;

public class InsertionInBST {

    static Node insert_recursion(Node root, int key) {

        // If the tree is empty, return a new node.
        if (root == null) return new Node(key);

        // If the key is already present in the tree, return the node.
        if (root.data == key) return root;

        // Otherwise, recur down the tree.
        if (key < root.data)
            root.left = insert_recursion(root.left, key);
        else
            root.right = insert_recursion(root.right, key);

        return root; // Return the (unchanged) node pointer.
    }

    // A utility function to do inorder tree traversal and print it in sorted ASC Order
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Approach: iteration
    static Node insert_iteration(Node root, int x) {
        Node newNode = new Node(x);

        if (root == null) return newNode;

        // Find the node who is going to have the new node temp as its child
        Node parent = null;
        Node curr = root;
        while (curr != null) {
            parent = curr;
            if (curr.data > x) {
                curr = curr.left;
            } else if (curr.data < x) {
                curr = curr.right;
            } else {
                return root; // Key already exists
            }
        }

        // If x is smaller, make it as the parents left child, else right child
        if (parent.data > x) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        return root;
    }


    public static void main(String[] args) {
        Node root = null;

        // Creating the following BST
        //      50
        //     /  \
        //    30   70
        //   / \   / \
        //  20 40 60 80

        root = insert_recursion(root, 50);
        root = insert_recursion(root, 30);
        root = insert_recursion(root, 20);
        root = insert_recursion(root, 40);
        root = insert_iteration(root, 70);
        root = insert_iteration(root, 60);
        root = insert_iteration(root, 80);

        // Print inorder (left, curr, right) traversal of the BST -> ASC Order
        inorder(root);
    }
}
