/*
 Leer los elementos de un vector y mostrar la suma de los mismos
 */
package arreglos;

import javax.swing.JOptionPane;

public class Ejercicio2 {

    static int tamanio = 0;
    static int[] vector;

    public static void main(String[] args) {
        llenarArreglo();
        JOptionPane.showMessageDialog(null, "La suma de los elementos del arreglo es: " + suma(vector));
    }

    public static void llenarArreglo() {
        tamanio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tamaño del arreglo"));
        vector = new int[tamanio];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Ingrese el dato a insertar en la posición " + (i + 1), "Llenando vector", JOptionPane.INFORMATION_MESSAGE));
        }
    }

    public static int suma(int[] array) {
        int suma = 0;
        for (int i = 0; i < array.length; i++) {
            suma += array[i];
        }
        return suma;
    }

}
