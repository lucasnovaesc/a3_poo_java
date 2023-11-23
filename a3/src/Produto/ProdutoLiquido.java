package Produto;

public class ProdutoLiquido extends Produto {
    private double ml;

    // Construtor
    public ProdutoLiquido(String nome, String descricao, double preco, double ml, String nacionalidade) {
        super(gerarIdAleatorio(), nome, descricao, preco, nacionalidade);
        this.ml = ml;
    }

    // Métodos de acesso para o campo ml
    public double getMl() {
        return ml;
    }

    public void setMl(double ml) {
        this.ml = ml;
    }
}
