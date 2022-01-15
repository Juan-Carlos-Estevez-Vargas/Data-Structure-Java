package doblemente_enlazadas;

public class NodoDoble {

    public int dato;
    NodoDoble siguiente, anterior;

    //Constructor para cuando NO hay nodos
    public NodoDoble(int elemento) {
        this(elemento, null, null);
    }

    //Constructor para cuando ya hay nodos
    public NodoDoble(int elemento, NodoDoble sig, NodoDoble ant) {
        dato = elemento;
        siguiente = sig;
        anterior = ant;
    }
}
