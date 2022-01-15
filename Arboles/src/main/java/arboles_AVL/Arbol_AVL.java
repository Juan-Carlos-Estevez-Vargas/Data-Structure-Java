package arboles_AVL;

import javax.swing.JOptionPane;

public class Arbol_AVL {

    private Nodo raiz;

    public Arbol_AVL() {
        this.raiz = null;
    }

    public Nodo obtenerRaiz() {
        return this.raiz;
    }
    
    //Método para saber cuando el árbol está vacío
    public boolean vacio() {
        return raiz == null;
    }

    //Método para buscar un Nodo en el árbol AVL
    public Nodo buscarNodo(int dato, Nodo raiz) {
        if (raiz == null) {
            return null;
        } else if (raiz.dato == dato) {
            return raiz;
        } else if (raiz.dato < dato) {
            return buscarNodo(dato, raiz.hijo_derecho);
        } else {
            return buscarNodo(dato, raiz.hijo_izquierdo);
        }
    }

    //Obteniendo el factor de equilibrio
    public int obtenerFE(Nodo x) {
        if (x == null) {
            return -1;
        } else {
            return x.factor_equilibrio;
        }
    }

    //Rotación simple a la izquierda
    public Nodo rotacionIzquierda(Nodo c) {
        Nodo auxiliar = c.hijo_izquierdo;
        c.hijo_izquierdo = auxiliar.hijo_derecho;
        auxiliar.hijo_derecho = c;
        c.factor_equilibrio = Math.max(obtenerFE(c.hijo_izquierdo), obtenerFE(c.hijo_derecho)) + 1;
        auxiliar.factor_equilibrio = Math.max(obtenerFE(auxiliar.hijo_izquierdo), obtenerFE(auxiliar.hijo_derecho)) + 1;
        return auxiliar;
    }

    //Rotación simple a la derecha
    public Nodo rotacionDerecha(Nodo c) {
        Nodo auxiliar = c.hijo_derecho;
        c.hijo_derecho = auxiliar.hijo_izquierdo;
        auxiliar.hijo_izquierdo = c;
        c.factor_equilibrio = Math.max(obtenerFE(c.hijo_izquierdo), obtenerFE(c.hijo_derecho)) + 1;
        auxiliar.factor_equilibrio = Math.max(obtenerFE(auxiliar.hijo_izquierdo), obtenerFE(auxiliar.hijo_derecho)) + 1;
        return auxiliar;
    }

    //Rotación doble a la izquierda
    public Nodo rotacionDobleIzquierda(Nodo c) {
        Nodo temporal;
        c.hijo_izquierdo = rotacionDerecha(c.hijo_izquierdo);
        temporal = rotacionIzquierda(c);
        return temporal;
    }

    //Rotación doble a la derecha
    public Nodo rotacionDobleDerecha(Nodo c) {
        Nodo temporal;
        c.hijo_derecho = rotacionIzquierda(c.hijo_derecho);
        temporal = rotacionDerecha(c);
        return temporal;
    }

    //Método para insertar AVL
    public Nodo insertarAVL(Nodo nuevo, Nodo sub_arbol) {
        Nodo nuevo_padre = sub_arbol;

        if (nuevo.dato < sub_arbol.dato) {
            if (sub_arbol.hijo_izquierdo == null) {
                sub_arbol.hijo_izquierdo = nuevo;
            } else {
                sub_arbol.hijo_izquierdo = insertarAVL(nuevo, sub_arbol.hijo_izquierdo);
                if ((obtenerFE(sub_arbol.hijo_izquierdo) - obtenerFE(sub_arbol.hijo_derecho)) == 2) {
                    if (nuevo.dato < sub_arbol.hijo_izquierdo.dato) {
                        nuevo_padre = rotacionIzquierda(sub_arbol);
                    } else {
                        nuevo_padre = rotacionDobleIzquierda(sub_arbol);
                    }
                }
            }
        } else if (nuevo.dato > sub_arbol.dato) {
            if (sub_arbol.hijo_derecho == null) {
                sub_arbol.hijo_derecho = nuevo;
            } else {
                sub_arbol.hijo_derecho = insertarAVL(nuevo, sub_arbol.hijo_derecho);
                if ((obtenerFE(sub_arbol.hijo_derecho) - obtenerFE(sub_arbol.hijo_izquierdo)) == 2) {
                    if (nuevo.dato > sub_arbol.hijo_derecho.dato) {
                        nuevo_padre = rotacionDerecha(sub_arbol);
                    } else {
                        nuevo_padre = rotacionDobleDerecha(sub_arbol);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Nodo duplicado", "Nodo duplicado", JOptionPane.WARNING_MESSAGE);
        }

        //Actualizando el factor de equilibrio
        if ((sub_arbol.hijo_izquierdo == null) && (sub_arbol.hijo_derecho != null)) {
            sub_arbol.factor_equilibrio = sub_arbol.hijo_derecho.factor_equilibrio + 1;
        } else if ((sub_arbol.hijo_derecho == null) && (sub_arbol.hijo_izquierdo != null)) {
            sub_arbol.factor_equilibrio = sub_arbol.hijo_izquierdo.factor_equilibrio + 1;
        } else {
            sub_arbol.factor_equilibrio = Math.max(obtenerFE(sub_arbol.hijo_izquierdo), obtenerFE(sub_arbol.hijo_derecho)) + 1;
        }

        return nuevo_padre;
    }

    //Método para insertar normal
    public void insertarNodo(int dato) {
        Nodo nuevo = new Nodo(dato);

        if (raiz == null) {
            raiz = nuevo;
        } else {
            raiz = insertarAVL(nuevo, raiz);
        }
    }

    //Recorridos
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
}
