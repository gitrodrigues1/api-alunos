package br.com.generation.api_alunos.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.generation.api_alunos.entitites.Turma;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateAlunoDto {

    private String nome;
    private Integer idade;
    private LocalDate dataNascimento;
    private Turma turma;
}
