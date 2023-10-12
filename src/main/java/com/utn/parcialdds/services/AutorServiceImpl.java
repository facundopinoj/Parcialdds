package com.utn.parcialdds.services;

import com.utn.parcialdds.entities.Autor;
import com.utn.parcialdds.repositories.AutorRepository;
import com.utn.parcialdds.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl extends BaseServiceImpl<Autor, Long> implements AutorService{

    @Autowired
    private AutorRepository autorRepository;

    public AutorServiceImpl(BaseRepository<Autor, Long> baseRepository) {
        super(baseRepository);
    }


    @Override
    public List <Autor> searchAutor(String filtro) throws Exception{
        try{
            List<Autor> autores = autorRepository.searchAutor(filtro);
            return autores;
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //PAGINACION

    @Override
    public Page<Autor> searchAutorPaged(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Autor> autores = autorRepository.searchAutorPaged(filtro, pageable);
            return autores;
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
