package Produto;

public abstract class Produto {
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private String nacionalidade;

    // Construtor
    public Produto(int id, String nome, String descricao, double preco, String nacionalidade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.nacionalidade = nacionalidade;
    }

    public static int gerarIdAleatorio() {
        return 100 + (int) (Math.random() * 900); // Gera um número aleatório entre 100000 e 999999
    }
    
    // Métodos de acesso (getters e setters) para os campos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        // Multiplica o preço base com base na nacionalidade
        if ("nacional".equals(nacionalidade)) {
            return preco * 1.2;
        } else if ("importado".equals(nacionalidade)) {
            return preco * 1.5;
        } else {
            return preco; // Caso a nacionalidade não seja reconhecida, retorna o preço original
        }
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
