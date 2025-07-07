package main.Ejercicio_02_invert;

public class Ejercicio_02_invert {
    
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

        Nodo temporal = raiz.izquierdo; // se guarda el izquierdo para no perderlo
        raiz.izquierdo = invertir(raiz.derecho); // se cambia el izquierdo por el derecho invertido
        raiz.derecho = invertir(temporal); // se cambia el derecho por el izquierdo guardado ya invertido

        return raiz;
    }

    public void recorridoInOrden(Nodo nodo) {
        if (nodo != null) {
            recorridoInOrden(nodo.izquierdo); // primero va a la izquierda
            System.out.print(nodo.valor + " ");
            recorridoInOrden(nodo.derecho); // luego a la derecha
        }
    }
}
