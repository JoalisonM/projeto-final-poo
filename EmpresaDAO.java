package com.mycompany.gerenciamentoempresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class EmpresaDAO {
    public void adicionarEmpresa(Empresa empresa) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;

        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("INSERT INTO empresa(nome,CNPJ) VALUES(?,?)");
            stmt.setString(1, empresa.getNome());
            stmt.setString(2, empresa.getCNPJ());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e);
        } finally {
            postgres.close(stmt, conexao);
        }
    }

    public List<Empresa> listarEmpresas() {
        List<Empresa> listaRetorno = new LinkedList<>();

        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;

        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM empresa ORDER BY codigo");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Empresa empresa = new Empresa();
                empresa.setNome(rs.getString("nome"));
                empresa.setCNPJ(rs.getString("CNPJ"));

                listaRetorno.add(empresa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }

        return listaRetorno;
    }

    public Empresa getEmpresaPeloCodigo(int codigoEmpresa) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;

        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM empresa WHERE codigo=?");
            stmt.setInt(1, codigoEmpresa);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Empresa empresa = new Empresa(rs.getString("nome"), rs.getString("CNPJ"));
                return empresa;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }
        return null;
    }

    public void atualizarEmpresa(Empresa empresa) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;

        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("UPDATE empresa SET nome=?,CNPJ=? WHERE codigo=?");
            stmt.setString(1, empresa.getNome());
            stmt.setString(2, empresa.getCNPJ());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e);
        } finally {
            postgres.close(stmt, conexao);
        }
    }

    public void deletarEmpresa(int codigo) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;

        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("DELETE FROM empresa WHERE codigo=?");
            stmt.setInt(1, codigo);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + e);
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }
}