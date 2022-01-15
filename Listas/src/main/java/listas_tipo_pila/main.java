package listas_tipo_pila;

import javax.swing.JOptionPane;

public class main {

    public static void main(String[] args) {
        int opcion = 0, nodo = 0;
        Pila pila = new Pila();
        
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Menú de Opciones\n\n"
                        + "1. Insertar un Nodo\n"
                        + "2. Eliminar un Nodo\n"
                        + "3. ¿La pila esta vacia?\n"
                        + "4. ¿Cual es el ultimo valor ingresado en la pila?\n"
                        + "5. ¿Cuantos nodos tiene la pila?\n"
                        + "6. Vaciar pila\n"
                        + "7. Mostrar contenido de la pila\n"
                        + "8. Salir\n\n"));
                
                switch (opcion) {
                    case 1:
                        nodo = Integer.parseInt(JOptionPane.showInputDialog(null, "Por Favor ingresa el valor a guardar en el nodo"));
                        pila.insertarNodo(nodo);
                        break;
                    case 2:
                        if (!pila.pilaVacia()) {
                            JOptionPane.showMessageDialog(null, "Se ha eliminado el siguiente nodo: " + pila.eliminarNodo());
                        } else {
                            JOptionPane.showMessageDialog(null, "La pila esta vacia");
                        }
                        break;
                    case 3:
                        if (pila.pilaVacia()) {
                            JOptionPane.showMessageDialog(null, "La pila esta vacia");
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "La pila NO esta vacia");
                        }
                        break;
                    case 4:
                        if (!pila.pilaVacia()) {
                            JOptionPane.showMessageDialog(null, "El ultimo valor ingresado en la pila es: " + pila.mostrarUltimoValorIngresado());
                        } else {
                            JOptionPane.showMessageDialog(null, "La pila esta vacia");
                        }
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "La pila contiene " + pila.tamanoPila() + " nodos.");
                        break;
                    case 6:
                        if (!pila.pilaVacia()) {
                            pila.vaciarPila();
                            JOptionPane.showMessageDialog(null, "Se ha vaciado la pila correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "La pila esta vacia");
                        }
                        break;
                    case 7:
                        pila.mostrarValores();
                        break;
                    case 8:
                        opcion = 8;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion incorrecta, vuelve a intentar nuevamente.");
                        break;
                    
                }
                
            } catch (NumberFormatException e) {
                
            }
        } while (opcion != 8);
    }
}
