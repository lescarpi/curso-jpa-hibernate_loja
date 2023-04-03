package br.com.loja.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private DadosPessoais dadosPessoais;

    public Cliente(String nome, String cpf) {
        this.dadosPessoais = new DadosPessoais(nome, cpf);
    }

    public Cliente() {
    }

    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }
}
