
package com.mycompany.gerenciamentoempresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class FuncionarioDAO {
     public void adicionarFuncionario(Funcionario funcionario) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("INSERT INTO funcionario(cpf,nome,telefone,email,idade,funcao,codigo_departamento) VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1, funcionario.getCPF());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getTelefone());
            stmt.setString(4, funcionario.getEmail());
            stmt.setInt(5, funcionario.getIdade());
            stmt.setString(6, funcionario.getFuncao());
            stmt.setInt(7, funcionario.getCodigoDepartamento());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e);
        } finally {
            postgres.close(stmt, conexao);
        }
    }
    
    public List<Funcionario> listarProdutos() {
        List<Funcionario> listaRetorno = new LinkedList<>();
        
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM funcionario ORDER BY cpf");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCPF(rs.getString("cpf"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setIdade(rs.getInt("idade"));
                funcionario.setFuncao(rs.getString("funcao"));
                funcionario.setCodigoDepartamento(rs.getInt("codigo_departamento"));
                
                listaRetorno.add(funcionario);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }
        
        return listaRetorno;
    }
    
    public Funcionario getFuncionarioPeloCodigo(String cpf) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM funcionario WHERE cpf=?");
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Funcionario funcionario = new Funcionario(rs.getInt("idade"),rs.getInt("codigo_departamento"),rs.getString("cpf"),rs.getString("nome"),
                rs.getString("telefone"),rs.getString("email"),rs.getString("funcao"));
                return funcionario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }
        return null;
    }
    
    public void atualizarFuncionario(Funcionario funcionario) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("UPDATE funcionario SET cpf=?,nome=?,telefone=?,email=?,idade=?,funcao=?,codigo_departamento=? WHERE cpf=?");
            stmt.setString(1, funcionario.getCPF());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getTelefone());
            stmt.setString(4, funcionario.getEmail());
            stmt.setInt(5, funcionario.getIdade());
            stmt.setString(6, funcionario.getFuncao());
            stmt.setInt(7, funcionario.getCodigoDepartamento());
            stmt.setString(8, funcionario.getCPF());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e);
        } finally {
            postgres.close(stmt, conexao);
        }
    }
    
    public void deletarFuncionario(String cpf) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("DELETE FROM funcionario WHERE cpf=?");
            stmt.setString(1, cpf);

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + e);
        } finally {
            postgres.close(null, stmt, conexao);}
    }
}
