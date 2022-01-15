package clase_Queue;

import java.awt.HeadlessException;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        int opcion = 0, elemento;
        Queue<Integer> colita = new LinkedList<>();

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar elemento a la cola\n"
                        + "2. Sacar elemento de la cola\n"
                        + "3. ¿La pila está vacía?\n"
                        + "4. Elemento ubicado al inicio de la cola\n"
                        + "5. Tamaño de la cola\n"
                        + "6. Salir\n", "Menú de opciones", JOptionPane.INFORMATION_MESSAGE));

                switch (opcion) {
                    case 1 -> {
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingrese el elemento a insertar", "Insertando elemento en la cola", JOptionPane.INFORMATION_MESSAGE));
                        colita.add(elemento);
                    }
                    case 2 -> {
                        if (!colita.isEmpty()) {
                            JOptionPane.showMessageDialog(null,
                                    "El elemento eliminado es: " + colita.remove(), "Despachando de la cola", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "La cola está vacia", "Cola vacía", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    case 3 -> {
                        if (colita.isEmpty()) {
                            JOptionPane.showMessageDialog(null,
                                    "La cola está vacia", "Cola vacía", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "La cola NO está vacia", "Cola NO vacía", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    case 4 -> {
                        if (!colita.isEmpty()) {
                            JOptionPane.showMessageDialog(null,
                                    "El elemento al inicio de la cola es: " + colita.peek(), "Inicio cola", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    case 5 -> {
                        JOptionPane.showMessageDialog(null,
                                "El tamaño de la cola es: " + colita.size(), "Tamaño Cola", JOptionPane.WARNING_MESSAGE);
                    }
                    case 6 -> {
                        JOptionPane.showMessageDialog(null,
                                "Adiós", "Fin de la aplicación", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
            }

        } while (opcion != 6);
    }
}
