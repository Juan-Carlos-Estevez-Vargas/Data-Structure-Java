package circulares;

public class Nodo {

    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        siguiente = this;
    }
}
