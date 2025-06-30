package main.Materia.Controllers;

import main.Materia.Models.Node;

/**
 * La clase ArbolBinario representa un árbol binario de búsqueda (BST).
 * Proporciona métodos para insertar nodos y para imprimir el árbol.
 */
public class ArbolBinario {

    private Node root;

    /**
     * Inserta un valor en el árbol binario de búsqueda.
     * 
     * @param value El valor a insertar en el árbol.
     */
    public void insert(int value) {
        root = insert(root, value);
    }

    /**
     * Inserta un nuevo valor en el árbol binario de búsqueda (BST).
     *
     * @param node  El nodo raíz del BST o subárbol donde se insertará el valor.
     * @param value El valor a insertar en el BST.
     * @return El nodo raíz del BST después de la inserción.
     *
     *         Este método realiza una inserción estándar de BST. Si el nodo es
     *         nulo, crea un nuevo nodo con el valor dado.
     *         Si el valor es menor que el valor del nodo actual, inserta
     *         recursivamente el valor en el subárbol izquierdo.
     *         Si el valor es mayor que el valor del nodo actual, inserta
     *         recursivamente el valor en el subárbol derecho.
     *         No se permiten valores duplicados en el árbol AVL.
     */
    public Node insert(Node node, int value) {
        // Realizar inserción normal de BST
        if (node == null)
            return new Node(value);

        if (value < node.getValue())
            node.setLeft(insert(node.getLeft(), value));
        else if (value > node.getValue())
            node.setRight(insert(node.getRight(), value));
        // No se permiten valores duplicados en el árbol AVL
        return node;
    }

    public void printTree() {
        printTreeNode2(root, "", true);
    }

    public void printTreeNode2(Node root, String prefix, boolean isLeft) {

        if (root != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.getValue());
            if (root.getLeft() != null || root.getRight() != null) {
                if (root.getLeft() != null) {
                    printTreeNode2(root.getLeft(), prefix + (isLeft ? "│   " : "    "), true);
                } else {
                    System.out.println(prefix + (isLeft ? "│   " : "    ") + "├── null");
                }
                if (root.getRight() != null) {
                    printTreeNode2(root.getRight(), prefix + (isLeft ? "│   " : "    "), false);
                } else {
                    System.out.println(prefix + (isLeft ? "│   " : "    ") + "└── null");
                }
            }
        }
    }

    public Node getRoot() {
        return root;
    }
}
