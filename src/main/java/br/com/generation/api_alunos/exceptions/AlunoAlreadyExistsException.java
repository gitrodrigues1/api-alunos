package br.com.generation.api_alunos.exceptions;

public class AlunoAlreadyExistsException extends Exception {
    public AlunoAlreadyExistsException(String message) {
        super(message);
    }
}
