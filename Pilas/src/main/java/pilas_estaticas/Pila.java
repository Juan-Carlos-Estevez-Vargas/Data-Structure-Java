package pilas_estaticas;

public class Pila {

    int vector_pila[];
    int cima_pila;

    //Constructor
    public Pila(int tamanio_pila) {
        vector_pila = new int[tamanio_pila];
        cima_pila = -1;
    }

    //Insertar elemento a la pila
    public void agregar(int dato) {
        cima_pila++;
        vector_pila[cima_pila] = dato;
    }

    //Eliminar elemento de la pila
    public int eliminar() {
        int auxiliar = vector_pila[cima_pila];
        cima_pila--;
        return auxiliar;
    }

    //Método para saber si la pila está vacía
    public boolean vacia() {
        return cima_pila == -1;
    }

    //Método para saber si la pila está llena
    public boolean llena() {
        return vector_pila.length - 1 == cima_pila;
    }
    
    //Método para saber la cima de la pila
    public int cima(){
        return vector_pila[cima_pila];
    }
    
    //Método para conocer el tamaño de la pila
    public int tamanioPila(){
        return vector_pila.length;
    }
}
