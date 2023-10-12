package com.utn.parcialdds.controllers;

import com.utn.parcialdds.entities.Autor;
import com.utn.parcialdds.services.AutorServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/autores") // Ejemplos: http://localhost:8080/api/v1/autores
public class AutorController extends BaseControllerImpl<Autor, AutorServiceImpl> {

    @GetMapping("/search") // Ejemplos: http://localhost:8080/api/v1/autores/search?filtro=e
    public ResponseEntity<?> searchAutor(@RequestParam String filtro){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchAutor(filtro));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" +e.getMessage() + "\"}"));
        }
    }

    //PAGINACION

    @GetMapping("/searchPaged") // Ejemplos: http://localhost:8080/api/v1/autores/searchPaged?filtro=Erica&page=0&size=5&sort=id,asc
    public ResponseEntity<?> searchAutorPaged(@RequestParam String filtro, Pageable pageable){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchAutorPaged(filtro, pageable));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" +e.getMessage() + "\"}"));
        }
    }

}
