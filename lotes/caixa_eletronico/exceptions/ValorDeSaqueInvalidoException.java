package lotes.caixa_eletronico.exceptions;

public class ValorDeSaqueInvalidoException extends IllegalArgumentException {
    public ValorDeSaqueInvalidoException() {
        super("O valor solicitado é maior que o valor disponível.");
    }

    public ValorDeSaqueInvalidoException(String mensagem) {
        super(mensagem);
    }
}
