package torres_de_hanoi;

public class Torres_de_Hanoi {

    public static void main(String[] args) {

        Torres_de_Hanoi torres = new Torres_de_Hanoi();
        torres.hanoi(64, 1, 2, 3);

    }

    //Algoritmo recursivo
    public void hanoi(int discos, int torre1, int torre2, int torre3) {

        if (discos == 1) {
            System.out.println("Mover disco de torre origen a torre destino");
        } else {
            hanoi(discos - 1, torre1, torre3, torre2);
            System.out.println("Mover disco de torre " + torre1 + " a torre " + torre3);
            hanoi(discos - 1, torre2, torre1, torre3);
        }
    }
}
