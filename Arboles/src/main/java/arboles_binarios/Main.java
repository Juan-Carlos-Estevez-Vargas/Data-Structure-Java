package arboles_binarios;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        int opcion = 0, elemento;
        String nombre;
        Arbol_binario arbolito = new Arbol_binario();

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar elemento al árbol binario\n"
                        + "2. Recorrer el árbol inOrden\n"
                        + "3. Recorrer el árbol en preOrden\n"
                        + "4. Recorrer el árbol en postOrden\n"
                        + "5. Busacar Nodo en el árbol\n"
                        + "6. Eliminar Nodo del árbol\n"
                        + "7. Salir\n", "Menú de opciones", JOptionPane.INFORMATION_MESSAGE));

                switch (opcion) {
                    case 1 -> {
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el número del Nodo", "Agregando Nodo", JOptionPane.QUESTION_MESSAGE));
                        nombre = JOptionPane.showInputDialog(null,
                                "Ingresa el nombre del Nodo", "Agregando Nodo", JOptionPane.QUESTION_MESSAGE);
                        arbolito.agregarNodo(elemento, nombre);
                    }
                    case 2 -> {
                        if (!arbolito.vacio()) {
                            arbolito.inOrden(arbolito.raiz);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "El árbol está vacío", "Árbol vacío", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    case 3 -> {
                        if (!arbolito.vacio()) {
                            arbolito.preOrden(arbolito.raiz);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "El árbol está vacío", "Árbol vacío", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    case 4 -> {
                        if (!arbolito.vacio()) {
                            arbolito.postOrden(arbolito.raiz);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "El árbol está vacío", "Árbol vacío", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    case 5 -> {
                        if (!arbolito.vacio()) {
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingresa el número del Nodo a buscar", "Buscando Nodo", JOptionPane.QUESTION_MESSAGE));
                            if (arbolito.buscarNodo(elemento) == null) {
                                JOptionPane.showMessageDialog(null,
                                        "Nodo no encontrado en el árbol", "Buscando Nodo", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Nodo encontrado " + arbolito.buscarNodo(elemento), "Nodo encontrado", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "El árbol está vacío", "Árbol vacío", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    case 6 -> {
                        if (!arbolito.vacio()) {
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingresa el número del Nodo a eliminar", "Eliminando Nodo", JOptionPane.QUESTION_MESSAGE));
                            if (arbolito.eliminar(elemento) == false) {
                                JOptionPane.showMessageDialog(null,
                                        "Nodo no encontrado en el árbol", "Eliminando Nodo", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Nodo eliminado correctamente del árbol ", "Nodo eliminado", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "El árbol está vacío", "Árbol vacío", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    case 7 -> {
                        break;
                    }

                    default -> {
                        JOptionPane.showMessageDialog(null,
                                "Opción incorrecta", "Opción incorrecta", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
            }
        } while (opcion != 7);
    }
}
