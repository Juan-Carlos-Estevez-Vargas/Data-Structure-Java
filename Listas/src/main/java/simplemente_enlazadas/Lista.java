package simplemente_enlazadas;

public class Lista {

    protected Nodo inicio, fin; //Punteros para saber donde está el inicio y el final

    public Lista() {
        inicio = null;
        fin = null;
    }

    //Método para agregar un Nodo al inicio de la lista
    public void agregarInicio(int elemento) {
        inicio = new Nodo(elemento, inicio);

        if (fin == null) {
            fin = inicio;
        }
    }

    //Método para mostrar los datos
    public void mostrarLista() {
        Nodo aux = inicio;

        while (aux != null) {
            System.out.print("[" + aux.dato + "]  --->   ");
            aux = aux.siguiente;
        }
    }

    //Método para saber si la lista esta vacía
    public boolean vacia() {
        return inicio == null;
    }

    //Método para insertar al final de la lista
    public void agregarFinal(int dato) {
        if (!vacia()) {
            fin.siguiente = new Nodo(dato);
            fin = fin.siguiente;
        } else {
            inicio = fin = new Nodo(dato);
        }
    }

    //Método para eliminar del inicio de la lista
    public int borrarInicio() {
        int elemento = inicio.dato;

        if (inicio == fin) {
            inicio = fin = null;
        } else {
            inicio = inicio.siguiente;
        }
        return elemento;
    }

    //Método para eliminar del final de la lista
    public int borrarFinal() {
        int elemento = fin.dato;

        if (inicio == fin) {
            inicio = fin = null;
        } else {
            Nodo temporal = inicio;

            while (temporal.siguiente != fin) {
                temporal = temporal.siguiente;
            }

            fin = temporal;
            fin.siguiente = null;
        }
        return elemento;
    }

    //Método para eliminar cualquier nodo de la lista
    public void eliminar(int elemento) {
        if (!vacia()) {
            if (inicio == fin && elemento == inicio.dato) {
                inicio = fin = null;
            } else if (elemento == inicio.dato) {
                inicio = inicio.siguiente;
            } else {
                Nodo anterior, temporal;
                anterior = inicio;
                temporal = inicio.siguiente;

                while (temporal != null && temporal.dato != elemento) {
                    anterior = anterior.siguiente;
                    temporal = temporal.siguiente;
                }

                if (temporal != null) {
                    anterior.siguiente = temporal.siguiente;

                    if (temporal == fin) {
                        fin = anterior;
                    }
                }
            }
        }
    }

    //Método para buscar un elemento
    public boolean estaenLista(int elemento) {
        Nodo temporal = inicio;

        while (temporal != null && temporal.dato != elemento) {
            temporal = temporal.siguiente;
        }
        return temporal != null;
    }
}
