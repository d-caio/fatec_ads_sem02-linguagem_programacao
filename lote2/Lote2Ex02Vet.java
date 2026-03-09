/*
OBJETIVO: Criar e coletar um vetor [100] inteiro e exibir:
        a. O maior e o menor valor;
        b. A média dos valores.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 08/03/2026
*/

package lote2;

import lote2.utils.ManipulacaoDeVetoresInteger;
import lote2.utils.Saida;

public class Lote2Ex02Vet {
    private static final int TAMANHO_DO_VETOR = 100;
    private static final int VALOR_MIN_DOS_ITENS_DO_VETOR = 0;
    private static final int VALOR_MAX_DOS_ITENS_DO_VETOR = 2000;

    public static void main(String[] args) {
        var vetor = new ManipulacaoDeVetoresInteger(TAMANHO_DO_VETOR, VALOR_MIN_DOS_ITENS_DO_VETOR, VALOR_MAX_DOS_ITENS_DO_VETOR);

        Number[] maiorEMenor = vetor.EncontrarMaiorEMenor();

        double media = vetor.media();

        String msg = "Vetor: " + vetor.vetorString() + "%n%nMaior: %s%n%nMenor: %s%n%nMédia: %s";

        Saida.ImprimirNoTerminal(msg, maiorEMenor[0].doubleValue(), maiorEMenor[1].doubleValue(), media);
    }
}
