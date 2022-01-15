package simplemente_enlazadas;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        int opcion = 0, element;
        Lista miLista = new Lista();

        do {
            try {
                opcion = Integer.parseInt(
                        JOptionPane.showInputDialog(null,
                                "1. Agregar un elemento al inicio de la lista\n"
                                + "2. Agregar un elemento al final de la lista\n"
                                + "3. Eliminar un elemento del inicio de la lista\n"
                                + "4. Eliminar un elemento del final de la lista\n"
                                + "5. Eliminar un elemento en específico de la lista\n"
                                + "6. Buscar un elemento en la lista\n"
                                + "7. Mostrar elementos de la lista\n"
                                + "8. Salir", "Menú de opciones", 3));

                switch (opcion) {
                    case 1 -> {
                        try {
                            element = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingresa el elemento: ", "Insertando nodos al inicio", 3));
                            miLista.agregarInicio(element);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
                        }
                    }
                    case 2 -> {
                        try {
                            element = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingresa el elemento: ", "Insertando nodos al final", 3));
                            miLista.agregarFinal(element);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
                        }
                    }
                    case 3 -> {
                        element = miLista.borrarInicio();
                        JOptionPane.showMessageDialog(null,
                                "El elemento eliminado es: " + element, "Eliminando nodo del inicio", JOptionPane.INFORMATION_MESSAGE);
                    }
                    case 4 -> {
                        element = miLista.borrarFinal();
                        JOptionPane.showMessageDialog(null,
                                "El elemento eliminado es: " + element, "Eliminando nodo del final", JOptionPane.INFORMATION_MESSAGE);
                    }
                    case 5 -> {
                        element = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el elemento a eliminar", "Eliminando nodos en específico", JOptionPane.INFORMATION_MESSAGE));
                        miLista.eliminar(element);
                        JOptionPane.showMessageDialog(null,
                                "El elemento eliminado es: " + element, "Eliminando nodo en específico", JOptionPane.INFORMATION_MESSAGE);
                    }
                    case 6 -> {
                        element = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el elemento a buscar", "EBuscando nodos en específico", JOptionPane.INFORMATION_MESSAGE));

                        if (miLista.estaenLista(element)) {
                            JOptionPane.showMessageDialog(null, "El elemento " + element + " si está en la lista");
                        } else {
                            JOptionPane.showMessageDialog(null, "El elemento " + element + " NO está en la lista");
                        }
                    }
                    case 7 -> {
                        miLista.mostrarLista();
                    }
                    default -> {
                        JOptionPane.showMessageDialog(null, "Opción incorrecta");
                    }
                }
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
            }
        } while (opcion != 8);
    }
}
