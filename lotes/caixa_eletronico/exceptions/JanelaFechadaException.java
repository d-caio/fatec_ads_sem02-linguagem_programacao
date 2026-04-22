package lotes.caixa_eletronico.exceptions;

public class JanelaFechadaException extends NullPointerException {
    public JanelaFechadaException() {
        super("Programa encerrado pelo usuário.");
    }
}
