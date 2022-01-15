package clase_Stack;

import java.awt.HeadlessException;
import java.util.Stack;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        int opcion = 0, elemento;
        Stack pilita = new Stack();

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
                        pilita.push(elemento);
                    }
                    case 2 -> {
                        if (pilita.size() > 0) {
                            JOptionPane.showMessageDialog(null,
                                    "El elemento desapilado es: " + pilita.pop(), "Desapilando Pila", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "La pila está vacia", "Pila vacía", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    case 3 -> {
                        if (pilita.size() <= 0) {
                            JOptionPane.showMessageDialog(null,
                                    "La pila está vacia", "Pila vacía", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "La pila NO está vacia", "Pila NO vacía", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    case 4 -> {
                        if (pilita.size() > 0) {
                            JOptionPane.showMessageDialog(null,
                                    "El elemento que se encuentra en la cima es: " + pilita.peek(), "Cima de la pila", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "La pila está vacia", "Pila vacía", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    case 5 -> {
                        JOptionPane.showMessageDialog(null,
                                "El tamaño de la pila es: " + pilita.size(), "Tamaño Pila", JOptionPane.WARNING_MESSAGE);
                    }
                    case 6 -> {
                        if (pilita.size() > 0) {
                            pilita.clear();
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
