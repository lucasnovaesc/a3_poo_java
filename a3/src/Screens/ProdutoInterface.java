package Screens;
import javax.swing.*;

import Produto.Produto;
import Produto.ProdutoLiquido;
import Produto.ProdutoSolido;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProdutoInterface extends JFrame {
    public ProdutoInterface() {
        setTitle("Interface de Produtos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // BOTOES INICIAIS
        JButton cadastrarButton = new JButton("Cadastrar Produto");
        JButton consultarButton = new JButton("Consultar Produto");
        JButton lerButton = new JButton("Ler Produto");
        JButton atualizarButton = new JButton("Atualizar Produto");
        JButton deletarButton = new JButton("Deletar Produto");

        // Adicione os botões ao painel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        panel.add(cadastrarButton);
        panel.add(consultarButton);
        panel.add(lerButton);
        panel.add(atualizarButton);
        panel.add(deletarButton);

        // Adicione um ouvinte de eventos para cada botão
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarProduto();
            }
        });

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implemente a lógica para consultar produto aqui
                JOptionPane.showMessageDialog(ProdutoInterface.this, "Consulta de Produto");
            }
        });

        lerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implemente a lógica para ler produto aqui
                JOptionPane.showMessageDialog(ProdutoInterface.this, "Leitura de Produto");
            }
        });

        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implemente a lógica para atualizar produto aqui
                JOptionPane.showMessageDialog(ProdutoInterface.this, "Atualização de Produto");
            }
        });

        deletarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implemente a lógica para deletar produto aqui
                JOptionPane.showMessageDialog(ProdutoInterface.this, "Deleção de Produto");
            }
        });

        // Adicione o painel ao frame
        add(panel);

        // Configure o tamanho e a visibilidade do frame
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

        private void cadastrarProduto() {
            JTextField nomeField = new JTextField();
            JTextField descricaoField = new JTextField();
            JTextField precoField = new JTextField();
            JTextField nacionalidadeField = new JTextField();
            JTextField tipoProdutoField = new JTextField();
        
            Object[] message = {
                    "Nome:", nomeField,
                    "Descrição:", descricaoField,
                    "Preço:", precoField,
                    "Nacionalidade (nacional ou importado):", nacionalidadeField,
                    "Tipo de Produto (solido ou liquido):", tipoProdutoField
            };
        
            int option = JOptionPane.showConfirmDialog(this, message, "Cadastro de Produto", JOptionPane.OK_CANCEL_OPTION);
        
            if (option == JOptionPane.OK_OPTION) {
                try {
                    String nome = nomeField.getText();
                    String descricao = descricaoField.getText();
                    double preco = Double.parseDouble(precoField.getText());
                    String nacionalidade = nacionalidadeField.getText();
                    String tipoProduto = tipoProdutoField.getText();
        
                    Produto produto;
        
                    if ("solido".equalsIgnoreCase(tipoProduto)) {
                        int peso = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o Peso do Produto Sólido:"));
                        produto = new ProdutoSolido(nome, descricao, preco, peso, nacionalidade);
                    } else if ("liquido".equalsIgnoreCase(tipoProduto)) {
                        double ml = Double.parseDouble(JOptionPane.showInputDialog(this, "Digite o Volume do Produto Líquido:"));
                        produto = new ProdutoLiquido(nome, descricao, preco, ml, nacionalidade);
                    } else {
                        JOptionPane.showMessageDialog(this, "Tipo de produto inválido. Use 'solido' ou 'liquido'.");
                        return;
                    }
        
                    // Adiciona o produto à lista (ou faz a lógica de persistência desejada)
                    // Por exemplo, você pode ter uma lista de produtos na classe MainGUI
                    // e adicionar o produto a essa lista.
        
                    // Imprime as informações do produto através da interface gráfica
                    String infoProduto = "ID: " + produto.getId() + "<br>" +
                                        "Nome: " + produto.getNome() + "<br>" +
                                        "Descrição: " + produto.getDescricao() + "<br>" +
                                        "Preço Final: " + produto.getPreco() + "<br>" +
                                        "Nacionalidade: " + produto.getNacionalidade();
        
                    if (produto instanceof ProdutoSolido) {
                        infoProduto += "<br>Peso: " + ((ProdutoSolido) produto).getPeso();
                    } else if (produto instanceof ProdutoLiquido) {
                        infoProduto += "<br>Volume: " + ((ProdutoLiquido) produto).getMl();
                    }
        
                    // Exibe as informações do produto e a mensagem de sucesso através da interface gráfica
                    JOptionPane.showMessageDialog(this, "<html>" + infoProduto + "<br><br>Produto adicionado com sucesso!</html>");
        
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Erro ao cadastrar o produto. Certifique-se de inserir valores válidos.");
                }
            }
        }




        


        


    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProdutoInterface());
    }
}
