package br.com.ifba.infrastructure.entity;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


@Getter // gera automaticamente getters para todos os atributos
@Setter //gera automaticamente setters  para todos atributos
@MappedSuperclass //anotação do JPA,indica que a classe não será diretamente mapeada para uma tabela
//mas suas propriedades serão herdadas por outras classes (reuso)

public abstract class PersistenceEntity { 

    @Id //marca o campo como chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)//gera automatico o ID pelo banco de dados.
    private Long id;
    
}
