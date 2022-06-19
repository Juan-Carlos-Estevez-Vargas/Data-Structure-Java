/*
 Dado un arreglo de 10 números naturales, determinar cuántos números
son menor de 15, mayores de 50 y cuántos están comprendidos entre 45 y 55
 */
package arreglos;

import javax.swing.JOptionPane;

public class Ejercicio3 {

    static int[] vector;
    static int menores_de_15 = 0, mayores_a_50 = 0, entre_45_y_55 = 0;

    public static void main(String[] args) {
        llenarArreglo();
        seleccion(vector);
        JOptionPane.showMessageDialog(null, "Números menores a 15 = " + menores_de_15 + "\nNúmeros mayores a 50 = " + mayores_a_50 + "\nNúmeros entre 45 y 55 = " + entre_45_y_55);
    }

    public static void llenarArreglo() {
        vector = new int[10];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Ingrese el dato a insertar en la posición " + (i + 1), "Llenando vector", JOptionPane.INFORMATION_MESSAGE));
        }
    }

    public static void seleccion(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 15) {
                menores_de_15++;
            } else if (array[i] > 44 && array[i] < 56) {
                entre_45_y_55++;
            } else if (array[i] > 50) {
                mayores_a_50++;
            }
        }
    }
}
