package br.com.mercadolivre.bootcamp.lojaclientes.model.entities;

public class Produto {

    private Long id;
    private String descricao;
    private int quantidade;
    private double preco;

    public Produto() {
    }

    public Produto(Long id, String descricao, int quantidade, double preco) {
        this.id = id;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
