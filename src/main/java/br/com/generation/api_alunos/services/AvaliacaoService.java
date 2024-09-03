package br.com.generation.api_alunos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.generation.api_alunos.dtos.CreateAvaliacaoDto;
import br.com.generation.api_alunos.entitites.Avaliacao;
import br.com.generation.api_alunos.entitites.AvaliacaoType;
import br.com.generation.api_alunos.exceptions.AvaliacaoAlreadyExistsException;
import br.com.generation.api_alunos.exceptions.AvaliacaoNotFoundException;
import br.com.generation.api_alunos.repositories.AlunoRepository;
import br.com.generation.api_alunos.repositories.AvaliacaoRepository;
import br.com.generation.api_alunos.repositories.MateriaRepository;

@Service
public class AvaliacaoService {
    
    private AvaliacaoRepository avaliacaoRepository;
    private AlunoRepository alunoRepository;
    private MateriaRepository materiaRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository, AlunoRepository alunoRepository,
            MateriaRepository materiaRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
        this.alunoRepository = alunoRepository;
        this.materiaRepository = materiaRepository;
    }

    public Avaliacao inserirAvaliacao(CreateAvaliacaoDto dto) throws AvaliacaoAlreadyExistsException {
        boolean existsAvaliacao = avaliacaoRepository.existsByAlunoIdAndAvaliacaoAndMateriaIdAndAnoLetivo(
                dto.getAluno(), 
                dto.getAvaliacao(),
                dto.getMateria(),
                dto.getAnoLetivo());

        if(existsAvaliacao) {
            throw new AvaliacaoAlreadyExistsException("Avaliação já cadastrada!");
        }

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setAluno(alunoRepository.findById(dto.getAluno()).get());
        avaliacao.setMateria(materiaRepository.findById(dto.getMateria()).get());
        avaliacao.setAvaliacao(AvaliacaoType.AV1);
        if(dto != null) avaliacao.setAnoLetivo(dto.getAnoLetivo());
        if(dto != null) avaliacao.setNota(dto.getNota());
        avaliacaoRepository.save(avaliacao);

        return avaliacao;
    }

    public List<Avaliacao> obterAvaliacoes() {
        return avaliacaoRepository.findAll();
    }

    public Avaliacao obterAvaliacaoPorId(Long id) throws AvaliacaoNotFoundException {
      return avaliacaoRepository.findById(id)
        .orElseThrow(() -> new AvaliacaoNotFoundException("Avaliacao não encontrada"));
    }
}
