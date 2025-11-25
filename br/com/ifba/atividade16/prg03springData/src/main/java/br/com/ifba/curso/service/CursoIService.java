package br.com.ifba.curso.service;

import br.com.ifba.curso.entity.Curso;
import java.util.List;

// Interface de Service: define as regras de negócio que devem ser implementadas
public interface CursoIService {

    Curso save(Curso curso);

    Curso update(Curso curso);

    void delete(Curso curso);

    List<Curso> findAll();

    Curso findByCodigo(String codigo);
    
    Curso findById(Long id);

    Curso findByName(String name);
}

