package arboles_AVL;

public class Nodo {

    int dato, factor_equilibrio;
    Nodo hijo_izquierdo, hijo_derecho;

    public Nodo(int dato) {
        this.dato = dato;
        this.factor_equilibrio = 0;
        this.hijo_izquierdo = null;
        this.hijo_derecho = null;
    }
}
