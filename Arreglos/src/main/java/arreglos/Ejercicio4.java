/*
 Escribir un programa que permita obtener el número de elementos positivos, negativos
 y ceros de un arreglo
 */
package arreglos;

import javax.swing.JOptionPane;

public class Ejercicio4 {

    static int[] vector;
    static int tamanio = 0;
    static int positivos = 0, negativos = 0, ceros = 0;

    public static void main(String[] args) {
        llenarArreglo();
        validacion(vector);
        JOptionPane.showMessageDialog(null, "Positivos " + positivos + "\nNegativos " + negativos + "\nCeros " + ceros);
    }

    public static void llenarArreglo() {
        tamanio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tamaño del arreglo"));
        vector = new int[tamanio];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Ingrese el dato a insertar en la posición " + (i + 1), "Llenando vector", JOptionPane.INFORMATION_MESSAGE));
        }
    }

    public static void validacion(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                negativos++;
            } else if (array[i] > 0) {
                positivos++;
            } else {
                ceros++;
            }
        }
    }
}
