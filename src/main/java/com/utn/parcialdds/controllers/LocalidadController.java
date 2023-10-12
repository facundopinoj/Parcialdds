package com.utn.parcialdds.controllers;

import com.utn.parcialdds.entities.Localidad;
import com.utn.parcialdds.services.LocalidadServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/localidades") // Ejemplos: http://localhost:8080/api/v1/localidades
public class LocalidadController extends BaseControllerImpl<Localidad, LocalidadServiceImpl>{

    @GetMapping("/search") // Ejemplos: http://localhost:8080/api/v1/localidades/search?filtro=Godoy
    public ResponseEntity<?> searchLocalidad(@RequestParam String filtro){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchLocalidad(filtro));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" +e.getMessage() + "\"}"));
        }
    }

    //PAGINACION

    @GetMapping("/searchPaged") // Ejemplos: http://localhost:8080/api/v1/localidades/searchPaged?filtro=Godoy&page=0&size=5&sort=id,asc
    public ResponseEntity<?> searchLocalidadPaged(@RequestParam String filtro, Pageable pageable){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchLocalidadPaged(filtro, pageable));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" +e.getMessage() + "\"}"));
        }
    }
}
