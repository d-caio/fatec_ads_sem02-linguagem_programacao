package lotes.caixa_eletronico.telas;

public class TelaDeException {
    public static void programaEncerradoPeloUsuario() {
        EstruturasDeTelas.mostrarTelaDeAtencao(
            "Fim",
            "Programa encerrado pelo usuário."
        );
    }

    public static void telaDeErro(int tentativas, int maximoDeTentativas, String texto) {
        String titulo = "Erro " + tentativas + " de " + maximoDeTentativas;
        
        EstruturasDeTelas.mostrarTelaDeErro(
            titulo,
            texto
        );
    }
}
