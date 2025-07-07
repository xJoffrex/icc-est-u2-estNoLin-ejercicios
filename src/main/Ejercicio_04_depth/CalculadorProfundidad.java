package main.Ejercicio_04_depth;

public class CalculadorProfundidad {

    public static class Nodo {
        public int valor;
        public Nodo izquierdo, derecho;

        public Nodo(int valor) {
            this.valor = valor;
            this.izquierdo = this.derecho = null;
        }
    }

    // Método para calcular profundidad máxima
    public int calcularProfundidad(Nodo raiz) {
        if (raiz == null) return 0;

        int profIzquierda = calcularProfundidad(raiz.izquierdo);
        int profDerecha = calcularProfundidad(raiz.derecho);

        return 1 + Math.max(profIzquierda, profDerecha);
    }
}
