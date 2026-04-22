package lotes.caixa_eletronico.telas;

import lotes.caixa_eletronico.exceptions.JanelaFechadaException;

public class Menu {
    private String titulo;
    private Opcao[] opcoes;

    public Menu(String titulo, String... descricaoDasOpcoes) {
        this.titulo = titulo;
        
        int quantidadeDeOpcoes = descricaoDasOpcoes.length;
        
        opcoes = new Opcao[quantidadeDeOpcoes];

        for (int i = 0; i < quantidadeDeOpcoes; i++) {
            Opcao opcao;
            
            if (i == quantidadeDeOpcoes - 1)
                opcao = new Opcao(0, descricaoDasOpcoes[i]);

            else
                opcao = new Opcao(i + 1, descricaoDasOpcoes[i]);

            opcoes[i] = opcao;
        }
    }

    public int selecionarOpcao() {
        int opcaoEscolhida = EstruturasDeTelas.mostrarMenu(titulo, opcoes);

        if (opcaoEscolhida < 0)
            throw new JanelaFechadaException();

        return opcaoEscolhida;
    }
}
