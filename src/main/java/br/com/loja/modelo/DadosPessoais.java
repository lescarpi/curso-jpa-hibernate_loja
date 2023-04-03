package br.com.loja.modelo;

import jakarta.persistence.Embeddable;

@Embeddable
public class DadosPessoais {

    private String nome;
    private String cpf;

    public DadosPessoais(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public DadosPessoais() {
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
