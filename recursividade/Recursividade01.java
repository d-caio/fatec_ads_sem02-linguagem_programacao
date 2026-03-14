/*
OBJETIVO: Serie1 = (1+2+3+...+100)
PROGRAMADOR: Caio Dias (d-caio).
DATA: 13/03/2026
*/

package recursividade;

public class Recursividade01 {
    private static int NUM_MIN = 1;
    private static int NUM_MAX = 100;

    public static void main(String[] args) {
        try {
            int resultado = serie1(NUM_MIN, NUM_MAX);

            System.out.println("O resultado da série (1 + 2 + 3 + ... + 100) é " + resultado + ".");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        }
    }

    private static int serie1(int numMin, int numMax) {
        int resultado;

        if (numMin > numMax)
            throw new IllegalArgumentException("Erro: O número mínimo precisa ser menor ou igual ao máximo.");

        if (numMin < numMax) {
            resultado = numMin + serie1(numMin + 1, numMax);

            return resultado;
        }

        return numMax;
    }
}
