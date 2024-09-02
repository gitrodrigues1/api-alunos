package br.com.generation.api_alunos.entitites;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Avaliacao {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Aluno aluno;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Materia materia;
    
    private Integer anoLetivo;

    @Enumerated(EnumType.STRING)
    private AvaliacaoType avaliacao;
    private Float nota;

}
