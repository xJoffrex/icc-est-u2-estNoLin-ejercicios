# Implementación de Árboles Binarios en Java

Este documento describe la implementación de un árbol binario de búsqueda (BST) en Java, destacando sus principales características y métodos, así como explicaciones detalladas de su funcionamiento.

Este repositorio se refiere a la segunda unidad de Estructuras de Datos, donde el primer capítulo cubre estructuras de datos No lineales: Arboles y Grafos.

## Requisitos
- Java JDK 17 o superior
- Git 2.20 o superior

## Clase `ArbolBinario`

La clase `ArbolBinario` representa un árbol binario de búsqueda. Permite insertar valores y visualizar el árbol de forma estructurada.

### Principales Atributos
- **`root`**: Representa la raíz del árbol. Inicialmente es `null` y se actualiza conforme se insertan nodos.




```java
private Node root;
```

---

## Método `insert`

### Descripción
Este método inserta un nuevo valor en el árbol binario de búsqueda. Es recursivo, ya que desciende por el árbol hasta encontrar la posición correcta para el nuevo nodo, respetando las propiedades del BST:
- Los valores menores al nodo actual van al subárbol izquierdo.
- Los valores mayores al nodo actual van al subárbol derecho.

### Definición del Método
```java
public void insert(int value) {
    root = insert(root, value);
}

private Node insert(Node node, int value) {
    if (node == null)
        return new Node(value);

    if (value < node.getValue())
        node.setLeft(insert(node.getLeft(), value));
    else if (value > node.getValue())
        node.setRight(insert(node.getRight(), value));

    return node;
}
```

### Funcionamiento
1. **Caso Base:**
   - Si el nodo actual es `null`, significa que se ha encontrado la posición donde debe insertarse el nuevo valor. Se crea un nuevo nodo con el valor proporcionado y se retorna.

2. **Recursión:**
   - Si el valor a insertar es menor que el valor del nodo actual, el método se llama recursivamente para el subárbol izquierdo.
   - Si el valor a insertar es mayor, el método se llama recursivamente para el subárbol derecho.

3. **Actualización del árbol:**
   - Después de insertar el valor, se retorna el nodo actualizado para asegurar que el árbol conserve su estructura.

### Ventajas de la Recursión
- Simplifica el código al evitar el uso de bucles y pilas adicionales.
- Refleja directamente la naturaleza jerárquica y divisoria de un árbol binario.

### Ejemplo de Uso
```java
ArbolBinario arbol = new ArbolBinario();
arbol.insert(10);
arbol.insert(5);
arbol.insert(15);
```

El árbol después de estas inserciones tiene la siguiente estructura:
```
10
├── 5
└── 15
```

---

## Método `printTree`

### Descripción
Este método permite imprimir el árbol de forma visual y estructurada. Utiliza recursión para recorrer los subárboles izquierdo y derecho, representando cada nivel con sangrías y líneas para facilitar la lectura.

### Definición del Método
```java
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
```

### Funcionamiento
1. **Impresión del Nodo Actual:**
   - Imprime el valor del nodo actual con un prefijo que indica su nivel y si es hijo izquierdo o derecho.

2. **Recursión:**
   - Si el nodo tiene hijos, se llama recursivamente al subárbol izquierdo y luego al derecho.
   - Si un subárbol es nulo, imprime `null` en su lugar.

### Ejemplo de Uso
```java
ArbolBinario arbol = new ArbolBinario();
arbol.insert(10);
arbol.insert(5);
arbol.insert(15);
arbol.printTree();
```

**Salida:**
```
10
├── 5
└── 15
```

---

## Métodos de Recorridos

### Preorden Iterativo (`preOrderIterative`)
Este método realiza un recorrido en preorden (Root, Left, Right) utilizando una pila para evitar la recursión.

```java
public void preOrderIterative(Node root) {
    if (root == null) {
        return;
    }

    Stack<Node> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
        Node node = stack.pop();
        System.out.print(node.getValue() + ", ");

        if (node.getRight() != null) {
            stack.push(node.getRight());
        }
        if (node.getLeft() != null) {
            stack.push(node.getLeft());
        }
    }
}
```

### Postorden Iterativo (`postOrderIterative`)
Este método realiza un recorrido en postorden (Left, Right, Root) utilizando dos pilas para almacenar los nodos.

```java
public void postOrderIterative(Node root) {
    if (root == null) {
        return;
    }

    Stack<Node> stack1 = new Stack<>();
    Stack<Node> stack2 = new Stack<>();

    stack1.push(root);

    while (!stack1.isEmpty()) {
        Node node = stack1.pop();
        stack2.push(node);

        if (node.getLeft() != null) {
            stack1.push(node.getLeft());
        }
        if (node.getRight() != null) {
            stack1.push(node.getRight());
        }
    }

    while (!stack2.isEmpty()) {
        Node node = stack2.pop();
        System.out.print(node.getValue() + ", ");
    }
}
```

### Inorden Recursivo (`inOrderTraversal`)
Este método realiza un recorrido en inorden (Left, Root, Right) de forma recursiva.

```java
public void inOrderTraversal(Node node) {
    if (node != null) {
        inOrderTraversal(node.getLeft());
        System.out.print(node.getValue() + ", ");
        inOrderTraversal(node.getRight());
    }
}
```

### Preorden Recursivo (`preOrderTraversal`)
Este método realiza un recorrido en preorden (Root, Left, Right) de forma recursiva.

```java
public void preOrderTraversal(Node node) {
    if (node != null) {
        System.out.print(node.getValue() + ", ");
        preOrderTraversal(node.getLeft());
        preOrderTraversal(node.getRight());
    }
}
```

### Postorden Recursivo (`postOrderTraversal`)
Este método realiza un recorrido en postorden (Left, Right, Root) de forma recursiva.

```java
public void postOrderTraversal(Node node) {
    if (node != null) {
        postOrderTraversal(node.getLeft());
        postOrderTraversal(node.getRight());
        System.out.print(node.getValue() + ", ");
    }
}
```

---

## Conclusión
La implementación de los métodos de recorrido permite explorar y procesar los nodos del árbol binario en diferentes órdenes. Los recorridos iterativos son útiles para evitar problemas de desbordamiento de pila en estructuras grandes, mientras que los recorridos recursivos son más sencillos de implementar y entender para estructuras pequeñas o medianas.



## Contribuir

Para contribuir a este proyecto, por favor crea un fork y envía una solicitud de extracción, o simplemente abre un issue con tus comentarios y sugerencias.

## Autores

- [PABLO TORRES] - Desarrollo inicial