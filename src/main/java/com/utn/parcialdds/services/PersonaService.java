package com.utn.parcialdds.services;

import com.utn.parcialdds.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonaService extends BaseService<Persona,Long>{

    List<Persona> searchPersona(String filtro) throws Exception;

    //PAGINACION
    Page<Persona> searchPersonaPaged(String filtro, Pageable pageable) throws Exception;

}