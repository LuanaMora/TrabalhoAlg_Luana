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
import javax.swing.JOptionPane;
import urnaeletronica.jdbc.ConnectionFactory;
import urnaeletronica.model.Partido;

/**
 *
 * @author TPSI-LUANA
 */
public class PartidoDAO implements GenericDAO<Partido> {

    private Connection connection = null;

    @Override
    public void save(Partido entity) throws SQLException {
        try {
            this.connection =  ConnectionFactory.getInstancia().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("insert into partido(")
                    .append(" ds_partido, sigla_partido) values(?, ?, ?)");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setString(1, entity.getDescricao());
            pstm.setString(2, entity.getSigla());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir Partido");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao Inserir Partido");
            ex.printStackTrace();
        } finally {
            connection.close();
        }
    }

    @Override
    public void update(Partido entity) throws SQLException {
        try {
            this.connection =  ConnectionFactory.getInstancia().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE partido")
                    .append("   SET ds_partido=?")
                    .append(" WHERE sigla_partido=?; ");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setString(1, entity.getDescricao());
            pstm.setString(2, entity.getSigla());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao Atualizar Partido");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao Atualizar Partido");
            ex.printStackTrace();
        } finally {
            connection.close();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            this.connection =  ConnectionFactory.getInstancia().getConnection();
            String sql = "DELETE FROM partido WHERE cd_partido = " + id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao Deletar Partido");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao Deletar Partido");
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
    }

    @Override
    public Partido getById(int id) throws SQLException {
        Partido partido = null;
        try {
            this.connection =  ConnectionFactory.getInstancia().getConnection();
            String sql = "SELECT * FROM CANDIDATO WHERE CD_CANDIDATO = " + id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            partido = new Partido();
            while (rs.next()) {
                partido.setDescricao(rs.getString("DS_PARTIDO"));
                partido.setSigla(rs.getString("SIGLA_PARTIDO"));
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("ERRO AO BUSCAR ID DE PARTIDO");
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
        return partido;
    }

    @Override
    public List<Partido> getByName(String name) throws SQLException {
        Partido partido = null;
        List<Partido> partidoList = new ArrayList<>();
        try {
            this.connection =  ConnectionFactory.getInstancia().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("select ds_partido, sigla_partido from partido ")
                    .append(" where ds_candidato like '%" + name + "%';");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                partido = new Partido();
                partido.setDescricao(rs.getString("ds_partido"));
                partido.setSigla(rs.getString("sigla_partido"));

                partidoList.add(partido);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }
        return partidoList;
    }

    @Override
    public List<Partido> getAll() throws SQLException {
        List<Partido> partidoList = null;
        Partido partido = null;
        try {
            this.connection =  ConnectionFactory.getInstancia().getConnection();
            String sql = "select * from partido order by sigla_partido";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            partidoList = new ArrayList<>();
            while (rs.next()) {
                partido = new Partido();
                partido.setDescricao(rs.getString("ds_partido"));
                partido.setSigla(rs.getString("sigla_partido"));
                partidoList.add(partido);
            }
            pstm.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar todos os partidos", "ERRO", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
        return partidoList;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection =  ConnectionFactory.getInstancia().getConnection();
            String sql = "SELECT COALESCE(MAX(cd_partido),0)+1 AS MAIOR FROM partido ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt("MAIOR");
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao maior ID Partidos");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao maior ID Partidos");
            ex.printStackTrace();
        } finally {
            pstm.close();
            this.connection.close();
        }
        return 1;
    }

}
