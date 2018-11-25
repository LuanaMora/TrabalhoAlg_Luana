/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urnaeletronica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import urnaeletronica.jdbc.ConnectionFactory;
import urnaeletronica.model.Eleitor;

/**
 *
 * @author TPSI-LUANA
 */
public class EleitorDAO implements GenericDAO<Eleitor> {

    private Connection connection = null;

    @Override
    public void save(Eleitor entity) throws SQLException {
        try {
            this.connection =  ConnectionFactory.getInstancia().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("insert into eleitor(cd_eleitor, titulo_eleitor, ")
                    .append("ds_eleitor, cpf_eleitor)")
                    .append("values(?,?,?,?);");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setString(2, entity.getTitulo_eleitor());
            pstm.setString(3, entity.getNome());
            pstm.setString(4, entity.getCpf());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir Eleitor");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao Inserir Eleitor");
            ex.printStackTrace();
        } finally {
            connection.close();
        }
    }

    @Override
    public void update(Eleitor entity) throws SQLException {
        try {
            this.connection =  ConnectionFactory.getInstancia().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE eleitor")
                    .append("   SET titulo_eleitor=?, ds_eleitor=?, cpf_eleitor=?")
                    .append(" WHERE cd_eleitor=?; ");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
           // pstm.setInt(1, entity.getCodigo());
            pstm.setString(1, entity.getTitulo_eleitor());
            pstm.setString(2, entity.getNome());
            pstm.setString(3, entity.getCpf());
            pstm.setInt(4, entity.getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao Atualizar Eleitor");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao Atualizar Eleitor");
            ex.printStackTrace();
        } finally {
            connection.close();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            this.connection =  ConnectionFactory.getInstancia().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM VOTO WHERE CD_ELEITOR = " + id + ";")
                .append(" DELETE FROM ELEITOR WHERE CD_ELEITOR = " + id +";");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao Deletar Eleitor");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao Deletar Eleitor");
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
    }

    @Override
    public Eleitor getById(int id) throws SQLException {
        Eleitor eleitor = null;
        try {
            this.connection =  ConnectionFactory.getInstancia().getConnection();
            String sql = "SELECT * FROM ELEITOR WHERE CD_ELEITOR = " + id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            eleitor = new Eleitor();
            while (rs.next()) {
                eleitor.setCodigo(rs.getInt("CD_ELEITOR"));
                eleitor.setTitulo_eleitor(rs.getString("TITULO_ELEITOR"));
                eleitor.setNome(rs.getString("DS_ELEITOR"));
                eleitor.setCpf(rs.getString("CPF_ELEITOR"));
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao Atualizar Eleitor");
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
        return eleitor;
    }

    @Override
    public List<Eleitor> getByName(String name) throws SQLException {
        Eleitor eleitor = null;
        List<Eleitor> eleitorList = new ArrayList<>();
        try {
            this.connection =  ConnectionFactory.getInstancia().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("select * from eleitor where ds_eleitor like '%" + name + "%';");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                eleitor = new Eleitor();
                eleitor.setCodigo(rs.getInt("CD_ELEITOR"));
                eleitor.setTitulo_eleitor(rs.getString("TITULO_ELEITOR"));
                eleitor.setNome(rs.getString("DS_ELEITOR"));
                eleitor.setCpf(rs.getString("CPF_ELEITOR"));
                eleitorList.add(eleitor);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }
        return eleitorList;
    }

    @Override
    public List<Eleitor> getAll() throws SQLException {
        List<Eleitor> eleitorList = null;
        Eleitor eleitor = null;
        try {
            this.connection =  ConnectionFactory.getInstancia().getConnection();
            String sql = ("select * from ELEITOR order by cd_eleitor;");

            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            eleitorList = new ArrayList<>();
            while (rs.next()) {
                eleitor = new Eleitor();
                eleitor.setCodigo(rs.getInt("CD_ELEITOR"));
                eleitor.setTitulo_eleitor(rs.getString("TITULO_ELEITOR"));
                eleitor.setNome(rs.getString("DS_ELEITOR"));
                eleitor.setCpf(rs.getString("CPF_ELEITOR"));

                eleitorList.add(eleitor);
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar todos OS Eeitores");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao consultar todos OS Eleitores");
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
        return eleitorList;
    }

    @Override
    public int getLastId() throws SQLException {
         PreparedStatement pstm = null;
        try {
            this.connection =  ConnectionFactory.getInstancia().getConnection();
            String sql = "SELECT COALESCE(MAX(CD_ELEITOR),0)+1 AS MAIOR FROM ELEITOR ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt("MAIOR");
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao maior ID Eleitor");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao maior ID Eleitores");
            ex.printStackTrace();
        } finally {
            pstm.close();
            this.connection.close();
        }
        return 1;
    }

}
