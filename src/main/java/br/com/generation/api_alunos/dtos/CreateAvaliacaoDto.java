package br.com.generation.api_alunos.dtos;

import br.com.generation.api_alunos.entitites.AvaliacaoType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAvaliacaoDto {
    
    private Long aluno;

    private Long materia;
    
    private Integer anoLetivo;
    private AvaliacaoType avaliacao;
    private Float nota;
}
