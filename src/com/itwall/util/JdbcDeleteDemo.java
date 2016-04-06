package com.itwall.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JdbcDeleteDemo {

    public static void main(String[] args) {

        try {
            Connection conn = ConnMySql.obtener();
            String sql = "DELETE FROM tb_persona_proyecto WHERE id_persona=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, 3);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A user was deleted successfully!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JdbcDeleteDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
