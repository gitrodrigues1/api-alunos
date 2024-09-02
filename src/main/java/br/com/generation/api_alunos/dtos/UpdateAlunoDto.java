package br.com.generation.api_alunos.dtos;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAlunoDto {
    
    private String nome;
    private Integer idade;
    private LocalDate dataNascimento;
}
