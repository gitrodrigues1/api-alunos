package br.com.generation.api_alunos.dtos;

import java.time.LocalDate;

import br.com.generation.api_alunos.entitites.Turma;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAlunoDto {

    private String nome;
    private Integer idade;
    private LocalDate dataNascimento;
    private Turma turma;
}
