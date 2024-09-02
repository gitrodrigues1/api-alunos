package br.com.generation.api_alunos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.generation.api_alunos.entitites.Aluno;
import br.com.generation.api_alunos.entitites.Avaliacao;
import br.com.generation.api_alunos.entitites.AvaliacaoType;
import br.com.generation.api_alunos.entitites.Materia;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{
    boolean existsByAlunoIdAndAvaliacaoAndMateriaIdAndAnoLetivo(Long aluno, AvaliacaoType avaliacao,Long materia, Integer anoLetivo);
    Avaliacao findByAlunoAndMateriaAndAnoLetivo(Aluno aluno, Materia materia, Integer anoLetivo);
}
