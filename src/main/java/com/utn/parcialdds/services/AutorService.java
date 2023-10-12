package com.utn.parcialdds.services;

import com.utn.parcialdds.entities.Autor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AutorService extends BaseService<Autor, Long>{

    List<Autor> searchAutor(String filtro) throws Exception;

    //PAGINACION

    Page<Autor> searchAutorPaged(String filtro, Pageable pageable) throws Exception;
}
