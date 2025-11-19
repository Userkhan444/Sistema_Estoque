package model;

public abstract class Produto {
    private final String nome;
    private final double preco;
    private final int id;

    public Produto(String nome, double preco, int id) {
        this.nome = nome;
        this.preco = preco;
        this.id = id;
    }

    //Getters

    public double getPreco() {
        return preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    // Métodos

    public String getDetalhesBasicos() {
        return String.format("ID: %d | Nome: %s | Preço: R$ %.2f", id, nome, preco);
    }
    public abstract String getTipo();

    @Override
    public String toString() {
        return getDetalhesBasicos();
    }
}
