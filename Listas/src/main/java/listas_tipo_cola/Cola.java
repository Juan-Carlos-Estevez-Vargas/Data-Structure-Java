package listas_tipo_cola;

import javax.swing.JOptionPane;

public class Cola {

    private Nodo inicioCola;
    private Nodo finalCola;
    String cola = "";

    public Cola() {
        this.inicioCola = null;
        this.finalCola = null;
    }

    //Metodo para saber si la cola esta vacia
    public boolean colaVacia() {
        return inicioCola == null;
    }

    //Metodo para insertar a la cola
    public void insertar(int informacion) {
        Nodo nuevo_nodo = new Nodo();
        nuevo_nodo.informacion = informacion;
        nuevo_nodo.siguiente = null;

        if (colaVacia()) {
            inicioCola = nuevo_nodo;
            finalCola = nuevo_nodo;
        } else {
            finalCola.siguiente = nuevo_nodo;
            finalCola = nuevo_nodo;
        }
    }

    //Metodo para extraer de la cola
    public int extraer() {
        if (!colaVacia()) {
            int informacion = inicioCola.informacion;

            if (inicioCola == finalCola) {
                inicioCola = null;
                finalCola = null;
            } else {
                inicioCola = inicioCola.siguiente;
            }

            return informacion;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    //Metodo para mostrar el contenido de la cola
    public void mostrarCola() {
        Nodo recorrido = inicioCola;
        String colaInvertida = "";

        while (recorrido != null) {
            cola += recorrido.informacion + " ";
            recorrido = recorrido.siguiente;
        }

        String cadena[] = cola.split(" ");

        for (int i = cadena.length - 1; i >= 0; i--) {
            colaInvertida += " " + cadena[i];
        }

        JOptionPane.showMessageDialog(null, colaInvertida);
        cola = "";
        
    }
}
