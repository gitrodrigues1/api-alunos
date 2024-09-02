package br.com.generation.api_alunos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.generation.api_alunos.entitites.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
