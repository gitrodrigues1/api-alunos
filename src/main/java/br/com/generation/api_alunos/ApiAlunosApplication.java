package br.com.generation.api_alunos;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.generation.api_alunos.entitites.Materia;
import br.com.generation.api_alunos.entitites.Professor;
import br.com.generation.api_alunos.entitites.Turma;
import br.com.generation.api_alunos.repositories.MateriaRepository;
import br.com.generation.api_alunos.repositories.ProfessorRepository;
import br.com.generation.api_alunos.repositories.TurmaRepository;

@SpringBootApplication
public class ApiAlunosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAlunosApplication.class, args);
	}

	// @Bean
	// CommandLineRunner commandLineRunner(
	// 	TurmaRepository turmas, 
	// 	ProfessorRepository professores, 
	// 	MateriaRepository materias) {
	// 	return args -> {
	// 		Materia matematica = new Materia(null, "Matemática", null);
	// 		Materia portugues = new Materia(null, "Português", null);
	// 		Materia historia = new Materia(null, "História", null);
	// 		materias.saveAll(List.of(matematica, portugues, historia));

	// 		professores.save(new Professor(null,"Joao da Silva", List.of(matematica)));
	// 		professores.save(new Professor(null,"Lucas Alves", List.of(matematica)));
	// 		professores.save(new Professor(null,"Jose Rodrigues", List.of(portugues, historia)));

	// 		Turma fundamental7 = new Turma(null, "Fundamental 7", "2024");
	// 		Turma fundamental8 = new Turma(null, "Fundamental 8", "2024");
	// 		Turma fundamental9 = new Turma(null, "Fundamental 9", "2024");
	// 		turmas.saveAll(List.of(fundamental7, fundamental8, fundamental9));

	// 	};
	// }

}
