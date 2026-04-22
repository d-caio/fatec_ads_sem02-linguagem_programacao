package lotes.caixa_eletronico.exceptions;

public class TentativasExcedidasException extends IllegalStateException {
    public TentativasExcedidasException() {
        super("Máximo de tentativas atingido. O programa será encerrado.");
    }
}
