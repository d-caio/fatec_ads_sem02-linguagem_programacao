package lotes.caixa_eletronico.caixa;

import java.math.*;

public class Banco {
    private int codigo;
    private String nome;
    private int saques = 0;
    private BigDecimal valorSacado = new BigDecimal("0");
    private BigDecimal valorMedio = new BigDecimal("0");
    private BigDecimal maiorSaque;
    private BigDecimal menorSaque;

    public Banco(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() { return codigo; }

    public String getNome() { return nome; }

    protected int getSaques() { return saques; }

    protected BigDecimal getValorSacado() { return valorSacado; }

    protected BigDecimal getMaiorSaque() { return maiorSaque; }
    
    protected BigDecimal getMenorSaque() { return menorSaque; }

    protected BigDecimal getValorMedio() { return valorMedio; }

    protected void adicionarSaque(BigDecimal valor) {
        valorSacado = valorSacado.add(valor);

        if (saques <= 0) {
            maiorSaque = valor;
            menorSaque = valor;

        } else {
            if (valor.compareTo(maiorSaque) > 0) {
                maiorSaque = valor;

            } else if (valor.compareTo(menorSaque) < 0) {
                menorSaque = valor;
            }
        }

        saques++;

        valorMedio = valorSacado.divide(BigDecimal.valueOf(saques), 2, RoundingMode.HALF_UP);
    }
}
