package br.com.loja.dao;

import br.com.loja.modelo.Categoria;
import jakarta.persistence.EntityManager;

public class CategoriaDao {

    private EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Categoria categoria) {
        this.em.persist(categoria);
    }

    public void atualizar(Categoria categoria) {
        this.em.merge(categoria);
    }

    public void deletar(Categoria categoria) {
        categoria = this.em.merge(categoria);
        this.em.remove(categoria);
    }

}
