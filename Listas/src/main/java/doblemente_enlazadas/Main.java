package doblemente_enlazadas;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        ListaDoble listita = new ListaDoble();
        int opcion = 0, elemento;

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar Nodo al inicio\n"
                        + "2. Agregar Nodo al final\n"
                        + "3. Mostrar lista de inicio a fin\n"
                        + "4. Mostrar lista de fin a inicio\n"
                        + "5. Eliminar un Nodo del inicio de la lista\n"
                        + "6. Eliminar un Nodo del final de la lista\n"
                        + "7. Salir\n"
                        + "¿Qué deseas hacer?", "Menú de opciones", JOptionPane.INFORMATION_MESSAGE));

                switch (opcion) {
                    case 1 -> {
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el elemento del nodo", "Agregando Nodo", JOptionPane.INFORMATION_MESSAGE));
                        listita.agregarInicio(elemento);
                    }
                    case 2 -> {
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el elemento del nodo", "Agregando Nodo", JOptionPane.INFORMATION_MESSAGE));
                        listita.agregarFinal(elemento);
                    }
                    case 3 -> {
                        if (!listita.vacia()) {
                            listita.mostrarListaInicioFin();
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "La lista está vacía", "Lista vacía", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    case 4 -> {
                        if (!listita.vacia()) {
                            listita.mostrarListaFinInicio();
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "La lista está vacía", "Lista vacía", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    case 5 -> {
                        if (!listita.vacia()) {
                            elemento = listita.eliminarInicio();
                            JOptionPane.showMessageDialog(null,
                                    "El elemento eliminado es: " + elemento, "Eliminado elementos", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "La lista está vacía", "Lista vacía", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    case 6 -> {
                        if (!listita.vacia()) {
                            elemento = listita.eliminarFinal();
                            JOptionPane.showMessageDialog(null,
                                    "El elemento eliminado es: " + elemento, "Eliminado elementos", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "La lista está vacía", "Lista vacía", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    case 7 -> {
                        JOptionPane.showMessageDialog(null,
                                "Aplicación finalizada", "Fiin", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                    default -> {
                        JOptionPane.showMessageDialog(null,
                                "Opción incorrecta", "Incorrecto", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
            }
        } while (opcion != 7);
    }
}
