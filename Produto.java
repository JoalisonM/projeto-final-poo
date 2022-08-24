package com.mycompany.gerenciamentoempresa;

public class Produto {
    private double valor;
    private String nome, descricao;
    private int codigo, quantidade, codigoCategoria, codigoFilial;
    
    public Produto() {}
    
    public Produto(double valor, String nome, String descricao, int codigo, int quantidade, int codigoCategoria, int codigoFilial) {
        this.valor = valor;
        this.nome = nome;
        this.descricao = descricao;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.codigoCategoria = codigoCategoria;
        this.codigoFilial = codigoFilial;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public int getCodigoFilial() {
        return codigoFilial;
    }

    public void setCodigoFilial(int codigoFilial) {
        this.codigoFilial = codigoFilial;
    }
    
    @Override
    public String toString() {
        return "Produto{" + "valor=" + valor + ", nome=" + nome + ", descricao=" + descricao + ", codigo=" + codigo + ", quantidade=" + quantidade + ", codigoCategoria=" + codigoCategoria + ", codigoFilial=" + codigoFilial + '}';
    }
}
