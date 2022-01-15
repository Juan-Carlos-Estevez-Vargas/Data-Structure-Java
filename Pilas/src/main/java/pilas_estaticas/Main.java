package pilas_estaticas;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        int opcion = 0, elemento, tamanio;

        try {
            tamanio = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "¿De qué tamaño deseas la pila?", "Solicitando tamaño d ela pila", JOptionPane.INFORMATION_MESSAGE));
            Pila pilita = new Pila(tamanio);

            do {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar elemento a la pila\n"
                        + "2. Sacar elemento de la pila\n"
                        + "3. ¿La pila está vacía?\n"
                        + "4. ¿La pila está llena?\n"
                        + "5. ¿Qué elemento está en la cima?\n"
                        + "6. Tamaño de la cima\n"
                        + "7. Salir\n", "Menú de opciones", JOptionPane.INFORMATION_MESSAGE));

                switch (opcion) {
                    case 1 -> {
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingrese el elemento a apilar", "Apilando elemento", JOptionPane.INFORMATION_MESSAGE));

                        if (!pilita.llena()) {
                            pilita.agregar(elemento);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "La pila está llena", "Pila llena", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    case 2 -> {
                        if (!pilita.vacia()) {
                            JOptionPane.showMessageDialog(null,
                                    "El elemento eliminado es: " + pilita.eliminar(), "Desapilando Pila llena", JOptionPane.WARNING_MESSAGE);
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
                        if (pilita.llena()) {
                            JOptionPane.showMessageDialog(null,
                                    "La pila está llena", "Pila llena", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "La pila aún contiene espacio", "Pila con espacio", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    case 5 -> {
                        if (!pilita.vacia()) {
                            JOptionPane.showMessageDialog(null,
                                    "El elemento que se encuentra en la cima es: " + pilita.cima(), "Cima de la pila", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "La pila está vacia", "Pila vacía", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    case 6 -> {
                        JOptionPane.showMessageDialog(null,
                                "El tamaño de la pila es: " + pilita.tamanioPila(), "Tamaño Pila", JOptionPane.WARNING_MESSAGE);
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
            } while (opcion != 7);
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
    }
}
