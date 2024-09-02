package br.com.generation.api_alunos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.generation.api_alunos.entitites.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    boolean existsByNome(String nome);
    Aluno findByNome(String nome);
}
