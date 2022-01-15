package grafos;

public class Caminos_minimos {

    //Método para determinar todos los caminos Floyd
    public String algoritmoFloyd(long[][] matriz_pesos) {
        int vertices = matriz_pesos.length;
        long[][] matrizPesos = matriz_pesos;
        String[][] caminos = new String[vertices][vertices];
        String[][] caminos_auxiliares = new String[vertices][vertices];
        String camino_recorrido = "", cadena = "", caminitos = "";
        float temporal1, temporal2, temporal3, temporal4, minimo;

        //Inicializando las matrices caminos y caminos_auxiliares
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                caminos[i][j] = "";
                caminos_auxiliares[i][j] = "";
            }
        }

        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    temporal1 = matrizPesos[i][j];
                    temporal2 = matrizPesos[i][k];
                    temporal3 = matrizPesos[k][j];
                    temporal4 = temporal2 + temporal3;

                    //Encontrando el camino mínimo
                    minimo = Math.min(temporal1, temporal4);

                    if (temporal1 != temporal4) {
                        if (minimo == temporal4) {
                            camino_recorrido = "";
                            caminos_auxiliares[i][j] = k + "";
                            caminos[i][j] = caminosR(i, k, caminos_auxiliares, camino_recorrido) + (k + 1);
                        }
                    }
                    matrizPesos[i][j] = (long) minimo;
                }
            }
        }

        //Agregando el camino a cadena
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                cadena += "[" + matrizPesos[i][j] + "]";
            }
            cadena += "\n";
        }

        //////////////////////////////////////////////////////////////////////////////
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (matrizPesos[i][j] != 1000000000) {
                    if (i != j) {
                        if (caminos[i][j].equals("")) {
                            caminitos += "De (" + (i + 1) + "--->" + (j + 1) + ") Irse por ... (" + (i + 1) + ", " + (j + 1) + ")\n";
                        } else {
                            caminitos += "De (" + (i + 1) + "--->" + (j + 1) + ") Irse por ... (" + (i + 1) + ", " + caminos[i][j] + ", " + (j + 1) + ")\n";
                        }
                    }
                }
            }
        }
        return "La matriz de caminos más cortos entre los diferentes vértices es:\n" + cadena
                + "\nLos diferentes caminos más cortos entre vértices són:\n" + caminitos;
    }

    //Método caminoR
    public String caminosR(int i, int k, String[][] caminos_auxiliares, String caminoRecorrido) {
        if (caminos_auxiliares[i][k].equals("")) {
            return "";
        } else {
            caminoRecorrido += caminosR(i, Integer.parseInt(caminos_auxiliares[i][k]), caminos_auxiliares, caminoRecorrido) + (Integer.parseInt(caminos_auxiliares[i][k]) + 1) + ", ";
            return caminoRecorrido;
        }
    }
}
