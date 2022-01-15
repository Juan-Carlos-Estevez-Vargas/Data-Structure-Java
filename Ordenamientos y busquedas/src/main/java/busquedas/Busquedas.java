package busquedas;

public class Busquedas {

    //Método de búsqueda SECUENCIAL
    public int busquedaSecuancial(int[] array, int elemento) {
        boolean encontrado = false;

        for (int i = 0; i < array.length && encontrado == false; i++) {
            if (elemento == array[i]) {
                encontrado = true;
                return i;
            }
        }
        return -1;
    }

    //Método de búsqueda BINARIA
    public int busquedaBinaria(int[] array, int elemento) {
        int centro, primero, ultimo, valor_central;
        primero = 0;
        ultimo = array.length - 1;

        while (primero <= ultimo) {
            centro = (primero + ultimo) / 2;
            valor_central = array[centro];

            if (elemento == array[valor_central]) {
                return centro;
            } else if (elemento < valor_central) {
                ultimo = centro - 1;
            } else {
                primero = centro + 1;
            }
        }
        return -1;
    }
}
