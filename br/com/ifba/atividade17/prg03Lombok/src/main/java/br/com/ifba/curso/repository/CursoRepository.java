package br.com.ifba.curso.repository;

import br.com.ifba.curso.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    //Esta interface herda de JpaRepository, que já fornece  métodos prontos para operações no banco de dados

    //método de consulta específico para buscar cursos por nome
    Curso findByNome(String nome);

    //método de consulta especifico que vai buscar cursos pelo código
    Curso findByCodigo(String codigo);
}
