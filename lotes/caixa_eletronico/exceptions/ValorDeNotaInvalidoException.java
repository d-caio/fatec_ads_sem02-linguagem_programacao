package lotes.caixa_eletronico.exceptions;

public class ValorDeNotaInvalidoException extends IllegalArgumentException {
    public ValorDeNotaInvalidoException() {
        super("O valor da nota não pode ser menor que R$ 1,00.");
    }
}
