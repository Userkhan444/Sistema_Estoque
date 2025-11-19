package model;

public class Livro extends Produto {
    private final String autor;

    public Livro(int id, String nome, double preco, String autor) {
        super(nome, preco, id);
        this.autor = autor;
    }

    @Override
    public String getTipo() {
        return "Livro";
    }

    @Override
    public String toString() {
        return super.getDetalhesBasicos() + " | Autor: " + this.autor;
    }

    public String getAutor() { return autor; }
}
