package com.itwall.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcInsertDemo {

	public static void main(String[] args) {

		try  {
			Connection conn = ConnMySql.obtener();
			String sql = "INSERT INTO tb_persona_proyecto (p_nombre, direccion, num_telefono) VALUES (?, ?, ?)";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "NombreTest");
			statement.setString(2, "DireccionTest");
			statement.setInt(3, 1234567);
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new user was inserted successfully!");
			}

			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {		
                Logger.getLogger(JdbcInsertDemo.class.getName()).log(Level.SEVERE, null, ex);
            }		
	}
}