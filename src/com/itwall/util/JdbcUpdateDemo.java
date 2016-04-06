package com.itwall.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A sample program that demonstrates how to execute SQL UPDATE statement using
 * JDBC.
 *
 * @author www.codejava.net
 *
 */
public class JdbcUpdateDemo {

    public static void main(String[] args) {

        try {
            Connection conn = ConnMySql.obtener();
            String sql = "UPDATE tb_persona_proyecto SET p_nombre=?, direccion=?, num_telefono=?, email=? where id_persona=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "NuevoNombre");
            statement.setString(2, "NuevaDireccion");
            statement.setInt(3, 34567);
            statement.setString(4, "nuevo@host.org");
            statement.setInt(5, 1);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JdbcUpdateDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
