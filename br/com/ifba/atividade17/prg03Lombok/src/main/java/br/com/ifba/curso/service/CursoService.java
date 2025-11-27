package br.com.ifba.curso.service;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.repository.CursoRepository;
import br.com.ifba.infrastructure.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

//Aqui são realizadas validações 
//a Regra de negocio
@Slf4j //habilita o uso do logger (log.info, log.warn, log.error...), permitindo registrar informações importantes durante a execução
@Service
public class CursoService implements CursoIService {

    @Autowired 
    private CursoRepository repository; //injeção de dependência, Acesso ao banco via Spring Data
    //isso reduz o acoplamento, deixa o código mais limpo

    
    
     // Salva um novo curso no sistema.
     // só q antes de salvar, aplica validações.
    @Override
    public Curso save(Curso curso) {
        
        log.info("Iniciando processo de salvar curso: {}", curso);

         //faz a verificação se o objeto curso é nulo
        if (curso == null) {
            log.error("Tentativa de salvar um curso nulo.");
            throw new RuntimeException("Curso não pode ser nulo!");
        }

        // esse verifica se o nome está vazio ou nulo usando StringUtil
        if (StringUtil.isNullOrEmpty(curso.getNome())) {
            log.warn("Nome do curso está vazio.");
            throw new RuntimeException("O nome do curso não pode ser vazio!");
        }

        // esse aqui verifica q não pode existir outro curso com o mesmo nome
        if (repository.findByNome(curso.getNome()) != null) {
            log.warn("Curso com nome já existente: {}", curso.getNome());
            throw new RuntimeException("Já existe um curso com esse nome!");
        }
        
        if (repository.findByCodigo(curso.getCodigo()) != null) {
            log.warn("Curso com código já existente: {}", curso.getCodigo());
            throw new RuntimeException("Já existe um curso com esse código!");
        }


        //se depois de tudo isso estiver certo, salva o curso
        log.info("Curso salvo com sucesso!");
        return repository.save(curso);
    }

    
    
     //edita ou melhor, atualiza um curso existente.
     //e aplica validações antes de atualizar.
    @Override
    public Curso update(Curso curso) {
        
        log.info("Iniciando atualização do curso: {}", curso);

    if (curso == null) {
        log.error("Tentativa de atualizar curso nulo.");
        throw new RuntimeException("Curso não pode ser nulo!");
    }

    if (curso.getId() == null) {
        log.error("ID ausente ao tentar atualizar o curso.");
        throw new RuntimeException("ID do curso é obrigatório para atualizar.");
    }

    if (StringUtil.isNullOrEmpty(curso.getNome())) {
        log.warn("Nome do curso vazio ao tentar atualizar.");
        throw new RuntimeException("O nome do curso não pode ser vazio!");
    }

    // Verifica se já existe outro curso com o mesmo nome
    Curso cursoNome = repository.findByNome(curso.getNome());
    if (cursoNome != null && !cursoNome.getId().equals(curso.getId())) {
        log.warn("Tentativa de atualizar com nome duplicado: {}", curso.getNome());
        throw new RuntimeException("Já existe outro curso com esse nome!");
    }

    // Verifica se já existe outro curso com o mesmo código
    Curso cursoCodigo = repository.findByCodigo(curso.getCodigo());
    if (cursoCodigo != null && !cursoCodigo.getId().equals(curso.getId())) {
         log.warn("Tentativa de atualizar com código duplicado: {}", curso.getCodigo());
        throw new RuntimeException("Já existe outro curso com esse código!");
    }

    log.info("Curso atualizado com sucesso!");
    return repository.save(curso);  //update automático no Spring Data
    }

    //esse deleta um curso.
     //mas igualmente aplica validações antes de excluir.
    @Override
    public void delete(Curso curso) {
        
        log.info("Tentando excluir curso: {}", curso);

        if (curso == null) {
            log.error("Tentativa de exclusão de curso nulo.");
            throw new RuntimeException("Curso não pode ser nulo!");
        }

        if (curso.getId() == null) {
            log.error("Tentativa de exclusão sem ID.");
            throw new RuntimeException("ID é obrigatório para deletar.");
        }

        repository.delete(curso);
        log.info("Curso excluído com sucesso!");
    }

    @Override
    public List<Curso> findAll() { //lista todos os cursos cadastrados.
        log.info("Listando todos os cursos.");
        return repository.findAll();
    }

    @Override
    public Curso findById(Long id) { //busca um curso pelo ID, e com validação.

        log.info("Buscando curso por ID: {}", id);
        
        if (id == null) {
            log.error("ID nulo ao buscar curso.");
            throw new RuntimeException("ID não pode ser nulo!");
        }

        return repository.findById(id).orElse(null);
    }

    @Override
    public Curso findByName(String name) { //busca curso pelo nome
        
        log.info("Buscando curso por nome: {}", name);

        if (StringUtil.isNullOrEmpty(name)) {
            log.warn("Nome vazio ao buscar curso.");
            throw new RuntimeException("Nome não pode ser vazio!");
        }

        return repository.findByNome(name);
    }

    @Override
    public Curso findByCodigo(String codigo) {
        
        log.info("Buscando curso por código: {}", codigo);

        if (StringUtil.isNullOrEmpty(codigo)) {
            log.warn("Código vazio ao buscar curso.");
            throw new RuntimeException("Código não pode ser vazio!");
        }

        return repository.findByCodigo(codigo);
    }
}
