package circulares;

import javax.swing.JOptionPane;

public class Lista {

    Nodo ultimo;

    public Lista() {
        ultimo = null;
    }

    //Método para saber cuando la lista está vacía
    public boolean vacia() {
        return ultimo == null;
    }

    //Método para insertar nodos
    public Lista insertarNodo(int elemento) {
        Nodo nuevo = new Nodo(elemento);

        if (ultimo != null) {
            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
        }

        ultimo = nuevo;
        return this;
    }

    //Método para mostrar lista
    public void mostrarLista() {
        Nodo auxiliar = ultimo.siguiente;
        String cadena = "";

        do {
            cadena += "[" + auxiliar.dato + "] -> ";
            auxiliar = auxiliar.siguiente;
        } while (auxiliar != ultimo.siguiente);

        JOptionPane.showMessageDialog(null, cadena, "Mostrando la lista", JOptionPane.INFORMATION_MESSAGE);
    }

    //Método para eliminar un Nodo de la lista
    public boolean eliminarNodo(int elemento) {
        Nodo actual;
        boolean encontrado = false;
        actual = ultimo;

        while (actual.siguiente != ultimo && !encontrado) {
            encontrado = (actual.siguiente.dato == elemento);

            if (!encontrado) {
                actual = actual.siguiente;
            }
        }

        encontrado = (actual.siguiente.dato == elemento);

        if (encontrado) {
            Nodo auxiliar = actual.siguiente;

            if (ultimo == ultimo.siguiente) {
                ultimo = null;
            } else {
                if (auxiliar == ultimo) {
                    ultimo = actual;
                }
                actual.siguiente = auxiliar.siguiente;
            }
            auxiliar = null;
        }
        return encontrado == true;
    }
}
