package lotes.caixa_eletronico.exceptions;

public class QuantidadeDeNotasInvalidaException extends IllegalArgumentException {
    public QuantidadeDeNotasInvalidaException() {
        super("A quantidade de notas não pode ser menor que zero.");
    }
}
