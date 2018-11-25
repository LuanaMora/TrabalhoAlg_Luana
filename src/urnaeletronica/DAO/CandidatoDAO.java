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
import urnaeletronica.model.Candidato;
import urnaeletronica.model.Partido;

/**
 *
 * @author TPSI-LUANA
 */
public class CandidatoDAO implements GenericDAO<Candidato> {

    private Connection connection = null;
    
    private StringBuilder sqlBase = new StringBuilder("select c.cd_candidato, c.nm_candidato, ")
            .append("c.ds_candidato, c.cd_partido from candidato as c")
            .append("inner join partido p on (c.sigla_partido = p.sigla_partido)");

    @Override
    public void save(Candidato entity) throws SQLException {
        try {
            this.connection =  ConnectionFactory.getInstancia().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("insert into candidato(cd_candidato,")
                    .append(" nm_candidato, ds_candidato, sigla_partido, dt_voto) values(?, ?, ?, ?, ?)");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setString(2, entity.getNumero());
            pstm.setString(3, entity.getNome());
            pstm.setString(4, entity.getPartido().getSigla());
            pstm.setInt(5, entity.getVoto());
            
            
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir Candidato");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao Inserir Candidato");
            ex.printStackTrace();
        } finally {
            connection.close();
        }
    }

    @Override
    public void update(Candidato entity) throws SQLException {
        try {
            this.connection =  ConnectionFactory.getInstancia().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE candidato")
                    .append("   SET nm_candidato=?, ds_candidato=?, sigla_partido=?")
                    .append(" WHERE cd_candidato=?; ");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setString(1, entity.getNumero());
            pstm.setString(2, entity.getNome());
            pstm.setString(3, entity.getPartido().getSigla());
            pstm.setInt(4, entity.getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao Atualizar Candidato");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao Atualizar Candidato");
            ex.printStackTrace();
        } finally {
            connection.close();
        }
    }
    
   //Esse método é somente para atualizar os votos atribuidos aos candidatos
    public int updateVoto(Candidato entity) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE candidato")
                    .append("   SET dt_voto = dt_voto + 1")
                    .append(" WHERE cd_candidato=?; ");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao Atualizar Candidato");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao Atualizar Candidato");
            ex.printStackTrace();
        } finally {
            connection.close();
        }
        return 1;
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            this.connection =  ConnectionFactory.getInstancia().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM VOTO WHERE CD_CANDIDATO = " + id + ";")
                .append(" DELETE FROM CANDIDATO WHERE CD_CANDIDATO = " + id +";");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao Deletar Candidato");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao Deletar Candidato");
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
    }

    @Override
    public Candidato getById(int id) throws SQLException {
        Candidato candidato = null;
        try {
            this.connection =  ConnectionFactory.getInstancia().getConnection();
            String sql = "SELECT * FROM CANDIDATO WHERE CD_CANDIDATO = " + id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            candidato = new Candidato();
            while (rs.next()) {
                candidato.setCodigo(rs.getInt("CD_CANDIDATO"));
                candidato.setNumero(rs.getString("NM_CANDIDATO"));
                candidato.setNome(rs.getString("DS_CANDIDATO"));
                candidato.setPartido(populaPartido(rs.getString("sigla_partido")
                ));
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao Atualizar Combustivel");
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
        return candidato;
    }

    @Override
    public List<Candidato> getByName(String name) throws SQLException {
        Candidato candidato = null;
        List<Candidato> candidatoList = new ArrayList<>();
        try {
            this.connection =  ConnectionFactory.getInstancia().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("select c.cd_candidato, c.nm_candidato, ")
                    .append(" c.ds_candidato, c.sigla_partido from candidato as c")
                    .append(" inner join partido as p")
                    .append(" using(sigla_partido)")
                    .append(" where c.ds_candidato like '%" + name + "%';");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                candidato = new Candidato();
                candidato.setCodigo(rs.getInt("cd_candidato"));
                candidato.setNumero(rs.getString("nm_candidato"));
                candidato.setNome(rs.getString("ds_candidato"));
                candidato.setPartido(populaPartido(
                        rs.getString("sigla_partido")
                ));
                candidatoList.add(candidato);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }
        return candidatoList;
    }

    @Override
    public List<Candidato> getAll() throws SQLException {
        List<Candidato> candidatoList = null;
        Candidato candidato = null;
        try {
            this.connection =  ConnectionFactory.getInstancia().getConnection();
            String sql = ("select * from candidato order by cd_candidato;");

            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            candidatoList = new ArrayList<>();
            while (rs.next()) {
                candidato = new Candidato();
                candidato.setCodigo(rs.getInt("CD_CANDIDATO"));
                candidato.setNumero(rs.getString("NM_CANDIDATO"));
                candidato.setNome(rs.getString("DS_CANDIDATO"));
                candidato.setVoto(rs.getInt("dt_voto"));
                candidato.setPartido(populaPartido(
                        rs.getString("sigla_partido")));
                candidatoList.add(candidato);
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar todos OS CandidatoS");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao consultar todos OS CandidatoS");
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
        return candidatoList;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection =  ConnectionFactory.getInstancia().getConnection();
            String sql = "SELECT COALESCE(MAX(CD_CANDIDATO),0)+1 AS MAIOR FROM CANDIDATO ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt("MAIOR");
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao maior ID Candidato");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao maior ID Candidato");
            ex.printStackTrace();
        } finally {
            pstm.close();
            this.connection.close();
        }
        return 1;
    }

    public Partido populaPartido(String sigla) {
        Partido partido = new Partido();
        partido.setSigla(sigla);
        return partido;
    }
}
