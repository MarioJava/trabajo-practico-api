package com.itwall.util;

import com.mysql.jdbc.Connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnMySql {

    static String driver;
    static String url;
    static String user;
    static String password;

    static {
      //  try {
            //Properties propiedades = new Properties();
            //propiedades.load(ConnMySql.class.getResourceAsStream("/properties/data.properties"));

             driver = "com.mysql.jdbc.Driver"; //propiedades.getProperty("driver");
             url = "jdbc:mysql://192.168.1.137/itwall";// propiedades.getProperty("url");
             user = "root"; //propiedades.getProperty("user");
             password = "admin123"; //propiedades.getProperty("password");
             
      //  } catch (IOException ex) {
        //    Logger.getLogger(ConnMySql.class.getName()).log(Level.SEVERE, null, ex);
       // }
    }

    private static Connection cnx = null;

    public static Connection obtener() throws SQLException, ClassNotFoundException {

        if (cnx == null) {
            try {
                Class.forName(driver);
                cnx = (Connection) DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                throw new SQLException(ex);
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
            }
        }
        return cnx;
    }

    public static void cerrar() throws SQLException {
        if (cnx != null) {
            cnx.close();
        }
    }

}
