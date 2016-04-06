package com.itwall.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcSelectDemo {

    public static void main(String[] args) {

        try {
            
            Connection conn = ConnMySql.obtener();
            String query = "SELECT * FROM tb_persona_proyecto";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                 int id_persona = rs.getInt(1);
                 String p_nombre = rs.getString("p_nombre");
                 String direccion = rs.getString("direccion");
                 Integer num_telefono = rs.getInt("num_telefono");

               System.out.format(" id_persona = %s, %s, %s, %s\n", id_persona, p_nombre, direccion, num_telefono);
            }

            ConnMySql.cerrar();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JdbcSelectDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
