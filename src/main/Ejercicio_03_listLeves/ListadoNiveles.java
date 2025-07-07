package main.Ejercicio_03_listLeves;

import java.util.*;

public class ListadoNiveles {
    
    public static class Nodo {
        public int valor;
        public Nodo izquierdo, derecho;

        public Nodo(int valor) {
            this.valor = valor;
            this.izquierdo = this.derecho = null;
        }
    }

    public List<LinkedList<Integer>> listarPorNiveles(Nodo raiz) {
        List<LinkedList<Integer>> resultado = new ArrayList<>();
        if (raiz == null) return resultado;

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            int cantidad = cola.size();
            LinkedList<Integer> nivelActual = new LinkedList<>();

            for (int i = 0; i < cantidad; i++) {
                Nodo actual = cola.poll();
                nivelActual.add(actual.valor);

                if (actual.izquierdo != null) cola.add(actual.izquierdo);
                if (actual.derecho != null) cola.add(actual.derecho);
            }

            resultado.add(nivelActual);
        }

        return resultado;
    }

    public void imprimirNiveles(List<LinkedList<Integer>> niveles) {
        for (LinkedList<Integer> nivel : niveles) {
            for (int valor : nivel) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }
}
