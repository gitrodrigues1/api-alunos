package br.com.generation.api_alunos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.generation.api_alunos.dtos.CreateAlunoDto;
import br.com.generation.api_alunos.entitites.Aluno;

@Mapper(componentModel = "spring")
public interface AlunoMapper {
    
    @Mapping(target = "avaliacoes", ignore = true)
    @Mapping(target = "id", ignore = true)
    Aluno map(CreateAlunoDto createAlunoDto);
    
    CreateAlunoDto map(Aluno aluno);
}
