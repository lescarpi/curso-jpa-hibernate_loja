package br.com.loja.dao;

import br.com.loja.modelo.Produto;
import jakarta.persistence.EntityManager;

public class ProdutoDao {

    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }

    public void atualizar(Produto produto) {
        this.em.merge(produto);
    }

    public void deletar(Produto produto) {
        produto = this.em.merge(produto);
        this.em.remove(produto);
    }

}
