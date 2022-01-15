package arboles_AVL;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        int opcion = 0, elemento;
        String nombre;
        Arbol_AVL arbolito = new Arbol_AVL();

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar elemento al árbol AVL\n"
                        + "2. Recorrer el árbol inOrden\n"
                        + "3. Recorrer el árbol en preOrden\n"
                        + "4. Recorrer el árbol en postOrden\n"
                        + "5. Buscar Nodo en el árbol\n"
                        + "6. Eliminar Nodo del árbol\n"
                        + "7. ¿El árbol está vacío?\n"
                        + "8. Salir", "Menú de opciones", JOptionPane.INFORMATION_MESSAGE));

                switch (opcion) {
                    case 1 -> {
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el número del Nodo", "Agregando Nodo", JOptionPane.QUESTION_MESSAGE));
                        nombre = JOptionPane.showInputDialog(null,
                                "Ingresa el nombre del Nodo", "Agregando Nodo", JOptionPane.QUESTION_MESSAGE);
                        arbolito.insertarNodo(elemento);
                    }
                    case 2 -> {
                        if (!arbolito.vacio()) {
                            arbolito.inOrden(arbolito.obtenerRaiz());
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "El árbol está vacío", "Árbol vacío", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    case 3 -> {
                        if (!arbolito.vacio()) {
                            arbolito.preOrden(arbolito.obtenerRaiz());
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "El árbol está vacío", "Árbol vacío", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    case 4 -> {
                        if (!arbolito.vacio()) {
                            arbolito.postOrden(arbolito.obtenerRaiz());
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "El árbol está vacío", "Árbol vacío", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    case 5 -> {
                        if (!arbolito.vacio()) {
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingresa el número del Nodo a buscar", "Buscando Nodo", JOptionPane.QUESTION_MESSAGE));
                            if (arbolito.buscarNodo(elemento, arbolito.obtenerRaiz()) == null) {
                                JOptionPane.showMessageDialog(null,
                                        "Nodo no encontrado en el árbol", "Buscando Nodo", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Nodo encontrado ", "Nodo encontrado", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "El árbol está vacío", "Árbol vacío", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    case 7 -> {
                        if (!arbolito.vacio()) {
                            JOptionPane.showMessageDialog(null,
                                    "El árbol NO está vacío", "Árbol con elementos", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "El árbol está vacío", "Árbol vacío", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    case 8 -> {
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
        } while (opcion != 8);
    }

}
