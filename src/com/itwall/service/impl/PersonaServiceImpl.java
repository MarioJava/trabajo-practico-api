/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itwall.service.impl;

import com.itwall.model.PersonaDTO;
import com.itwall.service.PersonaService;
import com.itwall.util.ConnMySql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author maliaga
 */
public class PersonaServiceImpl extends ConnMySql implements PersonaService {

    @Override
    public PersonaDTO findById(PersonaDTO personaDTO) {
        PersonaDTO per = new PersonaDTO();
        try {

            Connection conn = obtener();

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from tb_persona_proyecto "
                    + "where id_persona=" + personaDTO.getIdPersona());

            rs.next();
            per.setIdPersona(rs.getInt("id_persona"));
            per.setpNombre(rs.getString("p_nombre"));
            per.setpDireccion(rs.getString("direccion"));
            per.setpNumTelefono(rs.getInt("num_telefono"));
            per.setpImail(rs.getString("email"));


            return per;
        } catch (SQLException ex) {
            Logger.getLogger(PersonaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersonaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<PersonaDTO> findAll() {

        try {
            List<PersonaDTO> resp = new ArrayList<PersonaDTO>(0);
            Connection conn = obtener();

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from tb_persona_proyecto");

            while (rs.next()) {
                PersonaDTO per = new PersonaDTO();

                per.setIdPersona(rs.getInt("id_persona"));
                per.setpNombre(rs.getString("p_nombre"));
                per.setpDireccion(rs.getString("direccion"));
                per.setpNumTelefono(rs.getInt("num_telefono"));
                per.setpImail(rs.getString("email"));

                resp.add(per);
            }

            return resp;
        } catch (SQLException ex) {
            Logger.getLogger(PersonaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersonaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Integer deleteById(PersonaDTO per) {
        Integer resp = null;
        try {
            Connection conn = obtener();
            String sql = "DELETE FROM tb_persona_proyecto WHERE id_persona=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, per.getIdPersona());

            resp = statement.executeUpdate();

            if (resp > 0) {
                System.out.println("Persona eliminada con exito!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return resp;
    }

    @Override
    public Integer updateById(PersonaDTO personaDTO) {
        Integer resp = null;
        try {
            Connection conn = obtener();
            String sql = "UPDATE tb_persona_proyecto SET p_nombre=?, direccion=?, num_telefono=?, email=? where id_persona=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, personaDTO.getpNombre());
            statement.setString(2, personaDTO.getpDireccion());
            statement.setInt(3, personaDTO.getpNumTelefono());
            statement.setString(4, personaDTO.getpImail());
            statement.setInt(5, personaDTO.getIdPersona());

            resp = statement.executeUpdate();
            if (resp > 0) {
                System.out.println("Persona actualizada con exito!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return resp;
    }

    @Override
    public Integer createPersona(PersonaDTO personaDTO) {
        Integer resp = null;
        try {
            Connection conn = obtener();
            String sql = "INSERT INTO tb_persona_proyecto (p_nombre, direccion, num_telefono, email) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, personaDTO.getpNombre());
            statement.setString(2, personaDTO.getpDireccion());
            statement.setInt(3, personaDTO.getpNumTelefono());
            statement.setString(4, personaDTO.getpImail());

            resp = statement.executeUpdate();

            if (resp > 0) {
                System.out.println("Persona insertada con exito!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return resp;
    }

}
