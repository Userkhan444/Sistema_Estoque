package model;

public class Eletronico extends Produto {
    private String marca;

    public Eletronico(int id, String nome, double preco, String marca) {
        super(nome, preco, id);
        this.marca = marca;
    }

    @Override
    public String getTipo() {
        return "Eletrônico";
    }

    @Override
    public String toString() {
        return super.getDetalhesBasicos() + " | Marca: " + this.marca;
    }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
}