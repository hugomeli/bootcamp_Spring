package br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.entities;

public class Caixa {

    private double valorTotal;

    public Caixa(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void adicionaValor(double valor){
        this.valorTotal += valor;
    }

}
