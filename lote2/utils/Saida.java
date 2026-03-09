package lote2.utils;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Saida {
    private static String formatadorBr(Number num) {
        NumberFormat formatador = NumberFormat.getInstance(Locale.forLanguageTag("pt-BR"));
        formatador.setMinimumFractionDigits(0);
        formatador.setMaximumFractionDigits(2);

        String numFormatado = formatador.format(num);

        return numFormatado;
    }

    public static String vetorNumberFormatadoParaString(Number[] vetor) {
        return Arrays.stream(vetor).map(num -> formatadorBr(num.doubleValue())).collect(Collectors.joining(", ", "[ ", " ]"));
    }

    public static String listaNumberFormatadaParaString(List<Number> lista) {
        StringBuilder stringLista = new StringBuilder("[ ");

        for (int i = 0; i < lista.size(); i++) {
            stringLista.append(formatadorBr(lista.get(i)));
            
            if (i + 1 == lista.size())
                stringLista.append(" ]");

            else
                stringLista.append(", ");
        }

        return stringLista.toString();
    }
    
    public static void ImprimirNoTerminal(String msgOriginal, Double... nums) {
        String[] numsFormatados = new String[nums.length];

        for(int i = 0; i < nums.length; i++)
            numsFormatados[i] = formatadorBr(nums[i]);
        
        String msgFinal = String.format(msgOriginal, (Object[]) numsFormatados);

        System.out.println(msgFinal);
    }
}
