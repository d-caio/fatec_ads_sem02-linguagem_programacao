package lotes.caixa_eletronico.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Formatador {
    private static final Locale local = new Locale.Builder()
        .setLanguage("pt")
        .setRegion("BR")
        .build();

    public static String moeda(BigDecimal valor) {
        NumberFormat formatador = NumberFormat.getCurrencyInstance(local);

        return formatador.format(valor);
    }  
    
    public static String numeral(int num) {
        NumberFormat formatador = NumberFormat.getInstance(local);

        return formatador.format(num);
    }
}
