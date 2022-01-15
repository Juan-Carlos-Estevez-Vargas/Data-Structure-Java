package pila_dinamica;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        int opcion = 0, elemento;
        Pila pilita = new Pila();

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar elemento a la pila\n"
                        + "2. Sacar elemento de la pila\n"
                        + "3. ¿La pila está vacía?\n"
                        + "4. ¿Qué elemento está en la cima?\n"
                        + "5. Tamaño de la cima\n"
                        + "6. Vaciar pila\n"
                        + "7. Salir\n", "Menú de opciones", JOptionPane.INFORMATION_MESSAGE));

                switch (opcion) {
                    case 1 -> {
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingrese el elemento a apilar", "Apilando elemento", JOptionPane.INFORMATION_MESSAGE));
                        pilita.insertarNodo(elemento);
                    }
                    case 2 -> {
                        if (!pilita.vacia()) {
                            JOptionPane.showMessageDialog(null,
                                    "El elemento eliminado es: " + pilita.eliminarNodo(), "Desapilando Pila llena", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "La pila está vacia", "Pila vacía", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    case 3 -> {
                        if (pilita.vacia()) {
                            JOptionPane.showMessageDialog(null,
                                    "La pila está vacia", "Pila vacía", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "La pila NO está vacia", "Pila NO vacía", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    case 4 -> {
                        if (!pilita.vacia()) {
                            JOptionPane.showMessageDialog(null,
                                    "El elemento que se encuentra en la cima es: " + pilita.cima(), "Cima de la pila", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "La pila está vacia", "Pila vacía", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    case 5 -> {
                        JOptionPane.showMessageDialog(null,
                                "El tamaño de la pila es: " + pilita.tamanioPila(), "Tamaño Pila", JOptionPane.WARNING_MESSAGE);
                    }
                    case 6 -> {
                        if (!pilita.vacia()) {
                            pilita.limpiar();
                            JOptionPane.showMessageDialog(null,
                                    "La pila se ha vaciado", "Pila vacía", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "NO hay nada que limpiar", "Pila vacía", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    case 7 -> {
                        JOptionPane.showMessageDialog(null,
                                "Adiós", "Fin de la aplicación", JOptionPane.INFORMATION_MESSAGE);
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
