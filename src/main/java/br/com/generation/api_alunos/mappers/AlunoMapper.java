package br.com.generation.api_alunos.mappers;

import br.com.generation.api_alunos.dtos.CreateAlunoDto;
import br.com.generation.api_alunos.entitites.Aluno;

public class AlunoMapper {

    public Aluno toModel(CreateAlunoDto dto) {
        return Aluno.builder()
            .nome(dto.getNome())
            .idade(dto.getIdade())
            .dataNascimento(dto.getDataNascimento())
            .build();
    }

    public CreateAlunoDto toDto(Aluno aluno) {
        return CreateAlunoDto.builder()
            .nome(aluno.getNome())
            .idade(aluno.getIdade())
            .dataNascimento(aluno.getDataNascimento())
            .build();
    }
}
