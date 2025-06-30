
package main.Materia.Models;

/**
 * Represents a node in a binary tree structure.
 * Each node contains an integer value, references to its left and right
 * children,
 * and a height attribute commonly used in balanced trees such as AVL trees.
 *
 * <p>
 * Provides getter and setter methods for all fields.
 * </p>
 *
 * @author Pablo
 */

public class Node {
    private int value;
    private Node left;
    private Node right;
    private int height;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}