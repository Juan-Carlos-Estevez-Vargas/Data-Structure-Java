package arboles_binarios;

public class Arbol_binario {

    Nodo raiz;

    public Arbol_binario() {
        this.raiz = null;
    }

    //Método para insertar un Nodo en el árbol
    public void agregarNodo(int dato, String nombre) {
        Nodo nuevo = new Nodo(dato, nombre);

        if (raiz == null) {
            raiz = nuevo;
        } else {
            Nodo auxiliar = raiz;
            Nodo padre;

            while (true) {
                padre = auxiliar;
                if (dato < auxiliar.dato) {
                    auxiliar = auxiliar.hijo_izquierdo;
                    if (auxiliar == null) {
                        padre.hijo_izquierdo = nuevo;
                        return;
                    }
                } else {
                    auxiliar = auxiliar.hijo_derecho;
                    if (auxiliar == null) {
                        padre.hijo_derecho = nuevo;
                        return;
                    }
                }
            }
        }
    }

    //Método para saber cuando el árbol está vacío
    public boolean vacio() {
        return raiz == null;
    }

    //Método para recorrer el árbol INORDEN
    public void inOrden(Nodo raiz) {
        if (raiz != null) {
            inOrden(raiz.hijo_izquierdo);
            System.out.println(raiz.dato);
            inOrden(raiz.hijo_derecho);
        }
    }

    //Método para recorrer el árbol en PREORDEN
    public void preOrden(Nodo raiz) {
        if (raiz != null) {
            System.out.println(raiz.dato);
            preOrden(raiz.hijo_izquierdo);
            preOrden(raiz.hijo_derecho);
        }
    }

    //Método para recorrer el árbol el POSTORDEN
    public void postOrden(Nodo raiz) {
        if (raiz != null) {
            postOrden(raiz.hijo_izquierdo);
            postOrden(raiz.hijo_derecho);
            System.out.println(raiz.dato);
        }
    }

    //Método para buscar un Nodo en el árbol
    public Nodo buscarNodo(int dato) {
        Nodo auxiliar = raiz;

        while (auxiliar.dato != dato) {
            if (dato < auxiliar.dato) {
                auxiliar = auxiliar.hijo_izquierdo;
            } else {
                auxiliar = auxiliar.hijo_derecho;
            }
            if (auxiliar == null) {
                return null;
            }
        }
        return auxiliar;
    }

    //Método para eliminar un Nodo del árbol
    public boolean eliminar(int dato) {
        Nodo auxiliar = raiz, padre = raiz;
        boolean es_hijo_izquierdo = true;

        while (auxiliar.dato != dato) {
            padre = auxiliar;
            if (dato < auxiliar.dato) {
                es_hijo_izquierdo = true;
                auxiliar = auxiliar.hijo_izquierdo;
            } else {
                es_hijo_izquierdo = false;
                auxiliar = auxiliar.hijo_derecho;
            }

            if (auxiliar == null) {
                return false;
            }
        }

        if (auxiliar.hijo_izquierdo == null && auxiliar.hijo_izquierdo == null) { //es hoja
            if (auxiliar == raiz) {
                raiz = null;
            } else if (es_hijo_izquierdo) {
                padre.hijo_izquierdo = null;
            } else {
                padre.hijo_derecho = null;
            }
        } else if (auxiliar.hijo_derecho == null) {
            if (auxiliar == raiz) {
                raiz = auxiliar.hijo_izquierdo;
            } else if (es_hijo_izquierdo) {
                padre.hijo_izquierdo = auxiliar.hijo_izquierdo;
            } else {
                padre.hijo_derecho = auxiliar.hijo_derecho;
            }
        } else if (auxiliar.hijo_izquierdo == null) {
            if (auxiliar == raiz) {
                raiz = auxiliar.hijo_derecho;
            } else if (es_hijo_izquierdo) {
                padre.hijo_izquierdo = auxiliar.hijo_derecho;
            } else {
                padre.hijo_derecho = auxiliar.hijo_izquierdo;
            }
        } else {
            Nodo reemplazo = obtenerNodoReemplazo(auxiliar);
            if (auxiliar == raiz) {
                raiz = reemplazo;
            } else if (es_hijo_izquierdo) {
                padre.hijo_izquierdo = reemplazo;
            } else {
                padre.hijo_derecho = reemplazo;
            }
            reemplazo.hijo_izquierdo = auxiliar.hijo_izquierdo;
        }
        return true;
    }

    //Método encargado de devolvernos el Nodo reemplazo
    public Nodo obtenerNodoReemplazo(Nodo nodo_reemplazo) {
        Nodo reemplazar_padre = nodo_reemplazo;
        Nodo reemplazo = nodo_reemplazo;
        Nodo auxiliar = nodo_reemplazo.hijo_derecho;

        while (auxiliar != null) {
            reemplazar_padre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.hijo_izquierdo;
        }

        if (reemplazo != nodo_reemplazo.hijo_derecho) {
            reemplazar_padre.hijo_izquierdo = reemplazo.hijo_derecho;
            reemplazo.hijo_derecho = nodo_reemplazo.hijo_derecho;
        }

        return reemplazo;
    }
}
