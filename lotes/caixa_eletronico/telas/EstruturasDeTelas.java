package lotes.caixa_eletronico.telas;

import javax.swing.JOptionPane;

class EstruturasDeTelas {
    protected static int mostrarMenu(String titulo, Opcao[] opcoes) {
        String[] textoDasOpcoes = new String[opcoes.length];

        for (int i = 0; i < opcoes.length; i++) {
            int codigo = opcoes[i].getCodigo();
            String descricao = opcoes[i].getDescricao();
            textoDasOpcoes[i] = codigo + " - " + descricao;
        }
        
        int indexDaOpcaoEscolhida =  JOptionPane.showOptionDialog(
            null,
            "Selecione uma das opções.",
            titulo,
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            textoDasOpcoes,
            textoDasOpcoes[0]    
        );

        if (indexDaOpcaoEscolhida < 0)
            return indexDaOpcaoEscolhida;

        int opcaoEscolhida = opcoes[indexDaOpcaoEscolhida].getCodigo();

        return opcaoEscolhida;
    }

    protected static void mostrarTelaDeVisualizacao(String titulo, String texto) {
        JOptionPane.showMessageDialog(
            null,
            texto,
            titulo,
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    protected static String mostrarTelaDeEntrada(String titulo, String texto) {
        String entrada = JOptionPane.showInputDialog(
            null,
            texto,
            titulo,
            JOptionPane.QUESTION_MESSAGE
        );

        return entrada;
    }

    protected static void mostrarTelaDeAtencao(String titulo, String texto) {
        JOptionPane.showMessageDialog(
            null,
            texto,
            titulo,
            JOptionPane.WARNING_MESSAGE
        );
    }

    protected static void mostrarTelaDeErro(String titulo, String texto) {
        JOptionPane.showMessageDialog(
            null,
            texto,
            titulo,
            JOptionPane.ERROR_MESSAGE
        );
    }
}
