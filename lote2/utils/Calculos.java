package lote2.utils;

import java.util.List;

public class Calculos {
    public static double media(List<Integer> vetor) {
        int soma = 0;
        double media;

        for (Integer num : vetor)
            soma += num.intValue();

        media = (double) soma / vetor.size();

        return media;
    }

    public static double media(int[] vetor) {
        int soma = 0;
        double media;

        for (int num : vetor)
            soma += num;

        media = (double) soma / vetor.length;

        return media;
    }

    public static int somaLista(List<Integer> vetor) {
        int soma = 0;

        for (Integer num : vetor)
            soma += num.intValue();

        return soma;
    }

    public static int[] maiorMenor(int[] vetor) {
        int[] maiorMenorVetor = new int[2];
        int maior = vetor[0];
        int menor = vetor[0];

        for (int num:vetor) {
            if (num > maior)
                maior = num;

            else if (num < menor)
                menor = num;
        }

        maiorMenorVetor[0] = maior;
        maiorMenorVetor[1] = menor;

        return maiorMenorVetor;
    }
}
