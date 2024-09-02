package br.com.generation.api_alunos.entitites;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Materia {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "materia_nome")
    private String nome;

    @JsonIgnore
    @ManyToMany(mappedBy = "materias")
    private List<Professor> professores = new ArrayList<>();
}
