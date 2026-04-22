package lotes.caixa_eletronico.telas;

public class TelaDeVisualizacao {
    String titulo;
    String texto;

    public TelaDeVisualizacao(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
    }

    public void mostrar() { EstruturasDeTelas.mostrarTelaDeVisualizacao(titulo, texto); }
}
