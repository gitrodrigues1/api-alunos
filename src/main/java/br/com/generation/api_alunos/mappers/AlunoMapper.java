package br.com.generation.api_alunos.mappers;

import org.mapstruct.Mapper;

import br.com.generation.api_alunos.dtos.CreateAlunoDto;
import br.com.generation.api_alunos.entitites.Aluno;

@Mapper(componentModel = "spring")
public interface AlunoMapper {
    
    Aluno map(CreateAlunoDto createAlunoDto);
    CreateAlunoDto map(Aluno aluno);
}
