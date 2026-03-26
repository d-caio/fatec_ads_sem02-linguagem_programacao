/*
OBJETIVO: Mostre todas as possibilidades de 2 dados de forma que a soma tenha como resultado 7.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 21/03/2026
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lote1Ex41ModFunc {
    public static void main(String[] args) {
        System.out.println(dadosSoma7(new ArrayList<List<Integer>>()).toString());
    }

    private static List<List<Integer>> dadosSoma7(List<List<Integer>> matriz) {
        int minDado = 1, maxDado = 6, dado1 = minDado, dado2 = maxDado;

        List<Integer> vetor = Arrays.asList(dado1, dado2);

        while (true) {
            if (dado1 > maxDado && dado2 < minDado)
                return matriz;
            
            if (matriz.stream().anyMatch(lista -> Collections.indexOfSubList(lista, vetor) != -1)) {
                dado1++;
                dado2--;
                vetor.set(0, dado1);
                vetor.set(1, dado2);
                continue;
            }

            break;
        }

        matriz.add(vetor);

        return dadosSoma7(matriz);
    }
}
