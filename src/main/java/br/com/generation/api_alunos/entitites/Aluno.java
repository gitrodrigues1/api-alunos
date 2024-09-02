package br.com.generation.api_alunos.entitites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Aluno {
    
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer idade;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @JsonIgnore
    @OneToMany(mappedBy = "aluno", fetch = FetchType.EAGER)
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;

    public Aluno(String nome, Integer idade, LocalDate dataNascimento) {
        
        this.nome = nome;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
    }

    
    
}
