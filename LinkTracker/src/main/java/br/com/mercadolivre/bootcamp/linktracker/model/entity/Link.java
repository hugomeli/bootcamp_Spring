package br.com.mercadolivre.bootcamp.linktracker.model.entity;

public class Link {

    private String endereco;
    private int quantidadeVisitas;
    private String enderecoMascarado;
    private boolean isValid;
    private static int counterIdMascara=999;
    private String senha="";

    public Link(String endereco) {
        this.endereco = endereco;
        int idMascara = counterIdMascara;
        this.isValid = true;
        this.enderecoMascarado = "BIT" + idMascara;
        counterIdMascara ++;
    }

    public Link(String endereco, String senha) {
        this.endereco = endereco;
        int idMascara = counterIdMascara;
        this.isValid = true;
        this.enderecoMascarado = "BIT" + idMascara;
        this.senha = senha;
        counterIdMascara ++;
    }


    public Link() {
    }

    public int getQuantidadeVisitas() {
        return quantidadeVisitas;
    }

    public void setQuantidadeVisitas(int quantidadeVisitas) {
        this.quantidadeVisitas = quantidadeVisitas;
    }

    public String getEnderecoMascarado() {
        return enderecoMascarado;
    }

    public void setEnderecoMascarado(String enderecoMascarado) {
        this.enderecoMascarado = enderecoMascarado;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public static int getCounterIdMascara() {
        return counterIdMascara;
    }

    public static void setCounterIdMascara(int counterIdMascara) {
        Link.counterIdMascara = counterIdMascara;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
