package lotes.caixa_eletronico.caixa;

import java.math.BigDecimal;

import lotes.caixa_eletronico.exceptions.*;

class Nota {
    private BigDecimal valor;
    private int quantidade;
    
    protected Nota(BigDecimal valor, int quantidade) {
        /*if (BigDecimal.valueOf(valor) < 1)
            throw new ValorDeNotaInvalidoException();

        if (quantidade < 0)
            throw new QuantidadeDeNotasInvalidaException();*/
        
        this.valor = valor;
        this.quantidade = quantidade;
    }

    protected BigDecimal getValor() { return valor; }

    protected int getQuantidade() { return quantidade; }

    protected void adicionarNotas(int quantidade) { this.quantidade += quantidade; }
    
    protected void retirarNota() { quantidade --; }
}
