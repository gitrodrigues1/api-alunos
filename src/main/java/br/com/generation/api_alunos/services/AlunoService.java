package br.com.generation.api_alunos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.generation.api_alunos.dtos.CreateAlunoDto;
import br.com.generation.api_alunos.dtos.UpdateAlunoDto;
import br.com.generation.api_alunos.entitites.Aluno;
import br.com.generation.api_alunos.entitites.Turma;
import br.com.generation.api_alunos.exceptions.AlunoAlreadyExistsException;
import br.com.generation.api_alunos.exceptions.AlunoNotFoundException;
import br.com.generation.api_alunos.exceptions.TurmaNotFoundException;
import br.com.generation.api_alunos.mappers.AlunoMapper;
import br.com.generation.api_alunos.repositories.AlunoRepository;
import br.com.generation.api_alunos.repositories.TurmaRepository;

@Service
public class AlunoService {
    
    private final AlunoRepository alunoRepository;
    private final TurmaRepository turmaRepository;
    private AlunoMapper mapper;
    
    public AlunoService(AlunoRepository alunoRepository, TurmaRepository turmaRepository, AlunoMapper mapper) {
        this.alunoRepository = alunoRepository;
        this.turmaRepository = turmaRepository;
        this.mapper = mapper;
    }

    public CreateAlunoDto createAluno(CreateAlunoDto dto) throws AlunoAlreadyExistsException {
        Aluno aluno = alunoRepository.findByNome(dto.getNome());
        if(aluno != null && aluno.getDataNascimento() == dto.getDataNascimento()){
           throw new AlunoAlreadyExistsException("Aluno já existe");
        }
        aluno = new Aluno(dto.getNome(), dto.getIdade(), dto.getDataNascimento());
        
        CreateAlunoDto response = mapper.map(alunoRepository.save(aluno));
        return response;
    }

    public CreateAlunoDto addTurma(Long alunoId, Long turmaId) throws AlunoNotFoundException, TurmaNotFoundException {
        Aluno aluno = alunoRepository.findById(alunoId)
            .orElseThrow(() -> new AlunoNotFoundException("Aluno não encontrado"));

        Turma turma = turmaRepository.findById(turmaId)
                .orElseThrow(() -> new TurmaNotFoundException("Turma não encontrada"));

        aluno.setTurma(turma);

        CreateAlunoDto response = mapper.map(alunoRepository.save(aluno));
        return response;

    }

    public Aluno updateAluno(UpdateAlunoDto dto) throws AlunoNotFoundException {
        Aluno alunoDb = alunoRepository.findByNome(dto.getNome());
        
        if(alunoDb == null) 
            throw new AlunoNotFoundException("Aluno não encontrado");
        
        if(dto.getIdade() != null) alunoDb.setIdade(dto.getIdade());
        if(dto.getDataNascimento() != null) alunoDb.setDataNascimento(dto.getDataNascimento());
        alunoRepository.save(alunoDb);
        
        return alunoDb;
    }

    public Aluno getAlunoById(Long id) throws AlunoNotFoundException {
        return alunoRepository.findById(id)
            .orElseThrow(() -> new AlunoNotFoundException("Aluno não encontrado"));
    }

    public List<Aluno> getAlunos() {
        return alunoRepository.findAll();
    }

    public void deleteById(Long id) throws AlunoNotFoundException {
        if (!alunoRepository.existsById(id)) {
            throw new AlunoNotFoundException("Aluno não encontrado.");
        }
        alunoRepository.deleteById(id);
    }
}
