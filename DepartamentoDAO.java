package com.mycompany.gerenciamentoempresa;
    
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class DepartamentoDAO {
    public void adicionarDepartamento(Departamento departamento) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("INSERT INTO departamento(nome,email,codigo_filial) VALUES(?,?,?)");
            stmt.setString(1, departamento.getNome());
            stmt.setString(2, departamento.getEmail());
            stmt.setInt(3, departamento.getCodigoFilial());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e);
        } finally {
            postgres.close(stmt, conexao);
        }
    }
    
    public List<Departamento> listarDepartamentos() {
        List<Departamento> listaRetorno = new LinkedList<>();
        
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM departamento ORDER BY codigo");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Departamento departamento = new Departamento();
                departamento.setCodigo(rs.getInt("codigo"));
                departamento.setNome(rs.getString("nome"));
                departamento.setEmail(rs.getString("email"));
                departamento.setCodigoFilial(rs.getInt("codigo_filial"));
                
                
                listaRetorno.add(departamento);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }
        
        return listaRetorno;
    }
    
    public Departamento getDepartamentoPeloCodigo(int codigo) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM departamento WHERE codigo=?");
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Departamento departamento = new Departamento(rs.getString("codigo"),rs.getString("email"),rs.getInt("codigo"),rs.getInt("codigo_filial"));
                return departamento;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }
        return null;
    }
    
    public void atualizarDepartamento(Departamento departamento) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("UPDATE departamento SET nome=?,email=?,codigo_filial=? WHERE codigo=?");
            stmt.setString(1, departamento.getNome());
            stmt.setString(2, departamento.getEmail());
            stmt.setInt(3, departamento.getCodigoFilial());
            stmt.setInt(4, departamento.getCodigo());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e);
        } finally {
            postgres.close(stmt, conexao);
        }
    }
    
    public void deletarDepartamento(int codigo) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("DELETE FROM departamento WHERE codigo=?");
            stmt.setInt(1, codigo);

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + e);
        } finally {
            postgres.close(null, stmt, conexao);}
    }
}
