package lotes.caixa_eletronico.exceptions;

public class CaixaNaoCarregadoException extends IllegalStateException {
    public CaixaNaoCarregadoException() {
        super("Caixa não carregado.");
    }
}
