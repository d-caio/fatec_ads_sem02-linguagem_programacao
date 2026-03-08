/*
OBJETIVO: Criar e coletar um vetor [100] inteiro e exibir:
        a. O maior e o menor valor;
        b. A média dos valores.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 08/03/2026
*/

package lote2;

import java.util.Arrays;

import lote2.utils.*;

public class Lote2Ex02Vet {
    private static final int TAMANHO_VETOR = 100;
    private static final int VLR_MAX_VETOR = 1000;
    
    public static int[] vetor = new int[TAMANHO_VETOR];
    public static int maior, menor;
    public static double media;
    public static String msgResultado = "Dado o vetor %s%nO maior valor é %d%nO menor valor é %d%nA média dos valores é %.2f";

    public static void main(String[] args) {
        vetor = VetorMatriz.coletarVetor(TAMANHO_VETOR, VLR_MAX_VETOR);
        maior = Calculos.maiorMenor(vetor)[0];
        menor = Calculos.maiorMenor(vetor)[1];
        media = Calculos.media(vetor);

        String msgRsultadoFormatada = String.format(msgResultado, Arrays.toString(vetor), maior, menor, media);

        System.out.println(msgRsultadoFormatada);
    }
}
