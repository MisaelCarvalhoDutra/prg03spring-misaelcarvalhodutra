package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import java.util.List;

//Interface responsável por definir o contrato da camada Controller para a entidade Curso.
public interface CursoIController {

    //salva um novo Curso no sistema.
    Curso save(Curso curso);

    //atualiza um Curso existente, ou seja, edita um curso
    Curso update(Curso curso);

    //exclui um curso selecionado
    void delete(Curso curso);

    //aqui é opra retornar  todos os cursos cadastrados
    List<Curso> findAll();
    
    //busca um curso pelo codigo
    Curso findByCodigo(String codigo);

    //busca um curso por id
    Curso findById(Long id);

    //busca um curso por nome
    Curso findByName(String name);
}
