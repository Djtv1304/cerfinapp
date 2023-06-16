package com.cerfinapp.models.services;

import com.cerfinapp.models.dao.PersonaDao;
import com.cerfinapp.models.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //Clase marcada como un componente de servicio
public class PersonaServiceImplementation implements PersonaService {

    //Inyecto las dependencias del package DAO
    @Autowired
    private PersonaDao personaDao;

    @Override
    @Transactional(readOnly = true) //Debo utilizar esto en mis metodos personalizados
    public List<Persona> findAll() {
        return (List<Persona>) personaDao.findAll(); //Retorna una lista
    }

    @Override
    @Transactional(readOnly = true)
    public Persona findById(Long id) {
        return personaDao.findById(id).orElse(null); //Si encuentra, retorna la persona, si no retorna NULL
    }

    @Override
    @Transactional //Transactional Completo
    public Persona save(Persona persona) {
        return personaDao.save(persona);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        personaDao.deleteById(id); //Elimina con base en la entidad Cliente
    }
}
