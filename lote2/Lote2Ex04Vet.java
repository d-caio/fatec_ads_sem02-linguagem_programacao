/*
OBJETIVO: Criar e coletar em um vetor [30] real e calcular e exibir:
        a. A média do grupo;
        b. A quantidade de notas acima do grupo;
        c. As posições dos valores abaixo da média do grupo.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 09/03/2026
*/

package lote2;

import java.util.function.Predicate;
import java.util.List;

import lote2.utils.ManipulacaoDeVetoresDouble;
import lote2.utils.Saida;

public class Lote2Ex04Vet {
    private static final int TAMANHO_DO_VETOR = 30;
    private static final double VALOR_MIN_DOS_ITENS_DO_VETOR = 0.0;
    private static final double VALOR_MAX_DOS_ITENS_DO_VETOR = 10.0;

    public static void main(String[] args) {
        var vetor = new ManipulacaoDeVetoresDouble(TAMANHO_DO_VETOR, VALOR_MIN_DOS_ITENS_DO_VETOR, VALOR_MAX_DOS_ITENS_DO_VETOR);

        double media = vetor.media();

        Predicate<Number> testeAcimaDaMedia = num -> num.doubleValue() > media;
        
        List<Number> valoresAcimaDaMedia = vetor.filtrarVetorParaLista(testeAcimaDaMedia);
        
        int qntdAcimaDaMedia = valoresAcimaDaMedia.size();

        Predicate<Number> testeAbaixoDaMedia = num -> num.doubleValue() < media;

        List<Number> posicoesAbaixoDaMedia = vetor.determinarPosicoesNoVetor(testeAbaixoDaMedia);

        String msg = "Vetor: " + vetor.vetorString() + "%n%nMédia: %s%n%nQuantidade de valores acima da média: %s%n%nPosições dos valores abaixo da média: " + Saida.listaNumberFormatadaParaString(posicoesAbaixoDaMedia);

        Saida.ImprimirNoTerminal(msg, media, (double) qntdAcimaDaMedia);
    }
}
