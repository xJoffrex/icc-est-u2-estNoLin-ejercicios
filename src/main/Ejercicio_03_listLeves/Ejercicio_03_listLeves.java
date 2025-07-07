package main.Ejercicio_03_listLeves;

import java.util.*;

public class Ejercicio_03_listLeves {
    
    // Clase interna Nodo para representar los nodos del árbol binario
    public static class Nodo {
        public int valor;
        public Nodo izquierdo, derecho;

        public Nodo(int valor) {
            this.valor = valor;
            this.izquierdo = this.derecho = null;
        }
    }

    // Método para recorrer el árbol por niveles y devolver los valores por nivel
    public List<LinkedList<Integer>> listarPorNiveles(Nodo raiz) {
        List<LinkedList<Integer>> resultado = new ArrayList<>(); // Lista para almacenar los niveles
        if (raiz == null) return resultado; // Si el árbol está vacío, retorna lista vacía

        Queue<Nodo> cola = new LinkedList<>(); // Cola para el recorrido por niveles (BFS)
        cola.add(raiz); // Agrega la raíz como primer nodo

        while (!cola.isEmpty()) {
            int cantidad = cola.size(); // Número de nodos en el nivel actual
            LinkedList<Integer> nivelActual = new LinkedList<>(); // Lista para este nivel

            for (int i = 0; i < cantidad; i++) {
                Nodo actual = cola.poll(); // Saca el nodo actual de la cola
                nivelActual.add(actual.valor); // Agrega su valor a la lista del nivel

                // Agrega los hijos a la cola para procesarlos en el siguiente nivel
                if (actual.izquierdo != null) cola.add(actual.izquierdo);
                if (actual.derecho != null) cola.add(actual.derecho);
            }

            resultado.add(nivelActual); // Agrega el nivel a la lista de resultados
        }

        return resultado;
    }

    // Método para imprimir los niveles en consola
    public void imprimirNiveles(List<LinkedList<Integer>> niveles) {
        for (LinkedList<Integer> nivel : niveles) {
            for (int valor : nivel) {
                System.out.print(valor + " ");
            }
            System.out.println(); // Salto de línea después de cada nivel
        }
    }
}
