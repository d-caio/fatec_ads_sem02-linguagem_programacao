package lotes.caixa_eletronico.caixa;

import java.math.*;
import java.util.*;
import java.text.NumberFormat;

import lotes.caixa_eletronico.exceptions.*;
import lotes.caixa_eletronico.util.Formatador;

public class Caixa {
    private BigDecimal valorDisponivel = new BigDecimal("0");
    private BigDecimal totalSacado = new BigDecimal("0");
    private BigDecimal mediaDeSaques = new BigDecimal("0");
    private int saques = 0;
    private BigDecimal ultimoSaque;
    private BigDecimal maiorSaque;
    private BigDecimal menorSaque;
    
    private Banco[] bancos;
    
    private Nota[] notas = new Nota[] {
        new Nota(new BigDecimal("100"), 0),
        new Nota(new BigDecimal("50"), 0),
        new Nota(new BigDecimal("20"), 0),
        new Nota(new BigDecimal("10"), 0),
        new Nota(new BigDecimal("5"), 0),
        new Nota(new BigDecimal("2"), 0)
    };

    private boolean caixaEstaCarregado = false;

    private final int MINIMO_DE_NOTAS = notas.length;
    private final int MAXIMO_DE_NOTAS = 9995;
    private final int MAXIMO_DE_SAQUES = 100;

    public Caixa(String... nomesDosBancos) {
        int quantidadeDeBancos = nomesDosBancos.length;
        
        bancos = new Banco[quantidadeDeBancos];

        for (int i = 0; i < quantidadeDeBancos; i++)
            bancos[i] = new Banco(i + 1, nomesDosBancos[i]);
    }

    public Banco[] getBancos() { return bancos; }

    public String[] iniciarSaque() {
        if (!caixaEstaCarregado)
            throw new CaixaNaoCarregadoException();

        if (saques >= MAXIMO_DE_SAQUES)
            throw new LimiteDeSaquesAlcancadoException();

        if (valorDisponivel.compareTo(BigDecimal.ZERO) <= 0)
            throw new ValorDeSaqueInvalidoException("O caixa não tem mais notas disponíveis.");

        String[] nomesDosBancos = new String[bancos.length + 1];
        
        for (int i = 0; i < bancos.length; i++)
            nomesDosBancos[i] = bancos[i].getNome();

        nomesDosBancos[bancos.length] = "Voltar";

        return nomesDosBancos;
    }

    public void carregarNotas() {
        if (!caixaEstaCarregado) {
            var geradorDeNotas = new Random();
    
            int quantidadeDeNotas = geradorDeNotas.nextInt(MAXIMO_DE_NOTAS) + MINIMO_DE_NOTAS;
    
            int quantidadeDeCadaNota = quantidadeDeNotas / MINIMO_DE_NOTAS;
    
            int restanteDasNotas = quantidadeDeNotas % MINIMO_DE_NOTAS;
    
            for (int i = notas.length - 1; i >= 0; i--) {
                int notaExtra = 0;
    
                if (restanteDasNotas > 0) {
                    notaExtra++;
                    restanteDasNotas--;
                }

                int quantidadeDaNota = quantidadeDeCadaNota + notaExtra;
    
                notas[i].adicionarNotas(quantidadeDaNota);

                BigDecimal valor = notas[i].getValor();
                
                BigDecimal valorTotal = valor.multiply(BigDecimal.valueOf(quantidadeDaNota));

                valorDisponivel = valorDisponivel.add(valorTotal);
            }

            caixaEstaCarregado = true;
        }
    }

    public void sacar(BigDecimal valor, int codigoDoBanco) {
        if (valor.compareTo(valorDisponivel) > 0)
            throw new ValorDeSaqueInvalidoException();

        boolean valorEhInvalido = validarValor(valor);

        if (valorEhInvalido)
            throw new ValorDeSaqueInvalidoException("Não existem notas de R$ 1,00 e R$ 3,00. Valor inválido.");

        Nota[] notasTemporarias = Arrays.copyOf(notas, notas.length);

        BigDecimal saque = new BigDecimal("0");

        for (int i = 0; i < notas.length; i++) {
            BigDecimal valorDaNota = notas[i].getValor();
            int quantidadeDaNota = notas[i].getQuantidade();

            if (quantidadeDaNota < 1)
                continue;

            for (int j = 1; j <= quantidadeDaNota; j++) {
                BigDecimal saqueAposNota = saque.add(valorDaNota);

                BigDecimal valorRestanteAposNota = valor.subtract(saqueAposNota);

                boolean valorRestanteEhInvalido = validarValor(valorRestanteAposNota);

                if ((saqueAposNota.compareTo(valor) > 0) || valorRestanteEhInvalido)
                    break;

                saque = saqueAposNota;
                notasTemporarias[i].retirarNota();
            }
        }

        if (!saque.equals(valor)) {
            throw new ValorDeSaqueInvalidoException("Não é possível alcançar o valor solicitado com as notas disponíveis.");
        }

        valorDisponivel = valorDisponivel.subtract(valor);
        notas = Arrays.copyOf(notasTemporarias, notasTemporarias.length);
        totalSacado = totalSacado.add(valor);
        ultimoSaque = valor;

        if (saques == 0) {
            maiorSaque = valor;
            menorSaque = valor;
        } else if (valor.compareTo(maiorSaque) > 0) {
            maiorSaque = valor;
        } else if (valor.compareTo(menorSaque) < 0) {
            menorSaque = valor;
        }

        saques++;
        mediaDeSaques = totalSacado.divide(BigDecimal.valueOf(saques), 2, RoundingMode.HALF_UP);

        for (Banco banco:bancos)
            if (banco.getCodigo() == codigoDoBanco) {
                banco.adicionarSaque(valor);
                break;
            }
    }

    public String relatorioDeValoresDisponiveis() {
        var relatorioBuilder = new StringBuilder("Valor disponível para saque: ")
            .append(Formatador.moeda(valorDisponivel))
            .append("\n\nNotas disponíveis");
        
        for (Nota nota:notas) {
            BigDecimal valor = nota.getValor();
            int quantidade = nota.getQuantidade();

            relatorioBuilder
                .append("\n")
                .append(Formatador.moeda(valor))
                .append(": ")
                .append(Formatador.numeral(quantidade));
        }

        String relatorio = relatorioBuilder.toString();

        return relatorio;
    }

    public String relatorioDeSaque() {
        var relatorioBuilder = new StringBuilder("Último saque realizado: ")
            .append(Formatador.moeda(ultimoSaque))
            .append("\n\n")
            .append("Saques disponíveis: ")
            .append(MAXIMO_DE_SAQUES - saques)
            .append("\n\n")
            .append(relatorioDeValoresDisponiveis());
        
        String relatorio = relatorioBuilder.toString();

        return relatorio;
    }

    public String estatisticasCompletas() {
        String separador = "\n\n===========================================================\n\n";
        
        var relatorioBuilder = new StringBuilder("Dados gerais\n\nValor disponível para saque: ")
            .append(Formatador.moeda(valorDisponivel))
            .append("\nValor total sacado: ")
            .append(Formatador.moeda(totalSacado))
            .append("\nTotal de saques: ")
            .append(saques)
            .append("\nMédia de saques: ")
            .append(Formatador.moeda(mediaDeSaques))
            .append("\nMaior valor sacado: ")
            .append((maiorSaque == null) ? "" : Formatador.moeda(maiorSaque))
            .append("\nMenor valor sacado: ")
            .append((menorSaque == null) ? "" : Formatador.moeda(menorSaque))
            .append(separador)
            .append("Dados por banco");
        
        for (int i = 0; i < bancos.length; i++) {
            BigDecimal maiorSaque = bancos[i].getMaiorSaque();
            BigDecimal menorSaque = bancos[i].getMenorSaque();
            
            relatorioBuilder
                .append("\n\n")
                .append(bancos[i].getNome())
                .append("\nValor sacado: ")
                .append(Formatador.moeda(bancos[i].getValorSacado()))
                .append("\nTotal de saques: ")
                .append(bancos[i].getSaques())
                .append("\nMédia de saques: ")
                .append(Formatador.moeda(bancos[i].getValorMedio()))
                .append("\nMaior valor sacado: ")
                .append((maiorSaque == null) ? "" : Formatador.moeda(maiorSaque))
                .append("\nMenor valor sacado: ")
                .append((menorSaque == null) ? "" : Formatador.moeda(menorSaque));
        }

        String relatorio = relatorioBuilder.toString();

        return relatorio;
    }

    private boolean validarValor(BigDecimal valor) {
        BigDecimal[] valoresInvalidos = new BigDecimal[] {
            new BigDecimal("1"),
            new BigDecimal("3")
        };

        boolean valorEhInvalido = Arrays
            .stream(valoresInvalidos)
            .anyMatch(item -> item.equals(valor));

        return valorEhInvalido;
    }
}
