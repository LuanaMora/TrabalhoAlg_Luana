/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urnaeletronica.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author TPSI-LUANA
 */
public class ConnectionFactory {

    private static ConnectionFactory instancia; //singleton

    public ConnectionFactory() {

    }

    public static synchronized ConnectionFactory getInstancia() {
        if (instancia == null) {
            instancia = new ConnectionFactory();
        }
        return instancia;
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/urnaeletronica",
                    "postgres", "admin");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar uma "
                    + "conexão com o banco de dados "
                    + ex.getMessage());
        }
        return null;
    }
}
