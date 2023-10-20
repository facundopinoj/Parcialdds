package com.utn.parcialdds.repositories;

import com.utn.parcialdds.entities.Autor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends BaseRepository<Autor,Long>{

    //Query JPQL parametros indexados
    @Query(value = "SELECT a FROM Autor a WHERE a.nombre LIKE %:filtro% OR a.apellido LIKE %:filtro% ")
    List<Autor> searchAutor(@Param("filtro") String filtro);

    //PAGINACION

    @Query(value = "SELECT a FROM Autor a WHERE a.nombre LIKE %:filtro% OR a.apellido LIKE %:filtro% ")
    Page<Autor> searchAutorPaged(@Param("filtro")String filtro, Pageable pageable);


}
