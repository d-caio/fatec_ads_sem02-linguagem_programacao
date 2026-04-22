package lotes.caixa_eletronico.telas;

import java.math.BigDecimal;

import lotes.caixa_eletronico.exceptions.JanelaFechadaException;

public class TelaDeEntrada {
    private String titulo;
    private String texto;
    
    public TelaDeEntrada(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
    }

    public BigDecimal solicitarEntrada() {
        String entrada = EstruturasDeTelas.mostrarTelaDeEntrada(titulo, texto);

        if (entrada == null)
            throw new JanelaFechadaException();

        BigDecimal valor = new BigDecimal(entrada);

        if (valor.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("O valor deve ser maior que zero.");

        return valor;
    }
}
