package test.Ejercicio_01_insert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import main.Ejercicio_01_insert.InsertBST;
import main.Materia.Models.Node;

import org.junit.jupiter.api.Test;

public class InsertBSTTest {

    @Test
    public void bstInsertionTest() {
        InsertBST bstInsertion = new InsertBST();
        /// LISTAOD // [5, 3, 7, 2, 4, 6, 8]
        /// // Creamos el nodo raíz
        Node root = null;
        root = bstInsertion.insert(root, 5);
        assertNull(root.getLeft());
        assertNull(root.getRight());

        // Insertamos los valores en el BST
        // 3, 7, 2, 4, 6, 8 menos la raiz
        int[] values = { 3, 7, 2, 4, 6, 8 };
        for (int value : values) {
            root = bstInsertion.insert(root, value);
        }

        assertEquals(5, root.getValue());
        assertEquals(3, root.getLeft().getValue());
        assertEquals(7, root.getRight().getValue());
        assertEquals(2, root.getLeft().getLeft().getValue());
        assertEquals(4, root.getLeft().getRight().getValue());
        assertEquals(6, root.getRight().getLeft().getValue());
        assertEquals(8, root.getRight().getRight().getValue());
    }

}
