package serie_fibonacci_recursiva;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {

        int num;
        Scanner entrada = new Scanner(System.in);

        Fibonacci fibonacci = new Fibonacci();
        System.out.println("Ingrese un número");
        num = entrada.nextInt();
        System.out.println("\nLa serie Fibonacci de " + num + " es: " + fibonacci.fibonacci(num));

    }

    //Método recursivo
    public int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

}
