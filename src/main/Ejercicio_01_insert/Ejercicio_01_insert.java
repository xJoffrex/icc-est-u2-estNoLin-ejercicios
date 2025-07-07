package main.Ejercicio_01_insert;

public class Ejercicio_01_insert {

    static class Node {
        int value;
        Node left, right;

        Node(int val) {
            this.value = val;
            this.left = this.right = null;
        }
    }

    Node root;

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node current, int value) {
        if (current == null) return new Node(value); // si ya no hay nodo se crea uno nuevo

        if (value < current.value) {
            current.left = insertRecursive(current.left, value); // va por la izquierda si es menor
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value); // va por la derecha si es mayor
        }
        return current;
    }

    public void inOrderTraversal() {
        inOrderRecursive(root);
        System.out.println();
    }

    private void inOrderRecursive(Node node) {
        if (node != null) {
            inOrderRecursive(node.left); // se visita primero la izquierda
            System.out.print(node.value + " ");
            inOrderRecursive(node.right); // luego la derecha
        }
    }
}
