package colas;

public class Cola {
    Nodo inicio, fin;
    int tamanio;
    
    public Cola(){
        inicio = fin = null;
        tamanio=0;
    }
    
    //Método para saber si está vacía la cola
    public boolean vacia(){
        return inicio == null;
    }
    
    //Método para insertar Nodo
    public void insertar(int elemento){
        Nodo nuevo = new Nodo(elemento);
        
        if (vacia()) {
            inicio = nuevo;
        }else{
            fin.siguiente=nuevo;
        }
        
        fin = nuevo;
        tamanio++;
    }
    
    //Método para eliminar Nodo
    public int eliminar(){
        int auxiliar = inicio.dato;
        inicio = inicio.siguiente;
        tamanio--;
        return auxiliar;
    }
    
    //Método para saber el inicio de la cola
    public int inicioCola(){
        return inicio.dato;
    }
    
    //Método para saber tamaño de la cola
    public int tamanio(){
        return tamanio;
    }
}
