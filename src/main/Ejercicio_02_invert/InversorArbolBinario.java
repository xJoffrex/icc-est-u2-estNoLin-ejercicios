package main.Ejercicio_02_invert;

public class InversorArbolBinario {
    
    public static class Nodo {
        public int valor;
        public Nodo izquierdo, derecho;

        public Nodo(int valor) {
            this.valor = valor;
            this.izquierdo = this.derecho = null;
        }
    }

    public Nodo invertir(Nodo raiz) {
        if (raiz == null) return null;

        Nodo temporal = raiz.izquierdo;
        raiz.izquierdo = invertir(raiz.derecho);
        raiz.derecho = invertir(temporal);

        return raiz;
    }

    public void recorridoInOrden(Nodo nodo) {
        if (nodo != null) {
            recorridoInOrden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            recorridoInOrden(nodo.derecho);
        }
    }
}
