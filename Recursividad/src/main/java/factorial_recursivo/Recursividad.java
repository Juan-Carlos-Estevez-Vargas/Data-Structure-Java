package factorial_recursivo;

public class Recursividad {

    public int factorial(int valor) {
        if (valor > 0) {
            int valor_calculado = valor * factorial(valor - 1);
            return valor_calculado;
        }
        return 1;
    }
}
