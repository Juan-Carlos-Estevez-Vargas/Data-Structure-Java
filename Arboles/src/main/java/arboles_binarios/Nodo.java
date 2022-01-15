package arboles_binarios;

public class Nodo {

    int dato;
    String nombre;
    Nodo hijo_izquierdo, hijo_derecho;

    public Nodo(int elemento, String nombre) {
        this.dato = elemento;
        this.nombre = nombre;
        this.hijo_derecho = null;
        this.hijo_izquierdo = null;
    }

    @Override
    public String toString() {
        return this.nombre + " su dato es: " + this.dato;
    }
}
