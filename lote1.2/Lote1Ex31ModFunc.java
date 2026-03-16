/*
OBJETIVO: Calcule e mostre o quadrado dos números entre 10 e 150.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 14/03/2026
*/

public class Lote1Ex31ModFunc {
    public static void main(String[] args) {
        System.out.println(quadrado(10, 150, new StringBuilder("")).toString());
    }

    private static StringBuilder quadrado(int base, int numMax, StringBuilder msg) {
        if (base > numMax)
            throw new IllegalArgumentException("Erro: a base deve ser menor que o número máximo.");
        
        msg.append(base).append("² = ").append(base * base).append("\n");

        if (base < numMax)
            return quadrado(base + 1, numMax, msg);

        return msg.append(base).append("² = ").append(base * base);
    }
}
