/*
OBJETIVO:  Serie4 = (N/1) +(N-1 / 2 ) + (N-2 / 3) + .... + (1/N)
PROGRAMADOR: Caio Dias (d-caio).
DATA: 14/03/2026
*/

package recursividade;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Recursividade04 {
    public static void main(String[] args) {
        int n;
        double resultado;

        Scanner entrada = new Scanner(System.in);

        try {
            System.out.print("Valor de N: ");

            n = entrada.nextInt();
            entrada.close();

            resultado = serie04(n, 1);

            System.out.println("N = " + n + "\n\n((1/1) + (1/2) + (1/3) + ... + (1/N)) = " + resultado);
            
        } catch (InputMismatchException e) {
            System.out.println("Erro: N deve ser um número inteiro.");
        
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            
        }
    }

    private static double serie04(int n, int divisor) {
        if (n < 0)
            throw new IllegalArgumentException("N deve ser maior que zero.");

        if (n == 1)
            return (double) n / divisor;

        return serie04(n - 1, divisor + 1) + ((double) n / divisor);
            
    }
    
}
