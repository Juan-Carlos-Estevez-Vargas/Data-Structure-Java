/*Leer los elementos de un vector de números y calcular el promedio*/
package arreglos;

import javax.swing.JOptionPane;

public class Ejercicio1 {

    static int tamanio = 0;
    static int[] vector;

    public static void main(String[] args) {
        llenarArreglo();
        double resultado = promedio(vector) / tamanio;
        JOptionPane.showMessageDialog(null, "El promedio de los elementos del vector es: " + resultado);
    }

    public static void llenarArreglo() {
        tamanio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tamaño del arreglo"));
        vector = new int[tamanio];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Ingrese el dato a insertar en la posición " + (i + 1), "Llenando vector", JOptionPane.INFORMATION_MESSAGE));
        }
    }

    public static double promedio(int[] array) {
        double suma = 0;
        for (int i = 0; i < array.length; i++) {
            suma += array[i];
        }
        return suma;
    }
}
