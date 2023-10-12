package com.utn.parcialdds.repositories;

import com.utn.parcialdds.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {

    //Query JPQL parametros indexados ? - 1// nombrados
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro% ")
    List<Persona> searchPersona(@Param("filtro")String filtro);


    //Metodo de Query
    // List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    //boolean existByDni(int dni); comprobar si existe o no una persona

    //Queries Nativas

    //@Query(value = "SELECT * FROM Persona WHERE Persona.nombre LIKE %:filtro% OR Persona.apellido LIKE %:filtro% ", nativeQuery = true)
    //List <Persona> searchPersonaNativa(@Param("filtro") String filtro);




    //PAGINACION

    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro% ")
    Page<Persona> searchPersonaPaged(@Param("filtro")String filtro, Pageable pageable);

    // M query Pageable
    //Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    //M query nativa Pageable
    // @Query(value = "SELECT * FROM Persona WHERE Persona.nombre LIKE %:filtro% OR Persona.apellido LIKE %:filtro% ", countQuery =  "SELECT count(*) FROM Persona", nativeQuery = true)
    // Page<Persona> searchPersonaNativaPageable(@Param("filtro") String filtro, Pageable pageable);


}
