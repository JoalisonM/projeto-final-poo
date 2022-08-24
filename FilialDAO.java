package com.mycompany.gerenciamentoempresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class FilialDAO {
    public void adicionarFilial(Filial filial) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;

        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement(
                    "INSERT INTO filial(nome,tipo,rua,bairro,cidade,CNPJ_empresa) VALUES(?,?,?,?,?,?)");
            stmt.setString(1, filial.getNome());
            stmt.setString(2, filial.getTipo());
            stmt.setString(3, filial.getRua());
            stmt.setString(4, filial.getBairro());
            stmt.setString(5, filial.getCidade());
            stmt.setString(6, filial.getCNPJEmpresa());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e);
        } finally {
            postgres.close(stmt, conexao);
        }
    }

    public List<Filial> listarFiliais() {
        List<Filial> listaRetorno = new LinkedList<>();

        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;

        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM filial ORDER BY codigo");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Filial filial = new Filial();
                filial.setCodigo(rs.getInt("codigo"));
                filial.setNome(rs.getString("nome"));
                filial.setTipo(rs.getString("tipo"));
                filial.setCNPJEmpresa(rs.getString("CNPJ_empresa"));
                filial.setRua(rs.getString("rua"));
                filial.setBairro(rs.getString("bairro"));
                filial.setCidade(rs.getString("Cidade"));

                listaRetorno.add(filial);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }

        return listaRetorno;
    }

    public Filial getFilialPeloCodigo(int codigoFilial) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;

        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM filial WHERE codigo=?");
            stmt.setInt(1, codigoFilial);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Filial filial = new Filial(rs.getInt("codigo"), rs.getString("nome"), rs.getString("CNPJ_empresa"), rs.getString("tipo"),
                        rs.getString("rua"), rs.getString("bairro"), rs.getString("cidade"));
                return filial;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }
        return null;
    }

    public void atualizarFilial(Filial filial) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;

        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement(
                    "UPDATE filial SET nome=?,tipo=?,rua=?,bairro=?,cidade=?,CNPJ_empresa=? WHERE codigo=?");
            stmt.setString(1, filial.getNome());
            stmt.setString(2, filial.getTipo());
            stmt.setString(3, filial.getRua());
            stmt.setString(4, filial.getBairro());
            stmt.setString(5, filial.getCidade());
            stmt.setString(6, filial.getCNPJEmpresa());
            stmt.setInt(7, filial.getCodigo());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e);
        } finally {
            postgres.close(stmt, conexao);
        }
    }

    public void deletarFilial(int codigo) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;

        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("DELETE FROM filial WHERE codigo=?");
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