package com.utn.parcialdds.controllers;

import com.utn.parcialdds.entities.Persona;
import com.utn.parcialdds.services.PersonaServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path ="api/v1/personas") // Ejemplos: http://localhost:8080/api/v1/personas
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl>{

    @GetMapping("/search") // Ejemplos: http://localhost:8080/api/v1/personas/search?filtro=Pedro
    public ResponseEntity<?> searchPersona(@RequestParam String filtro){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchPersona(filtro));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" +e.getMessage() + "\"}"));
        }
    }

    //PAGINACION
    @GetMapping("/searchPaged") // Ejemplos: http://localhost:8080/api/v1/personas/searchPaged?filtro=Tomas&page=0&size=5&sort=id,asc
    public ResponseEntity<?> searchPersonaPaged(@RequestParam String filtro, Pageable pageable){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchPersonaPaged(filtro, pageable));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" +e.getMessage() + "\"}"));
        }
    }

}
