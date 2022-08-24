package com.mycompany.gerenciamentoempresa;

public class Departamento {
    private String nome, email;
    private int codigo, codigoFilial;
    
    public Departamento() {}

    public Departamento(String nome, String email, int codigo, int codigoFilial) {
        this.nome = nome;
        this.email = email;
        this.codigo = codigo;
        this.codigoFilial = codigoFilial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoFilial() {
        return codigoFilial;
    }

    public void setCodigoFilial(int codigoFilial) {
        this.codigoFilial = codigoFilial;
    }
    
    @Override
    public String toString() {
        return "Departamento{" + "nome=" + nome + ", email=" + email + ", codigo=" + codigo + ", codigoFilial=" + codigoFilial + '}';
    }
}
