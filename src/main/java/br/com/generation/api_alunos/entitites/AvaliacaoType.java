package br.com.generation.api_alunos.entitites;

public enum AvaliacaoType {
    AV1("avaliacao1"),
    AV2("avaliacao2"),;

    private final String descricao;

    private AvaliacaoType(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
