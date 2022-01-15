package listas_tipo_cola;

import javax.swing.JOptionPane;

public class main {

    public static void main(String[] args) {
        int opcion = 0, nodo_informacion = 0;
        Cola cola = new Cola();

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Menu de opciones\n\n"
                        + "1. Insertar un nodo\n"
                        + "2. Extraer un nodo\n"
                        + "3. Mostrar contenido de la cola\n"
                        + "4. salir\n\n"));

                switch (opcion) {
                    case 1 -> {
                        nodo_informacion = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Por favor ingresa el valor a almacenar"));
                        cola.insertar(nodo_informacion);
                    }
                    case 2 -> {
                        if (!cola.colaVacia()) {
                            JOptionPane.showMessageDialog(null, "Se extrajo el nodo: " + cola.extraer());
                        } else {
                            JOptionPane.showMessageDialog(null, "La cola esta vacia");
                        }
                    }
                    case 3 -> {
                        cola.mostrarCola();
                    }
                    case 4 -> {
                        opcion = 4;
                    }
                    default -> {
                        JOptionPane.showMessageDialog(null, "Opcion incorrecta, vuelva a intentarlo");
                    }
                }
            } catch (NumberFormatException e) {

            }
        } while (opcion != 4);
    }
}
