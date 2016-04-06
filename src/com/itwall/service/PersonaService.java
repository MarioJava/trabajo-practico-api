/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itwall.service;

import com.itwall.model.PersonaDTO;

import java.util.List;

/**
 *
 * @author administrador
 */
public interface PersonaService {

    PersonaDTO findById(PersonaDTO personaDTO);
    List<PersonaDTO> findAll();
    Integer deleteById(PersonaDTO per);
    Integer updateById(PersonaDTO personaDTO);
    Integer createPersona(PersonaDTO personaDTO);
}
