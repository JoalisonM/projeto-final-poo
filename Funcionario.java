package com.mycompany.gerenciamentoempresa;

public class Funcionario {
    private int idade, codigoDepartamento;
    private String CPF, nome, telefone, email, funcao;
    
    public Funcionario() {}

    public Funcionario(String CPF, String nome, String telefone, String email, int idade, String funcao, int codigoDepartamento) {
        this.CPF = CPF;
        this.idade = idade;
        this.codigoDepartamento = codigoDepartamento;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.funcao = funcao;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(int codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    
    @Override
    public String toString() {
        return "Funcionario{" + "idade=" + idade + ", codigoDepartamento=" + codigoDepartamento + ", CPF=" + CPF + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", funcao=" + funcao + '}';
    }
}
