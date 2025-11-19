package dao;

import model.Produto;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDadosMemoria implements Dao {

    // 1. Atributo estático privado que guarda a ÚNICA instância dessa classe.
    private static BancoDeDadosMemoria instance;

    // A lista que simula as tabelas do banco de dados
    private List<Produto> produtos;

    // 2. Construtor PRIVADO. Ninguém de fora pode dar "new BancoDeDadosMemoria()".
    private BancoDeDadosMemoria() {
        this.produtos = new ArrayList<>();
        // produtos.add(new model.Livro(1, "O Senhor dos Anéis", 50.0, "Tolkien"));
    }

    // 3. Método PÚBLICO e ESTÁTICO que controla o acesso à instância.
    // Se não existe, cria. Se existe, retorna a mesma.
    public static synchronized BancoDeDadosMemoria getInstance() {
        if (instance == null) {
            instance = new BancoDeDadosMemoria();
        }
        return instance;
    }

    @Override
    public boolean salvar(Produto novoProduto) {
        // Validação: Verifica se o ID já existe
        for (Produto p : produtos) {
            if (p.getId() == novoProduto.getId()) {
                System.out.println("ERRO: Já existe um produto com o ID " + novoProduto.getId());
                return false; // Não salva e retorna falso
            }
        }

        produtos.add(novoProduto);
        System.out.println("Produto salvo com sucesso no banco de memória!");
        return true;
    }

    @Override
    public List<Produto> listarTodos() {
        return this.produtos;
    }

    @Override
    public boolean remover(int id) {
        // Remove se o ID do produto for igual ao ID passado
        return produtos.removeIf(p -> p.getId() == id);
    }
}
