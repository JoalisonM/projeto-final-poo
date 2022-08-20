package com.mycompany.gerenciamentoempresa;

public class Filial {
    private int codigo;
    private String nome, tipo, CNPJEmpresa, rua, bairro, cidade;
    
    public Filial(int codigo, String nome, String tipo, String CNPJEmpresa, String rua, String bairro, String cidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.CNPJEmpresa = CNPJEmpresa;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCNPJEmpresa() {
        return CNPJEmpresa;
    }

    public void setCNPJEmpresa(String CNPJEmpresa) {
        this.CNPJEmpresa = CNPJEmpresa;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    @Override
    public String toString() {
        return "Filial{" + "codigo=" + codigo + ", nome=" + nome + ", tipo=" + tipo + ", CNPJEmpresa=" + CNPJEmpresa + ", rua=" + rua + ", bairro=" + bairro + ", cidade=" + cidade + '}';
    }
}
