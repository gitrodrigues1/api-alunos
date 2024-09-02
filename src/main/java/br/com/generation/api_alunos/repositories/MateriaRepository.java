package br.com.generation.api_alunos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.generation.api_alunos.entitites.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long>{

}
