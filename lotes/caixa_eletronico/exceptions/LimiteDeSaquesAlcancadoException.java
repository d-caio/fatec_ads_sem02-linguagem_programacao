package lotes.caixa_eletronico.exceptions;

public class LimiteDeSaquesAlcancadoException extends IllegalStateException {
    public LimiteDeSaquesAlcancadoException() {
        super("Limite de saques alcançado.");
    }
}
