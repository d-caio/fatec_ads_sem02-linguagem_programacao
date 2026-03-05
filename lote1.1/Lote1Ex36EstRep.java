/*
OBJETIVO: Receba um número N. Calcule e mostre a série 1 + 1/1! + 1/2! + ... + 1/N!
PROGRAMADOR: Caio Dias (d-caio).
DATA: 05/03/2026
*/

import java.text.NumberFormat;
import java.util.Locale;

public class Lote1Ex36EstRep {
    private static final int DIVIDENDO = 1;

    public static void main(String[] args) {
        double n, resultado = 1, fatorial = 1;

        try {
            if (args.length != 1)
                throw new ArrayIndexOutOfBoundsException(
                        "O programa deve conter um argumento do tipo int para rodar. Reinicie o programa.");

            int testeN = Integer.parseInt(args[0]);

            if (testeN < 1)
                throw new IllegalArgumentException("O número precisa ser maior que zero.");

            n = Double.parseDouble(args[0]);

            StringBuilder msgResultado = new StringBuilder(String.valueOf(DIVIDENDO)).append(" + ");

            for (int i = 1; i <= n; i++) {
                fatorial *= i;
                
                resultado += DIVIDENDO / fatorial;

                msgResultado.append(DIVIDENDO).append("/").append(i).append("!");
                
                if (i < n)
                    msgResultado.append(" + ");
            }

            String resultadoFormatado = NumberFormat.getInstance(Locale.of("pt", "BR")).format(resultado);

            msgResultado.append(" = ").append(resultadoFormatado);

            System.out.println(msgResultado);

        } catch (NumberFormatException e) {
            System.out.println("O valor precisa ser um número inteiro.");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());

        }
    }
}
