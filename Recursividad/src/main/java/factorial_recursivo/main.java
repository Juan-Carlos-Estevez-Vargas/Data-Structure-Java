package factorial_recursivo;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce el numero para calcular el factorial");
        int numero = entrada.nextInt();

        Recursividad recursividad = new Recursividad();

        int factorial = recursividad.factorial(numero);
        System.out.println("El factorial del número " + numero + " es: " + factorial);
    }
}
