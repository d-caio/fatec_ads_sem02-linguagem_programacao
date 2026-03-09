package lote2.utils;

import java.util.ArrayList;
import java.util.List;
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

    public Number[] concatenarVetores(Number[]... vetores) {
        int tamanhoDoNovoVetor = this.vetor.length;
        
        for (Number[] vetor:vetores)
            tamanhoDoNovoVetor += vetor.length;

        Number[] novoVetor = new Number[tamanhoDoNovoVetor];

        int indexAtual = 0;

        System.arraycopy(this.vetor, 0, novoVetor, indexAtual, this.vetor.length);
        indexAtual += this.vetor.length;

        for (Number[] vetor:vetores) {
            System.arraycopy(vetor, 0, novoVetor, indexAtual, vetor.length);
            indexAtual += vetor.length;
        }

        return novoVetor;
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

    public List<Number> filtrarVetorParaLista(Predicate<Number> teste) {
        List<Number> lista = new ArrayList<>();

        for (Number num:this.vetor) {
            if (teste.test(num))
                lista.add(num);
        }

        return lista;
    }

    public List<Number> determinarPosicoesNoVetor(Predicate<Number> teste) {
        List<Number> posicoes = new ArrayList<>();
        
        for (int i = 0; i < this.vetor.length; i++)
            if (teste.test(this.vetor[i]))
                posicoes.add(i);

        return posicoes;
    }

    public String vetorString() {
        return Saida.vetorNumberFormatadoParaString(vetor);
    }
}
