package br.com.generation.api_alunos.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.generation.api_alunos.dtos.CreateAvaliacaoDto;
import br.com.generation.api_alunos.entitites.Avaliacao;
import br.com.generation.api_alunos.exceptions.AvaliacaoAlreadyExistsException;
import br.com.generation.api_alunos.exceptions.AvaliacaoNotFoundException;
import br.com.generation.api_alunos.services.AvaliacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/avaliacao")
@Tag(name = "Avaliacao Controller", description = "API para inclusões de avaliação dos alunos.")
public class AvaliacaoController {
    
    private AvaliacaoService avaliacaoService;

    public AvaliacaoController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @PostMapping
    @Operation(summary = "Inserir avaliação", description = "Insere uma avaliação referente a um aluno.")
    public ResponseEntity<Avaliacao> inserirAvaliacao(@RequestBody CreateAvaliacaoDto dto) throws AvaliacaoAlreadyExistsException {
        Avaliacao avaliacao = avaliacaoService.inserirAvaliacao(dto);
        return ResponseEntity.ok().body(avaliacao);
    }

    @GetMapping
    @Operation(summary = "Obter avaliações", description = "Obtem a listagem de avaliações de alunos.")
    public ResponseEntity<List<Avaliacao>> obterAvaliacoes() {
        List<Avaliacao> avaliacoes = avaliacaoService.obterAvaliacoes();
        return ResponseEntity.ok().body(avaliacoes);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter avalição por id", description = "Obtem a avaliação de um aluno através de sua identificação.")
    public ResponseEntity<Avaliacao> obterAvaliacaoPorId(@PathVariable Long id) throws AvaliacaoNotFoundException {
        Avaliacao avaliacao = avaliacaoService.obterAvaliacaoPorId(id);
        return ResponseEntity.ok().body(avaliacao);
    }

}
