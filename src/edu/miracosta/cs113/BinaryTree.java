package edu.miracosta.cs113;

import java.io.Serializable;
import java.util.Scanner;

public class BinaryTree<E> implements Serializable
{
    protected Node<E> root;

    /**
     * The no-parameter constructor.
     */
    public BinaryTree()
    {
        root = null;
    }

    /**
     * The constructor that creates	a tree with	a given	node
     * at the root.
     */
    protected BinaryTree(Node<E> root)
    {
        this.root = root;
    }

    /** Constructs a new binary tree with data in its root, leftTree
     * as its left subtree and rightTree as its right subtree.
     */
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree)
    {
        root = new Node<E>(data);

        if (leftTree != null)
        {
            root.left = leftTree.root;
        }
        else
        {
            root.left = null;
        }
        if (rightTree != null)
        {
            root.right = rightTree.root;
        }
        else
        {
            root.right = null;
        }
    }

    public E getData()
    {
        return this.root.data;
    }
    /**
     * determines if node is a leaf.
     */
    public boolean isLeaf()
    {
        return (root.left == null && root.right == null);
    }


    /**
     * Traverses using pre-order.
     */
    private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb)
    {
        for (int i = 1; i < depth; i++)
        {
            sb.append(" ");
        }
        if (node == null)
        {
            sb.append("null\n");
        }
        else
         {
            sb.append(node.toString() + "\n");
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }

    /** Method to read a binary tree. The input consists of a preorder traversal of the binary tree.
     * The line "null" indicates a null tree.
     * @return The binary tree
     */
    public static BinaryTree<String> readBinaryTree(Scanner scan)
    {
        // Read a line and trim leading and trailing spaces.
        String data = scan.next();
        if (data.equals("null"))
        {
            return null;
        }
        else
        {
            //splits into the nodes that compose the root nodes.
            BinaryTree < String > leftTree = readBinaryTree(scan);
            BinaryTree < String > rightTree = readBinaryTree(scan);
            return new BinaryTree <String>(data, leftTree, rightTree);
        }
    }

    /**
     * ToString method using preorder traverse.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }

    /** Return the left subtree.
     * @return The left subtree or null if either the root or the left subtree is null
     */
    public BinaryTree<E> getLeftSubtree()
    {
        if (root != null && root.left != null)
        {
            return new BinaryTree<E>(root.left);
        }
        else
        {
            return null;
        }
    }

    /** Return the right sub-tree
     * @return the right sub-tree or null if either the root or the right subtree is null.
     */
    public BinaryTree<E> getRightSubtree()
    {
        if (root != null && root.right != null)
        {
            return new BinaryTree<E>(root.right);
        } else
            {
            return null;
        }
    }




    protected static class Node<E> implements Serializable
    {
        protected E data;
        protected Node<E> left;
        protected Node<E> right;

        /**
         * Class constructor for node with initialization of E data.
         */
        public Node(E data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        /**
         * To String.
         */
        public String toString()
        {
            return data.toString();
        }
    }
}
