package pila_dinamica;

public class Pila {

    private Nodo cima;
    int tamanio;

    public Pila() {
        cima = null;
        tamanio = 0;
    }

    //Método para saber cuando la pila está vacía
    public boolean vacia() {
        return cima == null;
    }

    //Método para insertar un elemento en la pila
    public void insertarNodo(int elemento) {
        Nodo nuevo = new Nodo(elemento);
        nuevo.siguiente = cima;
        cima = nuevo;
        tamanio++;
    }

    //Método para eliminar un elemento de la pila
    public int eliminarNodo() {
        int auxiliar = cima.dato;
        cima = cima.siguiente;
        tamanio--;
        return auxiliar;
    }

    //Método para saber si la cima de la pila
    public int cima() {
        return cima.dato;
    }

    //Método para saber el tamaño de la pila
    public int tamanioPila() {
        return tamanio;
    }

    //Método para limpiar la pila
    public void limpiar() {
        while (!vacia()) {
            eliminarNodo();
        }
    }
}
