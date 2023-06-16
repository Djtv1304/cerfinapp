package com.cerfinapp.models.services;

import com.cerfinapp.models.entity.Persona;

import java.util.List;

public interface PersonaService {

    public List<Persona> findAll();

    public Persona findById(Long id);

    public Persona save(Persona persona);

    public void delete(Long id);

}
