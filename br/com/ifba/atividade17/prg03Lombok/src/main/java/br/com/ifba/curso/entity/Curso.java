package br.com.ifba.curso.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



 //Representa a entidade Curso mapeada para o banco de dados.
 
// essa classe aqui herda de PersistenceEntity, que já define o ID da entidade.
@Entity
@Table(name = "curso")
@Getter  // gera automaticamente getters para todos os atributos
@Setter //gera automaticamente setters para todos os atributos
@NoArgsConstructor //gera o construtor sem argumentos exigido pelo JPA.
@AllArgsConstructor //gera um construtor com argumentos para todos os campos declarados nesta classe 
public class Curso extends PersistenceEntity{

    private String nome; 
    private String codigo; 
    
}