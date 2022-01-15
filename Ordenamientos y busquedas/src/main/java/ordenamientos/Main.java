package ordenamientos;

import busquedas.Busquedas;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class Main {

    static int tamanio = 0;
    static int[] vector, vector2;

    public static void main(String[] args) {
        menuPrincipal();
    }

    //Menú principal
    public static void menuPrincipal() {
        int opcion = 0;

        do {
            try {
                opcion = Integer.parseInt(
                        JOptionPane.showInputDialog(null,
                                "1. Ordenar arreglos\n"
                                + "2. Buscar elementos de un arreglo\n"
                                + "3. Salir\n", "Menú de opciones", 3));

                switch (opcion) {
                    case 1 -> {
                        menuOrdenamientos();
                    }
                    case 2 -> {
                        menuBusquedas();
                    }
                    case 3 -> {
                        break;
                    }
                }
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
            }
        } while (opcion != 3);
    }

    //Menú ordenamientos
    public static void menuOrdenamientos() {
        int opcion = 0;
        Ordenamiento ordenar = new Ordenamiento();
        do {
            try {
                opcion = Integer.parseInt(
                        JOptionPane.showInputDialog(null,
                                "1. Ordenar por método BURBUJA versión 1\n"
                                + "2. Ordenar por método BURBUJA versión 2\n"
                                + "3. Ordenar por método RÁDIX\n"
                                + "4. Ordenar por método QUICKSORT\n"
                                + "5. Ordenar por método INSERCIÓN\n"
                                + "6. Ordenar por método SHELL\n"
                                + "7. Ordenar por método INTERCALACIÓN\n"
                                + "8. Ordenar por método MEZCLA DIRECTA\n"
                                + "9. Ordenar por método MEZCLA NATURAL\n"
                                + "10. Volver\n"
                                + "11. Salir", "Menú de opciones", 3));

                switch (opcion) {
                    case 1 -> {
                        llenarArreglo();
                        ordenar.burbuja1(vector);
                        ordenar.mostrarArray(vector);
                    }
                    case 2 -> {
                        llenarArreglo();
                        ordenar.burbuja2(vector);
                        ordenar.mostrarArray(vector);
                    }
                    case 3 -> {
                        llenarArreglo();
                        ordenar.radix(vector);
                        ordenar.mostrarArray(vector);
                    }
                    case 4 -> {
                        llenarArreglo();
                        ordenar.quick(vector, 0, vector.length - 1);
                        ordenar.mostrarArray(vector);
                    }
                    case 5 -> {
                        llenarArreglo();
                        ordenar.insercion(vector, vector.length);
                        ordenar.mostrarArray(vector);
                    }
                    case 6 -> {
                        llenarArreglo();
                        ordenar.shell(vector);
                        ordenar.mostrarArray(vector);
                    }
                    case 7 -> {
                        llenarArreglo();
                        ordenar.burbuja1(vector);
                        llenarArregloB();
                        ordenar.radix(vector2);
                        ordenar.intercalacion(vector, vector2);
                    }
                    case 8 -> {
                        llenarArreglo();
                        vector2 = ordenar.mezclaDirecta(vector);
                        ordenar.mostrarArray(vector2);
                    }
                    case 9 -> {
                        llenarArreglo();
                        ordenar.mezclaNatural(vector);
                        ordenar.mostrarArray(vector);
                    }
                    case 10 -> {
                        menuPrincipal();
                    }
                }
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
            }
        } while (opcion != 11);
    }

    //Menú búsquedas
    public static void menuBusquedas() {
        int opcion = 0, elemento, indice = 0;
        Busquedas buscar = new Busquedas();
        Ordenamiento ordenar = new Ordenamiento();

        do {
            try {
                opcion = Integer.parseInt(
                        JOptionPane.showInputDialog(null,
                                "1. Búsqueda secuancial\n"
                                + "2. Búsqueda binaria\n"
                                + "3. Ordenar por método RÁDIX\n"
                                + "4. Volver\n"
                                + "5. Salir", "Menú de opciones", 3));

                switch (opcion) {
                    case 1 -> {
                        llenarArreglo();
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingrese el elemento a buscar", "Buscando elemento", JOptionPane.INFORMATION_MESSAGE));
                        indice = buscar.busquedaSecuancial(vector, elemento);
                        if (indice != -1) {
                            JOptionPane.showMessageDialog(null,
                                    "El elemento " + elemento + " fué encontrado en la posición " + indice, "Elemento encontrado", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "El elemento " + elemento + " NO fué encontrado", "Elemento NO encontrado", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    case 2 -> {
                        llenarArreglo();
                        ordenar.mezclaNatural(vector);
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingrese el elemento a buscar", "Buscando elemento", JOptionPane.INFORMATION_MESSAGE));
                        indice = buscar.busquedaBinaria(vector, elemento);
                        if (indice != -1) {
                            JOptionPane.showMessageDialog(null,
                                    "El elemento " + elemento + " fué encontrado en la posición " + indice, "Elemento encontrado", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "El elemento " + elemento + " NO fué encontrado", "Elemento NO encontrado", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
            }
        } while (opcion != 5);
    }

    //Métodos para llenar un arreglo
    public static void llenarArreglo() {
        tamanio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tamaño del arreglo"));
        vector = new int[tamanio];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Ingrese el dato a insertar en la posición " + (i + 1), "Llenando vector", JOptionPane.INFORMATION_MESSAGE));
        }
    }

    public static void llenarArregloB() {
        tamanio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tamaño del arreglo"));
        vector2 = new int[tamanio];

        for (int i = 0; i < vector2.length; i++) {
            vector2[i] = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Ingrese el dato a insertar en la posición " + (i + 1), "Llenando vector", JOptionPane.INFORMATION_MESSAGE));
        }
    }
}
