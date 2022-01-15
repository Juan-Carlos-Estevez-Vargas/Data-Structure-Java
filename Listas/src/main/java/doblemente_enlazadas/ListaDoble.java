package doblemente_enlazadas;

import javax.swing.JOptionPane;

public class ListaDoble {

    private NodoDoble inicio, fin;

    public ListaDoble() {
        inicio = fin = null;
    }

    //Método para saber cuando la lista está vacía
    public boolean vacia() {
        return inicio == null;
    }

    //Método para agregar nodos al final
    public void agregarFinal(int elemento) {
        if (!vacia()) {
            fin = new NodoDoble(elemento, null, fin);
            fin.anterior.siguiente = fin;
        } else {
            inicio = fin = new NodoDoble(elemento);
        }
    }

    //Método para agregar nodos al inicio
    public void agregarInicio(int elemento) {
        if (!vacia()) {
            inicio = new NodoDoble(elemento, inicio, null);
            inicio.siguiente.anterior = inicio;
        } else {
            inicio = fin = new NodoDoble(elemento);
        }
    }

    //Método para mostrar la lista de inicio a fin
    public void mostrarListaInicioFin() {
        if (!vacia()) {
            String datos = "< = >";
            NodoDoble auxiliar = inicio;

            while (auxiliar != null) {
                datos += "[" + auxiliar.dato + "] < = > ";
                auxiliar = auxiliar.siguiente;
            }
            JOptionPane.showMessageDialog(null,
                    datos, "Mostrando lista de inicio a fin", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //Método para mostrar la lista de fin a inicio
    public void mostrarListaFinInicio() {
        if (!vacia()) {
            String datos = " < = > ";
            NodoDoble auxiliar = fin;

            while (auxiliar != null) {
                datos += "[" + auxiliar.dato + "] < = > ";
                auxiliar = auxiliar.anterior;
            }
            JOptionPane.showMessageDialog(null,
                    datos, "Mostrando lista de fin a inicio", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //Método para eliminar un elemento del inicio de la lista
    public int eliminarInicio() {
        int elemento = inicio.dato;

        if (inicio == fin) {
            inicio = fin = null;
        } else {
            inicio = inicio.siguiente;
            inicio.anterior = null;
        }
        return elemento;
    }

    //Método para eliminar un elemento del final de la lista
    public int eliminarFinal() {
        int elemento = fin.dato;

        if (inicio == fin) {
            inicio = fin = null;
        } else {
            fin = fin.anterior;
            fin.siguiente = null;
        }
        return elemento;
    }
}
