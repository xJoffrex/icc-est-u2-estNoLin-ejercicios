package main;

import main.Ejercicio_01_insert.Ejercicio_01_insert;
import main.Ejercicio_02_invert.*;
import main.Ejercicio_02_invert.Ejercicio_02_invert;
import main.Ejercicio_03_listLeves.Ejercicio_03_listLeves;
import main.Ejercicio_04_depth.Ejercicio_04_depth;
import utils.StudentValidator;

public class App {
    public static void main(String[] args) throws Exception {
        // NO MODIFICAR ESTE CÓDIGO
        var estudiante = StudentValidator.validarDatos();
        System.out.println("👤 Estudiante: " + estudiante.nombre());
        System.out.println("✉️  Correo: " + estudiante.correo());
        // NO MODIFICAR HASTA AQUÍ

        //Ejercicio 1

        Ejercicio_01_insert tree = new Ejercicio_01_insert();
        int[] values = {5, 3, 7, 2, 4, 6, 8};

        for (int val : values) {
            tree.insert(val);
        }

        System.out.print("Recorrido InOrden del Arbol: ");
        tree.inOrderTraversal();

        //Ejercicio 2

        Ejercicio_02_invert.Nodo raiz = new Ejercicio_02_invert.Nodo(4);
        raiz.izquierdo = new Ejercicio_02_invert.Nodo(2);
        raiz.derecho = new Ejercicio_02_invert.Nodo(7);
        raiz.izquierdo.izquierdo = new Ejercicio_02_invert.Nodo(1);
        raiz.izquierdo.derecho = new Ejercicio_02_invert.Nodo(3);
        raiz.derecho.izquierdo = new Ejercicio_02_invert.Nodo(6);
        raiz.derecho.derecho = new Ejercicio_02_invert.Nodo(9);

        Ejercicio_02_invert inversor = new Ejercicio_02_invert();
        System.out.print("Arbol original (in-order): ");
        inversor.recorridoInOrden(raiz);

        inversor.invertir(raiz);
        System.out.print("\nArbol invertido: ");
        inversor.recorridoInOrden(raiz);

        // Ejercicio 03

        Ejercicio_03_listLeves.Nodo raizNiveles = new Ejercicio_03_listLeves.Nodo(4);
        raizNiveles.izquierdo = new Ejercicio_03_listLeves.Nodo(2);
        raizNiveles.derecho = new Ejercicio_03_listLeves.Nodo(7);
        raizNiveles.izquierdo.izquierdo = new Ejercicio_03_listLeves.Nodo(1);
        raizNiveles.izquierdo.derecho = new Ejercicio_03_listLeves.Nodo(3);
        raizNiveles.derecho.izquierdo = new Ejercicio_03_listLeves.Nodo(6);
        raizNiveles.derecho.derecho = new Ejercicio_03_listLeves.Nodo(9);

        Ejercicio_03_listLeves listador = new Ejercicio_03_listLeves();
        var niveles = listador.listarPorNiveles(raizNiveles);

        System.out.println("\nNiveles del arbol:");
        listador.imprimirNiveles(niveles);

        // Ejercicio 04
        Ejercicio_04_depth.Nodo raizProf = new Ejercicio_04_depth.Nodo(4);
        raizProf.izquierdo = new Ejercicio_04_depth.Nodo(2);
        raizProf.derecho = new Ejercicio_04_depth.Nodo(7);
        raizProf.izquierdo.izquierdo = new Ejercicio_04_depth.Nodo(1);
        raizProf.izquierdo.derecho = new Ejercicio_04_depth.Nodo(3);
        raizProf.izquierdo.izquierdo.izquierdo = new Ejercicio_04_depth.Nodo(8); 

        Ejercicio_04_depth calculador = new Ejercicio_04_depth();
        int profundidad = calculador.calcularProfundidad(raizProf);

        System.out.println("Profundidad máxima del arbol: " + profundidad); 
    }

}
