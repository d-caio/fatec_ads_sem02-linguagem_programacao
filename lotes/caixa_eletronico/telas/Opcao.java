package lotes.caixa_eletronico.telas;

class Opcao {
    private int codigo;
    private String descricao;

    protected Opcao(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    protected int getCodigo() { return codigo; }

    protected String getDescricao() { return descricao; }
}
