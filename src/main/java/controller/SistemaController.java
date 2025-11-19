package controller;

import model.dao.BancoDeDadosMemoria;
import model.dao.Dao;
import factory.ProdutoFactory;
import model.Produto;
import view.TerminalView;
import java.util.List;

public class SistemaController {

    private TerminalView view;
    private Dao dao;

    public SistemaController() {
        this.view = new TerminalView();
        // Aqui chamamos o SINGLETON. Pedimos a instância.
        this.dao = BancoDeDadosMemoria.getInstance();
    }

    public void iniciar() {
        int opcao;
        do {
            opcao = view.mostrarMenu();
            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    removerProduto();
                    break;
                case 0:
                    view.mostrarMensagem("Saindo do sistema...");
                    break;
                default:
                    view.mostrarMensagem("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void cadastrarProduto() {
        view.mostrarMensagem("\n--- CADASTRO ---");

        // 1. Coleta dados básicos via View
        int id = view.lerInteiro("Digite o ID: ");
        String nome = view.lerTexto("Digite o Nome: ");
        double preco = view.lerDouble("Digite o Preço: ");

        // 2. Define o tipo
        int tipo = view.lerInteiro("Tipo (1-Livro, 2-Eletrônico): ");

        String infoExtra;
        if (tipo == 1) {
            infoExtra = view.lerTexto("Digite o Autor: ");
        } else if (tipo == 2) {
            infoExtra = view.lerTexto("Digite a Marca: ");
        } else {
            view.mostrarMensagem("Tipo inválido! Cadastro cancelado.");
            return;
        }

        // 3. Usa a FACTORY para criar o objeto
        Produto novoProduto = ProdutoFactory.criarProduto(tipo, id, nome, preco, infoExtra);

        // 4. Salva no Banco (DAO)
        if (novoProduto != null) {
            // Tenta salvar e verifica o retorno boleano
            boolean salvou = dao.salvar(novoProduto);

            if (salvou) {
                view.mostrarMensagem("Produto cadastrado com sucesso!");
            } else {
                view.mostrarMensagem("Falha: ID duplicado. Tente novamente com outro ID.");
            }
        } else {
            view.mostrarMensagem("Erro ao criar produto (Tipo inválido).");
        }
    }

    private void listarProdutos() {
        // Pede os dados ao Model (DAO) e entrega para a View mostrar
        List<Produto> lista = dao.listarTodos();
        view.listarProdutos(lista);
    }

    private void removerProduto() {
        int id = view.lerInteiro("Digite o ID do produto a remover: ");
        boolean removeu = dao.remover(id);

        if (removeu) {
            view.mostrarMensagem("Produto removido!");
        } else {
            view.mostrarMensagem("Produto não encontrado.");
        }
    }
}