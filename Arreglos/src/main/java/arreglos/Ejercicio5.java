/*
 Se tiene un arreglo con el registro de las temperaturas de una población.
 Se desea calcular la media y determinar entre todas ellas cuáles son
 superiores o iguales a la media.
 */
package arreglos;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Ejercicio5 {

    static double[] vector;
    static int tamanio = 0;

    public static void main(String[] args) {
        llenarArreglo();
        JOptionPane.showMessageDialog(null, "La media de las temperaturas es de: "+Ejercicio5.media(vector)+"\nLas temperaturas que sobrepasan la media son: "+Ejercicio5.temperaturas(vector));
    }

    public static void llenarArreglo() {
        tamanio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tamaño del arreglo"));
        vector = new double[tamanio];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = Double.parseDouble(JOptionPane.showInputDialog(null,
                    "Ingrese el dato a insertar en la posición " + (i + 1), "Llenando vector", JOptionPane.INFORMATION_MESSAGE));
        }
    }

    public static double media(double[] array) {
        double suma = 0;
        for (int i = 0; i < array.length; i++) {
            suma += array[i];
        }
        return suma / tamanio;
    }

    public static ArrayList temperaturas(double[] array) {
        ArrayList<String> arrayTemperaturas = new ArrayList();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > Ejercicio5.media(array)) {
                arrayTemperaturas.add(String.valueOf(array[i]));
            }
        }
        return arrayTemperaturas;
    }
}
