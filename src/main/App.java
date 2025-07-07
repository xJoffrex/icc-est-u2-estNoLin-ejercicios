package main;

import main.Ejercicio_01_insert.BinarySearchTree;
import main.Ejercicio_02_invert.*;
import main.Ejercicio_02_invert.InversorArbolBinario;
import main.Ejercicio_03_listLeves.ListadoNiveles;
import main.Ejercicio_04_depth.CalculadorProfundidad;
import utils.StudentValidator;

public class App {
    public static void main(String[] args) throws Exception {
        // NO MODIFICAR ESTE CÓDIGO
        var estudiante = StudentValidator.validarDatos();
        System.out.println("👤 Estudiante: " + estudiante.nombre());
        System.out.println("✉️  Correo: " + estudiante.correo());
        // NO MODIFICAR HASTA AQUÍ

        //Ejercicio 1

        BinarySearchTree tree = new BinarySearchTree();
        int[] values = {5, 3, 7, 2, 4, 6, 8};

        for (int val : values) {
            tree.insert(val);
        }

        System.out.print("Recorrido InOrden del Arbol: ");
        tree.inOrderTraversal();

        //Ejercicio 2

        InversorArbolBinario.Nodo raiz = new InversorArbolBinario.Nodo(4);
        raiz.izquierdo = new InversorArbolBinario.Nodo(2);
        raiz.derecho = new InversorArbolBinario.Nodo(7);
        raiz.izquierdo.izquierdo = new InversorArbolBinario.Nodo(1);
        raiz.izquierdo.derecho = new InversorArbolBinario.Nodo(3);
        raiz.derecho.izquierdo = new InversorArbolBinario.Nodo(6);
        raiz.derecho.derecho = new InversorArbolBinario.Nodo(9);

        InversorArbolBinario inversor = new InversorArbolBinario();
        System.out.print("Arbol original (in-order): ");
        inversor.recorridoInOrden(raiz);

        inversor.invertir(raiz);
        System.out.print("\nArbol invertido: ");
        inversor.recorridoInOrden(raiz);

        // Ejercicio 03

        ListadoNiveles.Nodo raizNiveles = new ListadoNiveles.Nodo(4);
        raizNiveles.izquierdo = new ListadoNiveles.Nodo(2);
        raizNiveles.derecho = new ListadoNiveles.Nodo(7);
        raizNiveles.izquierdo.izquierdo = new ListadoNiveles.Nodo(1);
        raizNiveles.izquierdo.derecho = new ListadoNiveles.Nodo(3);
        raizNiveles.derecho.izquierdo = new ListadoNiveles.Nodo(6);
        raizNiveles.derecho.derecho = new ListadoNiveles.Nodo(9);

        ListadoNiveles listador = new ListadoNiveles();
        var niveles = listador.listarPorNiveles(raizNiveles);

        System.out.println("\nNiveles del arbol:");
        listador.imprimirNiveles(niveles);

        // Ejercicio 04
        CalculadorProfundidad.Nodo raizProf = new CalculadorProfundidad.Nodo(4);
        raizProf.izquierdo = new CalculadorProfundidad.Nodo(2);
        raizProf.derecho = new CalculadorProfundidad.Nodo(7);
        raizProf.izquierdo.izquierdo = new CalculadorProfundidad.Nodo(1);
        raizProf.izquierdo.derecho = new CalculadorProfundidad.Nodo(3);
        raizProf.izquierdo.izquierdo.izquierdo = new CalculadorProfundidad.Nodo(8); 

        CalculadorProfundidad calculador = new CalculadorProfundidad();
        int profundidad = calculador.calcularProfundidad(raizProf);

        System.out.println("Profundidad máxima del arbol: " + profundidad); 
    }

}
