package com.cerfinapp.controllers;

import com.cerfinapp.models.entity.Persona;
import com.cerfinapp.models.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"}) //Doy acceso al dominio de Angular mediante CORSE para que pueda recibir y enviar datos
@RestController
@RequestMapping("/api") //Mapeo todos los metodos de esta clase
public class PersonaRestController {

    @Autowired
    private PersonaService personaService; //Inyecto mi interfaz

    @GetMapping("/personas") //Mapeo la URL para generar el END_POINT a este método
    public List<Persona> listaPersonas() {
        //Uso mi clase service aquí
        return personaService.findAll();
    }

    @GetMapping("personas/{id}")
    public Persona showPersonaById(@PathVariable Long id) {
        return personaService.findById(id);
    }

    @PostMapping("/personas")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona createPersona(@RequestBody Persona personaNueva) { //Como la persona viene en formato JSON debo usar la notacion RequestBody para transformar ese JSON en un objeto
        return personaService.save(personaNueva);
    }

    @PutMapping("/personas/{id}")
    @ResponseStatus(HttpStatus.CREATED) //Devuelve un 201
    public Persona actualizarPersonaById(@RequestBody Persona personaNueva,@PathVariable Long id) { //Como la persona viene en formato JSON debo usar la notacion RequestBody para transformar ese JSON en un objeto
        Persona personaActual = personaService.findById(id);
        //Reemplazo los antiguos datos, con los nuevos
        personaActual.setNombre(personaNueva.getNombre());
        personaActual.setApellido(personaNueva.getApellido());
        personaActual.setCedula(personaNueva.getCedula());
        personaActual.setCorreo(personaNueva.getCorreo());
        personaActual.setGenero(personaNueva.getGenero());
        personaActual.setDiaNacimiento(personaNueva.getDiaNacimiento());
        personaActual.setMesNacimiento(personaNueva.getMesNacimiento());
        personaActual.setAnioNacimiento(personaNueva.getAnioNacimiento());

        return personaService.save(personaActual); //Retorno la nueva persona, ya que el .save hace un merge de los datos
    }

    @DeleteMapping("/personas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePersonaById(@PathVariable Long id) {
        personaService.delete(id);
    }

}
