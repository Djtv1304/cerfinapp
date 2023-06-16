package com.cerfinapp.models.dao;

import com.cerfinapp.models.entity.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<Persona,Long> {

}
