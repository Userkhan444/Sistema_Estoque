package factory;

import model.Eletronico;
import model.Livro;
import model.Produto;

public class ProdutoFactory {

    public static Produto criarProduto(int tipo, int id, String nome, double preco, String infoEspecifica) {

        switch (tipo) {
            case 1:
                // Cria um Livro usando a infoEspecifica como Autor
                return new Livro(id, nome, preco, infoEspecifica);

            case 2:
                // Cria um Eletrônico usando a infoEspecifica como Marca
                return new Eletronico(id, nome, preco, infoEspecifica);

            default:
                // Se o tipo for inválido, retorna null
                return null;
        }
    }
}
