package lote2.utils;

import java.util.function.Predicate;

public abstract class ManipulacaoDeVetores {
    private Number[] vetor;

    ManipulacaoDeVetores(int tamanhoVetor) {
        this.vetor = new Number[tamanhoVetor];
    }

    public Number[] getVetor() {
        return this.vetor;
    }

    void adicionarItemAoVetor(int index, Number valor) {
        vetor[index] = valor;
    }

    public double media() {
        double soma = 0.0;
        
        for (Number num:vetor)
            soma += num.doubleValue();

        return (soma / this.vetor.length);
    }

    public double media(Predicate<Number> numTeste) {
        int numDeItens = 0;
        double soma = 0.0;
        
        for (Number num:vetor)
            if (numTeste.test(num)) {
                soma += num.doubleValue();
                numDeItens++;
            }

        return ((numDeItens == 0) ? (0.0) : (soma / numDeItens));
    }

    public Number[] EncontrarMaiorEMenor() {
        Number maior = this.vetor[0];
        Number menor = this.vetor[0];

        for (Number num:vetor) {
            if (num.doubleValue() > maior.doubleValue())
                maior = num;

            if (num.doubleValue() < menor.doubleValue())
                menor = num;
        }
        
        Number[] maiorEMenor = {maior, menor};

        return maiorEMenor;
    }

    public String vetorString() {
        return Saida.vetorNumberFormatadoParaString(vetor);
    }
}
