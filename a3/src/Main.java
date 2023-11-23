import java.util.ArrayList;
import java.util.List;
import Produto.Produto;
import Produto.ProdutoLiquido;
import Produto.ProdutoSolido;

public class Main {
    public static void main(String[] args) {
        // Crie uma lista de produtos
        List<Produto> listaDeProdutos = new ArrayList<>();

        // Adicione objetos de ProdutoSolido à lista
        ProdutoSolido produtoSolido = new ProdutoSolido("Produto Sólido 1", "Descrição do Produto Sólido 1", 15.0, 10, "nacional");
        listaDeProdutos.add(produtoSolido);

        // Adicione objetos de ProdutoLiquido à lista
        ProdutoLiquido produtoLiquido = new ProdutoLiquido("Produto Líquido 1", "Descrição do Produto Líquido 1", 5.0, 2.5, "importado");
        listaDeProdutos.add(produtoLiquido);

        // Itere sobre a lista de produtos
        for (Produto produto : listaDeProdutos) {
            System.out.println("ID: " + produto.getId());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Preço: " + produto.getPreco()); // Agora retorna o preço atualizado

            double fatorMultiplicativo = 1.0;
            if ("nacional".equals(produto.getNacionalidade())) {
                fatorMultiplicativo = 1.2;
            } else if ("importado".equals(produto.getNacionalidade())) {
                fatorMultiplicativo = 1.5;
            }

            double precoAtualizado = produto.getPreco() * fatorMultiplicativo;

            System.out.println("Preço Atualizado: " + precoAtualizado);
            System.out.println("Nacionalidade: " + produto.getNacionalidade());
            System.out.println();
        }
    }
}
