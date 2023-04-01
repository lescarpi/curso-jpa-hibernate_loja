package br.com.loja.dao;

import br.com.loja.modelo.Categoria;
import jakarta.persistence.EntityManager;

public class CategoriaDAO {

    private EntityManager em;

    public CategoriaDAO(EntityManager em) {
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
