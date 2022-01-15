package grafos;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        int vertices = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de vértices de la matriz de pesos", "Vértices matriz de pesos", JOptionPane.INFORMATION_MESSAGE));
        long[][] matriz_pesos = new long[vertices][vertices];

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                matriz_pesos[i][j] = Long.parseLong(JOptionPane.showInputDialog(null, "Ingrese el peso de la posición " + (i) + "," + (j), "Llenando matriz", JOptionPane.INFORMATION_MESSAGE));
            }
        }

        Caminos_minimos camino_minimo = new Caminos_minimos();
        JOptionPane.showMessageDialog(null, camino_minimo.algoritmoFloyd(matriz_pesos));
    }
}
