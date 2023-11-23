package Produto;

public class ProdutoSolido extends Produto {
    private int peso;

    // Construtor
    public ProdutoSolido(String nome, String descricao, double preco, int peso, String nacionalidade) {
        super(gerarIdAleatorio(), nome, descricao, preco, nacionalidade);
        this.peso = peso;
    }

    // Métodos de acesso para o campo peso
    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
