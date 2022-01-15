package circulares;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        Lista listita = new Lista();
        int opcion = 0, elemento;
        boolean eliminar = false;

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar Nodo a la lista\n"
                        + "2. Eliminar un nodo de la lista\n"
                        + "3. Mostrar lista de inicio a fin\n"
                        + "4. Salir\n"
                        + "¿Qué deseas hacer?", "Menú de opciones", JOptionPane.INFORMATION_MESSAGE));

                switch (opcion) {
                    case 1 -> {
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el elemento del nodo", "Agregando Nodo", JOptionPane.INFORMATION_MESSAGE));
                        listita.insertarNodo(elemento);
                    }
                    case 2 -> {
                        if (!listita.vacia()) {
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingresa el elemento del nodo a eliminar", "Eliminando Nodo", JOptionPane.INFORMATION_MESSAGE));
                            eliminar = listita.eliminarNodo(elemento);

                            if (eliminar) {
                                JOptionPane.showMessageDialog(null,
                                        "El elemento eliminado es " + elemento, "Elemento eliminado", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "El elemento NO está en la lista", "NO hay elementos para eliminar", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "La lista está vacía", "Lista vacía", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    case 3 -> {
                        if (!listita.vacia()) {
                            listita.mostrarLista();
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "La lista está vacía", "Lista vacía", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    case 4 -> {
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
        } while (opcion != 4);
    }
}
