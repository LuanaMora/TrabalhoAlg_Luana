package urnaeletronica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import urnaeletronica.jdbc.ConnectionFactory;
import urnaeletronica.model.Voto;

/**
 *
 * @author TPSI-LUANA
 */
public class VotoDAO {

    private Connection connection = null;

    public void save(Voto entity) throws SQLException {
        try {
            this.connection =  ConnectionFactory.getInstancia().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("insert into voto (cd_eleitor,")
                    .append(" cd_candidato, dt_voto)")
                    .append("values(?, ?, ?);");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigoEleitor());
            pstm.setInt(2, entity.getCodigoCandidato());

            pstm.setDate(3, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir voto");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Erro inesperado ao Inserir voto");
            ex.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public List<Voto> getAll() throws SQLException {
        List<Voto> votoList = null;
        Voto voto = null;
        try {
            this.connection =  ConnectionFactory.getInstancia().getConnection();
            String sql = "select * from voto";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            votoList = new ArrayList<>();
            while (rs.next()) {
                voto = new Voto();
                voto.setCodigoEleitor(rs.getInt("cd_eleitor"));
                voto.setCodigoCandidato(rs.getInt("cd_candidato"));
                voto.setData(rs.getDate("dt_voto"));
                votoList.add(voto);
            }
            pstm.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar todos os votos"
                    + "", "ERRO", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
        return votoList;
    }

}
