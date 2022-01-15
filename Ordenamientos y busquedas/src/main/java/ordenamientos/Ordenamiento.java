package ordenamientos;

import javax.swing.JOptionPane;

public class Ordenamiento {

    int temporal;

    public Ordenamiento() {
        this.temporal = 0;
    }

    //Método de ordenamiento BURBUJA versión 1
    public void burbuja1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    //Método de ordenamiento BURBUJA versión 2
    public void burbuja2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temporal = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temporal;
                }
            }
        }
    }

    //Método de ordenamiento RADIX
    public void radix(int[] array) {
        int j;

        for (int i = Integer.SIZE - 1; i >= 0; i--) {
            int[] auxiliar = new int[array.length];
            j = 0;

            for (int k = 0; k < array.length; k++) {
                boolean mover = array[k] << i >= 0;

                if (i == 0 ? !mover : mover) {
                    auxiliar[j] = array[k];
                    j++;
                } else {
                    array[k - j] = array[k];
                }
            }

            for (int k = j; k < auxiliar.length; k++) {
                auxiliar[k] = array[k - j];
            }

            array = auxiliar;
        }
    }

    //Algoritmo de ordenamiento QUICKSORT
    public void quick(int[] array, int primero, int ultimo) {
        int i, j, pivote, auxiliar;
        i = primero;
        j = ultimo;
        pivote = array[(primero + ultimo) / 2];
        System.out.println("El pivote es: " + pivote);

        do {
            while (array[i] < pivote) {
                i++;
            }

            while (array[j] > pivote) {
                j--;
            }

            //Haciendo el intercambio
            if (i <= j) {
                auxiliar = array[i];
                array[i] = array[j];
                array[j] = auxiliar;
                i++;
            }
        } while (i <= j);

        if (primero < j) {
            quick(array, primero, j);
        }

        if (i < ultimo) {
            quick(array, i, ultimo);
        }
    }

    //Método de ordenamiento por INSERCIÓN
    public void insercion(int[] array, int n) {
        int auxiliar, j;

        for (int i = 1; i < n; i++) {
            auxiliar = array[i];
            j = i - 1;

            while (j >= 0 && array[j] > auxiliar) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = auxiliar;
        }
    }

    //Método de ordenamiento SHELL
    public void shell(int[] array) {
        int salto, auxiliar, j, k;
        salto = array.length / 2;

        while (salto > 0) {
            for (int i = salto; i < array.length; i++) {
                j = i - salto;
                while (j >= 0) {
                    k = j + salto;
                    if (array[j] <= array[k]) {
                        j = -1;
                    } else {
                        auxiliar = array[j];
                        array[j] = array[k];
                        array[k] = auxiliar;
                        j -= salto;
                    }
                }
            }
            salto /= 2;
        }
    }

    //Método de ordenamiento INTERCALACION
    public void intercalacion(int[] array1, int[] array2) {
        int l, j, k;
        int[] array3 = new int[array1.length + array2.length];

        //Repetir mientras los arreglos tengas elementos que comparar
        for (l = j = k = 0; l < array1.length && j < array2.length; k++) {
            if (array1[l] < array2[j]) {
                array3[k] = array1[l];
                l++;
            } else {
                array3[k] = array2[j];
                j++;
            }
        }

        //Para añadir los elementos del arreglo1 sobrantes en caso de haberlos
        for (; l < array1.length; l++, k++) {
            array3[k] = array1[l];
        }

        //Para añadir los elementos del arreglo2 sobrantes en caso de haberlos
        for (; j < array2.length; j++, k++) {
            array3[k] = array2[j];
        }
        mostrarArray(array3);
    }

    //Método de ordenamiento MEZCLA DIRECTA
    public int[] mezclaDirecta(int[] array) {
        int i, j, k;

        if (array.length > 1) {
            int n_elementos_izquierdo = array.length / 2;
            int n_elementos_derecha = array.length - n_elementos_izquierdo;
            int[] array_izquierdo = new int[n_elementos_izquierdo];
            int[] array_derecho = new int[n_elementos_derecha];

            //Copiando los elementos de la parte primera al arreglo izquierdo
            for (i = 0; i < n_elementos_izquierdo; i++) {
                array_izquierdo[i] = array[i];
            }

            //Copiando los elementos de la parte segunda al arreglo derecho
            for (i = n_elementos_izquierdo; i < n_elementos_izquierdo + n_elementos_derecha; i++) {
                array_derecho[i - n_elementos_izquierdo] = array[i];
            }

            //Recursividad
            array_izquierdo = mezclaDirecta(array_izquierdo);
            array_derecho = mezclaDirecta(array_derecho);

            //Ordenar
            i = j = k = 0;

            while (array_izquierdo.length != j && array_derecho.length != k) {
                if (array_izquierdo[j] < array_derecho[k]) {
                    array[i] = array_izquierdo[j];
                    i++;
                    j++;
                } else {
                    array[i] = array_derecho[k];
                    i++;
                    k++;
                }
            }

            //Arreglo final
            while (array_izquierdo.length != j) {
                array[i] = array_izquierdo[j];
                i++;
                j++;
            }

            while (array_derecho.length != k) {
                array[i] = array_derecho[k];
                i++;
                k++;
            }
        }
        return array;
    }

    //Método de ordenamiento MEZCLA NATURAL
    public void mezclaNatural(int[] array) {
        int izquierda, izq, derecha = array.length - 1, der = derecha;
        boolean ordenado = false;

        do {
            ordenado = true;
            izquierda = 0;

            while (izquierda < derecha) {
                izq = izquierda;
                while (izq < derecha && array[izq] <= array[izq + 1]) {
                    izq++;
                }

                der = izq + 1;
                while (der == derecha - 1 || der < derecha && array[der] <= array[der + 1]) {
                    der++;
                }

                if (der <= derecha) {
                    mezclaDirecta2(array);
                    ordenado = false;
                }
                izquierda = izq;
            }
        } while (!ordenado);
    }

    public void mezclaDirecta2(int[] array) {
        int i, j, k;

        if (array.length > 1) {
            int n_elementos_izquierdo = array.length / 2;
            int n_elementos_derecha = array.length - n_elementos_izquierdo;
            int[] array_izquierdo = new int[n_elementos_izquierdo];
            int[] array_derecho = new int[n_elementos_derecha];

            //Copiando los elementos de la parte primera al arreglo izquierdo
            for (i = 0; i < n_elementos_izquierdo; i++) {
                array_izquierdo[i] = array[i];
            }

            //Copiando los elementos de la parte segunda al arreglo derecho
            for (i = n_elementos_izquierdo; i < n_elementos_izquierdo + n_elementos_derecha; i++) {
                array_derecho[i - n_elementos_izquierdo] = array[i];
            }

            //Recursividad
            array_izquierdo = mezclaDirecta(array_izquierdo);
            array_derecho = mezclaDirecta(array_derecho);

            //Ordenar
            i = j = k = 0;

            while (array_izquierdo.length != j && array_derecho.length != k) {
                if (array_izquierdo[j] < array_derecho[k]) {
                    array[i] = array_izquierdo[j];
                    i++;
                    j++;
                } else {
                    array[i] = array_derecho[k];
                    i++;
                    k++;
                }
            }

            //Arreglo final
            while (array_izquierdo.length != j) {
                array[i] = array_izquierdo[j];
                i++;
                j++;
            }

            while (array_derecho.length != k) {
                array[i] = array_derecho[k];
                i++;
                k++;
            }
        }
    }

    //Mostrar los datos del vector
    public void mostrarArray(int[] array) {
        String datos = "";

        for (int i = 0; i < array.length; i++) {
            datos += "[" + array[i] + "]";
        }
        JOptionPane.showMessageDialog(null, "El arreglo ordenado es: \n" + datos, "Mostrando datos", JOptionPane.INFORMATION_MESSAGE);
    }
}
