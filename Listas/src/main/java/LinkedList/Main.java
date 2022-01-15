package LinkedList;

import java.awt.HeadlessException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        int opcion = 0, elemento, i = 0, j = 0;
        String datos = "";
        LinkedList listita = new LinkedList();

        do {
            try {
                opcion = Integer.parseInt(
                        JOptionPane.showInputDialog(null,
                                "1. Agregar un elemento a la lista\n"
                                + "2. Eliminar un elemento de la lista\n"
                                + "3. Buscar un elemento en la lista\n"
                                + "4. Mostrar elementos de la lista\n"
                                + "5. Mostrar tamaño de la lista\n"
                                + "6. Limpiar lista\n"
                                + "7. Salir", "Menú de opciones", 3));

                switch (opcion) {
                    case 1 -> {
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el elemento: ", "Insertando nodos a la lista", 3));
                        listita.add(elemento);
                    }
                    case 2 -> {
                        if (listita.size() > 0) {
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingresa el índice del elemento a eliminar: ", "Eliminando nodos de la lista", 3));
                            listita.remove(elemento);
                        } else {
                            JOptionPane.showMessageDialog(null, "La lista está vacía");
                        }

                    }
                    case 3 -> {
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el elemento a buscar: ", "Buscando nodos de la lista", 3));
                        if (listita.contains(elemento)) {
                            JOptionPane.showMessageDialog(null, "Elemento encontrado");
                        } else {
                            JOptionPane.showMessageDialog(null, "Elemento NO encontrado");
                        }
                    }
                    case 4 -> {
                        while (i < listita.size()) {
                            datos += "[" + listita.get(i) + "] -> ";
                            i++;
                        }
                        JOptionPane.showMessageDialog(null, datos);
                    }
                    case 5 -> {
                        JOptionPane.showMessageDialog(null, "El tamaño de la lista es: " + listita.size());
                    }
                    case 6 -> {
                        listita.clear();
                        datos = "";
                        JOptionPane.showMessageDialog(null, "Lista vaciada correctamente");
                    }
                    case 7 -> {
                        JOptionPane.showMessageDialog(null,
                                "Aplicación finalizada", "Fiin", JOptionPane.INFORMATION_MESSAGE);
                    }
                    default -> {
                        JOptionPane.showMessageDialog(null,
                                "Opción incorrecta", "Incorrecto", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
            }
        } while (opcion != 7);
    }
}
