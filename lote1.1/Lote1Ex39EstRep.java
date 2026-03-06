/*
OBJETIVO: Calcule a quantidade de grãos contidos em um tabuleiro de xadrez onde:
Casa: 	1	2	3	4	...	64
Qdte:	1	2	4	8	...	N
PROGRAMADOR: Caio Dias (d-caio).
DATA: 06/03/2026
*/

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Locale;

public class Lote1Ex39EstRep {
    private static final int MAX_CASAS = 64;

    public static void main(String[] args) {
        BigInteger graos = BigInteger.ONE;
        StringBuilder msgResultado = new StringBuilder("");
        NumberFormat formatador = NumberFormat.getInstance(Locale.of("pt", "BR"));

        String graosFormatado;

        for (int i = 1; i <= MAX_CASAS; i++) {
            graosFormatado = formatador.format(graos);
            
            msgResultado.append("Casa ").append(i).append(": ").append(graosFormatado).append(graos.equals(BigInteger.ONE) ? " grão\n" : " grãos\n");

            graos = graos.multiply(BigInteger.valueOf(2));
        }

        System.out.println(msgResultado);
    }
}
