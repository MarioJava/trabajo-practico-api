package service;

import com.itwall.model.PersonaDTO;
import com.itwall.service.PersonaService;
import com.itwall.service.impl.PersonaServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by maliaga on 23-03-16.
 */
public class PersonaServiceTest {

    private PersonaService personaService;

    @Before
    public void setUp() {
        personaService = new PersonaServiceImpl();
    }

    @Test
    public void deberiaListarTodaslasPersonas() {

        Assert.assertNotNull(personaService.findAll());

        for (PersonaDTO personaDTO : personaService.findAll()) {
            System.out.println(personaDTO.toString());
        }
    }

    @Test
    public void deberiaListarUnaPersonaPorID() {

        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setIdPersona(1);

        Assert.assertNotNull(personaService.findById(personaDTO));

        System.out.println(personaDTO.toString());
    }

    @Test
    public void deberiaCrearUnaPersona() {

        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setpNumTelefono(24353533);
        personaDTO.setpDireccion("Direccion");
        personaDTO.setpImail("email@email");
        personaDTO.setpNombre("NOmbre");

        Assert.assertEquals(new Integer(1),personaService.createPersona(personaDTO));

    }

    @Test
    public void deberiaEliminarUnaPersona() {

        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setIdPersona(33);

        Assert.assertEquals(new Integer(1),personaService.deleteById(personaDTO));

    }

    @Test
    public void deberiaActualizarUnaPersona() {

        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setIdPersona(10);
        personaDTO.setpDireccion("Nueva Direccion");
        personaDTO.setpImail("nuevo@email.com");
        personaDTO.setpNombre("nuevoNombre");
        personaDTO.setpNumTelefono(23456788);

        Assert.assertEquals(new Integer(1),personaService.updateById(personaDTO));

    }
}
