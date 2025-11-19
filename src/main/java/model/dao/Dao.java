package dao;

import model.Produto;
import java.util.List;

// Interface que define o contrato de armazenamento.
public interface Dao {
    boolean salvar(Produto p);
    List<Produto> listarTodos();
    boolean remover(int id);
}