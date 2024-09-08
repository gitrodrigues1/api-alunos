package br.com.generation.api_alunos.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.generation.api_alunos.dtos.CreateAlunoDto;
import br.com.generation.api_alunos.dtos.UpdateAlunoDto;
import br.com.generation.api_alunos.entitites.Aluno;
import br.com.generation.api_alunos.exceptions.AlunoAlreadyExistsException;
import br.com.generation.api_alunos.exceptions.AlunoNotFoundException;
import br.com.generation.api_alunos.exceptions.TurmaNotFoundException;
import br.com.generation.api_alunos.services.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/alunos")
@Tag(name = "Aluno Controller", description = "API para cadastro de alunos.")
public class AlunoController {
    
    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    @Operation(summary = "Criar aluno", description = "Cadastra um novo aluno")
    public CreateAlunoDto createAluno(@RequestBody CreateAlunoDto aluno) throws AlunoAlreadyExistsException {
        return alunoService.createAluno(aluno);
    }

    @PostMapping("/{alunoId}/{turmaId}")
    @Operation(summary = "Adicionar turma", description = "Adiciona uma nova turma a um aluno")
    public CreateAlunoDto addTurma(@PathVariable Long alunoId, @PathVariable Long turmaId) throws AlunoNotFoundException, TurmaNotFoundException {
        return alunoService.addTurma(alunoId, turmaId);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar aluno", description = "Atualiza os dados de um aluno")
    public Aluno updateAluno(@PathVariable Long id, @RequestBody UpdateAlunoDto aluno) throws AlunoNotFoundException {
        return alunoService.updateAluno(aluno);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter aluno", description = "Obtem um aluno através do seu id")
    public Aluno getAlunoById(@PathVariable Long id) throws AlunoNotFoundException {
        return alunoService.getAlunoById(id);
    }

    @GetMapping
    @Operation(summary = "Obter alunos", description = "Obtem a listagem de alunos")
    public ResponseEntity<List<Aluno>> getAlunos() {
        return ResponseEntity.ok().body(alunoService.getAlunos());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover aluno", description = "Deleta um aluno através do seu id.")
    public ResponseEntity<Void> deleteAlunoById(@PathVariable Long id) throws AlunoNotFoundException {
        alunoService.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
