package listas_tipo_pila;

import javax.swing.JOptionPane;

public class Pila {

    private Nodo ultimoValorIngresado;
    int tamano = 0;
    String lista = "";

    public Pila() {
        this.ultimoValorIngresado = null;
        this.tamano = 0;
    }

    //Metodo para conocer si la pila esta vacia
    public boolean pilaVacia() {
        return this.ultimoValorIngresado == null;
    }

    //Metodo para insertar un nodo a la pila
    public void insertarNodo(int nodo) {
        Nodo nuevo_nodo = new Nodo(nodo);
        nuevo_nodo.siguiente = ultimoValorIngresado;
        ultimoValorIngresado = nuevo_nodo;
        tamano++;
    }

    //Metodo para eliminar un nodo de la pila
    public int eliminarNodo() {
        int auxiliar = ultimoValorIngresado.informacion;
        ultimoValorIngresado = ultimoValorIngresado.siguiente;
        tamano--;
        return auxiliar;
    }

    //Metodo para conocer el ultimo valor ingresado
    public int mostrarUltimoValorIngresado() {
        return ultimoValorIngresado.informacion;
    }

    //Metodo para conocer el tamaño de la pila
    public int tamanoPila() {
        return tamano;
    }

    //Metodo para vaciar la pila
    public void vaciarPila() {
        while (!pilaVacia()) {
            eliminarNodo();
        }
    }

    //Metodo para mostrar el contenido de la pila
    public void mostrarValores() {
        Nodo recorrido = ultimoValorIngresado;

        while (recorrido != null) {
            lista += recorrido.informacion + "\n";
            recorrido = recorrido.siguiente;
        }

        JOptionPane.showMessageDialog(null, lista);
        lista = "";
    }
}
