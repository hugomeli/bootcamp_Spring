package br.com.mercadolivre.bootcamp.lojaclientes.model.entities;

import java.util.List;

public class Cliente {

    private static Long contadorId = 1L;
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private List<Pedido> pedidosRegistrados;

    public Cliente() {
        this.id = contadorId;
        contadorId += 1;
    }

    public Cliente(String nome, String cpf, String email, String telefone, List<Pedido> pedidosRegistrados) {
        this.id = contadorId;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.pedidosRegistrados = pedidosRegistrados;
        contadorId += 1;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Pedido> getPedidosRegistrados() {
        return pedidosRegistrados;
    }

    public void setPedidosRegistrados(List<Pedido> pedidosRegistrados) {
        this.pedidosRegistrados = pedidosRegistrados;
    }
}
