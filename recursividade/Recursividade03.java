/*
OBJETIVO:  Serie3 = (1/1) + (1/2) + (1/3) + ....+ (1/N) 
PROGRAMADOR: Caio Dias (d-caio).
DATA: 14/03/2026
*/

package recursividade;

public class Recursividade03 {
    public static void main(String[] args) {
        int n;
        double resultado;

        try {
            if (args.length != 1)
                throw new ArrayIndexOutOfBoundsException("Erro: O programa deve ter apenas um argumento.");

            n = Integer.parseInt(args[0]);

            resultado = serie03(n);

            System.out.println("N = " + n + "\n\n((1/1) + (1/2) + (1/3) + ... + (1/N)) = " + resultado);
            
        } catch (NumberFormatException e) {
            System.out.println("Erro: N deve ser um número inteiro.");
        
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());

        }
    }

    private static double serie03(int n) {
        if (n < 1)
            throw new IllegalArgumentException("Erro: N deve ser maior ou igual a 1.");

        if (n == 1)
            return n;

        return serie03(n - 1) + ((double) 1 / n);
    }
}
