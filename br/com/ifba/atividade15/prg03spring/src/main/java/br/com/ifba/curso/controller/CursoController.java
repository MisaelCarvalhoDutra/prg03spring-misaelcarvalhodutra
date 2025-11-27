package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoIService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Controller;

// Camada Controller, que faz a comunicação entre a camada View e a camada Service
@Controller
public class CursoController implements CursoIController {

    // Injeta o Service, onde ficam as regras de negócio.
    @Autowired
    private CursoIService service;

    @Override
    public Curso save(Curso curso) {
        return service.save(curso);
    }

    @Override
    public Curso update(Curso curso) {
        return service.update(curso);
    }

    @Override
    public void delete(Curso curso) {
        service.delete(curso);
    }

    @Override
    public List<Curso> findAll() {
        return service.findAll();
    }

    @Override
    public Curso findById(Long id) {
        return service.findById(id);
    }

    @Override
    public Curso findByCodigo(String codigo) {
        return service.findByCodigo(codigo);
    }

    @Override
    public Curso findByName(String name) {
        return service.findByName(name);
    }
}
